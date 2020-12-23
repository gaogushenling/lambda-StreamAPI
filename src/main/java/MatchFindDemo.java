import model.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * Stream API为我们提供了Stream.reduce用来实现集合元素的归约。reduce函数有三个参数：
 *
 * Identity标识：一个元素，它是归约操作的初始值，如果流为空，则为默认结果。
 * Accumulator累加器：具有两个参数的函数：归约运算的部分结果和流的下一个元素。
 * Combiner合并器（可选）：当归约并行化时，或当累加器参数的类型与累加器实现的类型不匹配时，用于合并归约操作的部分结果的函数。
 * 理解累加器：
 * 阶段累加结果作为累加器的第一个参数
 * 集合遍历元素作为累加器的第二个参数
 */
public class MatchFindDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //1、Integer类型归约
        //reduce初始值为0，累加器可以是lambda表达式，也可以是方法引用。
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);  //21

        int result12 = numbers
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(result12); //21

        //2、String类型归约
        //不仅可以归约Integer类型，只要累加器参数类型能够匹配，可以对任何类型的集合进行归约计算。
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result21 = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println(result21);  //abcde


        String result22 = letters
                .stream()
                .reduce("", String::concat);
        System.out.println(result22);  //ancde

        //3、复杂对象归约
        //计算所有的员工的年龄总和。
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

        //先用map将Stream流中的元素由Employee类型处理为Integer类型（age）。
        //然后对Stream流中的Integer类型进行归约
        Integer total = employees.stream().map(Employee::getAge).reduce(0,Integer::sum);
        System.out.println(total); //346

        //4、Combiner合并器的使用
        /*
        * 除了使用map函数实现类型转换后的集合归约，我们还可以用Combiner合并器来实现，这里第一次使用到了Combiner合并器。
        * 因为Stream流中的元素是Employee，累加器的返回值是Integer，所以二者的类型不匹配。
        * 这种情况下可以使用Combiner合并器对累加器的结果进行二次归约，相当于做了类型转换
        * */
        Integer total3 = employees.stream()
                .reduce(0,(totalAge,emp) -> totalAge + emp.getAge(),Integer::sum); //注意这里reduce方法有三个参数
        System.out.println(total3); //346

        //5、*并行流数据归约（使用合并器）
        //在进行并行流计算的时候，可能会将集合元素分成多个组计算。为了更快的将分组计算结果累加，可以使用合并器。
        Integer total2 = employees
                .parallelStream()
                .map(Employee::getAge)
                .reduce(0,Integer::sum,Integer::sum);  //注意这里reduce方法有三个参数即合并器

        System.out.println(total2); //346
    }
}
