package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Warning extends Application {
	public String test(String a) {
		return a;
	}

	@Override
	public void start(Stage SubStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Warning.fxml"));
			Scene scene = new Scene(root,378,239);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			SubStage.setScene(scene);
			SubStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
