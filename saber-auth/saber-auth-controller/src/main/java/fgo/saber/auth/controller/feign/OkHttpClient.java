package fgo.saber.auth.controller.feign;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import feign.Client;

/**
 * This module directs Feign's http requests to
 * <a href="http://square.github.io/okhttp/">OkHttp</a>, which enables SPDY and better network
 * control. Ex.
 *
 * <pre>
 * GitHub github = Feign.builder().client(new OkHttpClient()).target(GitHub.class,
 * "https://api.github.com");
 */
public final class OkHttpClient implements Client {

    private final okhttp3.OkHttpClient delegate;

    public OkHttpClient() {
        this(new okhttp3.OkHttpClient());
    }

    public OkHttpClient(okhttp3.OkHttpClient delegate) {
        this.delegate = delegate;
    }

    static Request toOkHttpRequest(feign.Request input) {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(input.url());

        MediaType mediaType = null;
        boolean hasAcceptHeader = false;
        for (String field : input.headers().keySet()) {
            if (field.equalsIgnoreCase("Accept")) {
                hasAcceptHeader = true;
            }

            for (String value : input.headers().get(field)) {
                requestBuilder.addHeader(field, value);
                if (field.equalsIgnoreCase("Content-Type")) {
                    mediaType = MediaType.parse(value);
                    if (input.charset() != null) {
                        mediaType.charset(input.charset());
                    }
                }
            }
        }
        // Some servers choke on the default accept string.
        if (!hasAcceptHeader) {
            requestBuilder.addHeader("Accept", "*/*");
        }

        byte[] inputBody = input.body();
        boolean isMethodWithBody = "POST".equals(input.method()) || "PUT".equals(input.method());
        if (isMethodWithBody) {
            requestBuilder.removeHeader("Content-Type");
            if (inputBody == null) {
                // write an empty BODY to conform with okhttp 2.4.0+
                // http://johnfeng.github.io/blog/2015/06/30/okhttp-updates-post-wouldnt-be-allowed-to-have-null-body/
                inputBody = new byte[0];
            }
        }

        RequestBody body = inputBody != null ? RequestBody.create(mediaType, inputBody) : null;
        requestBuilder.method(input.method(), body);
        return requestBuilder.build();
    }

    private static feign.Response toFeignResponse(Response response, feign.Request request)
            throws IOException {
        return feign.Response.builder()
                .status(response.code())
                .reason(response.message())
                .request(request)
                .headers(toMap(response.headers()))
                .body(toBody(response.body()))
                .build();
    }

    private static Map<String, Collection<String>> toMap(Headers headers) {
        return (Map) headers.toMultimap();
    }

    private static feign.Response.Body toBody(final ResponseBody input) throws IOException {
        if (input == null || input.contentLength() == 0) {
            if (input != null) {
                input.close();
            }
            return null;
        }
        final Integer length = input.contentLength() >= 0 && input.contentLength() <= Integer.MAX_VALUE
                ? (int) input.contentLength()
                : null;

        return new feign.Response.Body() {

            @Override
            public void close() throws IOException {
                input.close();
            }

            @Override
            public Integer length() {
                return length;
            }

            @Override
            public boolean isRepeatable() {
                return false;
            }

            @Override
            public InputStream asInputStream() throws IOException {
                return input.byteStream();
            }

            @Override
            public Reader asReader() throws IOException {
                return input.charStream();
            }

            public Reader asReader(Charset charset) throws IOException {
                return asReader();
            }
        };
    }

    @Override
    public feign.Response execute(feign.Request input, feign.Request.Options options)
            throws IOException {
        okhttp3.OkHttpClient requestScoped;
        if (delegate.connectTimeoutMillis() != options.connectTimeoutMillis()
                || delegate.readTimeoutMillis() != options.readTimeoutMillis()) {
            requestScoped = delegate.newBuilder()
                    .connectTimeout(options.connectTimeoutMillis(), TimeUnit.MILLISECONDS)
                    .readTimeout(options.readTimeoutMillis(), TimeUnit.MILLISECONDS)
                    .followRedirects(true)
                    .build();
        } else {
            requestScoped = delegate;
        }
        Request request = toOkHttpRequest(input);
        Response response = requestScoped.newCall(request).execute();
        return toFeignResponse(response, input).toBuilder().request(input).build();
    }
}
