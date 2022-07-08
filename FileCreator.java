
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// made by Sawan
public class FileCreator extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		// adding components and setting their alignment

		// label for filename
		Label FileName = new Label("File Name:");
		FileName.setLayoutX(30);
		FileName.setLayoutY(20);

		// label for file extension
		Label FileExtension = new Label("File Extention:");
		FileExtension.setLayoutX(30);
		FileExtension.setLayoutY(70);

		// label for message area
		Label Message = new Label("Message:");
		Message.setLayoutX(30);
		Message.setLayoutY(120);

		// text field for file name
		TextField FileNameText = new TextField();
		FileNameText.setLayoutX(140);
		FileNameText.setLayoutY(20);
		FileNameText.setMinWidth(630);

		// text field for file extension
		TextField FileExtensionText = new TextField();
		FileExtensionText.setLayoutX(140);
		FileExtensionText.setLayoutY(70);
		FileExtensionText.setMinWidth(630);

		// text area for message
		TextArea MessageArea = new TextArea();
		MessageArea.setLayoutX(140);
		MessageArea.setLayoutY(120);
		MessageArea.setMinWidth(630);

		// button for creating the file
		Button create = new Button();
		create.setLayoutX(140);
		create.setLayoutY(350);
		create.setText("Create the file");
		create.setMinWidth(90);

		// setting the stage title
		primaryStage.setTitle("File with a Message");

		// creating pane to add it to the stage created
		Pane pane = new Pane();
		pane.getChildren().addAll(FileNameText, FileExtensionText, FileExtension, FileName, Message, MessageArea,create);
		
		primaryStage.setScene(new Scene(pane, 800, 400));
		primaryStage.show();

		// button action event
		create.setOnAction((event) -> {

			// getting name and extension from text fields
			String name = FileNameText.getText();
			String extension = FileExtensionText.getText();

			// creating file
			try {

				// creating a new file
				File myObj = new File(name + "." + extension);

				// if file exist already, don't create a new file
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

			// Writing into the file
			try {

				// creating a file writer
				FileWriter myWriter = new FileWriter(name + "." + extension);

				// getting the message from message area
				String message = MessageArea.getText();

				// writing the message
				myWriter.write(message);
				myWriter.close();
				System.out.println("Successfully wrote to the file: " + message);

				// if faced any error, error will be displayed in console
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		});

	}

}
