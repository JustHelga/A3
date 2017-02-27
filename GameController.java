import java.awt.event.*;
/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

 // ADD YOUR INSTANCE VARIABLES HERE
    GameView gameView;
    GameModel gameModel;
    int size;
    DotStack myStack;


    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) {

// ADD YOUR CODE HERE
        gameModel = new GameModel(size);
        this.size = size;
        gameView = new GameView(gameModel, this);

    }

    /**
     * resets the game
     */
    public void reset(){

// ADD YOUR CODE HERE
        gameModel.reset();



    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {

// ADD YOUR CODE HERE
        String command; 
        command = e.getActionCommand(); 
        if (command.equals("0")){
           selectColor(0);
            System.out.println(command);
        } else if (command.equals("1")){
            selectColor(1);
            System.out.println(command);
        } else if (command.equals("2")){
            //selectColor(2);
            System.out.println(command);
        } else if (command.equals("3")){
            //selectColor(3);
            System.out.println(command);
        } else if (command.equals("4")){
            //selectColor(4);
            System.out.println(command);
        } else if (command.equals("5")){
            //selectColor(5);
            System.out.println(command);
        } else if (command.equals("Reset")){
            reset();
        } else if (command.equals("Quit")){
            System.exit(0);
        }
        
        gameView.update();
/*
        switch(command){
            case "Grey":
                break;
            case default:
                break;

        }

*/
    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives two options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){

// ADD YOUR CODE HERE
        int tempX;
        int tempY;
        DotInfo temp;
        if (color != gameModel.getCurrentSelectedColor()){
        	gameModel.setCurrentSelectedColor(color);
            myStack = new DotStack(size);
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    if (gameModel.isCaptured(i,j)){
                        myStack.push(gameModel.get(i,j));
                    }
                }
            }

            for (int i = 0; i < myStack.counter; i++){
                System.out.println(myStack.dots[i]);
            }

            while (!myStack.isEmpty()){
                temp = myStack.pop();
                tempX = temp.getX();
                tempY = temp.getY();

                if (tempX == 0 && tempY == 0){
                    
                    if (gameModel.getColor(tempX + 1, tempY) == color && !gameModel.isCaptured(tempX + 1, tempY)){
                        gameModel.capture(tempX + 1, tempY);
                        myStack.push(gameModel.get(tempX + 1, tempY));
                    }
                    
                    if (gameModel.getColor(tempX, tempY + 1) == color && !gameModel.isCaptured(tempX, tempY + 1)){
                        gameModel.capture(tempX, tempY + 1);
                        myStack.push(gameModel.get(tempX, tempY + 1));
                    }

                } else if (tempX == 0 && tempY != 0){
                    
                    if (gameModel.getColor(tempX + 1, tempY) == color && !gameModel.isCaptured(tempX + 1, tempY)){
                        gameModel.capture(tempX + 1, tempY);
                        myStack.push(gameModel.get(tempX + 1, tempY));
                    }

                    if (gameModel.getColor(tempX, tempY + 1) == color && !gameModel.isCaptured(tempX, tempY + 1)){
                        gameModel.capture(tempX, tempY + 1);
                        myStack.push(gameModel.get(tempX, tempY + 1));
                    }
                    
                    if (gameModel.getColor(tempX, tempY - 1) == color && !gameModel.isCaptured(tempX, tempY - 1)){
                        gameModel.capture(tempX, tempY - 1);
                        myStack.push(gameModel.get(tempX, tempY - 1));
                    }

                } else if (tempX != 0 && tempY == 0){
                    if (gameModel.getColor(tempX + 1, tempY) == color && !gameModel.isCaptured(tempX + 1, tempY)){
                        gameModel.capture(tempX + 1, tempY);
                        myStack.push(gameModel.get(tempX + 1, tempY));
                    }
                    
                    if (gameModel.getColor(tempX - 1, tempY) == color && !gameModel.isCaptured(tempX - 1, tempY)){
                        gameModel.capture(tempX - 1, tempY);
                        myStack.push(gameModel.get(tempX - 1, tempY));
                    }
                    
                    if (gameModel.getColor(tempX, tempY + 1) == color && !gameModel.isCaptured(tempX, tempY + 1)){
                        gameModel.capture(tempX, tempY + 1);
                        myStack.push(gameModel.get(tempX, tempY + 1));
                    }

                } else {


                    if (gameModel.getColor(tempX + 1, tempY) == color && !gameModel.isCaptured(tempX + 1, tempY)){
                        gameModel.capture(tempX + 1, tempY);
                        myStack.push(gameModel.get(tempX + 1, tempY));
                    }
                    
                    if (gameModel.getColor(tempX - 1, tempY) == color && !gameModel.isCaptured(tempX - 1, tempY)){
                        gameModel.capture(tempX - 1, tempY);
                        myStack.push(gameModel.get(tempX - 1, tempY));
                    }
                    
                    if (gameModel.getColor(tempX, tempY + 1) == color && !gameModel.isCaptured(tempX, tempY + 1)){
                        gameModel.capture(tempX, tempY + 1);
                        myStack.push(gameModel.get(tempX, tempY + 1));
                    }
                    
                    if (gameModel.getColor(tempX, tempY - 1) == color && !gameModel.isCaptured(tempX, tempY - 1)){
                        gameModel.capture(tempX, tempY - 1);
                        myStack.push(gameModel.get(tempX, tempY - 1));
                    }
                }
            }

            
            
            
            if (gameModel.isFinished()){

            }

        }
       
    }


// ADD YOUR PRIVATE METHODS HERE



}
