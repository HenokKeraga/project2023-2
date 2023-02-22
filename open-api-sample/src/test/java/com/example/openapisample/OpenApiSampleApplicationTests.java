package com.example.openapisample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.StringJoiner;

//@SpringBootTest
class OpenApiSampleApplicationTests {

    @Test
    void contextLoads() {
        List<String> stringList= List.of("1","b","r");

        var join = String.join("<", "2","4");
        System.out.println(join);

        StringJoiner stringJoiner = new StringJoiner("<");

        stringJoiner.add("6");
        stringJoiner.add("7");
        stringJoiner.add("8");
        System.out.println(stringJoiner);

        var stringJoiner1 = new StringJoiner("<", "2", "3");
        stringJoiner1.add("t");

        stringJoiner1.add("y");

        stringJoiner1.add("z");

        System.out.println(stringJoiner1);



    }

}
