import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class ResultHandler {
    private FileWriter innerFileWriter;
    private FileReader innerFileReader;
    public ResultHandler(FileReader fileReader, FileWriter filewriter) throws IOException {
        innerFileWriter = filewriter;
        innerFileReader = fileReader;
    }

    public long CountGames() throws IOException {
        Scanner fileScanner = new Scanner(innerFileReader);
        Set<MatchResult> games = fileScanner.findAll("Game №\\d{1,}").collect(Collectors.toSet());
        System.out.println(games.size());
        Set<String> gamesString = new HashSet<>();
        for(MatchResult m : games) {
            gamesString.add(m.group());
            System.out.println(m.group());
        }
        List<Integer> gamesNums = new ArrayList<>();
        for(String s : gamesString) {
            gamesNums.add(Integer.parseInt(s.replaceAll("\\D", "")));
        }
        gamesNums.sort(Collections.reverseOrder());
        return gamesNums.get(0);
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