
import java.util.ArrayList;
import java.util.Arrays;

public class Ducci {
    public static int count;
    public static ArrayList<int[]> tempMatrix;
    public static void main(String... args){

        int[][] sets = {
                {1, 5, 7, 9, 9},
                {1, 2, 1, 2, 1, 0},
                {10, 12, 41, 62, 31, 50},
                {0, 653, 1854, 4063},
                {10, 12, 41, 62, 31}
        };


        for(int[] set : sets){
            tempMatrix = new ArrayList<>();
            tempMatrix.add(set);
            System.out.print(Arrays.toString(tempMatrix.get(0))+ "\n");
            count = 1;
            calc(set);
            System.out.println(count + " cycles to reach full 0's or to find repeat");
        }

    }

    static int calc(int[] arr){
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] >= arr[i+1]){
                temp[i] = arr[i] - arr[i+1];
            }else{
                temp[i] = arr[i+1] - arr[i];
            }
        }
        if(arr[arr.length-1] <= arr[0]){
            temp[arr.length-1] = arr[0] - arr[arr.length-1];
        }else{
            temp[arr.length-1] = arr[arr.length-1] - arr[0];
        }

        count++;

        //System.out.print(Arrays.toString(temp) + "\n");
        for(int[] m : tempMatrix){
            if(Arrays.equals(m, temp)){
                return count;
            }
        }

        if(!isZero(temp)){
            tempMatrix.add(temp);
            calc(temp);
        }

        return count;


    }
    static boolean isZero(int[] arr){
        for(int n: arr){
            if(n != 0){
                return false;
            }

        }
        return true;
    }

}
