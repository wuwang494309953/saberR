package fgo.saber.common.snowflake;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 500; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(snowFlake.nextId());
                }
            });
        }
    }

}
