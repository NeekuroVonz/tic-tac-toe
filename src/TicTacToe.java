import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;
    // int[][] winCombNumsNums = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6},{1,4,7},{2,5,8}, {0,4,8},{2,4,6}};
    Integer[] horizontalComb = {0,1,2};
    Integer[] verticalComb = {0,3,6};
    Integer[] specialComb1 = {0,4,8};
    Integer[] specialComb2 = {2,4,6};
    List<Integer[]> winCombNums = new ArrayList<>();
    List<Integer> player1 = new ArrayList<>();
    List<Integer> player2 = new ArrayList<>();

    TicTacToe() {
        winCombNums.add(horizontalComb.clone());
        for (int i = 0; i < winCombNums.size(); i++) {
            Integer[] temp;
            if (!winCombNums.isEmpty() && winCombNums.size() < 3) {
                for (int j = 0; j < horizontalComb.length; j++) {
                    horizontalComb[j] += 3;
                }
                temp = horizontalComb.clone();
                winCombNums.add(temp);
                if (winCombNums.size() == 3) {
                    winCombNums.add(verticalComb.clone());
                }
            } else {
                for (int j = 0; j < verticalComb.length; j++) {
                    verticalComb[j] += 1;
                }
                temp = verticalComb.clone();
                if (winCombNums.size() >= 6) {
                    winCombNums.add(specialComb1);
                    winCombNums.add(specialComb2);
                    break;
                } else {
                    winCombNums.add(temp);
                }
            }
        }
        System.out.println(Arrays.deepToString(winCombNums.toArray()));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(255, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1.add(i);
                        player1Turn = false;
                        textField.setText("O turn");
                        check(player1);
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player2.add(i);
                        player1Turn = true;
                        textField.setText("X turn");
                        check(player2);
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
        }

        if (random.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X turn");
        } else {
            player1Turn = false;
            textField.setText("O turn");
        }
    }

    public void check(List<Integer> player) {
        System.err.println(player);
        for (int i = 0; i < winCombNums.size(); i++) {
            if (Arrays.equals(winCombNums.get(i), player.toArray())) {
                System.out.println("You win");
            }
        }
    }
    
    public void xWins(int a, int b, int c) {

    }
    public void oWins(int a, int b, int c) {

    }
}
