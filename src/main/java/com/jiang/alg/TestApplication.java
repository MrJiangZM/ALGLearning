package com.jiang.alg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.Size;
import java.util.function.Consumer;

/**
 * @author Jiang Zaiming
 * @date 2019/11/22 10:07 上午
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
//        Consumer<Test> num = getNum();
//        System.out.println(99999);
    }

    public static Consumer<Test> getNum() {
        return x -> {
            new Test("tt", "tt");
        };
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Test {
        private String id;
        private String name;
    }

}
