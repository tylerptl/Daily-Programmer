import java.util.ArrayList;

public class TransitionCipher {
    private final char[][] charGrid;
    private final String rotation;
    private final int nRow, nCol;



    public TransitionCipher(String str) {
        int begin = 1;
        int end = str.lastIndexOf("\"");
        int braceBegin = str.lastIndexOf("(");
        int braceEnd = str.lastIndexOf(")");

        int i, j;
        char[] arr = str.substring(begin, end).toCharArray();
        String grid = str.substring(braceBegin+1, braceEnd);
        String[] size = grid.split(", ");
        this.nCol = Integer.parseInt(size[0]);
        this.nRow = Integer.parseInt(size[1]);
        this.rotation = str.substring(braceEnd + 2);
        ArrayList<Character> charList = new ArrayList<>();

        for (i = 0; i < arr.length; i++) {
            j = (int) arr[i];
            if ((j > 64 && j < 91)) {
                charList.add(arr[i]);
            } else if ((j > 96 && j < 123)) {
                charList.add((char) (j - 32));

            }
        }
        //Fill in the blanks with X
        while (charList.size() < (nCol * nRow)) {
            charList.add('X');
        }
        this.charGrid = new char[nRow][nCol];
        i = 0;
        j = 0;
        for (char c : charList) {
            this.charGrid[i][j++] = c;
            if (j == nCol) {
                j = 0;
                i++;
            }
        }
        if (rotation.equals("clockwise")) {
            this.clockwise(this.charGrid, 0, this.nCol - 1, 0, this.nRow - 1);
        } else {
            this.counterClock(this.charGrid, 0, this.nCol - 1, 0, this.nRow - 1);
        }
        System.out.println();
    }
    private void counterClock(char[][] matrix, int rowStart, int colStart, int colLength, int rowLength) {
        for (int i = colStart; i >= colLength; i--) {
            System.out.print(matrix[rowStart][i]);
        }
        for (int i = rowStart + 1; i <= rowLength; i++) {
            System.out.print(matrix[i][colLength]);
        }
        if (colLength + 1 < colStart) {
            for (int i = colLength + 1; i <= colStart; i++) {
                System.out.print(matrix[rowLength][i]);
            }
            for (int i = rowLength - 1; i > rowStart; i--) {
                System.out.print(matrix[i][colStart]);
            }
        }
        if (rowStart + 1 <= rowLength - 1 && colLength + 1 <= colStart - 1) {
            counterClock(matrix, rowStart + 1, colStart - 1, colLength + 1, rowLength - 1);
        }
    }

    private void clockwise(char[][] matrix, int rowStart, int colStart, int colStop,  int rowLength){
        for (int i = rowStart; i <= rowLength; i++) {
            System.out.print(matrix[i][colStart]);
        }
        for (int i = colStart-1; i >=colStop; i--) {
            System.out.print(matrix[rowLength][i]);
        }
        if(rowStart+1<=rowLength) {
            for (int i = rowLength-1; i >= rowStart; i--) {
                System.out.print(matrix[i][colStop]);
            }
            for (int i = colStop+1; i < colStart; i++) {
                System.out.print(matrix[rowStart][i]);
            }
        }
        if(rowStart+1<=rowLength-1 && colStop+1<colStart-1){
            clockwise(matrix, rowStart+1, colStart-1, colStop+1, rowLength-1);
        }

    }

}
