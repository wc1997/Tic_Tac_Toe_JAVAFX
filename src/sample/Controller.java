package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    String p1 = "Player 1 - X";
    String p2 = "Player 2 - O";

    @FXML
    private TextField player;

    @FXML
    private Button a1,a2,a3,b1,b2,b3,c1,c2,c3;

    @FXML
    private void resetGame(){
        a1.setText("");
        a2.setText("");
        a3.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        c1.setText("");
        c2.setText("");
        c3.setText("");


        player.setText(p1);
    }

    @FXML
    private void processClick(ActionEvent event){

       String value =  ((Button)event.getSource()).getText();

        if (value.equals("")) {

            if (player.getText().equals(p1)) {
                ((Button) event.getSource()).setText("X");
                if (checkWin()){
                    player.setText(player.getText() + " WINS");


                }
                else player.setText(p2);
            } else if (player.getText().equals(p2)) {
                ((Button) event.getSource()).setText("O");
                if (checkWin()){
                    player.setText(player.getText() + " WINS");
                }
                else player.setText(p1);
            }



        }
    }

    private boolean checkWin(){
        if (hSame() || vSame() || diagSame()){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hSame(){
        if (!(a1.getText().isEmpty()) && a1.getText().equals(a2.getText()) && a1.getText().equals(a3.getText())){
            return true;
        }
        else if (!(b1.getText().isEmpty()) && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())){
            return true;
        }
        else if (!(c1.getText().isEmpty()) && c1.getText().equals(c2.getText()) && c1.getText().equals(c3.getText())){
            return true;
        }
        else return false;
    }


    private boolean vSame(){
        if (!(a1.getText().isEmpty()) && a1.getText().equals(b1.getText()) && a1.getText().equals(c1.getText())){
            return true;
        }
        else if (!(a2.getText().isEmpty()) && a2.getText().equals(b2.getText()) && a2.getText().equals(c2.getText())){
            return true;
        }
        else if (!(a3.getText().isEmpty()) && a3.getText().equals(b3.getText()) && a3.getText().equals(c3.getText())){
            return true;
        }
        else return false;
    }
    private boolean diagSame() {
        if (!(a1.getText().isEmpty()) && a1.getText().equals(b2.getText()) && a1.getText().equals(c3.getText())){
            return true;
        }
        else if (!(a3.getText().isEmpty()) && a3.getText().equals(b2.getText()) && a3.getText().equals(c1.getText())){
            return true;
        }
        else return false;
    }
}
