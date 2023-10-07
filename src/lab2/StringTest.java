public class StringTest {

    public static void main(String[] args) {
        String message = "What's up?";
        int len = message.length();

        char messageChar = message.charAt(0);
        System.out.println(messageChar);

        messageChar = message.charAt(1);
        System.out.println(messageChar);

        System.out.println(message.toUpperCase());
        System.out.println(message.substring(0, 4));


//        System.out.println(len);
    }

}
