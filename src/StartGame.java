import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    private List<Integer> computerNumber;
    private CheckNums checkNums = new CheckNums();
    private FileWriter internalFileWriter;
    public StartGame(List<Integer> generatedNumber, FileWriter fileWriter) {

        computerNumber = generatedNumber;
        internalFileWriter = fileWriter;
    }

    private String getGameResult(String gamerNums) {
        List<Integer> gamerNumsList = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            char charDigit = gamerNums.charAt(i);
            int intDigit = Character.digit(charDigit, 10);
            gamerNumsList.add(intDigit);
        }

        String checkResult = checkNums.getCheckResult(computerNumber, gamerNumsList);
        return checkResult;
    }

    public void playSingleGame() throws IOException {
        int attemptsNumber = 0;
        Attempts attempts = new Attempts();
        while (true) {
            GamerInput gamerInput = new GamerInput();
            String gamerNums = gamerInput.getUserInput();
            String checkResult = getGameResult(gamerNums);
            System.out.println(checkResult);
            internalFileWriter.write("Попытка " + gamerNums + "\n");
            ++attemptsNumber;

            if (checkResult.equals("4 быка, 0 коров")) {
                System.out.println("Верный ответ!");
                String attemptsWord = attempts.getAttemptWord(attemptsNumber);
                {internalFileWriter.write("Число было угадано с " + attemptsNumber + " " + attemptsWord + "\n");
                    break;}
            } else {
                System.out.println("Попробуйте еще раз...");
            }
        }
    }

    public String gameOver() {
        String answer = null;
        while (true) {
            System.out.print("Игра завершена? ");
            Scanner lineScanner = new Scanner(System.in);
            answer = lineScanner.nextLine();
            if (answer.equals("y")||answer.equals("n"))
            {break;}
            System.out.print("Введен некорректный ответ. ");
        }
        return answer;
    }


}
