package cs09.practice.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionPractice1 {
    private static List<Student> list = Arrays.asList(
            new Student("깡총이", 90, 96),
            new Student("독기산", 95, 94));

    public static void printString(Function<Student, String> function) {
        for (Student student : list) {
            System.out.println(function.apply(student) + " ");  // 람다식 실행
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Student> function) {
        for (Student student : list) {
            System.out.println(function.applyAsInt(student) + " "); // 람다식 실행
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("[학생 이름]");
        printString(Student::getName);
        System.out.println("[영어 점수]");
        printInt(Student::getEnglishScore);
        System.out.println("[수학 점수]");
        printInt(Student::getMathScore);
    }
}
