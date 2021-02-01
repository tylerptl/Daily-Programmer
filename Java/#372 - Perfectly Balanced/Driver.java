public class Driver {
    public static void main(String... args){
        //var bc = new BalanceCheck("xxxyyyzzz");

        var bc = new BalanceCheck();
        bc.processString("xxxyyy");
        bc.processString("yyyxxx");
        bc.processString("xxxyyyy");
        bc.processString("yyxyxxyxxyyyyxxxyxyx");
        bc.processString("xyxxxxyyyxyxxyxxyy");
        bc.processString("");
        bc.processString("x");



//        bc.iterateString();
//        boolean result = bc.checkBalance();
//        System.out.println("Result = " + result);
    }
}
