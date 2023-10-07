public class StringSandbox {
    public static void main(String[] args) {
        String str1 = "Cock and balls";
        String str2 = "Dick";
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            System.out.println(i);
        }
    }
}
