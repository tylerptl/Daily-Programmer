import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    private TrieNode root;
    HashMap<Character, ArrayList<String>> wordMap = new HashMap<>(); // Tracks max length for each initial removal
    ArrayList<String> tempArray = new ArrayList<>();

    public Trie(){
        root = new TrieNode();
    }

    //Insert into trie
    public void insert(String str){
        TrieNode p = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            }else{
                p = p.arr[index];
            }
        }
        //System.out.println("Added : " +str);

        p.isEnd = true;
    }

    //Returns if word exists in trie
    public boolean search(String str){
        TrieNode p = searchNode(str);
        if(p==null){
            return false;
        }else{
            if(p.isEnd){
                return true;
            }
        }
        return false;
    }

    //Returns if any word starts with given prefix
    public boolean startsWith(String prefix){
        TrieNode p = searchNode(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!= null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
        if(p==root){
            return null;
        }
        return p;
    }
    //This will return the value of the longest word found after removing
    //a single character each iteration.
    //TODO: Instead of having a counter try adding words to array and getting array length for total funnel size
    public int getLongestWord(String str){
        String temp;

        for(char c: str.toCharArray()){
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(str.indexOf(c));
            temp = sb.toString();
            //System.out.println(temp);

            //Check to see if there is a matching word - continue if false
            if(!search(temp)){
                //System.out.println(temp + " not found - continuing...");

                continue;
            }else{
                System.out.println("** " + temp + "** was found - looking deeper");
                getLongestWord(temp);
                tempArray.add(temp);
                wordMap.put(c, tempArray);
            }


        }

        return 0;

    }
}
