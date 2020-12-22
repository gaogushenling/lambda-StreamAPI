import java.util.Arrays;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "word");
        words.stream()
                .map(w -> Arrays.stream(w.split("")))    //[[h,e,l,l,o],[w,o,r,l,d]]
                .forEach(System.out::println);

        //flatMap可以理解为将若干个子管道中的数据全都，平面展开到父管道中进行处理
        words.stream()
                .flatMap(w -> Arrays.stream(w.split(""))) // [h,e,l,l,o,w,o,r,l,d]
                .forEach(System.out::println);
    }
}
