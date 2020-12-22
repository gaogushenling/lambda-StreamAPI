
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap1 {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        //不使用Stream管道流
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alphaUpper); //[MONKEY, LION, GIRAFFE, LEMUR]

        // 1、Stream管道流map的基础用法：使用Stream管道流
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        //上面使用了方法引用，和下面的lambda表达式语法效果是一样的
        //List<String> collect = alpha.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(collect); //[MONKEY, LION, GIRAFFE, LEMUR]

        //2、处理非字符串类型集合元素
        List<Integer> lengths = alpha.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(lengths); //[6, 4, 7, 5]

        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                //除了mapToInt。还有maoToLong，mapToDouble等等用法
                .mapToInt(String::length)
                .forEach(System.out::println);
    }
}
