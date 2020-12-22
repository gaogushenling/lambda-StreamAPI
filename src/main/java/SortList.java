import model.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {

        //Collections.sort();
        //1、字符串List排序
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        System.out.println(cities);
        //[Milan, london, San Francisco, Tokyo, New Delhi]

        //大小写不敏感的排序
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cities);
        //[london, Milan, New Delhi, San Francisco, Tokyo]

        //大小写敏感的排序
        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);
        //[Milan, New Delhi, San Francisco, Tokyo, london]

        //同样我们可以把排序器Comparator用在Stream管道流中。
        cities.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //Milan
        //New Delhi
        //San Francisco
        //Tokyo
        //london

        //2、整数类型List排序
        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);
        System.out.println(numbers); //[6, 2, 1, 4, 9]

        numbers.sort(Comparator.naturalOrder());  //自然排序
        System.out.println(numbers); //[1, 2, 4, 6, 9]

        numbers.sort(Comparator.reverseOrder()); //倒序排序
        System.out.println(numbers);  //[9, 6, 4, 2, 1]

        //3、按对象字段对List<Object>排序
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);


        //4、Comparator链对List<Object>排序
        employees.sort(Comparator.comparing(Employee::getAge));
        employees.forEach(System.out::println);

        //先按性别，再按年龄倒序
        //如果我们希望List按照年龄age的倒序排序，就使用reversed()方法
        employees.sort(
                Comparator.comparing(Employee::getGender)
                        .thenComparing(Employee::getAge)
                        .reversed()
        );
        employees.forEach(System.out::println);

        //都是正序 ，不加reversed
        //都是倒序，最后面加一个reserved
        //先是倒序（加reserved），然后正序
        //先是正序（加reserved），然后倒序（加reserved）

        //8、自定义Comparator排序
       /* employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee em1, Employee em2) {
                if(em1.getAge() == em2.getAge()){
                    return 0;
                }
                return em1.getAge() - em2.getAge() > 0 ? -1:1;
            }
        });*/
        //简化
        employees.sort((em1,em2) -> {
            if(em1.getAge() == em2.getAge()){
                return 0;
            }
            return em1.getAge() - em2.getAge() > 0 ? -1:1;
        });
        employees.forEach(System.out::println);
    }
}
