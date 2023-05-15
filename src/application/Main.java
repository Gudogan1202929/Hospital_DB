package application;

import static javafx.stage.Modality.NONE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

@SuppressWarnings("unused")
public class Main extends Application {

	ObservableList<Employees> emps = FXCollections.observableArrayList();
	ObservableList<Pateint> pat = FXCollections.observableArrayList();
	ObservableList<Employees> doctor = FXCollections.observableArrayList();
	ObservableList<Diagnosis> diagnosis = FXCollections.observableArrayList();
	ObservableList<Payment> payments = FXCollections.observableArrayList();
	ObservableList<Appointments> appointments = FXCollections.observableArrayList();
	ObservableList<Secretaries> sec = FXCollections.observableArrayList();

	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "root1234";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "projectHospital";
	private Connection con;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMaximized(true);

			primaryStage.setResizable(false);
			Label lb = new Label("Hospital  Managment System");
			lb.setLayoutX(450);
			lb.setLayoutY(50);
			lb.setFont(Font.font("Cooper Black", 50));
			lb.setStyle("-fx-background-radius: 50");
			lb.setTextFill(Color.DARKBLUE);
			Image image1 = new Image("11.jpg");

			Image image = new Image("11.jpg");

			primaryStage.getIcons().add(image);
//			Image image2 = new Image("1.jpg");
			ImageView imageView2 = new ImageView(image1);
			imageView2.setFitHeight(842);
			imageView2.setFitWidth(1540);
			ImageView imageView = new ImageView(
					"33.png");
			imageView.setFitHeight(150);
			imageView.setFitWidth(150);
			imageView.setLayoutX(400);
			imageView.setLayoutY(200);

			Button doctor = new Button("Doctor");
			doctor.setStyle(
					"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");

			doctor.setFont(Font.font("Georgia", 40));
			doctor.setLayoutX(370);
			doctor.setLayoutY(370);
			doctor.setTextFill(Color.YELLOW);
			Button pateint = new Button("Patient");
			pateint.setStyle(
					"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");
			ImageView imageView3 = new ImageView("C:\\Users\\Amm\\Desktop\\HospitalDataBase\\src\\444.png");
			imageView3.setFitHeight(150);
			imageView3.setFitWidth(150);
			imageView3.setLayoutX(700);
			imageView3.setLayoutY(200);

			pateint.setFont(Font.font("Georgia", 40));
			pateint.setLayoutX(685);
			pateint.setLayoutY(370);
			pateint.setTextFill(Color.YELLOW);
			Button employee = new Button("Employees");
			employee.setStyle(
					"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");
			ImageView imageView4 = new ImageView(
					"55.png");
			imageView4.setFitHeight(150);
			imageView4.setFitWidth(150);
			imageView4.setLayoutX(1030);
			imageView4.setLayoutY(200);

			employee.setFont(Font.font("Georgia", 40));
			employee.setLayoutX(990);
			employee.setLayoutY(370);
			employee.setTextFill(Color.YELLOW);
			Button appoinments = new Button("Appointments");
			appoinments.setStyle(
					"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");
			ImageView imageView5 = new ImageView(
					"66.png");
			imageView5.setFitHeight(150);
			imageView5.setFitWidth(150);
			imageView5.setLayoutX(1000);
			imageView5.setLayoutY(500);

			appoinments.setFont(Font.font("Georgia", 40));
			appoinments.setLayoutX(920);
			appoinments.setLayoutY(670);
			appoinments.setTextFill(Color.YELLOW);
			Button diagnosis = new Button("Diagnosis and Prescription");
			diagnosis.setStyle(
					"-fx-border-radius: 50;-fx-border-color: yellow;-fx-background-radius: 50;-fx-background-color: darkblue");
			ImageView imageView6 = new ImageView(
					"88.png");
			imageView6.setFitHeight(150);
			imageView6.setFitWidth(150);
			imageView6.setLayoutX(520);
			imageView6.setLayoutY(500);

			diagnosis.setFont(Font.font("Georgia", 40));
			diagnosis.setLayoutX(320);
			diagnosis.setLayoutY(670);
			diagnosis.setTextFill(Color.YELLOW);

			employee.setOnAction(e -> {
				employee(primaryStage);
			});
			
			doctor.setOnAction(e -> {
				doctor(primaryStage);

			});
			pateint.setOnAction(e -> {
				pateint(primaryStage);

			});
			diagnosis.setOnAction(e -> {

				diagnosis(primaryStage);
			});
			appoinments.setOnAction(e -> {

				appoinments(primaryStage);
			});
			Group group = new Group();
			group.getChildren().addAll(imageView2, lb, imageView, doctor, pateint, imageView3, employee, imageView4,
					appoinments, imageView5, diagnosis, imageView6);
			Scene scene = new Scene(group);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void appoinments(Stage primaryStage) {
		try {
			TableView<Appointments> appoinments;
//			public Appointments(int pateint_ID, String doctor_ID, String secretaries_ID, String patient_Name,
//					String doctor_Name, String secretaries_Name, String dateApponitments, String time)
			appointments.clear();
			getDataAppointment();
			getDataPatient();
			getDataEmployee();

			TableColumn<Appointments, Integer> appointments_ID = new TableColumn<>("Appointments_ID");
			appointments_ID.setPrefWidth(130);
			appointments_ID.setCellValueFactory(new PropertyValueFactory<>("appointments_ID"));

			TableColumn<Appointments, Integer> pateint_ID = new TableColumn<>("Pateint_ID");
			pateint_ID.setPrefWidth(150);
			pateint_ID.setCellValueFactory(new PropertyValueFactory<>("pateint_ID"));
			TableColumn<Appointments, String> patient_Name = new TableColumn<>("Patient_Name");
			patient_Name.setPrefWidth(150);
			patient_Name.setCellValueFactory(new PropertyValueFactory<>("patient_Name"));

			TableColumn<Appointments, Integer> doctor_ID = new TableColumn<>("Doctor_ID");
			doctor_ID.setPrefWidth(150);
			doctor_ID.setCellValueFactory(new PropertyValueFactory<>("doctor_ID"));

			TableColumn<Appointments, String> doctor_Name = new TableColumn<>("doctor_Name");
			doctor_Name.setPrefWidth(150);
			doctor_Name.setCellValueFactory(new PropertyValueFactory<>("doctor_Name"));

			TableColumn<Appointments, Integer> secretaries_ID = new TableColumn<>("secretaries_ID");
			secretaries_ID.setPrefWidth(150);
			secretaries_ID.setCellValueFactory(new PropertyValueFactory<>("secretaries_ID"));

			TableColumn<Appointments, String> secerterisce_name = new TableColumn<>("Secretaries_Name");
			secerterisce_name.setPrefWidth(150);
			secerterisce_name.setCellValueFactory(new PropertyValueFactory<>("Secretaries_Name"));

			TableColumn<Appointments, String> dateApponitments = new TableColumn<>("Date_Apponitments");
			dateApponitments.setPrefWidth(150);
			dateApponitments.setCellValueFactory(new PropertyValueFactory<>("dateApponitments"));

			TableColumn<Appointments, String> time = new TableColumn<>("Time");
			time.setPrefWidth(73);
			time.setCellValueFactory(new PropertyValueFactory<>("time"));

			appoinments = new TableView<>();
			appointments_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			pateint_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			patient_Name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			doctor_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			doctor_Name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			secretaries_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			secerterisce_name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			dateApponitments.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			time.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			appoinments.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			appointments_ID.setResizable(false);
			pateint_ID.setResizable(false);
			patient_Name.setResizable(false);
			doctor_ID.setResizable(false);
			doctor_Name.setResizable(false);
			secretaries_ID.setResizable(false);
			secerterisce_name.setResizable(false);
			dateApponitments.setResizable(false);
			time.setResizable(false);

//			employees.setBackground(
//					new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
//			employees.setItems(data);
			appoinments.setPrefHeight(250);
			appoinments.setPrefWidth(1261);

			appoinments.getColumns().addAll(appointments_ID, pateint_ID, patient_Name, doctor_ID, doctor_Name,
					secretaries_ID, secerterisce_name, dateApponitments, time);
			appoinments.refresh();
			appoinments.setItems(appointments);
			final VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(80, 0, 0, 30));
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(appoinments);

			primaryStage.setMaximized(true);

			primaryStage.setResizable(false);
			Label lb = new Label("Appointments");
			lb.setLayoutX(620);
			lb.setLayoutY(10);
			lb.setFont(Font.font("Cooper Black", 50));
			lb.setStyle("-fx-background-radius: 50");
			lb.setTextFill(Color.DARKBLUE);
			Label lb23 = new Label("Appointments_List");
			lb23.setLayoutX(290);
			lb23.setLayoutY(40);
			lb23.setFont(Font.font("Times New Roman", 30));
			lb23.setStyle("-fx-background-radius: 50");
			lb23.setTextFill(Color.DARKBLUE);
			Label lb50 = new Label("**Error!! some feild are empty**");
			Label lb51 = new Label("**Error!! some feild are empty**");
			Label lb52 = new Label("**Error!! The Pateint ID not found**");
			lb50.setVisible(false);
			lb51.setVisible(false);
			lb52.setVisible(false);
			Image image1 = new Image("1.jpg");

			Image image = new Image("3.jpg");

			primaryStage.getIcons().add(image);
			ImageView imageView2 = new ImageView(image1);
			imageView2.setFitHeight(842);
			imageView2.setFitWidth(1540);
			TextField text = new TextField();
			text.setPromptText("Patient ID:");
			text.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text.setFont(Font.font("Times New Roman", 13));
			text.setAlignment(Pos.CENTER);

			TextField text78 = new TextField();
			text78.setPromptText("Secretariea ID:");
			text78.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text78.setFont(Font.font("Times New Roman", 13));
			text78.setAlignment(Pos.CENTER);

			TextField text3 = new TextField();
			text3.setPromptText("The Date BY (yy-mm-dd):");
			text3.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text3.setFont(Font.font("Times New Roman", 13));
			text3.setAlignment(Pos.CENTER);
			TextField text4 = new TextField();
			text4.setPromptText("Time by(hh/mm):");
			text4.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");

			TextField text1 = new TextField();
			text1.setPromptText("The Doctor:");
			text1.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text1.setFont(Font.font("Times New Roman", 13));
			text1.setAlignment(Pos.CENTER);

			VBox box = new VBox(50);
			box.setLayoutX(200);
			box.setLayoutY(420);
			box.getChildren().addAll(text, text1, text78, text3, text4);

			ImageView imageView23 = new ImageView(
					"13.png");
			imageView23.setFitHeight(40);
			imageView23.setFitWidth(40);

			ImageView imageView = new ImageView(
					"57.png");
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);

