import java.util.function.Function;
class Hey {
    public double square(double num) {
        return Math.pow(num, 3);
    }

    public static void main(String... args){
        Hey hey = new Hey();
        Function<Double, Double> square = hey::square;
        double ans = square.apply(12d);

        //System.out.println(ans);
        int n = 10/0;
        System.out.println(n);
    }

}
