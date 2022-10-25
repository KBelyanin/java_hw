import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public List<Integer> generateNewNumber() {
        List<Integer> numberList = new ArrayList<Integer>();
        Random random = new Random();
        while (numberList.size()<4) {
            int a = random.nextInt(10);
            if (!numberList.contains(a)) {
                numberList.add(a);
            }
        }
        return numberList;
    }
}