			Button add = new Button("Add", imageView);
			add.setStyle("-fx-border-radius: 50");
			add.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			add.setFont(Font.font("Georgia", 20));
			add.setLayoutX(150);
			add.setLayoutY(773);
			add.setTextFill(Color.DARKBLUE);
			add.setOnAction(e -> {
				if (text.getText().isEmpty() || text1.getText().isEmpty() || text78.getText().isEmpty()
						|| text3.getText().isEmpty() || text4.getText().isEmpty()) {
					lb50.setVisible(true);
					lb51.setVisible(false);
					lb52.setVisible(false);

					lb50.setText("**Error!! some feild is empty**");
					lb50.setLayoutX(45);
					lb50.setLayoutY(330);
					lb50.setFont(Font.font("Georgia", 25));
					lb50.setStyle("-fx-background-radius: 50");
					lb50.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);
					boolean check = false;
					int f = 0;

					for (int i = 0; i < pat.size(); i++) {
						if (pat.get(i).getPateint() == Integer.parseInt(text.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);
						lb52.setText("**Error!! The Pateint ID not found**");
						lb52.setLayoutX(45);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);

						text.clear();
						text1.clear();
						text78.clear();
						text3.clear();
						text4.clear();

					} else {
						boolean check1 = false;
						int f1 = 0;

						for (int i = 0; i < doctor.size(); i++) {
							if (doctor.get(i).getEmployees_ID() == Integer.parseInt(text1.getText())) {
								f1 = i;
								check1 = true;
								break;
							}

							check1 = false;
						}
						if (check1 == false) {
							lb52.setVisible(true);
							lb51.setVisible(false);
							lb50.setVisible(false);
							lb52.setText("**Error!! The Doctor ID not found**");
							lb52.setLayoutX(45);
							lb52.setLayoutY(330);
							lb52.setFont(Font.font("Georgia", 25));
							lb52.setStyle("-fx-background-radius: 50");
							lb52.setTextFill(Color.DARKRED);

							text.clear();
							text1.clear();
							text78.clear();
							text3.clear();
							text4.clear();

						} else {
							boolean check2 = false;
							int f2 = 0;

							for (int i = 0; i < emps.size(); i++) {
								if (emps.get(i).getEmployees_ID() == Integer.parseInt(text78.getText())) {
									f2 = i;
									check2 = true;
									break;
								}

								check2 = false;
							}
							if (check2 == false) {
								lb52.setVisible(true);
								lb51.setVisible(false);
								lb50.setVisible(false);
								lb52.setText("**Error!! The Secertary ID not found**");
								lb52.setLayoutX(45);
								lb52.setLayoutY(330);
								lb52.setFont(Font.font("Georgia", 25));
								lb52.setStyle("-fx-background-radius: 50");
								lb52.setTextFill(Color.DARKRED);

							} else {
								lb52.setVisible(false);
								lb51.setVisible(false);
								lb50.setVisible(false);

								Appointments rc;
////						public Appointments(int pateint_ID, String doctor_ID, String secretaries_ID, String patient_Name,
//								String doctor_Name, String secretaries_Name, String dateApponitments, String time) {
								rc = new Appointments(Integer.parseInt(text.getText()),
										Integer.parseInt(text1.getText()), Integer.parseInt(text78.getText()),
										pat.get(f).getPateint_Name(), emps.get(f1).getName_employee(),
										emps.get(f2).getName_employee(), text3.getText(), text4.getText());
								appointments.add(rc);
								insertDataappointments(rc);
								lb52.setVisible(true);
								lb51.setVisible(false);
								lb50.setVisible(false);
								lb52.setText(
										"<< Was added the Appointment to the pateint_Id: " + text.getText() + " >>");
								lb52.setLayoutX(45);
								lb52.setLayoutY(330);
								lb52.setFont(Font.font("Georgia", 20));
								lb52.setStyle("-fx-background-radius: 50");
								lb52.setTextFill(Color.DARKRED);

								text.clear();
								text1.clear();
								text78.clear();
								text3.clear();
								text4.clear();

								appointments.clear();
								try {
									getDataAppointment();
								} catch (ClassNotFoundException | SQLException e1) {
									e1.printStackTrace();
								}

							}
						}
					}
				}

			});

			Label lb1 = new Label("Patient ID:");
			lb1.setLayoutX(670);
			lb1.setLayoutY(50);
			lb1.setFont(Font.font("Georgia", 20));
			lb1.setStyle("-fx-background-radius: 50");
			lb1.setTextFill(Color.BLACK);
			Label lb2 = new Label("Doctor ID:");
			lb2.setLayoutX(670);
			lb2.setLayoutY(50);
			lb2.setFont(Font.font("Georgia", 20));
			lb2.setStyle("-fx-background-radius: 50");
			lb2.setTextFill(Color.BLACK);
			Label lb90 = new Label("Secretaria ID:");
			lb90.setLayoutX(670);
			lb90.setLayoutY(50);
			lb90.setFont(Font.font("Georgia", 20));
			lb90.setStyle("-fx-background-radius: 50");
			lb90.setTextFill(Color.BLACK);
			Label lb3 = new Label("date:");
			lb3.setLayoutX(670);
			lb3.setLayoutY(50);
			lb3.setFont(Font.font("Georgia", 20));
			lb3.setStyle("-fx-background-radius: 50");
			lb3.setTextFill(Color.BLACK);
			Label lb4 = new Label("Time:");
			lb4.setLayoutX(670);
			lb4.setLayoutY(50);
			lb4.setFont(Font.font("Georgia", 20));
			lb4.setStyle("-fx-background-radius: 50");
			lb4.setTextFill(Color.BLACK);

			VBox box1 = new VBox(52);
			box1.setLayoutX(45);
			box1.setLayoutY(420);
			box1.getChildren().addAll(lb1, lb2, lb90, lb3, lb4);
			Button rectangle = new Button();
			rectangle.setLayoutX(30);
			rectangle.setLayoutY(395);
			rectangle.setLayoutY(360);
			rectangle.setPrefWidth(380);
			rectangle.setPrefHeight(475);
			rectangle.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			Button rectangle1 = new Button();
			rectangle1.setLayoutX(490);
			rectangle1.setLayoutY(360);
			rectangle1.setPrefWidth(380);
			rectangle1.setPrefHeight(475);
			rectangle1.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle1.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			ImageView imageView9 = new ImageView(
					"112.png");
			imageView9.setFitHeight(40);
			imageView9.setFitWidth(40);

			Button find = new Button("Find", imageView9);
			find.setStyle("-fx-border-radius: 50");
			find.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			find.setFont(Font.font("Georgia", 20));
			find.setLayoutX(570);
			find.setLayoutY(773);
			find.setTextFill(Color.DARKBLUE);
			ImageView imageView10 = new ImageView(
					"100.png");
			imageView10.setFitHeight(40);
			imageView10.setFitWidth(40);

			Button delete = new Button("Delete", imageView10);
			delete.setStyle("-fx-border-radius: 50");
			delete.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			delete.setFont(Font.font("Georgia", 20));
			delete.setLayoutX(675);
			delete.setLayoutY(773);
			delete.setTextFill(Color.DARKBLUE);

			ImageView imageView3 = new ImageView("6.png");
			imageView3.setFitHeight(50);
			imageView3.setFitWidth(50);
			Button back = new Button("Back", imageView3);
			imageView2.setRotate(360);

			back.setFont(Font.font("Georgia", 40));
			back.setLayoutX(10);
			back.setLayoutY(5);
			back.setTextFill(Color.DARKBLUE);
			back.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			back.setOnAction(e -> {

				start(primaryStage);

			});

			TextField text6 = new TextField();
			text6.setPromptText("Appoinment ID:");
			text6.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text6.setFont(Font.font("Times New Roman", 13));
			text6.setAlignment(Pos.CENTER);

			TextField text7 = new TextField();
			text7.setPromptText("Patient ID:");
			text7.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text2.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text7.setFont(Font.font("Times New Roman", 13));
			text7.setAlignment(Pos.CENTER);
			TextField text8 = new TextField();
			text8.setPromptText("The Date:");
			text8.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text8.setFont(Font.font("Times New Roman", 13));
			text8.setAlignment(Pos.CENTER);
			TextField text9 = new TextField();
			text9.setPromptText("The Time:");
			text9.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text9.setFont(Font.font("Times New Roman", 13));
			text9.setAlignment(Pos.CENTER);
			TextField text10 = new TextField();
			text10.setPromptText("The Doctor Name:");
			text10.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text10.setFont(Font.font("Times New Roman", 13));
			text10.setAlignment(Pos.CENTER);

			VBox box3 = new VBox(49);
			box3.setLayoutX(660);
			box3.setLayoutY(420);
			box3.getChildren().addAll(text6, text7, text10, text8, text9);
			text9.setDisable(true);
			text10.setDisable(true);
			text7.setDisable(true);
			text8.setDisable(true);
			find.setOnAction(e -> {
				if (text6.getText().isEmpty()) {

					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setText("**Error!!The feild Appointment Id is empty**");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);
					text6.setDisable(false);

				} else {

					text10.setDisable(false);
					text7.setDisable(false);
					text8.setDisable(false);
					text9.setDisable(false);

					lb50.setVisible(false);

					boolean check = false;
					int f = 0;
					for (int i = 0; i < appointments.size(); i++) {
						if (appointments.get(i).getAppointments_ID() == Integer.parseInt(text6.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}

					System.out.print(check);
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);
						lb52.setText("               **The Appointment Id not founded**");

						lb52.setLayoutX(450);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);
						text6.setDisable(false);

						text9.setDisable(true);
						text10.setDisable(true);
						text7.setDisable(true);
						text8.setDisable(true);

						text6.clear();

						text9.clear();

						text10.clear();
						text7.clear();
						text8.clear();

					} else {

						lb52.setVisible(false);
						lb51.setVisible(false);
						lb50.setVisible(false);

						text6.setDisable(false);

						text9.setDisable(false);
						text10.setDisable(false);
						text7.setDisable(false);
						text8.setDisable(false);
						text7.setText(String.valueOf(appointments.get(f).getPateint_ID()));
						text10.setText(String.valueOf(appointments.get(f).getDoctor_Name()));

						text8.setText(appointments.get(f).getDateApponitments());
						text9.setText(appointments.get(f).getTime());

					}
				}

			});
			delete.setOnAction(e -> {

				deleteRowAppointment(text6.getText().trim());
				appointments.clear();
				try {
					getDataAppointment();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

				text6.clear();

				text7.clear();
				text8.clear();
				text9.clear();
				text10.clear();

				text6.setDisable(false);

				text10.setDisable(true);
				text7.setDisable(true);
				text8.setDisable(true);
				text9.setDisable(true);

			});
			Label lb16 = new Label("Appoinment ID:");
			lb16.setLayoutX(670);
			lb16.setLayoutY(50);
			lb16.setFont(Font.font("Georgia", 20));
			lb16.setStyle("-fx-background-radius: 50");
			lb16.setTextFill(Color.BLACK);

			Label lb7 = new Label("Patient ID:");
			lb7.setLayoutX(670);
			lb7.setLayoutY(50);
			lb7.setFont(Font.font("Georgia", 20));
			lb7.setStyle("-fx-background-radius: 50");
			lb7.setTextFill(Color.BLACK);

			Label lb10 = new Label("Doctor Name:");
			lb10.setLayoutX(670);
			lb10.setLayoutY(50);
			lb10.setFont(Font.font("Georgia", 20));
			lb10.setStyle("-fx-background-radius: 50");
			lb10.setTextFill(Color.BLACK);
			Label lb8 = new Label("Date:");
			lb8.setLayoutX(670);
			lb8.setLayoutY(50);
			lb8.setFont(Font.font("Georgia", 20));
			lb8.setStyle("-fx-background-radius: 50");
			lb8.setTextFill(Color.BLACK);
			Label lb9 = new Label("Time:");
			lb9.setLayoutX(670);
			lb9.setLayoutY(50);
			lb9.setFont(Font.font("Georgia", 20));
			lb9.setStyle("-fx-background-radius: 50");
			lb9.setTextFill(Color.BLACK);

			Label lb13 = new Label("Addition");
			lb13.setLayoutX(160);
			lb13.setLayoutY(362);
			lb13.setFont(Font.font("Georgia", 30));
			lb13.setStyle("-fx-background-radius: 50");
			lb13.setTextFill(Color.DARKBLUE);
			Label lb14 = new Label("Delete");
			lb14.setLayoutX(650);
			lb14.setLayoutY(362);
			lb14.setFont(Font.font("Georgia", 30));
			lb14.setStyle("-fx-background-radius: 50");
			lb14.setTextFill(Color.DARKBLUE);

			VBox box2 = new VBox(50);
			box2.setLayoutX(505);
			box2.setLayoutY(420);

			box2.getChildren().addAll(lb16, lb7, lb10, lb8, lb9);
			Group group = new Group();
			group.getChildren().addAll(imageView2, rectangle, rectangle1, lb, box, box1, add, box3, box2, lb13, lb14,
					find, delete, lb23, vbox, back, lb50, lb51, lb52);
			Scene scene = new Scene(group);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private void diagnosis(Stage primaryStage) {

		try {
			TableView<Diagnosis> Diagnosis;
			TableView<Payment> Payment;
			diagnosis.clear();
			payments.clear();

			getDataPatient();
			getDataEmployee();
			getDataDiagnosis();
			getDataPayment();
			System.out.print(pat);

			TableColumn<Payment, Integer> payment_ID = new TableColumn<>("Payment_ID");
			payment_ID.setPrefWidth(90);
			payment_ID.setCellValueFactory(new PropertyValueFactory<>("payment_ID"));

			TableColumn<Payment, String> datePayment = new TableColumn<>("Date_Payment");
			datePayment.setPrefWidth(110);
			datePayment.setCellValueFactory(new PropertyValueFactory<>("datePayment"));

			TableColumn<Payment, Integer> doctor_ID = new TableColumn<>("Doctor_ID");
			doctor_ID.setPrefWidth(90);
			doctor_ID.setCellValueFactory(new PropertyValueFactory<>("doctor_ID"));
			TableColumn<Payment, Integer> secrtaries_ID = new TableColumn<>("Secrtaries_ID");
			secrtaries_ID.setPrefWidth(90);
			secrtaries_ID.setCellValueFactory(new PropertyValueFactory<>("secretaries_ID"));
			TableColumn<Payment, Integer> patient_IDPay = new TableColumn<>("Patient_ID");
			patient_IDPay.setPrefWidth(90);
			patient_IDPay.setCellValueFactory(new PropertyValueFactory<>("pateint_id"));
			TableColumn<Payment, Double> costpay = new TableColumn<>("Cost");
			costpay.setPrefWidth(80);
			costpay.setCellValueFactory(new PropertyValueFactory<>("cost"));
			payment_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			doctor_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			secrtaries_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			patient_IDPay.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			costpay.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			datePayment.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			payment_ID.setResizable(false);
			doctor_ID.setResizable(false);
			secrtaries_ID.setResizable(false);
			patient_IDPay.setResizable(false);
			costpay.setResizable(false);
			datePayment.setResizable(false);

			Payment = new TableView<>();

			Payment.setStyle("-fx-border-color: black;-fx-background-radius: 5;-fx-border-radius: 5");
			Payment.setPrefHeight(250);
			Payment.setPrefWidth(556);
			Payment.getColumns().addAll(payment_ID, patient_IDPay, secrtaries_ID, doctor_ID, datePayment, costpay);
			Payment.refresh();
			Payment.setItems(payments);
			final VBox vbox4 = new VBox();
			vbox4.setSpacing(5);
			vbox4.setPadding(new Insets(80, 0, 0, 970));
			vbox4.setAlignment(Pos.CENTER);
			vbox4.getChildren().addAll(Payment);
			TableColumn<Diagnosis, Integer> Diagnosis_ID = new TableColumn<>("Diagnosis_ID");
			Diagnosis_ID.setPrefWidth(100);
			Diagnosis_ID.setCellValueFactory(new PropertyValueFactory<>("diagnosis_ID"));
			TableColumn<Diagnosis, Integer> Patient_ID = new TableColumn<>("Patient_ID");
			Patient_ID.setPrefWidth(100);
			Patient_ID.setCellValueFactory(new PropertyValueFactory<>("pateint_ID"));
			TableColumn<Diagnosis, String> patient_name = new TableColumn<>("Patient_name");
			patient_name.setPrefWidth(150);
			patient_name.setCellValueFactory(new PropertyValueFactory<>("pateint_name"));

			TableColumn<Diagnosis, String> Diagnosis_Discription = new TableColumn<>("Diagnosis_Discription");
			Diagnosis_Discription.setPrefWidth(150);
			Diagnosis_Discription.setCellValueFactory(new PropertyValueFactory<>("diagnosis_description"));

			TableColumn<Diagnosis, String> diagnosis_description = new TableColumn<>("Treatment_Description");
			diagnosis_description.setPrefWidth(150);
			diagnosis_description.setCellValueFactory(new PropertyValueFactory<>("treatment_discription"));

			TableColumn<Diagnosis, Integer> doctor_id = new TableColumn<>("Doctor_ID");
			doctor_id.setPrefWidth(150);
			doctor_id.setCellValueFactory(new PropertyValueFactory<>("doctor_ID"));

			TableColumn<Diagnosis, String> dateOfBirthDIAGNOSIS = new TableColumn<>("Date_Of_Diagnosis");
			dateOfBirthDIAGNOSIS.setPrefWidth(120);
			dateOfBirthDIAGNOSIS.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

			Diagnosis = new TableView<>();
			Patient_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			Diagnosis_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			Diagnosis_Discription.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			diagnosis_description.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			doctor_id.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			dateOfBirthDIAGNOSIS.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			patient_name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			Diagnosis.setStyle("-fx-border-color: black;-fx-background-radius: 5;-fx-border-radius: 5");
//			employees.setBackground(
//					new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
//			employees.setItems(data);
			Diagnosis.setPrefHeight(250);
			Diagnosis.setPrefWidth(926);

			Diagnosis.getColumns().addAll(Diagnosis_ID, Patient_ID, patient_name, doctor_id, Diagnosis_Discription,
					diagnosis_description, dateOfBirthDIAGNOSIS);
			Diagnosis.refresh();
			Diagnosis.setItems(diagnosis);
			final VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(80, 0, 0, 30));
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(Diagnosis);

			primaryStage.setMaximized(true);

			primaryStage.setResizable(false);
			Label lb = new Label("Diagnosis");
			lb.setLayoutX(670);
			lb.setLayoutY(10);
			lb.setFont(Font.font("Cooper Black", 50));
			lb.setStyle("-fx-background-radius: 50");
			lb.setTextFill(Color.DARKBLUE);
			Label lb23 = new Label("Diagnosis_List");
			lb23.setLayoutX(300);
			lb23.setLayoutY(40);
			lb23.setFont(Font.font("Times New Roman", 30));
			lb23.setStyle("-fx-background-radius: 50");
			lb23.setTextFill(Color.DARKBLUE);

			Image image1 = new Image("211.jpg");

			Image image = new Image("211.jpg");

			primaryStage.getIcons().add(image);
			ImageView imageView2 = new ImageView(image1);
			imageView2.setFitHeight(842);
			imageView2.setFitWidth(1540);
			TextField text = new TextField();
			text.setPromptText("Pateint ID:");
			text.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text.setFont(Font.font("Times New Roman", 13));
			text.setAlignment(Pos.CENTER);
			TextField textD = new TextField();
			textD.setPromptText("Doctor ID:");
			textD.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			textD.setFont(Font.font("Times New Roman", 13));
			textD.setAlignment(Pos.CENTER);
			TextArea text1 = new TextArea();
			text1.setPromptText("Enter the description from diagnosis:");

			text1.setPrefWidth(100);
			text1.setPrefHeight(60);
			text1.setWrapText(true);
			text1.setFont(Font.font("Times New Roman", 13));
			text1.setStyle("-fx-border-color: black;-fx-background-radius: 70");
			TextArea text4 = new TextArea();
			text4.setPromptText("Enter just one treatment(prescription) :");

			text4.setPrefWidth(100);
			text4.setPrefHeight(60);
			text4.setWrapText(true);
			text4.setFont(Font.font("Times New Roman", 13));
			text4.setStyle("-fx-border-color: black;-fx-background-radius: 70");

			TextField text5 = new TextField();
			text5.setPromptText("Date of diagnosis:");
			text5.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text5.setFont(Font.font("Times New Roman", 13));
			text5.setAlignment(Pos.CENTER);
			VBox box = new VBox(26);
			box.setLayoutX(220);
			box.setLayoutY(440);
			box.getChildren().addAll(text, textD, text1, text4, text5);

			ImageView imageView = new ImageView(
					"21.png");
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);

			Button add = new Button("Add", imageView);
			add.setStyle("-fx-border-radius: 50");
			add.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			add.setFont(Font.font("Georgia", 20));
			add.setLayoutX(150);
			add.setLayoutY(773);
			add.setTextFill(Color.DARKBLUE);

			Label lb50 = new Label("**Error!! some feild are empty**");
			Label lb51 = new Label("**Error!! some feild are empty**");
			Label lb52 = new Label("**Error!! The Pateint ID not found**");
			lb50.setVisible(false);
			lb51.setVisible(false);
			lb52.setVisible(false);
			add.setOnAction(e -> {
				if (text.getText().isEmpty() || text1.getText().isEmpty() || text4.getText().isEmpty()
						|| text5.getText().isEmpty() || textD.getText().isEmpty()) {

					lb50.setVisible(true);

					lb50.setLayoutX(40);
					lb50.setLayoutY(330);
					lb50.setFont(Font.font("Georgia", 25));
					lb50.setStyle("-fx-background-radius: 50");
					lb50.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);
					boolean check = false;
					int f = 0;

					for (int i = 0; i < pat.size(); i++) {
						if (pat.get(i).getPateint() == Integer.parseInt(text.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);
						lb52.setText("**Error!! The Pateint ID not found**");
						lb52.setLayoutX(40);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);

						text.clear();
						text1.clear();
						text4.clear();
						text5.clear();
						textD.clear();

					} else {
						boolean check1 = false;
						int f1 = 0;

						for (int i = 0; i < doctor.size(); i++) {
							if (doctor.get(i).getEmployees_ID() == Integer.parseInt(textD.getText())) {
								f1 = i;
								check1 = true;
								break;
							}

							check1 = false;
						}
						if (check1 == false) {
							lb52.setVisible(true);
							lb51.setVisible(false);
							lb50.setVisible(false);
							lb52.setText("**Error!! The Doctor ID not found**");
							lb52.setLayoutX(40);
							lb52.setLayoutY(330);
							lb52.setFont(Font.font("Georgia", 25));
							lb52.setStyle("-fx-background-radius: 50");
							lb52.setTextFill(Color.DARKRED);

							text.clear();
							text1.clear();
							text4.clear();
							text5.clear();
							textD.clear();

						} else {
							lb52.setVisible(false);
							lb51.setVisible(false);
							lb50.setVisible(false);

							Diagnosis rc;
//						
							rc = new Diagnosis(pat.get(f).getPateint_Name(), text1.getText(), text4.getText(),
									text5.getText(), Integer.parseInt(text.getText()),
									Integer.parseInt(textD.getText()));
							diagnosis.add(rc);
							insertDataDiagnosis(rc);

							text.clear();
							text1.clear();
							text4.clear();
							text5.clear();
							textD.clear();

							diagnosis.clear();
							try {
								getDataDiagnosis();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}

						}
					}

				}

			});

			Label lb1 = new Label("Diagnosis:");
			lb1.setLayoutX(45);
			lb1.setLayoutY(560);
			lb1.setFont(Font.font("Georgia", 20));
			lb1.setStyle("-fx-background-radius: 50");
			lb1.setTextFill(Color.BLACK);
			Label lb2 = new Label("Prescription:");
			lb2.setLayoutX(45);
			lb2.setLayoutY(640);
			lb2.setFont(Font.font("Georgia", 20));
			lb2.setStyle("-fx-background-radius: 50");
			lb2.setTextFill(Color.BLACK);
			Label lb39 = new Label("Date Of Diagnosis:");
			lb39.setLayoutX(45);
			lb39.setLayoutY(718);
			lb39.setFont(Font.font("Georgia", 20));
			lb39.setStyle("-fx-background-radius: 50");
			lb39.setTextFill(Color.BLACK);
			Label lb32 = new Label("Patient ID:");
			lb32.setLayoutX(670);
			lb32.setLayoutY(50);
			lb32.setFont(Font.font("Georgia", 20));
			lb32.setStyle("-fx-background-radius: 50");
			lb32.setTextFill(Color.BLACK);
			Label lb333 = new Label("Doctor ID:");
			lb333.setLayoutX(670);
			lb333.setLayoutY(50);
			lb333.setFont(Font.font("Georgia", 20));
			lb333.setStyle("-fx-background-radius: 50");
			lb333.setTextFill(Color.BLACK);
			VBox box1 = new VBox(28);
			box1.setLayoutX(45);
			box1.setLayoutY(440);
			box1.getChildren().addAll(lb32, lb333);
			Button rectangle = new Button();
			rectangle.setLayoutX(30);
			rectangle.setLayoutY(395);
			rectangle.setLayoutY(360);
			rectangle.setPrefWidth(380);
			rectangle.setPrefHeight(475);
			rectangle.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			Button rectangle1 = new Button();
			rectangle1.setLayoutX(490);
			rectangle1.setLayoutY(360);
			rectangle1.setPrefWidth(380);
			rectangle1.setPrefHeight(475);
			rectangle1.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle1.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			Button rectangle2 = new Button();
			rectangle2.setLayoutX(1090);
			rectangle2.setLayoutY(360);
			rectangle2.setPrefWidth(380);
			rectangle2.setPrefHeight(475);
			rectangle2.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle2.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			ImageView imageView9 = new ImageView(
					"220.png");
			imageView9.setFitHeight(40);
			imageView9.setFitWidth(40);

			Button find = new Button("Find", imageView9);
			find.setStyle("-fx-border-radius: 50");
			find.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			find.setFont(Font.font("Georgia", 20));
			find.setLayoutX(520);
			find.setLayoutY(773);
			find.setTextFill(Color.DARKBLUE);
			ImageView imageView10 = new ImageView(
					"100.png");
			imageView10.setFitHeight(40);
			imageView10.setFitWidth(40);

			Button delete = new Button("Delete", imageView10);
			delete.setStyle("-fx-border-radius: 50");
			delete.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			delete.setFont(Font.font("Georgia", 20));
			delete.setLayoutX(615);
			delete.setLayoutY(773);
			delete.setTextFill(Color.DARKBLUE);
			ImageView imageView11 = new ImageView(
					"76.png");
			imageView11.setFitHeight(40);
			imageView11.setFitWidth(40);

			Button update = new Button("Update", imageView11);
			update.setStyle("-fx-border-radius: 50");
			update.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			update.setFont(Font.font("Georgia", 20));
			update.setLayoutX(725);
			update.setLayoutY(773);
			update.setTextFill(Color.DARKBLUE);
			ImageView imageView3 = new ImageView(
					"6.png");
			imageView3.setFitHeight(50);
			imageView3.setFitWidth(50);
			Button back = new Button("Back", imageView3);
			imageView2.setRotate(360);

			back.setFont(Font.font("Georgia", 40));
			back.setLayoutX(10);
			back.setLayoutY(5);
			back.setTextFill(Color.DARKBLUE);
			back.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			back.setOnAction(e -> {

				start(primaryStage);

			});

			TextField text6 = new TextField();
			text6.setPromptText("Patient ID:");
			text6.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text6.setFont(Font.font("Times New Roman", 13));
			text6.setAlignment(Pos.CENTER);

			TextArea text7 = new TextArea();
			text7.setPromptText("the description from diagnosis:");

			text7.setPrefWidth(100);
			text7.setPrefHeight(60);
			text7.setWrapText(true);
			text7.setFont(Font.font("Times New Roman", 13));
			text7.setStyle("-fx-border-color: black;-fx-background-radius: 70");

			text1.setPrefWidth(100);
			text1.setPrefHeight(60);
			text1.setWrapText(true);
			text1.setFont(Font.font("Times New Roman", 13));
			text1.setStyle("-fx-border-color: black;-fx-background-radius: 70");
			TextArea text8 = new TextArea();
			text8.setPromptText("Treatment(prescription) :");

			text8.setPrefWidth(100);
			text8.setPrefHeight(60);
			text8.setWrapText(true);
			text8.setFont(Font.font("Times New Roman", 13));
			text8.setStyle("-fx-border-color: black;-fx-background-radius: 70");
			TextField text9 = new TextField();
			text9.setPromptText("Date of diagnosis:");
			text9.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text9.setFont(Font.font("Times New Roman", 13));
			text9.setAlignment(Pos.CENTER);

			TextField text10 = new TextField();
			text10.setPromptText("Doctor ID:");
			text10.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text10.setFont(Font.font("Times New Roman", 13));
			text10.setAlignment(Pos.CENTER);

			TextField textDia = new TextField();
			textDia.setPromptText("Diagnosis ID:");
			textDia.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			textDia.setFont(Font.font("Times New Roman", 13));
			textDia.setAlignment(Pos.CENTER);

			VBox box3 = new VBox(20);
			box3.setLayoutX(680);
			box3.setLayoutY(440);

			text6.setDisable(true);
			text10.setDisable(true);
			text7.setDisable(true);
			text8.setDisable(true);
			text9.setDisable(true);

			box3.getChildren().addAll(textDia, text6, text10, text7, text8, text9);

			find.setOnAction(e -> {
				if (textDia.getText().isEmpty()) {

					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setText("**Error!!The feild diagnosis Id is empty**");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);
					text6.setDisable(true);

				} else {

					text10.setDisable(false);
					text7.setDisable(false);
					text8.setDisable(false);
					text9.setDisable(false);

					lb50.setVisible(false);

					boolean check = false;
					int f = 0;
					for (int i = 0; i < diagnosis.size(); i++) {
						if (diagnosis.get(i).getDiagnosis_ID() == Integer.parseInt(textDia.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}

					System.out.print(check);
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);
						lb52.setText("               **The diagnosis Id not founded**");

						lb52.setLayoutX(450);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);
						text6.setDisable(true);

						text9.setDisable(true);
						text10.setDisable(true);
						text7.setDisable(true);
						text8.setDisable(true);

						text6.clear();

						text9.clear();

						text10.clear();
						text7.clear();
						text8.clear();

					} else {

						lb52.setVisible(false);
						lb51.setVisible(false);
						lb50.setVisible(false);

						text6.setDisable(false);

						text9.setDisable(false);
						text10.setDisable(false);
						text7.setDisable(false);
						text8.setDisable(false);
						text6.setText(String.valueOf(diagnosis.get(f).getPateint_ID()));
						text10.setText(String.valueOf(diagnosis.get(f).getDoctor_ID()));
						text7.setText(diagnosis.get(f).getDiagnosis_description());
						text8.setText(diagnosis.get(f).getTreatment_discription());
						text9.setText(diagnosis.get(f).getDateOfBirth());

					}
				}

			});

			delete.setOnAction(e -> {
				if (textDia.getText().isEmpty()) {

					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setText("**Error!!The feild diagnosis Id is empty**");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);
					text6.setDisable(true);

				} else {
					lb50.setVisible(false);

					lb51.setVisible(false);
					lb52.setVisible(false);
					deleteRowDiagonisis(textDia.getText().trim());
					diagnosis.clear();
					try {
						getDataDiagnosis();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}

					textDia.clear();
					text6.clear();

					text10.clear();
					text7.clear();
					text8.clear();
					text9.clear();

					text6.setDisable(true);

					text10.setDisable(true);
					text7.setDisable(true);
					text8.setDisable(true);
					text9.setDisable(true);
				}
			});

			update.setOnAction(e -> {
				if (textDia.getText().isEmpty() || text6.getText().isEmpty() || text7.getText().isEmpty()
						|| text8.getText().isEmpty() || text10.getText().isEmpty() || text9.getText().isEmpty()) {

					lb50.setVisible(false);
					lb51.setText("**Error!! some feild are empty**");
					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);

				} else {
					boolean check = false;
					int f = 0;
					for (int i = 0; i < pat.size(); i++) {
						if (pat.get(i).getPateint() == Integer.parseInt(text6.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}

					System.out.print(check);
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);
						lb52.setText("               **The pateint Id not founded**");

						lb52.setLayoutX(450);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);
						text6.setDisable(true);

						text9.setDisable(true);
						text10.setDisable(true);
						text7.setDisable(true);
						text8.setDisable(true);
						textDia.clear();

						text6.clear();

						text9.clear();

						text10.clear();
						text7.clear();
						text8.clear();

					} else {
						boolean check1 = false;
						int f1 = 0;
						for (int i = 0; i < doctor.size(); i++) {
							if (doctor.get(i).getEmployees_ID() == Integer.parseInt(text10.getText())) {
								f1 = i;
								check1 = true;
								break;
							}

							check1 = false;
						}

						System.out.print(check1);
						if (check1 == false) {
							lb52.setVisible(true);
							lb51.setVisible(false);
							lb50.setVisible(false);
							lb52.setText("               **The Doctor Id not founded**");

							lb52.setLayoutX(450);
							lb52.setLayoutY(330);
							lb52.setFont(Font.font("Georgia", 25));
							lb52.setStyle("-fx-background-radius: 50");
							lb52.setTextFill(Color.DARKRED);
							text6.setDisable(true);

							text9.setDisable(true);
							text10.setDisable(true);
							text7.setDisable(true);
							text8.setDisable(true);
							textDia.clear();

							text6.clear();

							text9.clear();

							text10.clear();
							text7.clear();
							text8.clear();
							diagnosis.clear();

						} else {
							lb52.setVisible(false);
							lb51.setVisible(false);
							lb50.setVisible(false);

							text6.setDisable(false);

							text9.setDisable(false);
							text10.setDisable(false);
							text7.setDisable(false);
							text8.setDisable(false);
//					

							lb50.setVisible(false);

							lb51.setVisible(true);
							lb52.setVisible(false);
							updateDiaPateint_Id(textDia.getText(), text6.getText());
							updateDiaDoctor_Id(textDia.getText(), text10.getText());
							updateDiaDiagonis(textDia.getText(), text8.getText());
							updateDiaTreatment(textDia.getText(), text7.getText());
							updateDiaDate(textDia.getText(), text9.getText());
							diagnosis.clear();
							lb51.setText("<<Was Update to Diagnosis Id: " + textDia.getText() + ">>");
							lb51.setLayoutX(500);
							lb51.setLayoutY(330);
							lb51.setFont(Font.font("Georgia", 20));
							lb51.setStyle("-fx-background-radius: 50");
							lb51.setTextFill(Color.BLACK);
						}
						try {
							getDataDiagnosis();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
						textDia.clear();
						text6.clear();

						text7.clear();
						text8.clear();
						text9.clear();
						text10.clear();

						text6.setDisable(true);

						text10.setDisable(true);
						text7.setDisable(true);
						text8.setDisable(true);
						text9.setDisable(true);

					}
				}
//				updateLevel(t.getRowValue().getSnum(), t.getNewValue());

			});
			Label lb335 = new Label("Diagnosis ID:");
			lb335.setLayoutX(670);
			lb335.setLayoutY(50);
			lb335.setFont(Font.font("Georgia", 20));
			lb335.setStyle("-fx-background-radius: 50");
			lb335.setTextFill(Color.BLACK);
			Label lb334 = new Label("Doctor ID:");
			lb334.setLayoutX(670);
			lb334.setLayoutY(50);
			lb334.setFont(Font.font("Georgia", 20));
			lb334.setStyle("-fx-background-radius: 50");
			lb334.setTextFill(Color.BLACK);
			Label lb16 = new Label("Patient ID:");
			lb16.setLayoutX(670);
			lb16.setLayoutY(50);
			lb16.setFont(Font.font("Georgia", 20));
			lb16.setStyle("-fx-background-radius: 50");
			lb16.setTextFill(Color.BLACK);

			Label lb7 = new Label("Diagnosis:");
			lb7.setLayoutX(670);
			lb7.setLayoutY(50);
			lb7.setFont(Font.font("Georgia", 20));
			lb7.setStyle("-fx-background-radius: 50");
			lb7.setTextFill(Color.BLACK);
			Label lb8 = new Label("Prescription:");
			lb8.setLayoutX(670);
			lb8.setLayoutY(50);
			lb8.setFont(Font.font("Georgia", 20));
			lb8.setStyle("-fx-background-radius: 50");
			lb8.setTextFill(Color.BLACK);
			Label lb90 = new Label("Date Of Diagnosis:");
			lb90.setLayoutX(505);
			lb90.setLayoutY(737);
			lb90.setFont(Font.font("Georgia", 20));
			lb90.setStyle("-fx-background-radius: 50");
			lb90.setTextFill(Color.BLACK);
			Label lb13 = new Label("Add Diagnosis and\n Prescription");
			lb13.setLayoutX(100);
			lb13.setLayoutY(362);
			lb13.setFont(Font.font("Georgia", 30));
			lb13.setStyle("-fx-background-radius: 50");
			lb13.setTextFill(Color.DARKBLUE);
			Label lb14 = new Label("Delete Or Update");
			lb14.setLayoutX(580);
			lb14.setLayoutY(362);
			lb14.setFont(Font.font("Georgia", 30));
			lb14.setStyle("-fx-background-radius: 50");
			lb14.setTextFill(Color.DARKBLUE);

			VBox box2 = new VBox(23);
			box2.setLayoutX(505);
			box2.setLayoutY(440);

			Label lb24 = new Label("Payment_List");
			lb24.setLayoutX(1210);
			lb24.setLayoutY(40);
			lb24.setFont(Font.font("Times New Roman", 30));
			lb24.setStyle("-fx-background-radius: 50");
			lb24.setTextFill(Color.DARKBLUE);
			box2.getChildren().addAll(lb335, lb16, lb334);

			TextField text30 = new TextField();
			text30.setPromptText("Patient ID:");
			text30.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text30.setFont(Font.font("Times New Roman", 13));
			text30.setAlignment(Pos.CENTER);

			TextField text31 = new TextField();
			text31.setPromptText("Secrteries ID:");

			text31.setFont(Font.font("Times New Roman", 13));
			text31.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text31.setAlignment(Pos.CENTER);

			TextField text32 = new TextField();
			text32.setPromptText("Doctor ID:");

			text32.setFont(Font.font("Times New Roman", 13));
			text32.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text32.setAlignment(Pos.CENTER);

			TextField text33 = new TextField();
			text33.setPromptText("Date_Payment :");

			text33.setFont(Font.font("Times New Roman", 13));
			text33.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text33.setAlignment(Pos.CENTER);

			TextField text34 = new TextField();
			text34.setPromptText("Cost :");

			text34.setFont(Font.font("Times New Roman", 13));
			text34.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text34.setAlignment(Pos.CENTER);

			VBox box5 = new VBox(33);
			box5.setLayoutX(1250);
			box5.setLayoutY(440);
			box5.getChildren().addAll(text30, text31, text32, text33, text34);
			ImageView imageView23 = new ImageView(
					"13.png");
			imageView23.setFitHeight(40);
			imageView23.setFitWidth(40);

			Button addPay = new Button("Add", imageView23);
			addPay.setStyle("-fx-border-radius: 50");
			addPay.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			addPay.setFont(Font.font("Georgia", 20));
			addPay.setLayoutX(1250);
			addPay.setLayoutY(773);
			addPay.setTextFill(Color.DARKBLUE);
			addPay.setOnAction(e -> {
				if (text30.getText().isEmpty() || text31.getText().isEmpty() || text32.getText().isEmpty()
						|| text33.getText().isEmpty() || text34.getText().isEmpty()) {
					System.out.println("ssssssss");
					lb50.setVisible(true);
					lb50.setText("**Error!! some feild is empty**");
					lb50.setLayoutX(1090);
					lb50.setLayoutY(330);
					lb50.setFont(Font.font("Georgia", 25));
					lb50.setStyle("-fx-background-radius: 50");
					lb50.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);
					boolean check = false;
					int f = 0;

					for (int i = 0; i < pat.size(); i++) {
						if (pat.get(i).getPateint() == Integer.parseInt(text30.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);
						lb52.setText("**Error!! The Pateint ID not found**");
						lb52.setLayoutX(1090);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);

						text30.clear();
						text31.clear();
						text32.clear();
						text33.clear();
						text34.clear();

					} else {
						boolean check1 = false;
						int f1 = 0;

						for (int i = 0; i < doctor.size(); i++) {
							if (doctor.get(i).getEmployees_ID() == Integer.parseInt(text31.getText())) {
								f1 = i;
								check1 = true;
								break;
							}

							check1 = false;
						}
						if (check1 == false) {
							lb52.setVisible(true);
							lb51.setVisible(false);
							lb50.setVisible(false);
							lb52.setText("**Error!! The Secertary ID not found**");
							lb52.setLayoutX(1090);
							lb52.setLayoutY(330);
							lb52.setFont(Font.font("Georgia", 25));
							lb52.setStyle("-fx-background-radius: 50");
							lb52.setTextFill(Color.DARKRED);

							text30.clear();
							text31.clear();
							text32.clear();
							text33.clear();
							text34.clear();

						} else {
							boolean check2 = false;
							int f2 = 0;

							for (int i = 0; i < doctor.size(); i++) {
								if (doctor.get(i).getEmployees_ID() == Integer.parseInt(text32.getText())) {
									f1 = i;
									check2 = true;
									break;
								}

								check2 = false;
							}
							if (check2 == false) {
								lb52.setVisible(true);
								lb51.setVisible(false);
								lb50.setVisible(false);
								lb52.setText("**Error!! The Docror ID not found**");
								lb52.setLayoutX(1090);
								lb52.setLayoutY(330);
								lb52.setFont(Font.font("Georgia", 25));
								lb52.setStyle("-fx-background-radius: 50");
								lb52.setTextFill(Color.DARKRED);

							} else {
								lb52.setVisible(false);
								lb51.setVisible(false);
								lb50.setVisible(false);

								Payment rc;
//						public Diagnosis( String pateint_name, String treatment_discription, String diagnosis_description,
//						Date dateOfBirth, int pateint_ID, int doctor_ID) {
								rc = new Payment(Integer.parseInt(text30.getText()), Integer.parseInt(text31.getText()),
										Integer.parseInt(text32.getText()), text33.getText(),
										Double.parseDouble(text34.getText()));
								payments.add(rc);
								insertDataPayment(rc);
								lb52.setVisible(true);
								lb51.setVisible(false);
								lb50.setVisible(false);
								lb52.setText("<< Was added the cost to the pateint_Id: " + text30.getText() + " >>");
								lb52.setLayoutX(1050);
								lb52.setLayoutY(330);
								lb52.setFont(Font.font("Georgia", 20));
								lb52.setStyle("-fx-background-radius: 50");
								lb52.setTextFill(Color.DARKRED);
								text30.clear();
								text31.clear();
								text32.clear();
								text33.clear();
								text34.clear();

								payments.clear();
								try {
									getDataPayment();
								} catch (ClassNotFoundException | SQLException e1) {
									e1.printStackTrace();
								}

							}
						}
					}

				}

			});

			Label lb30 = new Label("Patient ID:");
			lb30.setLayoutX(670);
			lb30.setLayoutY(50);
			lb30.setFont(Font.font("Georgia", 20));
			lb30.setStyle("-fx-background-radius: 50");
			lb30.setTextFill(Color.BLACK);

			Label lb31 = new Label("Secrteries ID:");
			lb31.setLayoutX(670);
			lb31.setLayoutY(50);
			lb31.setFont(Font.font("Georgia", 20));
			lb31.setStyle("-fx-background-radius: 50");
			lb31.setTextFill(Color.BLACK);
			Label lb33 = new Label("Doctor ID:");
			lb33.setLayoutX(670);
			lb33.setLayoutY(50);
			lb33.setFont(Font.font("Georgia", 20));
			lb33.setStyle("-fx-background-radius: 50");
			lb33.setTextFill(Color.BLACK);

			Label lb34 = new Label("Date_Payment:");
			lb34.setLayoutX(670);
			lb34.setLayoutY(50);
			lb34.setFont(Font.font("Georgia", 20));
			lb34.setStyle("-fx-background-radius: 50");
			lb34.setTextFill(Color.BLACK);
			Label lb35 = new Label("Cost:");
			lb35.setLayoutX(670);
			lb35.setLayoutY(50);
			lb35.setFont(Font.font("Georgia", 20));
			lb35.setStyle("-fx-background-radius: 50");
			lb35.setTextFill(Color.BLACK);
			Label lb36 = new Label("Add Payment");
			lb36.setLayoutX(100);
			lb36.setLayoutY(362);
			lb36.setFont(Font.font("Georgia", 30));
			lb36.setStyle("-fx-background-radius: 50");
			lb36.setTextFill(Color.DARKBLUE);

			VBox box6 = new VBox(35);
			box6.setLayoutX(1110);
			box6.setLayoutY(440);

			box6.getChildren().addAll(lb30, lb31, lb33, lb34, lb35);

			Label lb40 = new Label("Issue Invoce");
			lb40.setLayoutX(1200);
			lb40.setLayoutY(370);
			lb40.setFont(Font.font("Times New Roman", 30));
			lb40.setStyle("-fx-background-radius: 50");
			lb40.setTextFill(Color.DARKBLUE);

			lb7.setLayoutX(505);
			lb7.setLayoutY(590);
			lb8.setLayoutX(505);
			lb8.setLayoutY(665);
			Group group = new Group();
			group.getChildren().addAll(imageView2, rectangle, rectangle1, rectangle2, lb, box, box1, add, box3, box2,
					lb13, lb14, find, delete, update, lb23, vbox4, lb24, vbox, back, box5, box6, lb40, addPay, lb2,
					lb39, lb1, lb50, lb51, lb52, lb90, lb7, lb8);
			Scene scene = new Scene(group);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private void pateint(Stage primaryStage) {
		try {
			TableView<Pateint> pateint;
			pat.clear();

			getDataPatient();
			TableColumn<Pateint, Integer> Patient_ID = new TableColumn<>("Patient_ID");
			Patient_ID.setPrefWidth(100);
			Patient_ID.setCellValueFactory(new PropertyValueFactory<>("Pateint"));

			TableColumn<Pateint, String> Patient_Name = new TableColumn<>("Patient_Name");
			Patient_Name.setPrefWidth(150);
			Patient_Name.setCellValueFactory(new PropertyValueFactory<>("pateint_Name"));

			TableColumn<Pateint, String> genderPatient = new TableColumn<>("Gender");
			genderPatient.setPrefWidth(80);
			genderPatient.setCellValueFactory(new PropertyValueFactory<>("gender"));

			TableColumn<Pateint, Double> phoneNumPatient = new TableColumn<>("Phone_Number");
			phoneNumPatient.setPrefWidth(150);
			phoneNumPatient.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

			TableColumn<Pateint, Date> dateOfBirthPatient = new TableColumn<>("Date_Of_Birth");
			dateOfBirthPatient.setPrefWidth(120);
			dateOfBirthPatient.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

			TableColumn<Pateint, Double> Insurance = new TableColumn<>("Insurance");
			Insurance.setPrefWidth(80);
			Insurance.setCellValueFactory(new PropertyValueFactory<>("Insurance"));

			TableColumn<Pateint, String> name_builder = new TableColumn<>("Name_Building");
			name_builder.setPrefWidth(100);
			name_builder.setCellValueFactory(new PropertyValueFactory<>("name_building"));

			TableColumn<Pateint, String> city = new TableColumn<>("city");
			city.setPrefWidth(100);
			city.setCellValueFactory(new PropertyValueFactory<>("city"));
			pateint = new TableView<>();
			Patient_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			Patient_Name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			genderPatient.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			phoneNumPatient.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			dateOfBirthPatient.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			Insurance.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			name_builder.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			city.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			pateint.setStyle("-fx-border-color: black;-fx-background-radius: 5;-fx-border-radius: 5");
//			employees.setBackground(
//					new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
//			employees.setItems(data);
			pateint.setPrefHeight(250);
			pateint.setPrefWidth(885);

			pateint.getColumns().addAll(Patient_ID, Patient_Name, genderPatient, phoneNumPatient, dateOfBirthPatient,
					Insurance, name_builder, city);
			pateint.refresh();
			pateint.setItems(pat);

			Patient_ID.setResizable(false);
			Patient_Name.setResizable(false);
			genderPatient.setResizable(false);
			phoneNumPatient.setResizable(false);
			dateOfBirthPatient.setResizable(false);
			Insurance.setResizable(false);
			name_builder.setResizable(false);
			city.setResizable(false);

			final VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(80, 0, 0, 30));
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(pateint);

			primaryStage.setMaximized(true);

			primaryStage.setResizable(false);
			Label lb = new Label("pateints");
			lb.setLayoutX(670);
			lb.setLayoutY(10);
			lb.setFont(Font.font("Cooper Black", 50));
			lb.setStyle("-fx-background-radius: 50");
			lb.setTextFill(Color.YELLOW);
			Label lb23 = new Label("Pateints_List");
			lb23.setLayoutX(300);
			lb23.setLayoutY(40);
			lb23.setFont(Font.font("Times New Roman", 30));
			lb23.setStyle("-fx-background-radius: 50");
			lb23.setTextFill(Color.DARKBLUE);

			Image image1 = new Image("121.jpg");

			Image image = new Image("11.jpg");

			primaryStage.getIcons().add(image);
			ImageView imageView2 = new ImageView(image1);
			imageView2.setFitHeight(842);
			imageView2.setFitWidth(1540);
			TextField text = new TextField();
			text.setPromptText("Pateint Name:");
			text.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text.setFont(Font.font("Times New Roman", 13));
			text.setAlignment(Pos.CENTER);

			TextField text2 = new TextField();
			text2.setPromptText("Phone Number:");
			text2.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text2.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text2.setFont(Font.font("Times New Roman", 13));
			text2.setAlignment(Pos.CENTER);
			TextField text3 = new TextField();
			text3.setPromptText("The Date BY (yy-mm-dd):");
			text3.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text3.setFont(Font.font("Times New Roman", 13));
			text3.setAlignment(Pos.CENTER);
			TextField text4 = new TextField();
			text4.setPromptText("Name Building:");
			text4.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text4.setFont(Font.font("Times New Roman", 13));
			text4.setAlignment(Pos.CENTER);
			TextField text211 = new TextField();
			text211.setPromptText("City:");
			text211.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text211.setFont(Font.font("Times New Roman", 13));
			text211.setAlignment(Pos.CENTER);
			ChoiceBox<String> text1 = new ChoiceBox<>();
			text1.setValue("              Select a Gender    ");
			text1.setPrefWidth(200);
			String[] genderText = { "                       Male          ", "                       Female        " };

			text1.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text1.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text1.getItems().addAll(genderText);
			ChoiceBox<String> text5 = new ChoiceBox<>();
			text5.setValue("              Are have insurance    ");
			text5.setPrefWidth(200);
			String[] genderText5 = { "                         Yes       ", "                         No        " };

			text5.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text5.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text5.getItems().addAll(genderText5);

			Label lb1 = new Label("Pateint Name:");
			lb1.setLayoutX(670);
			lb1.setLayoutY(50);
			lb1.setFont(Font.font("Georgia", 20));
			lb1.setStyle("-fx-background-radius: 50");
			lb1.setTextFill(Color.BLACK);
			Label lb2 = new Label("Gender:");
			lb2.setLayoutX(670);
			lb2.setLayoutY(50);
			lb2.setFont(Font.font("Georgia", 20));
			lb2.setStyle("-fx-background-radius: 50");
			lb2.setTextFill(Color.BLACK);
			Label lb3 = new Label("Phone Number:");
			lb3.setLayoutX(670);
			lb3.setLayoutY(50);
			lb3.setFont(Font.font("Georgia", 20));
			lb3.setStyle("-fx-background-radius: 50");
			lb3.setTextFill(Color.BLACK);
			Label lb4 = new Label("Date Of Birth:");
			lb4.setLayoutX(670);
			lb4.setLayoutY(50);
			lb4.setFont(Font.font("Georgia", 20));
			lb4.setStyle("-fx-background-radius: 50");
			lb4.setTextFill(Color.BLACK);
			Label lb5 = new Label("Insurance:");
			lb5.setLayoutX(670);
			lb5.setLayoutY(50);
			lb5.setFont(Font.font("Georgia", 20));
			lb5.setStyle("-fx-background-radius: 50");
			lb5.setTextFill(Color.BLACK);
			Label lb6 = new Label("Name Building:");
			lb6.setLayoutX(670);
			lb6.setLayoutY(50);
			lb6.setFont(Font.font("Georgia", 20));
			lb6.setStyle("-fx-background-radius: 50");
			lb6.setTextFill(Color.BLACK);

			Label lb111 = new Label("City:");
			lb111.setLayoutX(670);
			lb111.setLayoutY(50);
			lb111.setFont(Font.font("Georgia", 20));
			lb111.setStyle("-fx-background-radius: 50");
			lb111.setTextFill(Color.BLACK);

			VBox box1 = new VBox(29);
			box1.setLayoutX(45);
			box1.setLayoutY(420);
			box1.getChildren().addAll(lb1, lb2, lb3, lb4, lb5, lb6, lb111);
			Button rectangle = new Button();
			rectangle.setLayoutX(30);
			rectangle.setLayoutY(395);
			rectangle.setLayoutY(360);
			rectangle.setPrefWidth(380);
			rectangle.setPrefHeight(475);
			rectangle.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			Button rectangle1 = new Button();
			rectangle1.setLayoutX(490);
			rectangle1.setLayoutY(360);
			rectangle1.setPrefWidth(380);
			rectangle1.setPrefHeight(475);
			rectangle1.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle1.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			ImageView imageView = new ImageView(
					"21.png");
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);

			Button add = new Button("Add", imageView);
			add.setStyle("-fx-border-radius: 50");
			add.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			add.setFont(Font.font("Georgia", 20));
			add.setLayoutX(150);
			add.setLayoutY(773);
			add.setTextFill(Color.DARKBLUE);
			ImageView imageView9 = new ImageView(
					"220.png");
			imageView9.setFitHeight(40);
			imageView9.setFitWidth(40);
			Label lb50 = new Label("**Error!! some feild are empty**");
			lb50.setVisible(false);
			VBox box = new VBox(26);
			box.setLayoutX(200);
			box.setLayoutY(420);
			box.getChildren().addAll(text, text1, text2, text3, text5, text4, text211);
			add.setOnAction(e -> {
				System.out.print(text1.getValue().trim().equals("Select a Gender"));
				if (text.getText().isEmpty() || text1.getValue().trim().equals("Select a Gender")
						|| text2.getText().isEmpty() || text3.getText().isEmpty() || text4.getText().isEmpty()
						|| text5.getValue().trim().equals("Select a Role") || text211.getText().isEmpty()) {

					lb50.setVisible(true);

					lb50.setLayoutX(40);
					lb50.setLayoutY(330);
					lb50.setFont(Font.font("Georgia", 25));
					lb50.setStyle("-fx-background-radius: 50");
					lb50.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);
					Pateint rc;
//					public Pateint( String pateint_Name, String gender, String phoneNum, Date dateOfBirth, String insurance,
//					String name_building,String city)
					rc = new Pateint(text.getText(), text1.getValue().trim(), text2.getText(), text3.getText(),
							text5.getValue().trim(), text4.getText(), text211.getText());
					pat.add(rc);
					insertDataPatient(rc);
					text1.setValue("Select a Gender");
					text.clear();
					text2.clear();
					text3.clear();
					text4.clear();
					text5.setValue("Select a Role");
					text211.clear();
					pat.clear();
					try {
						getDataPatient();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

			});
			Label lb51 = new Label("**Error!! some feild are empty**");
			Label lb52 = new Label("**Error!! The Patient ID not found**");
			lb51.setVisible(false);
			lb52.setVisible(false);

			pateint.refresh();
			Button find = new Button("Find", imageView9);
			find.setStyle("-fx-border-radius: 50");
			find.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			find.setFont(Font.font("Georgia", 20));
			find.setLayoutX(520);
			find.setLayoutY(773);
			find.setTextFill(Color.DARKBLUE);

			ImageView imageView10 = new ImageView(
					"100.png");
			imageView10.setFitHeight(40);
			imageView10.setFitWidth(40);

			Button delete = new Button("Delete", imageView10);
			delete.setStyle("-fx-border-radius: 50");
			delete.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			delete.setFont(Font.font("Georgia", 20));
			delete.setLayoutX(615);
			delete.setLayoutY(773);
			delete.setTextFill(Color.DARKBLUE);
			ImageView imageView11 = new ImageView(
					"76.png");
			imageView11.setFitHeight(40);
			imageView11.setFitWidth(40);

			Button update = new Button("Update", imageView11);
			update.setStyle("-fx-border-radius: 50");
			update.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			update.setFont(Font.font("Georgia", 20));
			update.setLayoutX(725);
			update.setLayoutY(773);
			update.setTextFill(Color.DARKBLUE);
			ImageView imageView3 = new ImageView("6.png");
			imageView3.setFitHeight(50);
			imageView3.setFitWidth(50);
			Button back = new Button("Back", imageView3);
			imageView2.setRotate(360);

			back.setFont(Font.font("Georgia", 40));
			back.setLayoutX(10);
			back.setLayoutY(5);
			back.setTextFill(Color.DARKBLUE);
			back.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			back.setOnAction(e -> {

				start(primaryStage);

			});

			TextField text6 = new TextField();
			text6.setPromptText("Patient Name:");
			text6.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text6.setFont(Font.font("Times New Roman", 13));
			text6.setAlignment(Pos.CENTER);

			TextField text7 = new TextField();
			text7.setPromptText("Phone Number:");
			text7.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text2.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text7.setFont(Font.font("Times New Roman", 13));
			text7.setAlignment(Pos.CENTER);
			TextField text8 = new TextField();
			text8.setPromptText("The Date BY (yy-mm-dd):");
			text8.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text8.setFont(Font.font("Times New Roman", 13));
			text8.setAlignment(Pos.CENTER);

			ChoiceBox<String> text10 = new ChoiceBox<>();
			text10.setValue("              Select a Gender    ");
			text10.setPrefWidth(200);
			String[] genderText10 = { "                       Male          ",
					"                       Female        " };

			text10.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text10.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text10.getItems().addAll(genderText10);
			ChoiceBox<String> text11 = new ChoiceBox<>();
			text11.setValue("              Are have Insurance    ");
			text11.setPrefWidth(200);
			String[] genderText11 = { "                         Yes       ", "                         No        " };

			text11.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text11.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text11.getItems().addAll(genderText11);

			TextField text12 = new TextField();
			text12.setPromptText("Pateint_ID:");
			text12.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			TextField text13 = new TextField();
			text13.setPromptText("The Name Building:");
			text13.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text13.setFont(Font.font("Times New Roman", 13));
			text13.setAlignment(Pos.CENTER);
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text12.setFont(Font.font("Times New Roman", 13));
			text12.setAlignment(Pos.CENTER);

			TextField text14 = new TextField();
			text14.setPromptText("The City:");
			text14.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text14.setFont(Font.font("Times New Roman", 13));
			text14.setAlignment(Pos.CENTER);
			VBox box3 = new VBox(20);
			box3.setLayoutX(660);
			box3.setLayoutY(420);
			box3.getChildren().addAll(text12, text6, text10, text7, text8, text11, text13, text14);
			text6.setDisable(true);
			text10.setDisable(true);
			text7.setDisable(true);
			text8.setDisable(true);
			text11.setDisable(true);
			text13.setDisable(true);
			text14.setDisable(true);
			find.setOnAction(e -> {
				if (text12.getText().isEmpty()) {

					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setText("**Error!! some feild are empty**");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);
					text6.setDisable(true);

				} else {

					text6.setDisable(false);
					text10.setDisable(false);
					text7.setDisable(false);
					text8.setDisable(false);
					text11.setDisable(false);
					text13.setDisable(false);
					text14.setDisable(false);
					lb50.setVisible(false);

					boolean check = false;
					int f = 0;
					for (int i = 0; i < pat.size(); i++) {
						if (pat.get(i).getPateint() == Integer.parseInt(text12.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}

					System.out.print(check);
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);

						lb52.setLayoutX(450);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);
						text6.setDisable(true);
						text10.setDisable(true);
						text7.setDisable(true);
						text8.setDisable(true);
						text11.setDisable(true);
						text13.setDisable(true);
						text14.setDisable(true);

						text6.clear();

						text10.setValue("              Select a Gender    ");
						text7.clear();
						text8.clear();
						text11.setValue("              Select a Role    ");
						text13.clear();
						text14.clear();

					} else {

						lb52.setVisible(false);
						lb51.setVisible(false);
						lb50.setVisible(false);

						text6.setDisable(false);

						text6.setDisable(false);
						text10.setDisable(false);
						text7.setDisable(false);
						text8.setDisable(false);
						text11.setDisable(false);
						text13.setDisable(false);
						text14.setDisable(false);
						text6.setText(pat.get(f).getPateint_Name());
						text10.setValue("                       " + pat.get(f).getGender() + "      ");
						text7.setText(pat.get(f).getPhoneNum());
						text8.setText(pat.get(f).getDateOfBirth());
//						text9.setText(String.valueOf(emps.get(f).getSalary()));
						text11.setValue("                       " + pat.get(f).getInsurance() + "       ");
						text13.setText(pat.get(f).getName_building());
						text14.setText(pat.get(f).getCity());

					}
				}

			});

			delete.setOnAction(e -> {

				deleteRowPateint(text12.getText().trim());
				pat.clear();
				try {
					getDataPatient();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

				text12.clear();
				text6.clear();

				text10.setValue("              Select a Gender    ");
				text7.clear();
				text8.clear();
				text11.setValue("              Select a Role    ");
				text13.clear();

				text14.clear();
				text6.setDisable(true);

				text10.setDisable(true);
				text7.setDisable(true);
				text8.setDisable(true);
				text11.setDisable(true);
				text13.setDisable(true);

				text14.setDisable(true);
			});

			update.setOnAction(e -> {
				if (text12.getText().isEmpty() || text6.getText().isEmpty()
						|| text10.getValue().equals("              Select a Gender    ") || text7.getText().isEmpty()
						|| text8.getText().isEmpty() || text11.getValue().equals("              Select a Role    ")
						|| text13.getText().isEmpty() || text14.getText().isEmpty()) {

					lb50.setVisible(false);
					lb51.setText("**Error!! some feild are empty**");
					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);

					lb51.setVisible(true);
					lb52.setVisible(false);
					updatepateint_Name(text12.getText(), text6.getText());
					updatePatgender(text12.getText(), text10.getValue().trim());
					updatePatphoneNum(text12.getText(), text7.getText());
					updatePatdateOfBirth(text12.getText(), text8.getText());
					updatePatinsurance(text12.getText(), text11.getValue().trim());
					updatePatname_bulding(text12.getText(), text13.getText());
					updatePatcity(text12.getText(), text14.getText());
					pat.clear();
					lb51.setText("<<Was Update to Employee name: " + text6.getText() + ">>");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 20));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.BLACK);
					try {
						getDataPatient();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					text12.clear();
					text6.clear();

					text10.setValue("              Select a Gender    ");
					text7.clear();
					text8.clear();
					text11.setValue("              Select a Role    ");
					text13.clear();

					text14.clear();
					text6.setDisable(true);

					text10.setDisable(true);
					text7.setDisable(true);
					text8.setDisable(true);
					text11.setDisable(true);
					text13.setDisable(true);

					text14.setDisable(true);
				}

