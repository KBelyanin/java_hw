public class Attempts {

    public String getAttemptWord (int attemptsNumber) {
        String word = "попыток";
        if ((attemptsNumber%100) == 11) {
            return word;
        } else if ((attemptsNumber % 10) == 1) {
            word = "попытки";
            return word;
        } else {
            return word;
        }
    }

}
