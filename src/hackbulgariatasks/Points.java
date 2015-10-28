package hackbulgariatasks;

import javax.swing.JOptionPane;

public class Points {

    public static void main(String[] args) {

        int xCoordinate; //not infinite but it will do
        int yCoordinate;
        String givenString;
        String firstInput;
        String secondInput;
        boolean checkDirection = true;

        firstInput = JOptionPane.showInputDialog("Please enter the X coordinate: ");
        xCoordinate = Integer.parseInt(firstInput);
        secondInput = JOptionPane.showInputDialog("Please enter the Y coordinate: ");
        yCoordinate = Integer.parseInt(secondInput);
        JOptionPane.showMessageDialog(null, String.format("Your current possition is: (%d, %d)", xCoordinate, yCoordinate));
        givenString = JOptionPane.showInputDialog("Please enter your directions: ");
        char[] directionsArray = givenString.toCharArray();

        for (int i = 0; i < directionsArray.length; i++) {
            switch (directionsArray[i]) {
                case '<':
                    if (checkDirection) {
                        xCoordinate--;
                    } 
                    else {
                        xCoordinate++;
                    }
                    break;
                case '>':
                    if (checkDirection) {
                        xCoordinate++;
                    } 
                    else {
                        xCoordinate--;
                    }
                    break;
                case '^':
                    if (checkDirection) {
                        yCoordinate--;
                    } //y decreases upwards
                    else {
                        yCoordinate++;
                    }
                    break;
                case 'v':
                    if (checkDirection) {
                        yCoordinate++;
                    } //and increases downwards
                    else {
                        yCoordinate--;
                    }
                    break;
                case '~':
                    if (checkDirection) {
                        checkDirection = false;
                    } 
                    else {
                        checkDirection = true;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong input!");
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, String.format("Your new coordinates are: (%d, %d)", xCoordinate, yCoordinate));
    }

}
