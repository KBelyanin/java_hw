
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Game {


    public void newGame() throws IOException {
        String gameRepeat = "n";
        long gameNumber;

        while (gameRepeat.equals("n")){
            FileWriter fileWriter = new FileWriter("result.txt", true);
            FileReader fileReader = new FileReader("result.txt");
            ResultHandler resultHandler = new ResultHandler(fileReader,fileWriter);

            gameNumber = resultHandler.CountGames();
            ++gameNumber;

            Generator generator = new Generator();
            List<Integer> generatedNumber = generator.generateNewNumber();

            System.out.println(" Загаданное число " + generatedNumber.toString());

            resultHandler.writeGameTitle(generatedNumber, gameNumber);

            StartGame startGame = new StartGame(generatedNumber, fileWriter);
            startGame.playSingleGame();

            gameRepeat = startGame.gameOver();

            fileWriter.flush();
            fileWriter.close();
        }
    }
}
