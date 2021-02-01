public class Driver {
    public static void main(String... args){
        //Calendar cal = new Calendar(123456, 7891011);
        Calendar cal = new Calendar(123456789101112L, 1314151617181920L);
//        cal.iterateYears();
//        cal.displayStats();

        cal.alternateIterateYears(123456789101112L, 1314151617181920L);
        //cal.alternateIterateYears(1234, 5678);

        cal.displayStats();
    }
}
