package ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Duke;

import java.io.IOException;

public class MainGui extends Application {
    private String taskPath;
    private String walletPath;

    public void initialize(String[] args, String taskPath, String walletPath) {
        this.taskPath = taskPath;
        this.walletPath = walletPath;
        Application.launch(MainGui.class, args);
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainGui.class
                    .getResource("/view/MainWindow.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            fxmlLoader.<MainWindow>getController().initialize(this.taskPath, this.walletPath);
            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }
}
