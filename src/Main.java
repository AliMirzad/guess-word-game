import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        int point = 0;
        cc:
        while (true) {
            System.out.println("what do u want?\n" + "#play #point #new_word #exit");
            String input = scanner.next();
            switch (input) {
                case "play":
                    point += playGame();
                    break;
                case "new_word":
                    enterNewWord();
                    break;
                case "point":
                    System.out.println(point);
                    break;
                case "exit":
                    System.out.println("exited");
                    break cc;
            }
        }
        scanner.close();
    }

    private static void enterNewWord() throws IOException {
        scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\words.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        Cell cell = row.createCell(0);
        System.out.println("enter word:");
        cell.setCellValue(scanner.next());
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\words.xlsx"));
        wb.write(out);
    }

    private static int playGame() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\words.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        Random random = new Random();
        String word = sheet.getRow(random.nextInt(sheet.getLastRowNum() + 1)).getCell(0).getStringCellValue();
        char[] wordChars = word.toCharArray();
        char[] guess = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (wordChars[i] == wordChars[random.nextInt(word.length())] || wordChars[i] == wordChars[random.nextInt(word.length())])
                guess[i] = wordChars[i];
            else guess[i] = '_';
        }
        int wrongCount = 0;
        scanner = new Scanner(System.in);
        boolean winner = false;
        bb:
        while (wrongCount <= 5) {
            for (char c : guess) {
                if (c == '_') System.out.print(changeColor("red") + c);
                else System.out.print(changeColor("green") + c);
            }
            System.out.println();
            System.out.println(changeColor("reset") + "enter your word: ");
            char charGuess = scanner.next().charAt(0);
            boolean flag = true;
            aa:
            for (int i = 0; i < word.length(); i++) {
                if (guess[i] == '_' && wordChars[i] == charGuess) {
                    guess[i] = wordChars[i];
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

    public static String changeColor(String color) {
        if (color.equals("red")) return "\u001B[31m";
        if (color.equals("green")) return "\u001B[32m";
        if (color.equals("reset")) return "\u001B[37m";
        else return null;
    }
}