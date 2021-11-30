package tech.hm.sec02;

import tech.hm.courceutils.Util;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        NameGenerator.getNames(5).subscribe(Util.onNext());
    }
}
