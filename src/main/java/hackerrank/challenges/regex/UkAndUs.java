package hackerrank.challenges.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UkAndUs {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= num; i++) {
            stringBuilder.append(" " + in.nextLine() + " ");
        }

        int numWords = in.nextInt();

        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = in.next();
        }

        for (int i = 0; i < numWords; i++) {
            int count = count(words[i], stringBuilder.toString());
            words[i] = words[i].replaceAll("our", "or");
            count += count(words[i], stringBuilder.toString());
            System.out.println(count);
        }
    }

    private static int count(String word, String text) {
        Matcher matcher = Pattern.compile("(?=(" + " " + word + " " + "))").matcher(text);
        int numFound = 0;
        while (matcher.find()) {
            numFound++;
        }
        return numFound;
    }
}
