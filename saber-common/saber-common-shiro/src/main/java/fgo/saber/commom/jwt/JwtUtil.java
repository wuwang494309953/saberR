package fgo.saber.commom.jwt;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author zq
 * @date 2018/10/19
 */
public class JwtUtil {

    private static final String SECRET_KEY = "saber_auth";

    /**
     * @param subject 用户ID
     * @param issuer 签发人
     * @param period 有效时间(毫秒)
     * @param roles 访问主张-角色
     * @param permissions 访问主张-权限
     * @return json web token
     */
    public static String issueJwt(String subject, String issuer, Long period, String roles, String permissions) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 当前时间戳
        long currentTimeMillis = System.currentTimeMillis();
        JwtBuilder jwt  =  Jwts.builder();
        jwt.setId(UUID.randomUUID().toString());
        // 用户名主题
        jwt.setSubject(subject);
        if(StringUtils.isNotBlank(issuer)) {
            //签发者
            jwt.setIssuer(issuer);
        }
        //签发时间
        jwt.setIssuedAt(new Date(currentTimeMillis));
        if(null != period){
            Date expiration = new Date(currentTimeMillis+period);
            //有效时间
            jwt.setExpiration(expiration);
        }
        if(StringUtils.isNotBlank(roles)) {
            //角色
            jwt.claim("roles", roles);
        }
        if(StringUtils.isNotBlank(permissions)) {
            //权限
            jwt.claim("perms", permissions);
        }
        //压缩，可选GZIP
        jwt.compressWith(CompressionCodecs.DEFLATE);
        //加密设置
        jwt.signWith(signatureAlgorithm, SECRET_KEY);
        return jwt.compact();
    }

}
