import java.util.HashMap;

public class BalanceCheck {
    private HashMap<String, MutableInt> alphaMap;
    private String str;

    BalanceCheck(){

    }
//    BalanceCheck(String str){
//        alphaMap = new HashMap<>();
//        this.str = str;
//    }
    void processString(String str){
        alphaMap = new HashMap<>();

        boolean result;
        this.str = str;
        if(str.length() == 0){
            result = true;
            System.out.println("Result = " + result + "\n\n");
        }
        else if(str.length() == 1){
            result = false;
            System.out.println("Result = " + result + "\n\n");
        }
        else{
            iterateString();
            result = checkBalance();
            System.out.println("Result = " + result + "\n\n");
        }


    }

    void iterateString(){
        for(char c : str.toCharArray()){
            String s = Character.toString(c);
            MutableInt count = alphaMap.get(s);
            if(count == null){
                alphaMap.put(s, new MutableInt());
            }
            else{
                count.increment();
            }
        }

    }
    boolean checkBalance(){
       // System.out.println("Checking balance of ( " + str + " ).");
        boolean first = true;
        MutableInt frequency = new MutableInt();

        for(MutableInt m : alphaMap.values()){
            if(first){
                frequency = m;
                System.out.println("String ( " + str + " ); Minimum frequency = " + frequency.get());
                first = false;

            }
            else{
                if(m.get() != frequency.get()){
                    return false;
                }
            }
        }
        return true;
    }
}
