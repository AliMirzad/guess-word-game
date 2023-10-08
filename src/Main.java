import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\names.txt");
//        Scanner scanner = new Scanner(file);
//        int totalWord = 0;
//        Random random = new Random();
//        while (scanner.hasNextLine()) {
//            scanner.nextLine();
//            totalWord++;
//        }
//        scanner.close();
//        scanner = new Scanner(System.in);
//        int point = 0;
//        cc:
//        while (true) {
//            System.out.println("what do u want? ");
//            String input = scanner.next();
//            switch (input) {
//                case "play":
//                    point += playGame(totalWord);
//                    break;
//                case "point":
//                    System.out.println(point);
//                    break;
//                case "exit":
//                    System.out.println("bye bye");
//                    break cc;
//            }
//        }
        playGame();
    }

    private static void playGame(/*int totalWord*/) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\words.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();

        Random random = new Random();
        random.nextInt(sheet.getLastRowNum() + 1);
        Row row = sheet.getRow(2);
//        Cell cell = sheet.getRo;
        System.out.println(row);
//        char[] word = Files.readAllLines(
//                        Paths.get("C:\\Users\\mirza\\IdeaProjects\\guess-word-game\\src\\names.txt"))
//                .get(random.nextInt(totalWord)).toCharArray();
//        int wordLength = word.length;
//        char[] guess = new char[wordLength];
//        int firstChar = random.nextInt(wordLength);
//        int secondChar = random.nextInt(wordLength);
//        for (int i = 0; i < wordLength; i++) {
//            if (word[i] == word[firstChar] || word[i] == word[secondChar]) {
//                guess[i] = word[i];
//            } else {
//                guess[i] = '_';
//            }
//        }
//        while (itr.hasNext())
//        {

//            Row row = itr.next();
//            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
//            while (cellIterator.hasNext())
//            {
//                Cell cell = cellIterator.next();
//                switch (cell.getCellType())
//                {
//                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                    default:
//                }
//            }
//            System.out.println("");
//        }
//        int wrongCount = 0;
//        Scanner scanner = new Scanner(System.in);
//        String red = "\u001B[31m";
//        String green = "\u001B[32m";
//        String reset = "\u001B[37m";
//        boolean winner = false;
//        bb:
//        while (wrongCount <= 5) {
//            for (char c : guess) {
//                if (c == '_') {
//                    System.out.print(red + c);
//                } else {
//                    System.out.print(green + c);
//                }
//            }
//            System.out.println();
//            System.out.println(reset + "enter your word: ");
//            char charGuess = scanner.next().charAt(0);
//            System.out.println();
//            boolean flag = true;
//            aa:
//            for (int i = 0; i < wordLength; i++) {
//                if (guess[i] == '_' && word[i] == charGuess) {
//                    guess[i] = word[i];
//                    count++;
//                    flag = true;
//                    break aa;
//                }
//                flag = false;
//            }
//            if (!flag) {
//                System.out.println("wrong guess");
//                wrongCount++;
//            }
//            int counter = 0;
//            for (int i = 0; i < guess.length; i++) {
//                if (guess[i] == '_') {
//                    counter++;
//                }
//            }
//            if (counter == 0) {
//                for (char c : guess) {
//                    System.out.print(c);
//                }
//                System.out.println();
//                winner = true;
//                break bb;
//            }
//        }
//        if (winner) {
//            return 1;
//        } else {
//            return -1;
//        }
    }

//    public static void getFileFromPath
}