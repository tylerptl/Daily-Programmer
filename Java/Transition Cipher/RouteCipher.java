import java.util.ArrayList;

public class RouteCipher {
    private final char[][] charGrid;
    private final String rotation;
    private final int nRow, nCol;

    public RouteCipher(String s) {
        int quoteBegin = 1;
        int quoteEnd = s.lastIndexOf("\"");
        int braceBegin = s.lastIndexOf("(");
        int braceEnd = s.lastIndexOf(")");
        int i, j;
        char[] arr = s.substring(quoteBegin, quoteEnd).toCharArray();
        String grid = s.substring(braceBegin + 1, braceEnd);
        String[] gridSize = grid.split(", ");
        this.nRow = Integer.parseInt(gridSize[1]);
        this.nCol = Integer.parseInt(gridSize[0]);
        this.rotation = s.substring(braceEnd + 2);
        ArrayList<Character> charList = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            j = (int) arr[i];
            if ((j > 64 && j < 91)) {
                charList.add(arr[i]);
            } else if ((j > 96 && j < 123)) {
                charList.add((char) (j - 32));
            }
        }
        while (charList.size() < (nCol * nRow))
            charList.add('X');
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
            this.rotateClockwise(this.charGrid, 0, this.nCol - 1, 0, this.nRow - 1);
        } else {
            this.rotateCounter(this.charGrid, 0, this.nCol - 1, 0, this.nRow - 1);
        }
        System.out.print("\n");
    }

    private void rotateCounter(char[][] matrix, int rowStart, int colStart, int colLength, int rowLength) {
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
            rotateCounter(matrix, rowStart + 1, colStart - 1, colLength + 1, rowLength - 1);
        }
    }

    private void rotateClockwise(char[][] matrix, int rowStart, int colStart, int colEnd, int rowLength) {
        for (int i = rowStart; i <= rowLength; i++) {
            System.out.print(matrix[i][colStart]);
        }
        for (int i = colStart - 1; i >= colEnd; i--) {
            System.out.print(matrix[rowLength][i]);
        }
        if (rowStart + 1 <= rowLength) {
            for (int i = rowLength - 1; i >= rowStart; i--) {
                System.out.print(matrix[i][colEnd]);
            }
            for (int i = colEnd + 1; i < colStart; i++) {
                System.out.print(matrix[rowStart][i]);
            }
        }
        if (rowStart + 1 <= rowLength - 1 && colEnd + 1 < colStart - 1) {
            rotateClockwise(matrix, rowStart + 1, colStart - 1, colEnd + 1, rowLength - 1);
        }
    }

}