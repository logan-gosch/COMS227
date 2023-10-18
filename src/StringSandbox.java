import java.util.Scanner;

public class StringSandbox {
    public static void main(String[] args) {

    }

    public static void forLoopTest() {
        String str1 = "Test and Foo";
        String str2 = "Foo";
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            System.out.println(i);
        }
    }



}
