public class Driver {
    public static void main(String... args){
        Integer[] arr = new Integer[]{14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12};
        havelHakimi algo = new havelHakimi(arr);
        algo.runAlgo();
        System.out.println(algo.isTrue);


    }
}
