// ADD YOUR IMPORTS HERE
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;


/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out the actual game and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

// ADD YOUR INSTANCE VARIABLES HERE

    GameModel model;
    GameController gameController;
    JPanel dotPanel;
    JPanel buttonPanel;
    JPanel menuPanel;
    int size;
    DotButton d;
    DotButton d0, d1, d2, d3, d4, d5;



    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) {

// ADD YOUR CODE HERE
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.model = model;
        this.gameController = gameController;
        size = model.getSize();
        setTitle("Laboratory 4: Move it!");
        dotPanel = new JPanel(new GridLayout(size, size, 0, 0));

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                d = new DotButton(i, j, model.getColor(i,j), size);
                d.setBorderPainted(false);


                dotPanel.add(d);
            }
        }

        buttonPanel = new JPanel(new GridLayout(1, 6));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        /*for (int i = 0; i < 6; i++){
            d = new DotButton(i, size);
            d.addActionListener(gameController);
            d.setBorderPainted(false);
            buttonPanel.add(d);
    
            
        }
        
        */

        d0 = new DotButton(0, size);
        d0.addActionListener(gameController);
        d0.setBorderPainted(false);
        buttonPanel.add(d0);

        d1 = new DotButton(1, size);
        d1.addActionListener(gameController);
        d1.setBorderPainted(false);
        buttonPanel.add(d1);

        d2 = new DotButton(2, size);
        d2.addActionListener(gameController);
        d2.setBorderPainted(false);
        buttonPanel.add(d2);

        d3 = new DotButton(3, size);
        d3.addActionListener(gameController);
        d3.setBorderPainted(false);
        buttonPanel.add(d3);

        d4 = new DotButton(4, size);
        d4.addActionListener(gameController);
        d4.setBorderPainted(false);
        buttonPanel.add(d4);

        d5 = new DotButton(5, size);
        d5.addActionListener(gameController);
        d5.setBorderPainted(false);
        buttonPanel.add(d5);


        add(dotPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setResizable(false); 
        pack();
        setVisible(true);


        menuPanel = new JPanel();




    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

    	 dotPanel = new JPanel(new GridLayout(size, size, 0, 0));

         for (int i = 0; i < size; i++){
             for (int j = 0; j < size; j++){
            	 
            	 if (model.isCaptured(i, j)){
            		 d = new DotButton(i, j, model.getCurrentSelectedColor(), size);
            	 } else
            	 
                 d = new DotButton(i, j, model.getColor(i,j), size);
                 d.setBorderPainted(false);


                 dotPanel.add(d);
             }
         }    	
// ADD YOUR CODE HERE

    }


}