//				updateLevel(t.getRowValue().getSnum(), t.getNewValue());

			});
			Label lb16 = new Label("Patient ID:");
			lb16.setLayoutX(670);
			lb16.setLayoutY(50);
			lb16.setFont(Font.font("Georgia", 20));
			lb16.setStyle("-fx-background-radius: 50");
			lb16.setTextFill(Color.BLACK);

			Label lb7 = new Label("Patient Name:");
			lb7.setLayoutX(670);
			lb7.setLayoutY(50);
			lb7.setFont(Font.font("Georgia", 20));
			lb7.setStyle("-fx-background-radius: 50");
			lb7.setTextFill(Color.BLACK);
			Label lb8 = new Label("Gender:");
			lb8.setLayoutX(670);
			lb8.setLayoutY(50);
			lb8.setFont(Font.font("Georgia", 20));
			lb8.setStyle("-fx-background-radius: 50");
			lb8.setTextFill(Color.BLACK);
			Label lb9 = new Label("Phone Number:");
			lb9.setLayoutX(670);
			lb9.setLayoutY(50);
			lb9.setFont(Font.font("Georgia", 20));
			lb9.setStyle("-fx-background-radius: 50");
			lb9.setTextFill(Color.BLACK);
			Label lb10 = new Label("Date Of Birth:");
			lb10.setLayoutX(670);
			lb10.setLayoutY(50);
			lb10.setFont(Font.font("Georgia", 20));
			lb10.setStyle("-fx-background-radius: 50");
			lb10.setTextFill(Color.BLACK);
			Label lb11 = new Label("Insurance:");
			lb11.setLayoutX(670);
			lb11.setLayoutY(50);
			lb11.setFont(Font.font("Georgia", 20));
			lb11.setStyle("-fx-background-radius: 50");
			lb11.setTextFill(Color.BLACK);
			Label lb12 = new Label("Name_Building:");
			lb12.setLayoutX(670);
			lb12.setLayoutY(50);
			lb12.setFont(Font.font("Georgia", 20));
			lb12.setStyle("-fx-background-radius: 50");
			lb12.setTextFill(Color.BLACK);
			Label lb15 = new Label("City:");
			lb15.setLayoutX(670);
			lb15.setLayoutY(50);
			lb15.setFont(Font.font("Georgia", 20));
			lb15.setStyle("-fx-background-radius: 50");
			lb15.setTextFill(Color.BLACK);

			Label lb13 = new Label("Addition");
			lb13.setLayoutX(160);
			lb13.setLayoutY(362);
			lb13.setFont(Font.font("Georgia", 30));
			lb13.setStyle("-fx-background-radius: 50");
			lb13.setTextFill(Color.DARKBLUE);
			Label lb14 = new Label("Delete Or Update");
			lb14.setLayoutX(580);
			lb14.setLayoutY(362);
			lb14.setFont(Font.font("Georgia", 30));
			lb14.setStyle("-fx-background-radius: 50");
			lb14.setTextFill(Color.DARKBLUE);

			VBox box2 = new VBox(22);
			box2.setLayoutX(505);
			box2.setLayoutY(420);

			box2.getChildren().addAll(lb16, lb7, lb8, lb9, lb10, lb11, lb12, lb15);
			Group group = new Group();
			group.getChildren().addAll(imageView2, rectangle, rectangle1, lb, box, box1, add, box3, box2, lb13, lb14,
					find, delete, update, lb23, vbox, back, lb50, lb51, lb52);
			Scene scene = new Scene(group);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private void doctor(Stage primaryStage) {
		try {
			TableView<Employees> employees;
			doctor.clear();

			PrintDoctors();
			TableColumn<Employees, Integer> employees_ID = new TableColumn<>("Doctor_ID");
			employees_ID.setPrefWidth(100);
			employees_ID.setCellValueFactory(new PropertyValueFactory<>("employees_ID"));

			TableColumn<Employees, String> Employees_Name = new TableColumn<>("Doctor_Name");
			Employees_Name.setPrefWidth(150);
			Employees_Name.setCellValueFactory(new PropertyValueFactory<>("name_employee"));

			TableColumn<Employees, String> gender = new TableColumn<>("Gender");
			gender.setPrefWidth(80);
			gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

			TableColumn<Employees, Double> phoneNum = new TableColumn<>("Phone_Number");
			phoneNum.setPrefWidth(150);
			phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

			TableColumn<Employees, Date> dateOfBirth = new TableColumn<>("Date_Of_Birth");
			dateOfBirth.setPrefWidth(120);
			dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

			TableColumn<Employees, Double> salary = new TableColumn<>("Salary");
			salary.setPrefWidth(100);
			salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

			TableColumn<Employees, String> Name_Building = new TableColumn<>("Name_Building");
			Name_Building.setPrefWidth(100);
			Name_Building.setCellValueFactory(new PropertyValueFactory<>("name_bulding"));
			TableColumn<Employees, String> city = new TableColumn<>("City");
			city.setPrefWidth(80);
			city.setCellValueFactory(new PropertyValueFactory<>("city"));
			employees = new TableView<>();
			employees_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			Employees_Name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			gender.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			phoneNum.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			dateOfBirth.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			salary.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			Name_Building.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			city.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			employees.setStyle("-fx-border-color: black;-fx-background-radius: 5;-fx-border-radius: 5");
//			employees.setBackground(
//					new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
//			employees.setItems(data);
			employees.setPrefHeight(250);
			employees.setPrefWidth(885);

			Employees_Name.setResizable(false);
			employees_ID.setResizable(false);
			gender.setResizable(false);
			phoneNum.setResizable(false);
			dateOfBirth.setResizable(false);
			salary.setResizable(false);
			Name_Building.setResizable(false);
			city.setResizable(false);

			employees.getColumns().addAll(employees_ID, Employees_Name, gender, phoneNum, dateOfBirth, salary,
					Name_Building, city);
			employees.refresh();
			employees.setItems(doctor);
			final VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(200, 0, 0, 60));
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(employees);

			primaryStage.setMaximized(true);

			primaryStage.setResizable(false);
			Label lb = new Label("Doctor");
			lb.setLayoutX(670);
			lb.setLayoutY(10);
			lb.setFont(Font.font("Cooper Black", 50));
			lb.setStyle("-fx-background-radius: 50");
			lb.setTextFill(Color.BLACK);
			Label lb23 = new Label("Doctors_List");
			lb23.setLayoutX(370);
			lb23.setLayoutY(150);
			lb23.setFont(Font.font("Times New Roman", 30));
			lb23.setStyle("-fx-background-radius: 50");
			lb23.setTextFill(Color.DARKBLUE);

			Image image1 = new Image("0.jpg");

			Image image = new Image("0.jpg");
			ImageView imageView3 = new ImageView(
					"6.png");
			imageView3.setFitHeight(50);
			imageView3.setFitWidth(50);

			Button back = new Button("Back", imageView3);

			back.setFont(Font.font("Georgia", 40));
			back.setLayoutX(10);
			back.setLayoutY(5);
			back.setTextFill(Color.DARKBLUE);
			back.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			back.setOnAction(e -> {

				start(primaryStage);

			});
//			Button bPationtCity = new Button("bPationtCity", imageView3);
//
//			bPationtCity.setOnAction(e -> {
//				
//				connectDB();
//				String sql = "select pateint.City ,count(pateint) from pateint group by(pateint.City);";
//				Statement stat = con.createStatement();
//				ResultSet rs = stat.executeQuery(sql);
//
//				rs.close();
//				stat.close();
//				con.close();
//			});

			primaryStage.getIcons().add(image);
			ImageView imageView2 = new ImageView(image1);
			imageView2.setFitHeight(842);
			imageView2.setFitWidth(1540);

			Group group = new Group();
			group.getChildren().addAll(imageView2, lb, lb23, vbox, back);
			Scene scene = new Scene(group);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void employee(Stage primaryStage) {
		try {
			TableView<Employees> employees;

			emps.clear();

			getDataEmployee();

			TableColumn<Employees, Integer> employees_ID = new TableColumn<>("Employees_ID");
			employees_ID.setPrefWidth(100);
			employees_ID.setCellValueFactory(new PropertyValueFactory<>("employees_ID"));

			TableColumn<Employees, String> Employees_Name = new TableColumn<>("Employees_Name");
			Employees_Name.setPrefWidth(150);
			Employees_Name.setCellValueFactory(new PropertyValueFactory<>("name_employee"));

			TableColumn<Employees, String> gender = new TableColumn<>("Gender");
			gender.setPrefWidth(80);
			gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

			TableColumn<Employees, String> phoneNum = new TableColumn<>("Phone_Number");
			phoneNum.setPrefWidth(150);
			phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

			TableColumn<Employees, String> dateOfBirth = new TableColumn<>("Date_Of_Birth");
			dateOfBirth.setPrefWidth(120);
			dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

			TableColumn<Employees, Double> salary = new TableColumn<>("Salary");
			salary.setPrefWidth(80);
			salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

			TableColumn<Employees, String> role = new TableColumn<>("Role");
			role.setPrefWidth(80);
			role.setCellValueFactory(new PropertyValueFactory<>("role"));

			TableColumn<Employees, String> name_biulding = new TableColumn<>("Name_Building");
			name_biulding.setPrefWidth(182);
			name_biulding.setCellValueFactory(new PropertyValueFactory<>("name_bulding"));
			name_biulding.setResizable(false);

			TableColumn<Employees, String> city = new TableColumn<>("City");
			city.setPrefWidth(110);
			city.setCellValueFactory(new PropertyValueFactory<>("city"));

			employees = new TableView<>();
			employees_ID.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			Employees_Name.setResizable(false);
			employees_ID.setResizable(false);
			gender.setResizable(false);
			phoneNum.setResizable(false);
			dateOfBirth.setResizable(false);
			salary.setResizable(false);
			role.setResizable(false);

			Employees_Name.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			gender.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			phoneNum.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			dateOfBirth.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			salary.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			role.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			employees.setStyle("-fx-border-color: black;-fx-background-radius: 5;-fx-border-radius: 5");
//			employees.setBackground(
//					new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
//			employees.setItems(data);
			employees.setPrefHeight(250);
			employees.setPrefWidth(1058);

			employees.getColumns().addAll(employees_ID, Employees_Name, gender, phoneNum, dateOfBirth, salary, role,
					name_biulding, city);
			employees.refresh();
			employees.setItems(emps);

			name_biulding.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			name_biulding.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");
			city.setStyle("-fx-border-color: darkblue;-fx-background-radius: 5;-fx-border-radius: 5");

			final VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(80, 0, 0, 30));
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(employees);

			primaryStage.setMaximized(true);

			primaryStage.setResizable(false);
			Label lb = new Label("Employees");
			lb.setLayoutX(670);
			lb.setLayoutY(10);
			lb.setFont(Font.font("Cooper Black", 50));
			lb.setStyle("-fx-background-radius: 50");
			lb.setTextFill(Color.BLACK);
			Label lb23 = new Label("Emplyees_List");
			lb23.setLayoutX(300);
			lb23.setLayoutY(40);
			lb23.setFont(Font.font("Times New Roman", 30));
			lb23.setStyle("-fx-background-radius: 50");
			lb23.setTextFill(Color.DARKBLUE);

			Image image1 = new Image("12.jpg");

			Image image = new Image("211.jpg");

			primaryStage.getIcons().add(image);
			ImageView imageView2 = new ImageView(image1);
			imageView2.setFitHeight(842);
			imageView2.setFitWidth(1540);
			TextField text = new TextField();
			text.setPromptText("Employee Name:");
			text.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text.setFont(Font.font("Times New Roman", 13));
			text.setAlignment(Pos.CENTER);

			TextField text2 = new TextField();
			text2.setPromptText("Phone Number:");
			text2.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text2.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text2.setFont(Font.font("Times New Roman", 13));
			text2.setAlignment(Pos.CENTER);
			TextField text3 = new TextField();
			text3.setPromptText("The Date BY (yy-mm-dd):");
			text3.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text3.setFont(Font.font("Times New Roman", 13));
			text3.setAlignment(Pos.CENTER);
			TextField text4 = new TextField();
			text4.setPromptText("The Salary:");
			text4.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text4.setFont(Font.font("Times New Roman", 13));
			text4.setAlignment(Pos.CENTER);
			TextField text20 = new TextField();
			text20.setPromptText("The Name Building:");
			text20.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text20.setFont(Font.font("Times New Roman", 13));
			text20.setAlignment(Pos.CENTER);

			ChoiceBox<String> text1 = new ChoiceBox<>();
			text1.setValue("              Select a Gender    ");
			text1.setPrefWidth(200);
			String[] genderText = { "                       Male          ", "                       Female        " };

			text1.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text1.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text1.getItems().addAll(genderText);
			ChoiceBox<String> text5 = new ChoiceBox<>();
			text5.setValue("              Select a Role    ");
			text5.setPrefWidth(200);
			String[] genderText5 = { "                       Doctor          ",
					"                     Secretary        " };

			text5.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text5.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text5.getItems().addAll(genderText5);
			TextField text22 = new TextField();
			text22.setPromptText("The City:");
			text22.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text22.setFont(Font.font("Times New Roman", 13));
			text22.setAlignment(Pos.CENTER);

			VBox box = new VBox(20);
			box.setLayoutX(200);
			box.setLayoutY(420);
			box.getChildren().addAll(text, text1, text2, text3, text4, text5, text20, text22);

			ImageView imageView = new ImageView(
					"21.png");
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);

			Button add = new Button("Add", imageView);
			add.setStyle("-fx-border-radius: 50");
			add.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			add.setFont(Font.font("Georgia", 20));
			add.setLayoutX(150);
			add.setLayoutY(773);
			add.setTextFill(Color.DARKBLUE);
			Label lb50 = new Label("**Error!! some feild are empty**");
			Label lb51 = new Label("**Error!! some feild are empty**");
			Label lb52 = new Label("**Error!! The Employee ID not found**");
			lb50.setVisible(false);
			lb51.setVisible(false);
			lb52.setVisible(false);

			add.setOnAction(e -> {
				System.out.print(text1.getValue().trim().equals("Select a Gender"));
				if (text.getText().isEmpty() || text1.getValue().trim().equals("Select a Gender")
						|| text2.getText().isEmpty() || text3.getText().isEmpty() || text4.getText().isEmpty()
						|| text5.getValue().trim().equals("Select a Role") || text20.getText().isEmpty()
						|| text22.getText().isEmpty()) {

					lb50.setVisible(true);

					lb50.setLayoutX(40);
					lb50.setLayoutY(330);
					lb50.setFont(Font.font("Georgia", 25));
					lb50.setStyle("-fx-background-radius: 50");
					lb50.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);
					Employees rc;
//					public Employees(int employees_ID, String name_employee, String gender, String phoneNum, String dateOfBirth,
//							double salary, String role, String name_bulding, String city) {
					rc = new Employees(text.getText(), text1.getValue().trim(), text2.getText(), text3.getText(),
							Double.parseDouble(text4.getText()), text5.getValue().trim(), text20.getText(),
							text22.getText());
					emps.add(rc);
					insertDataEmployee(rc);
					text1.setValue("Select a Gender");
					text.clear();
					text2.clear();
					text3.clear();
					text4.clear();
					text5.setValue("Select a Role");
					text20.clear();
					text22.clear();
					emps.clear();
					try {
						getDataEmployee();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}

			});

			employees.refresh();

			Label lb1 = new Label("Employee Name:");
			lb1.setLayoutX(670);
			lb1.setLayoutY(50);
			lb1.setFont(Font.font("Georgia", 20));
			lb1.setStyle("-fx-background-radius: 50");
			lb1.setTextFill(Color.BLACK);
			Label lb2 = new Label("Gender:");
			lb2.setLayoutX(670);
			lb2.setLayoutY(50);
			lb2.setFont(Font.font("Georgia", 20));
			lb2.setStyle("-fx-background-radius: 50");
			lb2.setTextFill(Color.BLACK);
			Label lb3 = new Label("Phone Number:");
			lb3.setLayoutX(670);
			lb3.setLayoutY(50);
			lb3.setFont(Font.font("Georgia", 20));
			lb3.setStyle("-fx-background-radius: 50");
			lb3.setTextFill(Color.BLACK);
			Label lb4 = new Label("Date Of Birth:");
			lb4.setLayoutX(670);
			lb4.setLayoutY(50);
			lb4.setFont(Font.font("Georgia", 20));
			lb4.setStyle("-fx-background-radius: 50");
			lb4.setTextFill(Color.BLACK);
			Label lb5 = new Label("Salary:");
			lb5.setLayoutX(670);
			lb5.setLayoutY(50);
			lb5.setFont(Font.font("Georgia", 20));
			lb5.setStyle("-fx-background-radius: 50");
			lb5.setTextFill(Color.BLACK);
			Label lb6 = new Label("Role:");
			lb6.setLayoutX(670);
			lb6.setLayoutY(50);
			lb6.setFont(Font.font("Georgia", 20));
			lb6.setStyle("-fx-background-radius: 50");
			lb6.setTextFill(Color.BLACK);
			Label lb20 = new Label("Name_Building:");
			lb20.setLayoutX(670);
			lb20.setLayoutY(50);
			lb20.setFont(Font.font("Georgia", 20));
			lb20.setStyle("-fx-background-radius: 50");
			lb20.setTextFill(Color.BLACK);
			Label lb21 = new Label("City:");
			lb21.setLayoutX(670);
			lb21.setLayoutY(50);
			lb21.setFont(Font.font("Georgia", 20));
			lb21.setStyle("-fx-background-radius: 50");
			lb21.setTextFill(Color.BLACK);
			VBox box1 = new VBox(22);
			box1.setLayoutX(45);
			box1.setLayoutY(420);
			box1.getChildren().addAll(lb1, lb2, lb3, lb4, lb5, lb6, lb20, lb21);
			Button rectangle = new Button();
			rectangle.setLayoutX(30);
			rectangle.setLayoutY(395);
			rectangle.setLayoutY(360);
			rectangle.setPrefWidth(380);
			rectangle.setPrefHeight(475);
			rectangle.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			Button rectangle1 = new Button();
			rectangle1.setLayoutX(490);
			rectangle1.setLayoutY(360);
			rectangle1.setPrefWidth(380);
			rectangle1.setPrefHeight(475);
			rectangle1.setStyle("-fx-border-radius: 50;-fx-border-color: black");
			rectangle1.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));

			ImageView imageView9 = new ImageView(
					"220.png");
			imageView9.setFitHeight(40);
			imageView9.setFitWidth(40);

			Button find = new Button("Find", imageView9);
			find.setStyle("-fx-border-radius: 50");
			find.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			find.setFont(Font.font("Georgia", 20));
			find.setLayoutX(520);
			find.setLayoutY(773);
			find.setTextFill(Color.DARKBLUE);
			ImageView imageView10 = new ImageView(
					"100.png");
			imageView10.setFitHeight(40);
			imageView10.setFitWidth(40);

			Button delete = new Button("Delete", imageView10);
			delete.setStyle("-fx-border-radius: 50");
			delete.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			delete.setFont(Font.font("Georgia", 20));
			delete.setLayoutX(615);
			delete.setLayoutY(773);
			delete.setTextFill(Color.DARKBLUE);
			ImageView imageView11 = new ImageView(
					"76.png");
			imageView11.setFitHeight(40);
			imageView11.setFitWidth(40);

			Button update = new Button("Update", imageView11);
			update.setStyle("-fx-border-radius: 50");
			update.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			update.setFont(Font.font("Georgia", 20));
			update.setLayoutX(725);
			update.setLayoutY(773);
			update.setTextFill(Color.DARKBLUE);
			ImageView imageView3 = new ImageView(
					"0.png");
			imageView3.setFitHeight(50);
			imageView3.setFitWidth(50);
			Button back = new Button("Back", imageView3);
			imageView2.setRotate(360);

			back.setFont(Font.font("Georgia", 40));
			back.setLayoutX(10);
			back.setLayoutY(5);
			back.setTextFill(Color.DARKBLUE);
			back.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			back.setOnAction(e -> {

				start(primaryStage);

			});

			TextField text6 = new TextField();
			text6.setPromptText("Employee Name:");
			text6.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text6.setFont(Font.font("Times New Roman", 13));
			text6.setAlignment(Pos.CENTER);

			TextField text7 = new TextField();
			text7.setPromptText("Phone Number:");
			text7.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text2.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text7.setFont(Font.font("Times New Roman", 13));
			text7.setAlignment(Pos.CENTER);
			TextField text8 = new TextField();
			text8.setPromptText("The Date BY (yy-mm-dd):");
			text8.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70");
