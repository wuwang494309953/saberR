package fgo.saber.util;

import fgo.saber.base.exception.CommonBaseException;
import fgo.saber.base.json.JsonResult;

import javax.annotation.Nullable;

/**
 * @author zq
 * @date 2019/8/27
 */
public class SbPreconditions {

    public static <T> T checkNotNull(T obj, @Nullable JsonResult result) {
        if (obj == null) {
            throw new CommonBaseException(result);
        } else {
            return obj;
        }
    }

}
