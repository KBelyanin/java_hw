import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ResultHandler {
    private FileWriter innerFileWriter;
    private FileReader innerFileReader;
    public ResultHandler(FileReader fileReader, FileWriter filewriter) throws IOException {
        innerFileWriter = filewriter;
        innerFileReader = fileReader;
    }

    public long CountGames() throws IOException {
        Scanner fileScanner = new Scanner(innerFileReader);
        LineNumberReader lineNumberReader = new LineNumberReader(innerFileReader);
        long gameNumber = fileScanner.findAll("Game №").count();
        return gameNumber;
    }

    public void writeGameTitle(List<Integer> generatedNumber, long gameNumber) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String dateTimeNow = LocalDateTime.now().format(formatter);
        String numberForWrite = "";
        for (int number:generatedNumber) {
            numberForWrite += Integer.toString(number);
        }
        innerFileWriter.write("Game №" + gameNumber + " " + dateTimeNow +
                " загаданное число " + numberForWrite +"\n");

    }


}