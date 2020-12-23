import model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Matvhfind {
    public static void main(String[] args) {
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

        //不用Stream API实现，查找员工列表中是否包含年龄大于70的员工
        boolean isExistAgeThan70 = false;
        for(Employee employee:employees){
            if(employee.getAge() > 70){
                isExistAgeThan70 = true;
                break;
            }
        }
        System.out.println(isExistAgeThan70);

        //1、第一个匹配规则函数：anyMatch，判断Stream流中是否 包含 某一个“匹配规则”的元素。
        // 这个匹配规则可以是lambda表达式或者谓词。

        //使用Stream API
        boolean isExistAgeThan702 = employees.stream().anyMatch(Employee.ageGreaterThan70);
        System.out.println(isExistAgeThan702);
        //将谓词逻辑换成lambda表达式
        boolean isExistAgeThan72 = employees.stream().anyMatch(e -> e.getAge() > 72);
        System.out.println(isExistAgeThan72);

        //2.1、allMatch匹配规则函数：判断是够Stream流中的 所有元素都 符合某一个"匹配规则"。
        //是否所有员工的年龄都大于10岁
        boolean isExistAgeThan10 = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println(isExistAgeThan10);

        //2.2、noneMatch匹配规则函数：判断是否Stream流中的 所有元素都不 符合某一个"匹配规则"。
        //是否不存在小于18岁的员工
        boolean isExistAgeLess18 = employees.stream().noneMatch(e -> e.getAge() < 18);
        System.out.println(isExistAgeLess18);

        /**
         *  3、元素查找与Optional
         * Optional类代表一个值存在或者不存在。在java8中引入，这样就不用返回null了。
         *
         * isPresent() 将在 Optional 包含值的时候返回 true , 否则返回 false 。
         * ifPresent(Consumer block) 会在值存在的时候执行给定的代码块。我们在第3章
         * 介绍了 Consumer 函数式接口；它让你传递一个接收 T 类型参数，并返回 void 的Lambda
         * 表达式。
         * T get() 会在值存在时返回值，否则?出一个 NoSuchElement 异常。
         * T orElse(T other) 会在值存在时返回值，否则返回一个默认值。
         * 关于Optinal的各种函数用法请观看视频！B站观看地址
         *
         * findFirst用于查找第一个符合“匹配规则”的元素，返回值为Optional
         * findAny用于查找任意一个符合“匹配规则”的元素，返回值为Optional
         */
        //从列表中按照顺序查找第一个年龄大于40的员工
        Optional<Employee> employeeOptional
                =  employees.stream().filter(e -> e.getAge() > 40).findFirst();
        System.out.println(employeeOptional.get());

        //isPresent是否存在
       boolean is
                =  employees.stream().filter(e -> e.getAge() > 40).findFirst().isPresent();
        System.out.println(is);

        //ifPresent如果存在
        employees.stream().filter(e -> e.getAge() > 40).findFirst().ifPresent(
                        e -> System.out.println(e)
        );

        //orElse不存在给默认值
        Employee employeeOptionalOrElse =
        employees.stream().filter(e -> e.getAge() > 90).findFirst().orElse(
                        new Employee(0,0,"F","","")
        );
        System.out.println(employeeOptionalOrElse);

        //findAny 找任意一个
        Employee employeeOptionalOrElseFindAny =
                employees.stream().filter(e -> e.getAge() > 90).findAny().orElse(
                        new Employee(0,0,"F","","")
                );
        System.out.println(employeeOptionalOrElseFindAny);
    }
}
