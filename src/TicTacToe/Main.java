package TicTacToe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JFrame window;
    JPanel mainPanel,leftPanel,rightPanel,playersButtonPanel,layoutButtonsPanel;
    JRadioButton one, two, threeByThree,fourByFour;
    JButton startGame;
    String numOfPlayers,layoutSize;
    public Main(){
        window = new JFrame("Tic Tac Toe");
        mainPanel = new JPanel(new GridLayout(1,2));
        rightPanel = new JPanel(new GridLayout(2,1));
        leftPanel = new JPanel(new GridLayout(2,1));
        playersButtonPanel = new JPanel(new GridLayout(1,2));
        layoutButtonsPanel = new JPanel(new GridLayout(1,2));

        //players buttons setup
        ButtonGroup playersNum = new ButtonGroup();
        one = new JRadioButton("1");
        two = new JRadioButton("2");
        playersNum.add(one);
        playersNum.add(two);
        playersButtonPanel.add(one);
        playersButtonPanel.add(two);
        leftPanel.add(new JLabel("Number of Players: "));
        leftPanel.add(playersButtonPanel);
        //layout buttons setup
        ButtonGroup layoutNum = new ButtonGroup();
        threeByThree = new JRadioButton("Three By Three");
        fourByFour = new JRadioButton("Four By Four");
        layoutNum.add(threeByThree);
        layoutNum.add(fourByFour);
        layoutButtonsPanel.add(threeByThree);
        layoutButtonsPanel.add(fourByFour);
        rightPanel.add(new JLabel("Board Layout: "));
        rightPanel.add(layoutButtonsPanel);

        //main panel setup
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        //add buttons to an action listener
        one.addActionListener(new buttonListener());
        two.addActionListener(new buttonListener());
        threeByThree.addActionListener(new buttonListener());
        fourByFour.addActionListener(new buttonListener());
        startGame = new JButton("Start");
        startGame.addActionListener(e -> {
            if(layoutSize==null||numOfPlayers==null){
                JOptionPane.showMessageDialog(window, "Please select the layout and the number of players!");
                return;
            }

            if(layoutSize.equals("Three By Three"))
                new ThreexThreeGUI(numOfPlayers);
            else
                new FourxFourGUI(numOfPlayers);
            window.dispose();
        });

        //window setup
        window.add(mainPanel,BorderLayout.CENTER);
        window.add(startGame,BorderLayout.SOUTH);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
    private class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == one)
                numOfPlayers = "1";
            if(e.getSource() == two)
                numOfPlayers = "2";
            if(e.getSource() == threeByThree)
                layoutSize = "Three By Three";
            if(e.getSource() == fourByFour)
                layoutSize = "Four By Four";
        }
    }
public static void main(String[] args) {new Main();}
}
