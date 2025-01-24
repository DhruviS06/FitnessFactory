package com.example.fitnessfactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FitnessFactoryGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fitness Factory");

        // Create main menu
        VBox mainMenu = new VBox(10);
        Button enrollButton = new Button("Enroll");
        Button timingsButton = new Button("View Timings");
        Button rulesButton = new Button("View Rules");

        mainMenu.getChildren().addAll(enrollButton, timingsButton, rulesButton);

        Scene mainScene = new Scene(mainMenu, 400, 300);

        // Enrollment menu
        VBox enrollmentMenu = new VBox(10);
        Label enrollmentLabel = new Label("Choose Membership Duration");
        RadioButton oneMonthOption = new RadioButton("One Month - Rs. 1300");
        RadioButton threeMonthOption = new RadioButton("Three Months - Rs. 3500");
        RadioButton sixMonthOption = new RadioButton("Six Months - Rs. 6000");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        TextField ageField = new TextField();
        ageField.setPromptText("Enter your age");
        Button confirmEnrollButton = new Button("Confirm Enrollment");
        Button backToMainFromEnroll = new Button("Back");

        ToggleGroup membershipGroup = new ToggleGroup();
        oneMonthOption.setToggleGroup(membershipGroup);
        threeMonthOption.setToggleGroup(membershipGroup);
        sixMonthOption.setToggleGroup(membershipGroup);

        TextArea enrollmentResult = new TextArea();
        enrollmentResult.setEditable(false);

        enrollmentMenu.getChildren().addAll(enrollmentLabel, oneMonthOption, threeMonthOption, sixMonthOption,
                new Label("Name:"), nameField, new Label("Age:"), ageField, confirmEnrollButton,
                backToMainFromEnroll, enrollmentResult);

        Scene enrollmentScene = new Scene(enrollmentMenu, 400, 400);

        // Timings menu
        VBox timingsMenu = new VBox(10);
        Label timingsLabel = new Label("Gym Timings:\nMonday to Saturday:\n  Morning: 5:30am - 10:00am\n" +
                "  Evening: 3:30pm - 10:00pm\nClosed on Sunday.");
        Button backToMainFromTimings = new Button("Back");

        timingsMenu.getChildren().addAll(timingsLabel, backToMainFromTimings);
        Scene timingsScene = new Scene(timingsMenu, 400, 300);

        // Rules menu
        VBox rulesMenu = new VBox(10);
        Label rulesLabel = new Label("Gym Rules:\n- Re-rack the weights\n- Handle equipment carefully\n" +
                "- Don't disturb other members\n- Train only once a day.");
        Button backToMainFromRules = new Button("Back");

        rulesMenu.getChildren().addAll(rulesLabel, backToMainFromRules);
        Scene rulesScene = new Scene(rulesMenu, 400, 300);

        // Button Actions
        enrollButton.setOnAction(event -> primaryStage.setScene(enrollmentScene));
        timingsButton.setOnAction(event -> primaryStage.setScene(timingsScene));
        rulesButton.setOnAction(event -> primaryStage.setScene(rulesScene));

        backToMainFromEnroll.setOnAction(event -> primaryStage.setScene(mainScene));
        backToMainFromTimings.setOnAction(event -> primaryStage.setScene(mainScene));
        backToMainFromRules.setOnAction(event -> primaryStage.setScene(mainScene));

        confirmEnrollButton.setOnAction(event -> {
            String selectedOption = "";
            if (oneMonthOption.isSelected()) {
                selectedOption = "One Month - Rs. 1300";
            } else if (threeMonthOption.isSelected()) {
                selectedOption = "Three Months - Rs. 3500";
            } else if (sixMonthOption.isSelected()) {
                selectedOption = "Six Months - Rs. 6000";
            }

            String name = nameField.getText();
            String ageText = ageField.getText();

            if (name.isEmpty() || ageText.isEmpty() || selectedOption.isEmpty()) {
                enrollmentResult.setText("Please fill in all fields and select a membership duration.");
            } else {
                try {
                    int age = Integer.parseInt(ageText);
                    if (age < 12 || age > 95) {
                        enrollmentResult.setText("Invalid age. Age must be between 12 and 95.");
                    } else {
                        enrollmentResult.setText("Enrollment Successful!\nName: " + name +
                                "\nAge: " + age + "\nMembership: " + selectedOption);
                    }
                } catch (NumberFormatException e) {
                    enrollmentResult.setText("Invalid age. Please enter a number.");
                }
            }
        });

        // Set the initial scene
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
