package com.example.wxmp;

import com.example.wxmp.entity.NetworkHookLog;
import com.example.wxmp.repository.NetworkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class WxMpApplicationTests {
    @Autowired
    public NetworkRepository productRepository;

    public void setProductRepository(NetworkRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    void contextLoads() {
        NetworkHookLog networkHookLog = new NetworkHookLog();
        networkHookLog.settCrtTm(new Date());
        networkHookLog.setcDocChar("123123");
        productRepository.save(networkHookLog);
    }

}
