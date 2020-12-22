import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamState {
    public static void main(String[] args) {
        //1、Limit与Skip管道数据截取
        List<String> limitN = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .limit(2)
                .collect(Collectors.toList());
        List<String> skipN = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .skip(2)
                .collect(Collectors.toList());
        //2、Distinct元素去重
        List<String> uniqueAnimals = Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion")
                .distinct()
                .collect(Collectors.toList());
        //3、Sorted排序
        List<String> alphabeticOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .sorted()
                .collect(Collectors.toList());
        //4、串行、并行与顺序
        //默认串行
        //并行操作parallel，操作无状态操作
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion")
                .parallel()
                .forEach(System.out::println);
    }
}
