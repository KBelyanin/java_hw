import java.util.List;

public class CheckNums {

    public String getCheckResult(List<Integer> generatedNumber, List<Integer> userNumber) {
        int b=0;
        int c=0;
        String checkResult ="";
        int i = 0;
        String bWord;
        String cWord;

        for (int item:userNumber) {

            if (generatedNumber.get(i) == item) {
                ++b;}
            else if (generatedNumber.contains(item)) {
                ++c;
            }
            ++i;
        }

        if (b == 0) {bWord = "быков";} else if (b == 1) {
            bWord = "бык";
        } else {bWord = "быка";}
        if (c == 0) {cWord = "коров";} else if (c == 1) {
            cWord = "корова";}
        else {cWord = "коровы";}

        checkResult = b + " " + bWord + ", " + c + " " +cWord;
        return checkResult;
    }
}
