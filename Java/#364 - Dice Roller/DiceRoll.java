import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class DiceRoll {
    public static void main(String... args) throws IOException {
        BufferedReader br;
        int dice, maxRoll, count, sum;
        String line;
        int[] allRolls;
        br = new BufferedReader(new FileReader("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#364 - Dice Roller\\rolls.txt"));


        while((line = br.readLine()) != null){
            sum =0;
            count = 0;
            dice = Integer.parseInt(line.split("d")[0]);
            maxRoll = Integer.parseInt(line.split("d")[1]);
            allRolls = new int[dice];
            while(count < dice){
                int val = roll(maxRoll);
                allRolls[count] = val;
                sum += val;
                count++;
            }

            System.out.println("Number of dice to roll : " + dice + ", Number of sides: " + maxRoll);
            System.out.print(sum + ": ");
            for(int n : allRolls){
                System.out.print(n + " ");
            }
            System.out.println("\n");

        }
    }

    public static int roll(int n){
        int min, max;
        min = 1;
        max = n;

        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }
}
