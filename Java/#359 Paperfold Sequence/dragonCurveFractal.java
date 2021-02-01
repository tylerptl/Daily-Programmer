import java.util.stream.IntStream;

public class dragonCurveFractal {
    public static void main(String... args){
        IntStream.range(1, 1 << 8)
                // get bitwise compliment and shift right
                .map(i ->~(i >> Integer.numberOfTrailingZeros(i) + 1) & 1)
                .forEach(System.out::print);
    }
}
