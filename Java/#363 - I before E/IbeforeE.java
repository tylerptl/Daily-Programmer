/**
 * https://www.reddit.com/r/dailyprogrammer/comments/8q96da/20180611_challenge_363_easy_i_before_e_except/
 */

import java.io.*;
public class IbeforeE {
    private static int exceptions, numTrue, numFalse;

    public static void main(String... args) throws IOException {
        String[] arr = {"a", "zombie", "transceiver", "veil", "icier", "ciecei", "ceiei"};
        for(String str : arr){
            System.out.println(check(str));
        }
        // Code for bonus area below
        exceptions = 0;
        numTrue = 0;
        numFalse = 0;

        System.out.println("\n\nChecking for exceptions in enable1.txt");

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asdf\\Documents\\Programming\\Java Work\\Daily Programmer Challenges\\#363 - I before E\\enable1.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            check(line);

        }


        System.out.println("Exceptions found: " + exceptions);
        System.out.println("True = " + numTrue + ", false = " + numFalse);
        System.out.println("Complete.");

    }

   private static boolean check(String str){

        if(!str.contains("ei")){
           if(str.contains("cie")){
               exceptions++;
               numFalse++;
               return false;
           }
           numTrue++;
           return true;
        }
        if(str.contains("cei") && str.length() < 5){
           numTrue++;
           return true;

        }if(str.contains("cei") && str.length()>3){
            String prefix, suffix;
            int index = str.indexOf("cei");
            prefix = str.substring(0, index);
            suffix = str.substring(index+3, str.length());
            if(prefix.contains("ei") || prefix.contains("cie") || suffix.contains("ei") || suffix.contains("cie")){
                numFalse++;
                return false;
            }else{
                numTrue++;
                return true;
            }

            //checkExpanded(str.substring(str.indexOf("cei")+3));
        }
        if(str.contains("ei") && !str.contains("cei")){
            exceptions++;
            numFalse++;
            return false;
        }

        numTrue++;
        return true;


    }
}


