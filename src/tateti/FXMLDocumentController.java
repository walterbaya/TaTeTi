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
    private int[][] matrix = new int[3][3];

    private void takeADecision() {
        Button[] botones = {button1, button2, button3, button4, button6, button7, button8, button9};
        if (clickCounter == 1) {
            int i = new Random().nextInt(botones.length);
            System.out.println(i);
            botones[i].setText("black");
            botones[i].setDisable(true);
        }
    }

    //Si el centro no esta ocupado la maquina lo pone en el centro
    private void botPlay() {

    }

    @FXML
    private void setTextButton1() {
        if (clickCounter % 2 == 0) {
            button1.setText("white");
            matrix[0][0] = 1;
            alertaWhiteWins();
        } else {
            button1.setText("black");
            matrix[0][0] = 2;
            alertBlackWins();
        }
        button1.setDisable(true);
        clickCounter++;
    }

    @FXML
    private void setTextButton2() {
        if (clickCounter % 2 == 0) {
            button2.setText("white");
            matrix[0][1] = 1;
            alertaWhiteWins();
        } else {
            button2.setText("black");
            matrix[0][1] = 2;
            alertBlackWins();
        }
        button2.setDisable(true);
        clickCounter++;
    }

    @FXML
    private void setTextButton3() {
        if (clickCounter % 2 == 0) {
            button3.setText("white");
            matrix[0][2] = 1;
            alertaWhiteWins();
        } else {
            button3.setText("black");
            matrix[0][2] = 2;
            alertBlackWins();
        }
        button3.setDisable(true);
        clickCounter++;
    }

    @FXML
    private void setTextButton4() {
        if (clickCounter % 2 == 0) {
            button4.setText("white");
            matrix[1][0] = 1;
            alertaWhiteWins();
        } else {
            button4.setText("black");
            matrix[1][0] = 2;
            alertBlackWins();
        }
        button4.setDisable(true);
        clickCounter++;
    }

    @FXML
    private void setTextButton5() {
        if (clickCounter % 2 == 0) {
            button5.setText("white");
            matrix[1][1] = 1;
            alertaWhiteWins();
        } else {
            button5.setText("black");
            matrix[1][1] = 2;
            alertBlackWins();
        }
        button5.setDisable(true);
        clickCounter++;
    }

    @FXML
    private void setTextButton6() {
        if (clickCounter % 2 == 0) {
            button6.setText("white");
            matrix[1][2] = 1;
            alertaWhiteWins();
        } else {
            button6.setText("black");
            matrix[1][2] = 2;
            alertBlackWins();
        }
        button6.setDisable(true);
        clickCounter++;
    }

    @FXML
    private void setTextButton7() {
        if (clickCounter % 2 == 0) {
            button7.setText("white");
            matrix[2][0] = 1;
            alertaWhiteWins();
        } else {
            button7.setText("black");
            matrix[2][0] = 2;
            alertBlackWins();
        }
        button7.setDisable(true);
        clickCounter++;

    }

    @FXML
    private void setTextButton8() {
        if (clickCounter % 2 == 0) {
            button8.setText("white");
            matrix[2][1] = 1;
            alertaWhiteWins();
        } else {
            button8.setText("black");
            matrix[2][1] = 2;
            alertBlackWins();
        }
        button8.setDisable(true);
        clickCounter++;

    }

    @FXML
    private void setTextButton9() {
        if (clickCounter % 2 == 0) {
            button9.setText("white");
            matrix[2][2] = 1;
            alertaWhiteWins();
        } else {
            button9.setText("black");
            matrix[2][2] = 2;
            alertBlackWins();
        }
        button9.setDisable(true);
        clickCounter++;
    }

    private void alertaWhiteWins() {
        if (whiteWins()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Victory!");
            alert.setContentText("White wins!");
            alert.showAndWait();
            Platform.exit();
        }

    }

    private void alertBlackWins() {
        if (blackWins()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Victory!");
            alert.setContentText("Black wins!");
            alert.showAndWait();
            Platform.exit();
        }

    }

    private boolean gameOver() {
        return (whiteWins() || blackWins() || tiedGame());
    }

    private boolean whiteRows() {
        int whiteCellCounter = 0;
        boolean out = false;
        for (int i = 0; i < matrix[0].length && !out; i++) {
            for (int j = 0; j < matrix.length && !out; j++) {
                if (matrix[i][j] == 1) {
                    if (j == matrix.length - 1) {
                        if (whiteCellCounter == matrix.length - 1) {
                            whiteCellCounter++;
                            out = true;
                        } else {
                            whiteCellCounter = 0;
                        }
                    }
                    whiteCellCounter++;
                }
            }
        }
        return (whiteCellCounter == matrix.length);
    }


    public boolean whiteColums() {
        int whiteCellCounter = 0;
        boolean out = false;
        for (int i = 0; i < matrix[0].length && !out; i++) {
            for (int j = 0; j < matrix.length && !out; j++) {
                if (matrix[j][i] == 1) {
                    if (j == matrix.length - 1) {
                        if (whiteCellCounter == matrix.length - 1) {
                            whiteCellCounter++;
                            out = true;
                        } else {
                            whiteCellCounter = 0;
                        }
                    }
                    whiteCellCounter++;
                }
            }
        }
        return (whiteCellCounter == matrix.length);

    }

   /* public boolean whiteDiagonals() {
        
    }*/

    public boolean whiteWins() {
        if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && matrix[0][0] == 2
                || matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2] && matrix[1][0] == 2
                || matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2] && matrix[2][0] == 2
                || matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0] && matrix[0][0] == 2
                || matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1] && matrix[0][1] == 2
                || matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2] && matrix[0][2] == 2
                || matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] == 2
                || matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] == 2) {

            whiteWins = true;
        } else {

        }
        return whiteWins;
    }

    private boolean blackWins() {
        if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && matrix[0][0] == 2
                || matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2] && matrix[1][0] == 2
                || matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2] && matrix[2][0] == 2
                || matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0] && matrix[0][0] == 2
                || matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1] && matrix[0][1] == 2
                || matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2] && matrix[0][2] == 2
                || matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] == 2
                || matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] == 2) {

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
