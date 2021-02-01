import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Driver {
    public static void main(String... args) throws IOException {
        Trie wordTrie;
        wordTrie = new Trie();
        List<String> words = Files.lines(Paths.get("enable1.txt"))
                .filter(x -> x.length() > 0)
                .collect(Collectors.toList());
        words

                .forEach(wordTrie::insert);


//        var testWords = new String[]{"gnash","princesses"};
//
//        for(String str: testWords) {
//            System.out.println(str);
//            wordTrie.insert(str);
//
//        }
        System.out.println(wordTrie.search("zygote"));
        System.out.println(wordTrie.startsWith("gn"));
        wordTrie.getLongestWord("gnash");







    }
}
