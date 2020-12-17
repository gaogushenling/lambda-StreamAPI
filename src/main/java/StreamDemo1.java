package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("e", "c", "cbn", "zxc", "caz", "d", "b", "a");

        //不使用StreamAPI
       /* for (String letter : letters) {
                                //转换大写
            String temp = letter.toLowerCase();
            //排序
            //转
            //总之非常麻烦
        }*/

        //1、集合 使用StreamAPI
        //数组转换成流
        List<String> lettertsNew = letters.stream()
                //过滤：找出以c开头的元素
                .filter(s -> s.startsWith("c"))
                //将过滤后的结果全部大写，其中::为函数引用
                .map(String::toUpperCase)
                //排序，可写排序规则
                .sorted()
                //将流转换成集合
                .collect(Collectors.toList());

        System.out.println(lettertsNew);

        //2、数组转换成流
        String[] letters2 = {"e", "c", "cbn", "zxc", "caz", "d", "b", "a"};
        Stream.of(letters2).filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().toArray(String[]::new);

        //3、set转成流：集合类是一样的
        Set<String> lettersSet = new HashSet<>(letters);
        List<String> lettertsNewSet = lettersSet.stream()
                //过滤：找出以c开头的元素
                .filter(s -> s.startsWith("c"))
                //将过滤后的结果全部大写，其中::为函数引用
                .map(String::toUpperCase)
                //排序，可写排序规则
                .sorted()
                //将流转换成集合
                .collect(Collectors.toList());

        //4、文本文件转换成流
        Paths.get("file.text");
        try {
            Stream<String> stringStream = Files.lines(Paths.get("file.text"));
            List<String> f = stringStream
                    //过滤：找出以c开头的元素
                    .filter(s -> s.startsWith("c"))
                    //将过滤后的结果全部大写，其中::为函数引用
                    .map(String::toUpperCase)
                    //排序，可写排序规则
                    .sorted()
                    //将流转换成集合
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
