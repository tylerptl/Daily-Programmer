import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Baum Sweet Sequence:
 *
 *      In mathematics, the Baum–Sweet sequence is an infinite automatic sequence of 0s and 1s defined by the rule:
 *       b_n = 1 if the binary representation of n contains no block of consecutive 0s of odd length;
 *       b_n = 0 otherwise;
 *       for n >= 0.
 *
 *
 *
 * https://www.reddit.com/r/dailyprogrammer/comments/7j33iv/20171211_challenge_344_easy_baumsweet_sequence/
 *
 * @author Tyler Crill
 * @version 1/13/18
 */


public class BaumSweetSequence {
    public static void main(String [] args){
        IntStream.rangeClosed(1, 20)
                .mapToObj(i -> Arrays.stream(Integer.toBinaryString(i).split("1"))
                        .anyMatch(in -> in.length()  % 2 == 1))     // if the element contains odd amount of 0 in a block
                .collect(toList()).forEach(b-> System.out.print((b?0:1) + ", "));   // then collect it in a list and print 0, else collect and print 1
    }

}
