module tictactoe.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens tictactoe.tictactoe to javafx.fxml;
    exports tictactoe.tictactoe;
}