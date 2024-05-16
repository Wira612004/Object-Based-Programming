// Wira Harsa - TI22I
// 1.
public class Task9 {
    public static void main(String[] args) {
        String name = "WIRAHARSA";

        for (int i = 0; i <= name.length(); i++) {
            String stars = "";
            for (int j = 0; j < i; j++) {
                stars += "*";
            }
            System.out.println(name.substring(0, name.length() - i) + stars);
        }
    }
}
