package com.example.gui_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import java.awt.*;
//import java.awt.Button;
//import java.awt.image.ImageObserver;
//import java.awt.image.ImageProducer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

        public class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                GridPane grid = new GridPane();
                grid.setVgap(15);
                grid.setHgap(10);
                grid.setStyle("-fx-background-color: #f0f8ff; -fx-border-color: #b0c4de; -fx-border-width: 2px; -fx-border-radius: 10px;");
                Scene scene = new Scene(grid,650, 650);       //scene



                //Name
                TextField nameField = new TextField();
                Label nameLabel = new Label("FullName");
                nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                nameField.setStyle("-fx-border-color: #87ceeb; -fx-border-radius: 5px;");
                HBox nameBox = new HBox();
                nameBox.setSpacing(15);
                nameBox.setPadding(new Insets(10));
                nameBox.getChildren().addAll(nameLabel,nameField);
                grid.add(nameBox,0,1,1,1);


                TextField Id = new TextField();
                Label IdLabel = new Label("ID");
                IdLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                Id.setStyle("-fx-border-color: #87ceeb; -fx-border-radius: 5px;");
                HBox IdBox = new HBox();
                IdBox.setSpacing(55);
                IdBox.setPadding(new Insets(10));
                IdBox.getChildren().addAll(IdLabel,Id);
                grid.add(IdBox,0,2,1,1);

                RadioButton male=new RadioButton("Male");
                RadioButton female=new RadioButton("Female");
                ToggleGroup group=new ToggleGroup();
                male.setToggleGroup(group);
                female.setToggleGroup(group);
                Label GenderLabel = new Label("Gender");
                GenderLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                HBox genderBox = new HBox();
                genderBox.setSpacing(25);
                genderBox.setPadding(new Insets(10));
                genderBox.getChildren().addAll(GenderLabel,female,male);
                grid.add(genderBox,0,3);


                ComboBox<String> provinceComboBox = new ComboBox<>();
                provinceComboBox.getItems().addAll("punjab","Sindh","KPK","Balochistan");
                Label provinceLabel = new Label("Province");
                provinceLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                provinceComboBox.setStyle("-fx-border-color: #87ceeb; -fx-border-radius: 5px;");
                HBox ProvinceBox = new HBox();
                ProvinceBox.setSpacing(25);
                ProvinceBox.setPadding(new Insets(10));
                ProvinceBox.getChildren().addAll(provinceLabel,provinceComboBox);
                grid.add(ProvinceBox,0,4);


                DatePicker datePicker = new DatePicker();
                Label dateLabel = new Label("DOB");
                dateLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                datePicker.setStyle("-fx-border-color: #87ceeb; -fx-border-radius: 5px;");
                HBox dateBox = new HBox();
                dateBox.setSpacing(40);
                dateBox.setPadding(new Insets(10));
                dateBox.getChildren().addAll(dateLabel,datePicker);
                grid.add(dateBox,0,5);


                Button NewButton = new Button("New");
                NewButton.setOnAction(e ->{
                    try{
                    File newFile=new File("Data");
                    if(!newFile.exists()){
                        newFile.createNewFile();}}
                    catch(IOException E){
                        E.printStackTrace();
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data"))) {
                        writer.write("Name: " + nameField.getText()+ "\n");
                        writer.write("ID: " + Id.getText() + "\n");
                        writer.write("Gender: " + ((RadioButton) group.getSelectedToggle()).getText() + "\n");
                        writer.write("Province: " + provinceComboBox.getValue()+ "\n");
                        writer.write("DOB: " + datePicker.getValue().toString()+ "\n");}
                    catch (IOException E){
                        E.printStackTrace();
                    }

                } );
                HBox buttonBox = new HBox();
                buttonBox.setSpacing(10);
                buttonBox.setPadding(new Insets(10));
                grid.add(NewButton,8,1);

                Button DeleteButton = new Button("Delete");
                HBox buttonBox2 = new HBox();
                buttonBox2.setSpacing(10);
                buttonBox2.setPadding(new Insets(10));
                grid.add(DeleteButton,8,2);

                Button RestoreButton = new Button("Restore");
                HBox buttonBox3 = new HBox();
                buttonBox3.setSpacing(10);
                buttonBox3.setPadding(new Insets(10));
                grid.add(RestoreButton,8,3);

                Button FindButton = new Button("Find Prev");
                HBox buttonBox4 = new HBox();
                buttonBox4.setSpacing(10);
                buttonBox4.setPadding(new Insets(10));
                grid.add(FindButton,8,4);

                Button NextButton = new Button("Find Next");
                HBox buttonBox5 = new HBox();
                buttonBox5.setSpacing(10);
                buttonBox5.setPadding(new Insets(10));
                grid.add(NextButton,8,5);

                Button CriteriaButton = new Button("Criteria");
                HBox buttonBox6 = new HBox();
                buttonBox6.setSpacing(10);
                buttonBox6.setPadding(new Insets(10));
                grid.add(CriteriaButton,8,6);

                Button CloseButton = new Button("Close");
                HBox buttonBox7 = new HBox();
                buttonBox7.setSpacing(10);
                buttonBox7.setPadding(new Insets(10));
                grid.add(CloseButton,8,7);



                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
            }

            public static void main(String[] args) {
                launch();
            }
        }




