import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame implements ActionListener {
    JFrame frame = new JFrame("Tic Tac Toe");
    JButton button[] = new JButton[9];
    String letter = "";
    String[] letters = new String[9];
    String x = "X";
    String o = "O";
    int count = 0;
    boolean win = false;

    public TicTacToeGame() {
        for(int i = 0; i < 9; i++) {
           letters[i] = "";
        }
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 9; i++) {
            button[i] = new JButton();
            frame.add(button[i]);
        }

        for(int i = 0; i < 9; i++) {
            button[i].addActionListener(this);
        }
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if(count % 2 == 0) {
            x = "X";
            letter = "X";
        } else {
            o = "O";
            letter = "O";
        }
        for(int i = 0; i< 9; i++) {
            if(e.getSource() == button[i]) {
                button[i].setText(letter);
           //     button[i].setEnabled(false);
                letters[i] = letter;
            }
        }

// Who Won

        // Horizontal
        if (letters[0].equals(letters[1]) && letters[1].equals(letters[2]) && !letters[0].equals("")) {
            win = true;
        } else if (letters[3].equals(letters[4]) && letters[4].equals(letters[5]) && !letters[3].equals("")) {
            win = true;
        } else if (letters[6].equals(letters[7]) && letters[7].equals(letters[8]) && !letters[6].equals("")) {
            win = true;
        }

        // Vertical
        if (letters[0].equals(letters[3]) && letters[3].equals(letters[6]) && !letters[0].equals("")) {
            win = true;
        } else if (letters[1].equals(letters[4]) && letters[4].equals(letters[7]) && !letters[1].equals("")) {
            win = true;
        } else if (letters[2].equals(letters[5]) && letters[5].equals(letters[8]) && !letters[2].equals("")) {
            win = true;
        }

        // Diagonal
        if (letters[0].equals(letters[4]) && letters[4].equals(letters[8]) && !letters[0].equals("")) {
            win = true;
        } else if (letters[2].equals(letters[4]) && letters[4].equals(letters[6]) && !letters[2].equals("")) {
            win = true;
        }

        if (win) {
            JOptionPane.showMessageDialog(null, "Player " + letter + " wins!");
            for (JButton i : button) {
                i.setEnabled(false);
            }
        } else if (!win && count == 9) {
            JOptionPane.showMessageDialog(null, "The game ended in a tie.");
        }
    }



}
