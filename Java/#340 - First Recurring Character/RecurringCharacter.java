/**
 * This program will return the first character that recurs in the input.
 * Example: ABBA = A, ABCDEBC = B
 */
public class RecurringCharacter {
    String input;
    public void findRecurrance(String str){



        if(str.length() < 2 ){
            System.out.println("No match found.");
            return;
        }
        char c = str.charAt(0);
        System.out.println("String = " + str + ", char = " + c);
        if(str.substring(1).contains(Character.toString(c))){
            System.out.println(c + " is the first recurring character");
        }else{
            findRecurrance(str.substring(1));
        }
    }

    public static void main(String[] args){
        RecurringCharacter rc = new RecurringCharacter();
        rc.input = "";
        rc.findRecurrance(rc.input);


    }
}
