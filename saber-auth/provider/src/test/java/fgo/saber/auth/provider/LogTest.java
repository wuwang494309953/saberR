package fgo.saber.auth.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    @Test
    public void log1() {
        log.info("hello world: {}", "saber");
        log.debug("hello world: {}", "saber");
        log.warn("hello world: {}", "saber");
        log.error("hello world: {}", "saber");
    }
}
