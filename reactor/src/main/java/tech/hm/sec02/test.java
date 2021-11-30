package tech.hm.sec02;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class test {

    public static void main(String[] args) {
        String str2 = List.of(1, 2, 3).stream()
                .map(i -> getValue(i))
                .filter(str -> Objects.nonNull(str))
                .findFirst()
                .orElse(null);

        System.out.println(str2);
    }


    private static String getValue(Integer i){

        if(i == 1) return null;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Вызов для i" + i);
        return "Value" +i;
    }
}
