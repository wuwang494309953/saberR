package fgo.saber.auth.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerApplicationTests {

    @Test
    public void contextLoads() {
        String str =  "POSThttps://dp.clife.net/v1/app/open/account/password/updatePassaccessToken=a09322552e8845bd9bd348173a6224c3&appId=31124&oldPassword=IAgg4yJ4Fe0XVqa1Mefg0g==&password=v9WSkegltfK78et2Vp P5w==&timestamp=1537439929000&a6bae15ce05442118e75b46b0e899b71";
        String str1 = "POSThttps://dp.clife.net/v1/app/open/account/password/updatePassaccessToken=a09322552e8845bd9bd348173a6224c3&appId=31124&oldPassword=IAgg4yJ4Fe0XVqa1Mefg0g==&password=v9WSkegltfK78et2Vp%2bP5w==&timestamp=1537439929000&a6bae15ce05442118e75b46b0e899b71";
    }

}