//		text3.setBackground(
//				new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text8.setFont(Font.font("Times New Roman", 13));
			text8.setAlignment(Pos.CENTER);
			TextField text9 = new TextField();
			text9.setPromptText("The Salary:");
			text9.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text9.setFont(Font.font("Times New Roman", 13));
			text9.setAlignment(Pos.CENTER);

			ChoiceBox<String> text10 = new ChoiceBox<>();
			text10.setValue("              Select a Gender    ");
			text10.setPrefWidth(200);
			String[] genderText10 = { "                       Male          ",
					"                       Female        " };

			text10.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text10.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text10.getItems().addAll(genderText10);
			ChoiceBox<String> text11 = new ChoiceBox<>();
			text11.setValue("              Select a Role    ");
			text11.setPrefWidth(200);
			String[] genderText11 = { "                       Doctor          ",
					"                     Secretary        " };

			text11.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text11.setBackground(new Background(
					new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text11.getItems().addAll(genderText11);

			TextField text12 = new TextField();
			text12.setPromptText("Employee_ID:");
			text12.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			TextField text13 = new TextField();
			text13.setPromptText("Name building:");
			text13.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text13.setFont(Font.font("Times New Roman", 13));
			text13.setAlignment(Pos.CENTER);
			TextField text14 = new TextField();
			text14.setPromptText("City:");
			text14.setStyle("-fx-border-radius: 70;-fx-border-color: black;-fx-background-radius: 70;");
			text14.setFont(Font.font("Times New Roman", 13));
			text14.setAlignment(Pos.CENTER);
//		text4.setBackground(
//			new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.0f), CornerRadii.EMPTY, Insets.EMPTY)));
			text12.setFont(Font.font("Times New Roman", 13));
			text12.setAlignment(Pos.CENTER);
			VBox box3 = new VBox(14);
			box3.setLayoutX(660);
			box3.setLayoutY(420);
			text6.setDisable(true);

			text10.setDisable(true);
			text7.setDisable(true);
			text8.setDisable(true);
			text9.setDisable(true);
			text11.setDisable(true);
			text13.setDisable(true);

			text14.setDisable(true);

			box3.getChildren().addAll(text12, text6, text10, text7, text8, text9, text11, text13, text14);
			find.setOnAction(e -> {
				if (text12.getText().isEmpty()) {

					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setText("**Error!! some feild are empty**");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);
					text6.setDisable(true);

					text10.setDisable(true);
					text7.setDisable(true);
					text8.setDisable(true);
					text9.setDisable(true);
					text11.setDisable(true);
					text13.setDisable(true);

					text14.setDisable(true);

				} else {

					text6.setDisable(true);

					lb50.setVisible(true);
					text10.setDisable(false);
					text7.setDisable(false);
					text8.setDisable(false);
					text9.setDisable(false);
					text11.setDisable(false);
					text13.setDisable(false);

					text14.setDisable(false);
					boolean check = false;
					int f = 0;
					for (int i = 0; i < emps.size(); i++) {
						if (emps.get(i).getEmployees_ID() == Integer.parseInt(text12.getText())) {
							f = i;
							check = true;
							break;
						}

						check = false;
					}

					System.out.print(check);
					if (check == false) {
						lb52.setVisible(true);
						lb51.setVisible(false);
						lb50.setVisible(false);

						lb52.setLayoutX(450);
						lb52.setLayoutY(330);
						lb52.setFont(Font.font("Georgia", 25));
						lb52.setStyle("-fx-background-radius: 50");
						lb52.setTextFill(Color.DARKRED);
						text6.setDisable(true);

						text10.setDisable(true);
						text7.setDisable(true);
						text8.setDisable(true);
						text9.setDisable(true);
						text11.setDisable(true);
						text13.setDisable(true);

						text14.setDisable(true);
						text6.clear();

						text10.setValue("              Select a Gender    ");
						text7.clear();
						text8.clear();
						text9.clear();
						text11.setValue("              Select a Role    ");
						text13.clear();

						text14.clear();

					} else {

						lb52.setVisible(false);
						lb51.setVisible(false);
						lb50.setVisible(false);

						text6.setDisable(false);

						text10.setDisable(false);
						text7.setDisable(false);
						text8.setDisable(false);
						text9.setDisable(false);
						text11.setDisable(false);
						text13.setDisable(false);
						text14.setDisable(false);
						text6.setText(emps.get(f).getName_employee());
						text10.setValue("                       " + emps.get(f).getGender() + "      ");
						text7.setText(emps.get(f).getPhoneNum());
						text8.setText(emps.get(f).getDateOfBirth());
						text9.setText(String.valueOf(emps.get(f).getSalary()));
						text11.setValue("                       " + emps.get(f).getRole() + "       ");
						text13.setText(emps.get(f).getName_bulding());
						text14.setText(emps.get(f).getCity());

					}
				}

			});

			delete.setOnAction(e -> {

				deleteRowEmployee(text12.getText().trim());
				emps.clear();
				try {
					getDataEmployee();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

				text12.clear();
				text6.clear();

				text10.setValue("              Select a Gender    ");
				text7.clear();
				text8.clear();
				text9.clear();
				text11.setValue("              Select a Role    ");
				text13.clear();

				text14.clear();
				text6.setDisable(true);

				text10.setDisable(true);
				text7.setDisable(true);
				text8.setDisable(true);
				text9.setDisable(true);
				text11.setDisable(true);
				text13.setDisable(true);

				text14.setDisable(true);
			});

			update.setOnAction(e -> {
				if (text12.getText().isEmpty() || text6.getText().isEmpty()
						|| text10.getValue().equals("              Select a Gender    ") || text7.getText().isEmpty()
						|| text8.getText().isEmpty() || text9.getText().isEmpty()
						|| text11.getValue().equals("              Select a Role    ") || text13.getText().isEmpty()
						|| text14.getText().isEmpty()) {

					lb50.setVisible(false);
					lb51.setText("**Error!! some feild are empty**");
					lb51.setVisible(true);
					lb52.setVisible(false);
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 25));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.DARKRED);

				} else {
					lb50.setVisible(false);

					lb51.setVisible(true);
					lb52.setVisible(false);
					updateEmpName(text12.getText(), text6.getText());
					updateEmpGender(text12.getText(), text10.getValue().trim());
					updateEmployPhoneNum(text12.getText(), text7.getText());
					updatedateOfBirth(text12.getText(), text8.getText());
					updateEmploysalary(text12.getText(), text9.getText());
					updateEmployrole(text12.getText(), text11.getValue().trim());
					updateEmployname_bulding(text12.getText(), text13.getText());
					updateEmploycity(text12.getText(), text14.getText());
					emps.clear();
					lb51.setText("<<Was Update to Employee name: " + text6.getText() + ">>");
					lb51.setLayoutX(500);
					lb51.setLayoutY(330);
					lb51.setFont(Font.font("Georgia", 20));
					lb51.setStyle("-fx-background-radius: 50");
					lb51.setTextFill(Color.BLACK);
					try {
						getDataEmployee();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					text12.clear();
					text6.clear();

					text10.setValue("              Select a Gender    ");
					text7.clear();
					text8.clear();
					text9.clear();
					text11.setValue("              Select a Role    ");
					text13.clear();

					text14.clear();
					text6.setDisable(true);

					text10.setDisable(true);
					text7.setDisable(true);
					text8.setDisable(true);
					text9.setDisable(true);
					text11.setDisable(true);
					text13.setDisable(true);

					text14.setDisable(true);
				}

//				updateLevel(t.getRowValue().getSnum(), t.getNewValue());

			});
			Label lb16 = new Label("Employee ID:");
			lb16.setLayoutX(670);
			lb16.setLayoutY(50);
			lb16.setFont(Font.font("Georgia", 20));
			lb16.setStyle("-fx-background-radius: 50");
			lb16.setTextFill(Color.BLACK);

			Label lb7 = new Label("Employee Name:");
			lb7.setLayoutX(670);
			lb7.setLayoutY(50);
			lb7.setFont(Font.font("Georgia", 20));
			lb7.setStyle("-fx-background-radius: 50");
			lb7.setTextFill(Color.BLACK);
			Label lb8 = new Label("Gender:");
			lb8.setLayoutX(670);
			lb8.setLayoutY(50);
			lb8.setFont(Font.font("Georgia", 20));
			lb8.setStyle("-fx-background-radius: 50");
			lb8.setTextFill(Color.BLACK);
			Label lb9 = new Label("Phone Number:");
			lb9.setLayoutX(670);
			lb9.setLayoutY(50);
			lb9.setFont(Font.font("Georgia", 20));
			lb9.setStyle("-fx-background-radius: 50");
			lb9.setTextFill(Color.BLACK);
			Label lb10 = new Label("Date Of Birth:");
			lb10.setLayoutX(670);
			lb10.setLayoutY(50);
			lb10.setFont(Font.font("Georgia", 20));
			lb10.setStyle("-fx-background-radius: 50");
			lb10.setTextFill(Color.BLACK);
			Label lb11 = new Label("Salary:");
			lb11.setLayoutX(670);
			lb11.setLayoutY(50);
			lb11.setFont(Font.font("Georgia", 20));
			lb11.setStyle("-fx-background-radius: 50");
			lb11.setTextFill(Color.BLACK);
			Label lb12 = new Label("Role:");
			lb12.setLayoutX(670);
			lb12.setLayoutY(50);
			lb12.setFont(Font.font("Georgia", 20));
			lb12.setStyle("-fx-background-radius: 50");
			lb12.setTextFill(Color.BLACK);

			Label lb13 = new Label("Addition");
			lb13.setLayoutX(160);
			lb13.setLayoutY(362);
			lb13.setFont(Font.font("Georgia", 30));
			lb13.setStyle("-fx-background-radius: 50");
			lb13.setTextFill(Color.DARKBLUE);
			Label lb14 = new Label("Delete Or Update");
			lb14.setLayoutX(580);
			lb14.setLayoutY(362);
			lb14.setFont(Font.font("Georgia", 30));
			lb14.setStyle("-fx-background-radius: 50");
			lb14.setTextFill(Color.DARKBLUE);

			VBox box2 = new VBox(17);
			box2.setLayoutX(505);
			box2.setLayoutY(420);
			Label lb22 = new Label("Name_Building:");
			lb22.setLayoutX(670);
			lb22.setLayoutY(50);
			lb22.setFont(Font.font("Georgia", 20));
			lb22.setStyle("-fx-background-radius: 50");
			Label lb211 = new Label("City:");
			lb211.setLayoutX(670);
			lb211.setLayoutY(50);
			lb211.setFont(Font.font("Georgia", 20));
			lb211.setStyle("-fx-background-radius: 50");
			box2.getChildren().addAll(lb16, lb7, lb8, lb9, lb10, lb11, lb12, lb22, lb211);
			Group group = new Group();
			group.getChildren().addAll(imageView2, rectangle, rectangle1, lb, box, box1, add, box3, box2, lb13, lb14,
					find, delete, update, lb23, vbox, back, lb50, lb51, lb52);
			Scene scene = new Scene(group);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
