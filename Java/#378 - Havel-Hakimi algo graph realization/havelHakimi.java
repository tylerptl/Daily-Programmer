import java.util.Arrays;
import java.util.Collections;

public class havelHakimi {
    private Integer[] familiarity;
   // quickSort qs;
    int arrLength;


    public boolean isStatus() {
        return isTrue;
    }

    boolean isTrue;
    boolean isEmpty;

    havelHakimi(Integer[] nums){
       if(validateArray(nums)){
           familiarity = nums;
           //qs = new quickSort();
           arrLength = familiarity.length;
           isTrue = true;
           isEmpty = checkArrayFill();

       }else{
           System.out.println("Invalid input detected - exiting...");
           System.exit(0);
       }
    }
    boolean validateArray(Integer[] arr){
        for(int n : arr){
            if (n < 0){
                return false;
            }

        }
        return true;
    }



    Integer[] getFamiliarity(){
        return familiarity;
    }
    void setFamiliarity(Integer[] arr){
        familiarity = arr;
    }

    void printArray(Integer[] arr){
        for(int n : arr){
            System.out.print(n + ", ");
        }
        System.out.println(isStatus() + " ");
    }

    void runAlgo(){
        if(isEmpty){
            System.exit(0);
        }
        if(!isTrue){
            return;
        }
        Integer[] arr = getFamiliarity();
        checkArrayFill();
        organizeArray(arr);
        pruneArray(arr);
        printArray(getFamiliarity());
        checkArrayFill();
        decrementArray();


    }

    /**
     * Return true if array is empty. This will mean the input was true.
     * @return
     */
    boolean checkArrayFill(){
        if(getFamiliarity().length == 0){
            isEmpty = true;
            return isEmpty;
        }
        isEmpty = false;
        return isEmpty;
    }
    /** Find the first 0 entry and remove all subsequent entries.
     *
     * @param arr Array which has previously been sorted by organizeArray().
     */
    void pruneArray(Integer[] arr){
        Integer[] newArr;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                //newArr = new int[i-1];
                newArr = Arrays.copyOfRange(arr,0, i);
                setFamiliarity(newArr);
                break;

            }
        }

    }

    void decrementArray(){
        if(isEmpty){
            return;
        }
       Integer[] arr = getFamiliarity();
        int n;
        n = arr[0];
       Integer[] temp = Arrays.copyOfRange(arr, 1, arr.length);
        if(n > temp.length){
            isTrue = false;
            return;
        }
        setFamiliarity(temp);
        runAlgo();

    }

    /**Step one in process is to sort the array in a descending order and prune all 0 entries. This will be done by calling
     * the descendingSort() from quickSort class and then pruning the array w/pruneArray().
     *
     */
    void organizeArray(Integer[] arr){
        Arrays.sort(arr, Collections.reverseOrder());
        //qs.descendingSort(arr, 0, arrLength-1);

    }



}
