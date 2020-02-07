package edu.jsu.mcis;

import java.awt.event.*;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }

    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = ((JButton) event.getSource()).getName(); //Get name of button

        int row = Integer.parseInt(name.substring(6, 7)); //Get row and column from name of button
        int col = Integer.parseInt(name.substring(7));

        model.makeMark(row, col); //Make mark
        view.updateSquares();

        TicTacToeModel.Result result = model.getResult(); //Get result

        if (model.isGameover()){ //If the game is over, lock the buttons
            view.disableSquares();
            view.showResult(result.toString());
        }else{
            view.clearResult();
        }
    }
}
