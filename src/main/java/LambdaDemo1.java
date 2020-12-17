package main.java;

public class LambdaDemo1 {
    interface Printer{
        void printer(String val);
    }
    public void pringSomething(String something,Printer printer){
        printer.printer(something);
    }


    public static void main(String[] args) {
        LambdaDemo1 lambdaDemo1 = new LambdaDemo1();
        String some = "asdasasa";

        //不使用lambda表达式
        Printer printer = new Printer() {
            @Override
            public void printer(String val) {
                System.out.println(val);
            }
        };
        lambdaDemo1.pringSomething(some,printer);

        /*1、使用lambda表达式
        *接口匿名实现类，简化函数
        * ①参数
        * ②函数体
        * */
        Printer printer1 = (String val) ->{
            System.out.println(val);
        };

        //1.1、进一步简化，去掉参数类型
        Printer printer2 = (val) ->{
            System.out.println(val);
        };
        //1.2、进一步简化，去掉参数括号（前提：只有一个参数）
        Printer printer3 = val ->{
            System.out.println(val);
        };
        //1.3、进一步简化，去掉函数体大括号（前提：函数体只有一行代码）
        Printer printer4 = val -> System.out.println(val);

        //1.4、最后可精简为如下，会自动推断lambda传入的参数类型
        lambdaDemo1.pringSomething(some,val -> System.out.println(val));

        //1.5、无参数传入的话，可以简写成
//        () -> System.out.println("无参");
        /*
        * 总结：
        * 省略类型：自动推断
        * 省略括号：一个参数
        * 
        * lambda表达式表达的是接口函数，
        * 箭头左侧是函数参数，箭头右侧是函数体。
        * 函数的参数类型和返回值类型都可以省略，程序会根据接口定义的上下文自动确定数据类型。
        * */
    }
}









































