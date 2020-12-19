package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;


@Data
@AllArgsConstructor
//员工
public class Employee {

    private Integer id;
    private Integer age;   //年龄
    private String gender;  //性别
    private String firstName; //名字
    private String lastName; //姓氏

    //Predicate接口，在英语中这个单词的意思是：谓词
    //谓词逻辑的复用如下
    //e -> e.getAge() > 70 && e.getGender().equals("M")
    public static Predicate<Employee> ageGreaterThan70 = x -> x.getAge() >70;
    public static Predicate<Employee> genderM = x -> x.getGender().equals("M");
}