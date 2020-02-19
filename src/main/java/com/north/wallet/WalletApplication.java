package com.north.wallet;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
@MapperScan("com.north.wallet.mapper")
public class WalletApplication {

    public static void main(String[] args) {

        long starTime = System.currentTimeMillis();
        SpringApplication.run(WalletApplication.class, args);
        long endTime = System.currentTimeMillis();
        long time = endTime - starTime;
        log.info("\nStart Time: " + time / 1000d + " s");
        log.info("...............................................................");
        log.info("...............................................................");
        log.info("..... ......North pole Service starts successfully.............");
        log.info("...............................................................");
        log.info("...............................................................");

    }


}
