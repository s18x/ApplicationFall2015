package hackbulgariatasks;

import javax.swing.JOptionPane;

public class WordGameTest {

    public static void main(String[] args) {

        char[][] testArray = new char[][]{
            {'I', 'V', 'A', 'N'},
            {'E', 'V', 'N', 'H'},
            {'I', 'N', 'A', 'V'},
            {'M', 'V', 'V', 'N'},
            {'Q', 'R', 'I', 'T'}
        };
        String word = JOptionPane.showInputDialog("Please enter your word: (ivan)");
        WordGame game = new WordGame(testArray, word);
        JOptionPane.showMessageDialog(null, game.checkTable());
        System.out.println(game.toString());
    }
}
