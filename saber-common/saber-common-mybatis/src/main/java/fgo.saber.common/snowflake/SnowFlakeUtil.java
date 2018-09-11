package fgo.saber.common.snowflake;

/**
 * @author zq
 * @Date 2018/9/10
 */
public class SnowFlakeUtil {

    private static final SnowFlake sf = initSnowFlake();

    public static Long nextId() {
        return sf.nextId();
    }

    private static SnowFlake initSnowFlake() {
        String mac = AuthorizationUtils.getMac();
        String code = AuthorizationUtils.getMachineCode();
        return new SnowFlake(Math.abs(code.hashCode()) % SnowFlake.MAX_DATACENTER_NUM,
                Math.abs(mac.hashCode()) % SnowFlake.MAX_MACHINE_NUM);
    }

    public static void main(String[] args) {
        SnowFlake snowFlake = SnowFlakeUtil.initSnowFlake();
        for (int i = 0; i < 500; i++) {
            System.out.println(snowFlake.nextId());
        }
    }

}