////			System.out.println("error!!!");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void getDataEmployee() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "Select * from Employees";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			emps.add(new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9)));
		}
		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed with" + emps.size() + " Lines");

	}

	private void getDataPatient() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "Select * from Pateint";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			pat.add(new Pateint(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),

					rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		System.out.println(pat);
		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed with" + pat.size() + " Lines");

	}

	private void getDataDiagnosis() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "Select * from diagnosis";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
//		Diagnosis(int diagnosis_ID, int pateint_ID, String pateint_name, String diagnosis_description,String treatment_discription, int doctor_ID,String dateOfBirth)
			diagnosis.add(new Diagnosis(rs.getInt(1), rs.getInt(2), rs.getString(4), rs.getString(3), rs.getString(5),
					rs.getInt(7),

					rs.getString(6)));
		}
		System.out.println(diagnosis);
		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed with" + diagnosis.size() + " Lines");

	}

	private void insertDataDiagnosis(Diagnosis rc) {

		try {
			System.out.println(
					"insert into diagnosis (pateintpateint,treatment_discription,diagnosis_description,dateOfDiagnosis,doctor_ID)values("
							+ rc.getPateint_ID() + ",'" + rc.getTreatment_discription() + "','"
							+ rc.getDiagnosis_description() + "','" + rc.getDateOfBirth() + "'," + rc.getDoctor_ID()
							+ ")");

			connectDB();
			ExecuteStatement(
					"insert into diagnosis (pateintpateint,pateint_Name,treatment_discription,diagnosis_description,dateOfDiagnosis,doctor_ID)values("
							+ rc.getPateint_ID() + ",'" + rc.getPateint_name() + "','" + rc.getTreatment_discription()
							+ "','" + rc.getDiagnosis_description() + "','" + rc.getDateOfBirth() + "',"
							+ rc.getDoctor_ID() + ")");
			con.close();
			System.out.println("Connection closed with" + diagnosis.size() + " Lines");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataEmployee(Employees rc) {

		try {
			System.out.println(
					"insert into employees(name_employee,gender,phoneNum,dateOfBirth,salary,role,name_bulding,city)('"
							+ rc.getName_employee() + "','" + rc.getGender() + "','" + rc.getPhoneNum() + "','"
							+ rc.getDateOfBirth() + "'," + rc.getSalary() + ",'" + rc.getRole() + "','"
							+ rc.getName_bulding() + "','" + rc.getCity() + "')");

			connectDB();
			ExecuteStatement(
					"insert into employees(name_employee,gender,phoneNum,dateOfBirth,salary,role,name_bulding,city) values('"
							+ rc.getName_employee() + "','" + rc.getGender() + "','" + rc.getPhoneNum() + "','"
							+ rc.getDateOfBirth() + "'," + rc.getSalary() + ",'" + rc.getRole() + "','"
							+ rc.getName_bulding() + "','" + rc.getCity() + "')");
			con.close();
			System.out.println("Connection closed with" + emps.size() + " Lines");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataPatient(Pateint rc) {

		try {

			System.out.println(
					"insert into Pateint(pateint_Name,gender,phoneNum,dateOfBirth,insurance,name_bulding,city)('"
							+ rc.getPateint_Name() + "','" + rc.getGender() + "','" + rc.getPhoneNum() + "','"
							+ rc.getDateOfBirth() + "','" + rc.getInsurance() + "','" + rc.getName_building() + "','"
							+ rc.getCity() + "')");

			connectDB();
			ExecuteStatement(
					"insert into Pateint(pateint_Name,gender,phoneNum,dateOfBirth,insurance,name_bulding,city)values('"
							+ rc.getPateint_Name() + "','" + rc.getGender() + "','" + rc.getPhoneNum() + "','"
							+ rc.getDateOfBirth() + "','" + rc.getInsurance() + "','" + rc.getName_building() + "','"
							+ rc.getCity() + "');");
			con.close();
			System.out.println("Connection closed with " + pat.size() + " Lines");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getDataPayment() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "Select * from payment";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
//			public Payment(int payment_ID, int pateint_id, int secretaries_ID, int doctor_ID, String datePayment, double cost)
			payments.add(new Payment(rs.getInt(1), rs.getInt(5), rs.getInt(4), rs.getInt(3), rs.getString(2),
					rs.getDouble(6)));
		}
		System.out.println(diagnosis);
		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed with" + diagnosis.size() + " Lines");

	}

	private void getDataAppointment() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from  appointments";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			appointments.add(new Appointments(rs.getInt(1), rs.getInt(5), rs.getInt(4), rs.getInt(3), rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(2), rs.getString(6)));

		}
		System.out.println(appointments);
		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed with" + appointments.size() + " Lines");

	}

	private void insertDataappointments(Appointments rc) {

		try {

			System.out.println(
					"insert into appointments(pateint_id,doctor_ID,secretaries_ID,dateApponitments,time)values("
							+ rc.getPateint_ID() + "," + rc.getDoctor_ID() + "," + rc.getSecretaries_ID() + ",'"
							+ rc.getDateApponitments() + "'," + rc.getTime() + ");");

			connectDB();
			ExecuteStatement(
					"insert into appointments(pateint_id,doctor_ID,secretaries_ID,patient_Name,doctor_Name,secretaries_Name,dateApponitments,time)values("
							+ rc.getPateint_ID() + "," + rc.getDoctor_ID() + "," + rc.getSecretaries_ID() + ",'"
							+ rc.getPatient_Name() + "','" + rc.getDoctor_Name() + "','" + rc.getSecretaries_Name()
							+ "','" + rc.getDateApponitments() + "','" + rc.getTime() + "');");
			con.close();
			System.out.println("Connection closed with " + appointments.size() + " Lines");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataPayment(Payment rc) {

		try {

			System.out.println("insert into payment(pateint_id,secretaries_ID,doctor_ID,datePayment,cost)values("
					+ rc.getPateint_id() + "," + rc.getSecretaries_ID() + "," + rc.getDoctor_ID() + ",'"
					+ rc.getDatePayment() + "'," + rc.getCost() + ");");

			connectDB();
			ExecuteStatement("insert into payment(pateint_id,secretaries_ID,doctor_ID,datePayment,cost)values("
					+ rc.getPateint_id() + "," + rc.getSecretaries_ID() + "," + rc.getDoctor_ID() + ",'"
					+ rc.getDatePayment() + "'," + rc.getCost() + ");");
			con.close();
			System.out.println("Connection closed with " + pat.size() + " Lines");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	public void ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	private void deleteRowEmployee(String id) {

		try {
			System.out.println("delete from  employees where employees_ID=" + id + ";");
			connectDB();
			ExecuteStatement("delete from  employees where employees_ID=" + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteRowPateint(String id) {

		try {
			System.out.println("delete from  pateint where pateint=" + id + ";");
			connectDB();
			ExecuteStatement("delete from  pateint where pateint=" + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteRowDiagonisis(String id) {

		try {
			System.out.println("delete from  diagnosis where diagnosis_ID=" + id + ";");
			connectDB();
			ExecuteStatement("delete from  diagnosis where diagnosis_ID=" + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteRowAppointment(String id) {

		try {
			System.out.println("delete from  appointments where appointments_ID=" + id + ";");
			connectDB();
			ExecuteStatement("delete from  appointments where appointments_ID=" + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmpName(String id, String name_employe) {

		try {
			System.out
					.println("update  employees set name_employee = '" + name_employe + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement(
					"update  employees set name_employee = '" + name_employe + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmpGender(String id, String gender) {

		try {
			System.out.println("update  employees set gender = '" + gender + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement("update  employees set gender = '" + gender + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployPhoneNum(String id, String gender) {

		try {
			System.out.println("update  employees set phoneNum = '" + gender + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement("update  employees set phoneNum = '" + gender + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatedateOfBirth(String id, String dateOfBirth) {

		try {
			System.out.println("update  employees set dateOfBirth = '" + dateOfBirth + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement(
					"update  employees set dateOfBirth = '" + dateOfBirth + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmploysalary(String id, String salary) {

		try {
			System.out.println("update  employees set salary = '" + salary + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement("update  employees set salary = '" + salary + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployrole(String id, String role) {

		try {
			System.out.println("update  employees set role = '" + role + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement("update  employees set role = '" + role + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployname_bulding(String id, String name_bulding) {

		try {
			System.out
					.println("update  employees set name_bulding = '" + name_bulding + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement(
					"update  employees set name_bulding = '" + name_bulding + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmploycity(String id, String city) {

		try {
			System.out.println("update  employees set city = '" + city + "' where employees_ID = " + id);
			connectDB();
			ExecuteStatement("update  employees set city = '" + city + "' where employees_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePatcity(String id, String city) {
		try {
			System.out.println("update  pateint set pateint = '" + city + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set pateint = '" + city + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePatname_bulding(String id, String name_bulding) {
		try {
			System.out.println("update  pateint set name_bulding = '" + name_bulding + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set name_bulding = '" + name_bulding + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePatinsurance(String id, String insurance) {
		try {
			System.out.println("update  pateint set insurance = '" + insurance + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set insurance = '" + insurance + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePatdateOfBirth(String id, String dateOfBirth) {
		try {
			System.out.println("update  pateint set dateOfBirth = '" + dateOfBirth + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set dateOfBirth = '" + dateOfBirth + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePatphoneNum(String id, String phoneNum) {
		try {
			System.out.println("update  pateint set phoneNum = '" + phoneNum + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set phoneNum = '" + phoneNum + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePatgender(String id, String gender) {
		try {
			System.out.println("update  pateint set gender = '" + gender + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set gender = '" + gender + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatepateint_Name(String id, String pateint_Name) {
		try {
			System.out.println("update  pateint set pateint_Name = '" + pateint_Name + "' where pateint = " + id);
			connectDB();
			ExecuteStatement("update  pateint set pateint_Name = '" + pateint_Name + "' where pateint = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateDiaDate(String id, String dateOfDiagnosis) {
		try {
			System.out.println(
					"update  diagnosis set dateOfDiagnosis = '" + dateOfDiagnosis + "' where diagnosis_ID = " + id);
			connectDB();
			ExecuteStatement("update  diagnosis set dateOfDiagnosis = '" + dateOfDiagnosis + "' where diagnosis_ID = "
					+ id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateDiaTreatment(String id, String treatment) {
		try {
			System.out.println(
					"update  diagnosis set treatment_discription = '" + treatment + "' where diagnosis_ID = " + id);
			connectDB();
			ExecuteStatement("update  diagnosis set treatment_discription = '" + treatment + "' where diagnosis_ID = "
					+ id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateDiaDiagonis(String id, String diagnosis_description) {
		try {
			System.out.println("update  diagnosis set diagnosis_description = '" + diagnosis_description
					+ "' where diagnosis_ID = " + id);
			connectDB();
			ExecuteStatement("update  diagnosis set diagnosis_description = '" + diagnosis_description
					+ "' where diagnosis_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateDiaDoctor_Id(String id, String doctor_ID) {
		try {
			System.out.println("update  diagnosis set doctor_ID = '" + doctor_ID + "' where diagnosis_ID = " + id);
			connectDB();
			ExecuteStatement("update  diagnosis set doctor_ID = '" + doctor_ID + "' where diagnosis_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateDiaPateint_Id(String id, String pateintpateint) {
		try {
			System.out.println("update  diagnosis set doctor_ID = '" + pateintpateint + "' where diagnosis_ID = " + id);
			connectDB();
			ExecuteStatement(
					"update  diagnosis set doctor_ID = '" + pateintpateint + "' where diagnosis_ID = " + id + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void PrintDoctors() {

		try {

			connectDB();
			String s = "select * from employees where role = 'Doctor';";
			Statement stat = con.createStatement();
			ResultSet rsDoctor = stat.executeQuery(s);

			while (rsDoctor.next()) {
//				(int employees_ID, String name_employee, String gender, String phoneNum, String dateOfBirth,
//						double salary, String name_bulding, String city)
				doctor.add(new Employees(rsDoctor.getInt(1), rsDoctor.getString(2), rsDoctor.getString(3),
						rsDoctor.getString(4), rsDoctor.getString(5), rsDoctor.getDouble(6), rsDoctor.getString(8),
						rsDoctor.getString(9)));
			}
			System.out.println(doctor);
			rsDoctor.close();
			stat.close();

			con.close();
			System.out.println("Connection closed with" + doctor.size() + " Lines");
		} catch (Exception E) {
			E.printStackTrace();
		}

	}

}
