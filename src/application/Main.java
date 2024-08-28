package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import javax.swing.Action;

import java.time.ZoneId;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			TextField display = new TextField();
			display.setEditable(false);
			
			Button option1 = new Button("Display date and time");
			Button option2 = new Button("Print to file");
			Button option3 = new Button("Change Font");
			Button option4 = new Button("Exit");
			
			Menu menu = new Menu();
			CustomMenuItem menu1 = new CustomMenuItem(option1);
			CustomMenuItem menu2 = new CustomMenuItem(option2);
			CustomMenuItem menu3 = new CustomMenuItem(option3);
			CustomMenuItem menu3 = new CustomMenuItem(option3);
			
			option1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					display.setText("" + LocalDateTime.now()); 
				}
			});
			
			option2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					try {
						String fileName = "log.txt";
						FileWriter file = new FileWriter(fileName);
						PrintWriter write = new 
						PrintWriter(file);
						
						write.println(display.getText());
						write.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			option3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent event) {
					display.setText("" + LocalDateTime.now()); 
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
