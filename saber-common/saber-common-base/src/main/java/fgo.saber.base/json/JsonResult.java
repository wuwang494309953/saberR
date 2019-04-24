package fgo.saber.base.json;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zq
 * @Date 2018/9/12
 */
@Data
@NoArgsConstructor
//@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class JsonResult<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> JsonResult<T> success() {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(0);
        return result;
    }

    public static <T> JsonResult<T> success(String msg) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public static <T> JsonResult<T> success(T t) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(0);
        result.setData(t);
        return result;
    }

    public static <T> JsonResult<T> success(String msg, T t) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(t);
        return result;
    }

    public static <T> JsonResult<T> fail(int code, String msg) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /*public Map toMap() {
        Map result = Maps.newLinkedHashMap();
        result.put("code", this.getCode());
        if (StringUtils.isNotBlank(this.getMsg())) {
            result.put("msg", this.getMsg());
        }
        if (this.getData() != null) {
            result.put("data", this.getData());
        }
        return result;
    }*/
}
