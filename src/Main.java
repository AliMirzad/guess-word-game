import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\names.txt");
        Scanner scanner = new Scanner(file);
        int totalWord = 0;
        Random random = new Random();
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            totalWord++;
        }
        scanner.close();
        scanner = new Scanner(System.in);
        int point = 0;
        cc:
        while (true) {
            System.out.println("what do u want? ");
            String input = scanner.next();
            switch (input) {
                case "play":
                    point += playGame(totalWord);
                    break;
                case "point":
                    System.out.println(point);
                    break;
                case "exit":
                    System.out.println("bye bye");
                    break cc;
            }
        }
    }

    private static int playGame(int totalWord) throws IOException {
        Random random = new Random();
        char[] word = Files.readAllLines(
                        Paths.get("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\names.txt"))
                .get(random.nextInt(totalWord)).toCharArray();
        int wordLength = word.length;
        char[] guess = new char[wordLength];
        int firstChar = random.nextInt(wordLength);
        int secondChar = random.nextInt(wordLength);
        for (int i = 0; i < wordLength; i++) {
            if (word[i] == word[firstChar] || word[i] == word[secondChar]) {
                guess[i] = word[i];
            } else {
                guess[i] = '_';
            }
        }
        int count = 0;
        int wrongCount = 0;
        Scanner scanner = new Scanner(System.in);
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String reset = "\u001B[37m";
        boolean winner = false;
        bb:
        while (wrongCount <= 5) {
            for (char c : guess) {
                if (c == '_') {
                    System.out.print(red + c);
                } else {
                    System.out.print(green + c);
                }
            }
            System.out.println();
            System.out.println(reset + "enter your word: ");
            char charGuess = scanner.next().charAt(0);
            System.out.println();
            boolean flag = true;
            aa:
            for (int i = 0; i < wordLength; i++) {
                if (guess[i] == '_' && word[i] == charGuess) {
                    guess[i] = word[i];
                    count++;
                    flag = true;
                    break aa;
                }
                flag = false;
            }
            if (!flag) {
                System.out.println("wrong guess");
                wrongCount++;
            }
            int counter = 0;
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == '_') {
                    counter++;
                }
            }
            if (counter == 0) {
                for (char c : guess) {
                    System.out.print(c);
                }
                System.out.println();
                winner = true;
                break bb;
            }
        }
        if (winner) {
            return 1;
        } else {
            return -1;
        }
    }
}