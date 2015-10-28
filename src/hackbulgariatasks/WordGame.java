package hackbulgariatasks;

import javax.swing.JOptionPane;

public class WordGame {

    private char[][] table;
    private String word;

    public WordGame(char[][] table, String word) {
        this.setTable(table);
        this.setWord(word.toUpperCase());
    }

    public WordGame() {
        this.table = new char[][]{{'S', 'S', 'S'}, {'S', 'S', 'S'}, {'S', 'S', 'S'}};
        this.word = "SSS";
    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        boolean isUpperCaseLetter = false;
        for (char[] row : table) {
            for (char element : row) {
                if (Character.isLetter(element)) {
                    isUpperCaseLetter = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong table input!");
                    System.exit(0);
                }
                if (Character.isUpperCase(element)) {
                    isUpperCaseLetter = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong table input!\nLower case letters!");
                    System.exit(0);
                }
            }
        }
        if (isUpperCaseLetter) {
            this.table = table;
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        if (word == null) {
            JOptionPane.showMessageDialog(null, "Wrong word input!");
            System.exit(0);
        } else if (word.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Wrong word input!");
            System.exit(0);
        } else {
            this.word = word;
        }
    }

    public int rowCheck() {
        int rowReps = 0;
        for (char[] row : table) {
            String rowWord = new String(row);
            if (word.length() > rowWord.length()) {
                break;
            }
            String wordRow = new StringBuilder(rowWord).reverse().toString();
            if (rowWord.contains(word) || wordRow.contains(word)) {
                rowReps++;
            }
        }
        return rowReps;
    }

    public int columnCheck() {
        int columnReps = 0;
        String columnWord = "";
        for (int column = 0; column < table[0].length; column++) {
            for (int row = 0; row < table.length; row++) {
                columnWord += Character.toString(table[row][column]);
            }
            if (word.length() > columnWord.length()) {
                break;
            }
            String wordColumn = new StringBuilder(columnWord).reverse().toString();
            if (columnWord.contains(word) || wordColumn.contains(word)) {
                columnReps++;
            }
        }
        return columnReps;
    }
    //almost works
    public int diagonalCheck() {
        int diagonalReps = 0;
        String diagonalWord = "";
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                int x = i;
                int y = j;
                while (x < table.length && y < table[0].length) {
                    diagonalWord += Character.toString(table[x++][y++]);
                }
                String wordDiagonal = new StringBuilder(diagonalWord).reverse().toString();
                if (diagonalWord.contains(word) || wordDiagonal.contains(word)) {
                    diagonalReps++;
                }
            }
        }
        for (int i = table.length - 1; i >= 0; i--) {
            for (int j = table[0].length - 1; j >= 0; j--) {
                int x = i;
                int y = j;
                while (x >= 0 && y >= 0) {
                    diagonalWord += Character.toString(table[x--][y--]);
                }
                String wordDiagonal = new StringBuilder(diagonalWord).reverse().toString();
                if (diagonalWord.contains(word) || wordDiagonal.contains(word)) {
                    diagonalReps++;
                }
            }
        }
        return diagonalReps;
    }

    public String checkTable() {
        int result = this.rowCheck() + this.columnCheck() /*+ this.diagonalCheck()*/;
        return Integer.toString(result);
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(Character.toString(table[i][j]) + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        System.out.println("Table: ");
        this.printTable();
        return String.format("Word: %s", word);
    }

}
