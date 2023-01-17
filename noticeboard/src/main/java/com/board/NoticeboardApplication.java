package com.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.board.mapper"})
public class NoticeboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeboardApplication.class, args);
    }

}
