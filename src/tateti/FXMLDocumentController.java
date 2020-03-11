package tateti;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class FXMLDocumentController implements Initializable {
 
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    int clickCounter = 0;
    
    boolean blackWins = false;

    boolean whiteWins = false;
    
    /*Black player is been represented with a number 2 in the matrix and
      White player with a number 1
    */
    
    private int[][] matriz = new int[3][3];

    private void takeADecision() {
        Button[] botones = {button1, button2, button3, button4, button6, button7, button8, button9};
        if (clickCounter == 1) {
            int i = new Random().nextInt(botones.length);
            System.out.println(i);
            botones[i].setText("Negro");
            botones[i].setDisable(true);
        }
    }
    
    //Si el centro no esta ocupado la maquina lo pone en el centro
    private void botPlay() {
        if (matriz[1][1] != 1) {
            button5.setText("negro");
        } else {
            takeADecision();
        }
    }

    @FXML
    private void setTextButton1() {
        button1.setText("Blanco");
        matriz[0][0] = 1;
        alertaWhiteWins();
        button1.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton2() {

        button2.setText("Blanco");
        matriz[0][1] = 1;
        alertaWhiteWins();
        button2.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton3() {

        button3.setText("Blanco");
        matriz[0][2] = 1;
        alertaWhiteWins();

        button3.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton4() {

        button4.setText("Blanco");
        matriz[1][0] = 1;
        alertaWhiteWins();

        button4.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton5() {

        button5.setText("Blanco");
        matriz[1][1] = 1;
        alertaWhiteWins();

        button5.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton6() {

        button6.setText("Blanco");
        matriz[1][2] = 1;
        alertaWhiteWins();

        button6.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton7() {

        button7.setText("Blanco");
        matriz[2][0] = 1;
        alertaWhiteWins();

        button7.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton8() {

        button8.setText("Blanco");
        matriz[2][1] = 1;
        alertaWhiteWins();

        button8.setDisable(true);
        clickCounter++;
        botPlay();
    }

    @FXML
    private void setTextButton9() {
        if (clickCounter % 2 == 0) {
            button9.setText("Blanco");
            matriz[2][2] = 1;
            alertaWhiteWins();
        } else {
            button9.setText("Negro");
            matriz[2][2] = 2;
            alertBlackWins();
        }
        button9.setDisable(true);
        clickCounter++;
        botPlay();
    }

    private void alertaWhiteWins() {
        if (whiteWins()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VICTORIA!");
            alert.setContentText("Gano Blanco!");
            alert.showAndWait();
            Platform.exit();
        }

    }

    private void alertBlackWins() {
        if (blackWins()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VICTORIA!");
            alert.setContentText("Gano Negro!");
            alert.showAndWait();
            Platform.exit();
        }

    }

    private boolean gameOver() {
         return (whiteWins()||blackWins()||tiedGame()); 
    }

    private boolean whiteWins() {
        if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2] && matriz[0][0] == 1
                || matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2] && matriz[1][0] == 1
                || matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2] && matriz[2][0] == 1
                || matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0] && matriz[0][0] == 1
                || matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1] && matriz[0][1] == 1
                || matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2] && matriz[0][2] == 1
                || matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] == 1
                || matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] == 1) {

            whiteWins = true;
        } else {

        }
        return whiteWins;

    }

    private boolean blackWins() {
        if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2] && matriz[0][0] == 2
                || matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2] && matriz[1][0] == 2
                || matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2] && matriz[2][0] == 2
                || matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0] && matriz[0][0] == 2
                || matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1] && matriz[0][1] == 2
                || matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2] && matriz[0][2] == 2
                || matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] == 2
                || matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] == 2) {

            blackWins = true;
        } else {

        }
        return blackWins;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private boolean tiedGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
