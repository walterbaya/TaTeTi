package tateti;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.util.Pair;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button boton1;
    @FXML
    private Button boton2;
    @FXML
    private Button boton3;
    @FXML
    private Button boton4;
    @FXML
    private Button boton5;
    @FXML
    private Button boton6;
    @FXML
    private Button boton7;
    @FXML
    private Button boton8;
    @FXML
    private Button boton9;

    int nroClick = 0;

    boolean ganoNegro = false;

    boolean ganoBlanco = false;

   

    private void tomarDesicion() {
        Button[] botones = {boton1, boton2, boton3, boton4, boton6, boton7, boton8, boton9};
        if (nroClick == 1) {
            int i = new Random().nextInt(botones.length);
            System.out.println(i);
            botones[i].setText("Negro");
            botones[i].setDisable(true);
        }
    }
    private int[][] matriz = new int[3][3];

    //Si el centro no esta ocupado la maquina lo pone en el centro
    private void jugarMaquina() {
        if (matriz[1][1] != 1) {
            boton5.setText("negro");
        } else {
            tomarDesicion();
        }
    }

    @FXML
    private void setTextButton1() {
        boton1.setText("Blanco");
        matriz[0][0] = 1;
        alertaGanoBlanco();
        boton1.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton2() {

        boton2.setText("Blanco");
        matriz[0][1] = 1;
        alertaGanoBlanco();
        boton2.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton3() {

        boton3.setText("Blanco");
        matriz[0][2] = 1;
        alertaGanoBlanco();

        boton3.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton4() {

        boton4.setText("Blanco");
        matriz[1][0] = 1;
        alertaGanoBlanco();

        boton4.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton5() {

        boton5.setText("Blanco");
        matriz[1][1] = 1;
        alertaGanoBlanco();

        boton5.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton6() {

        boton6.setText("Blanco");
        matriz[1][2] = 1;
        alertaGanoBlanco();

        boton6.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton7() {

        boton7.setText("Blanco");
        matriz[2][0] = 1;
        alertaGanoBlanco();

        boton7.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton8() {

        boton8.setText("Blanco");
        matriz[2][1] = 1;
        alertaGanoBlanco();

        boton8.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    @FXML
    private void setTextButton9() {
        if (nroClick % 2 == 0) {
            boton9.setText("Blanco");
            matriz[2][2] = 1;
            alertaGanoBlanco();
        } else {
            boton9.setText("Negro");
            matriz[2][2] = 2;
            alertaGanoNegro();
        }
        boton9.setDisable(true);
        nroClick++;
        jugarMaquina();
    }

    private void alertaGanoBlanco() {
        if (ganoBlanco()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VICTORIA!");
            alert.setContentText("Gano Blanco!");
            alert.showAndWait();
            Platform.exit();
        }

    }

    private void alertaGanoNegro() {
        if (ganoNegro()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VICTORIA!");
            alert.setContentText("Gano Negro!");
            alert.showAndWait();
            Platform.exit();
        }

    }

    private boolean ganoBlanco() {
        if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2] && matriz[0][0] == 1
                || matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2] && matriz[1][0] == 1
                || matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2] && matriz[2][0] == 1
                || matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0] && matriz[0][0] == 1
                || matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1] && matriz[0][1] == 1
                || matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2] && matriz[0][2] == 1
                || matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] == 1
                || matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] == 1) {

            ganoBlanco = true;
        } else {

        }
        return ganoBlanco;

    }

    private boolean ganoNegro() {
        if (matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2] && matriz[0][0] == 2
                || matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2] && matriz[1][0] == 2
                || matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2] && matriz[2][0] == 2
                || matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0] && matriz[0][0] == 2
                || matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1] && matriz[0][1] == 2
                || matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2] && matriz[0][2] == 2
                || matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] == 2
                || matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] == 2) {

            ganoNegro = true;
        } else {

        }
        return ganoNegro;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
