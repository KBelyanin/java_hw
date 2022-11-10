import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {


    public void newGame() throws IOException {
        String gameRepeat = "n";
        long gameNumber = 0;

        File dir = new File("src/save"); //указывает на директорию
        List<File> lst = new ArrayList<>();
        for ( File file : Objects.requireNonNull(dir.listFiles())){
            if ( file.isFile() )
                lst.add(file);
        }

        while (gameRepeat.equals("n")){
            FileWriter fileWriter = new FileWriter("src/save/result.txt", true);
            FileReader fileReader = new FileReader("ser/save/result.txt");
            ResultHandler resultHandler = new ResultHandler(fileReader,fileWriter);
            for (File f: lst) {
                long newNum = resultHandler.CountGames(f);
                gameNumber = gameNumber>newNum? gameNumber:newNum;
            }

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
