public class Driver {
    public static void main(String... args){
        String[] inputs =       // Test input success
                {"0100110",
                "01001100111",
                "100001100101000"};

        String[] challengeInput = {"010111111111100100101000100110111000101111001001011011000011000"};  // Challenge input success
       // var solutions = new SolutionFind(inputs);
        var solutionsChallenge = new SolutionFind(challengeInput);

        solutionsChallenge.findSolutions();

    }
}
