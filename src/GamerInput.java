import java.util.Scanner;

public class GamerInput {

    public String getUserInput() {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите 4х значное число: ");
            input = scanner.nextLine();
            if (input.length() != 4) {
                System.out.println("Введенное число не соответствует условиях игры: ");
            } else break;
        }
        return input;
    }
}