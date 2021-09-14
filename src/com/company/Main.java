package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    static final long STRING_LENGTH = 80;
    static final int WORD_LENGTH = 7;
    static final String LETTERS_EXAMPLE = "fdhrhytjtduktjrjeafdgesy";

    public static void main(String[] args) {

        RandomGenerator randomGenerator;
        randomGenerator = (length) -> {
            char[] chars = LETTERS_EXAMPLE.toCharArray();
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                char c = chars[random.nextInt(chars.length)];
                if (i % WORD_LENGTH == 0) {
                    sb.append(" ");
                }
                sb.append(c);
            }
            return sb.toString();
        };

        String msg = randomGenerator.generate(STRING_LENGTH);
        System.out.println("Исходное сообщение: " + msg);

        System.out.println("Отсортированные слова: ");
        sortWords(splitMessage(msg)).stream().
                map(word -> word + " ").
                forEach(System.out::print);
    }

    public static String[] splitMessage(String msg) {
        return msg.split(" ");
    }

    public static List<String> sortWords(String[] splittedString) {
        return Arrays.stream(splittedString)
                .sorted()
                .collect(Collectors.toList());
    }
}
