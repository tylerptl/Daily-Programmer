import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/
 *
 * Given two strings of letters, determine whether the second can be made from the first
 * by removing one letter. The remaining letters must stay in the same order.
 *
 * funnel("leave", "eave") => true
 * funnel("reset", "rest") => true
 * funnel("dragoon", "dragon") => true
 * funnel("eave", "leave") => false
 * funnel("sleet", "lets") => false
 * funnel("skiff", "ski") => false
 */

public class funnel {
    char[] baseWord, testWord;

    funnel(){


    }

    boolean compare(String input, String check){
        baseWord = input.toCharArray();
        testWord = check.toCharArray();

        //Remove any strings that obviously don't match
        if(check.length() >= input.length() || input.length() - check.length() > 1){
            System.out.println("check length invalid - dismissing...");
            return false;
        }

        for(int i =0; i < testWord.length; i++){
            if(testWord[i] != baseWord[i]){
                if(baseWord[i+1] != testWord[i]){
                    System.out.println("\nChecked string can not be created by removing one character.");
                    return false;
                }
            }
        }
        System.out.println("\n("+check+") is a viable mutation of (" + input + ").");
        return true;

    }

    void optionalOne(String input, List<String> list){
        String resultString;
        ArrayList<String> matchedWords = new ArrayList();

        long start = System.nanoTime();

        for(int i = 0; i < input.length(); i++){
            // Prevent duplicate characters causing duplicate returns i.e boots returning bots twice
            if(i>0 && input.charAt(i-1) == input.charAt(i)){
                continue;
            }
            StringBuilder sb = new StringBuilder(input);
            resultString = sb.deleteCharAt(i).toString();
            if(list.contains(resultString)){
                matchedWords.add(resultString);

            }

        }

        if(matchedWords.size()>= 1){
            System.out.print(matchedWords.get(0));
        }
        for(int i = 1; i < matchedWords.size(); i++){
            System.out.print(", " + matchedWords.get(i));
        }

        long finish = System.nanoTime();
        long elapsedTime = finish - start;
        double seconds = (double)elapsedTime/1000000000;
        System.out.println("\n**Elapsed time in seconds: " + seconds);
    }

    public static void bonus2(String filename) throws IOException {
        var words = Files.lines(Paths.get(filename)).collect(toSet());

        words.stream().map(word -> List.of(word,
                IntStream.range(0, word.length())
                        .mapToObj(i -> word.substring(0, i) + word.substring(i+1, word.length())).filter(words::contains).collect(toSet())))
                .filter(l -> ((Set<String>) l.get(1)).size() >= 5)
                .forEach(item -> {System.out.println(item.get(0) + ": " + ((Set<String>) item.get(1)).stream().collect(joining(",")));});

    }




}
