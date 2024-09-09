package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Creates a simply GUI using JavaFX
 * Modified the label and textfield
 * to be more descriptive of the last menu
 * option selected
 * @author Brinsly Yendeh
 * @version 2.0 08/28/2024
 */
		
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Label displayLabel = new Label("Hello World!");
			TextField display = new TextField();
			display.setEditable(false);
			
			//The buttons 2 be added to the drop down menu
			Button option1 = new Button("Display date and time");
			Button option2 = new Button("Print to file");
			Button option3 = new Button("Change Background Font");
			Button option4 = new Button("Exit");
			
			option1.setPrefWidth(200);
			option2.setPrefWidth(200);
			option3.setPrefWidth(200);
			option4.setPrefWidth(200);
			
			//create menu object and menu sub options
			//and assign the buttons to them
			Menu menu = new Menu("Menu");
			CustomMenuItem menu1 = new CustomMenuItem(option1);
			CustomMenuItem menu2 = new CustomMenuItem(option2);
			CustomMenuItem menu3 = new CustomMenuItem(option3);
			CustomMenuItem menu4 = new CustomMenuItem(option4);
			
			//pass all the menuItems to the menu object
			//create the menu bar and pass the menu to it
			menu.getItems().addAll(menu1, menu2, menu3, menu4);
			MenuBar bar = new MenuBar();
			bar.getMenus().add(menu);
			bar.setPrefWidth(330);
			
			//Create a layout and add the created components
			//to it
			GridPane root = new GridPane();
			root.setPadding(new Insets(10, 10, 10, 10));
			root.setHgap(10);
		    root.setVgap(10);
			root.add(bar, 0, 0);
			root.add(displayLabel, 0, 1);
			root.add(display, 0, 2);
			
			//create a scene and pass it the layout
			//as well as its size then pass that scene to
			//the stage and show the stage
			Scene scene = new Scene(root, 350, 350);
			primaryStage.setScene(scene);
			primaryStage.setTitle("User Interface I");
			primaryStage.show();
			
			//displays date and time to TextField when menu1 is clicked
			option1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					displayLabel.setText("Date & Time:");
					display.setText("" + LocalDateTime.now()); 
				}
			});
			
			//Writes the TextField's content to a file when menu2 is clicked
			option2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					try {
						String fileName = "log.txt";
						FileWriter file = new FileWriter(fileName);
						PrintWriter write = new PrintWriter(file);
						
						write.println(display.getText());
						displayLabel.setText("Printing to file:");
						display.setText("Successfully printed date and time to file " + fileName); 
						write.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			//create a random number and with it create a random hue of the color green
			//by string rgb to (0 red, random green, 0 blue). The + 50 is to account
			//for hue's too dark and make them visibly more green
			option3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					Random random = new Random();
			        int hue = random.nextInt(206) + 50;
			        Color color = Color.rgb(0, hue, 0);
			        root.setBackground(new Background(new BackgroundFill(color, null, null)));
			        displayLabel.setText("Color change:");
			        display.setText("Background color changed!");
			        option3.setText("Green Hue: " + hue);
				}
			});
			
			//ends the program
			option4.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					Platform.exit();
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
