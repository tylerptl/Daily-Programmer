import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String... args) throws IOException {
        List<String> wordList = new ArrayList<>();
        Scanner kb = new Scanner(System.in);
        funnel funnel = new funnel();
        System.out.println("Enter your base word...");
        String in = kb.nextLine();
        System.out.println("Entered - " + in + " Enter the word you would like to check...");
        String check = kb.nextLine();
        System.out.println("Entered - " + check +" - comparing now...");

        funnel.compare(in,check);

        BufferedReader br = new BufferedReader(new FileReader("enable1.txt"));

        //Optional 1

        String line;

        System.out.println("Now searching through enable1 word list for (" + in + ")...");

        while((line =br.readLine())!= null){
            wordList.add(line);
        }
        funnel.optionalOne(in, wordList);

        funnel.bonus2("enable1.txt");




    }
}
