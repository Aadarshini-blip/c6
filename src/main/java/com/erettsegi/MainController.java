package com.erettsegi;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class MainController implements Initializable {
    @FXML public TableView tv1;
    @FXML public GridPane gr1;
    @FXML public GridPane gr2;
    @FXML public GridPane gr3;
    @FXML public GridPane gr4;
    @FXML public GridPane gr5;
    @FXML public GridPane gr6;
    @FXML public GridPane gr7;
    @FXML public GridPane gr8;
    @FXML public GridPane gr9;
    @FXML public GridPane gr10;
    @FXML public GridPane gr11;
    @FXML public GridPane gr12;
    @FXML public GridPane gr13;
    @FXML public GridPane gr14;
    @FXML public GridPane gr15;
    @FXML public GridPane gr16;
    @FXML public TextField tf1;
    @FXML public TextField tf2;
    @FXML public TextField tf3;
    @FXML public TextField tf4;
    @FXML public TextField tf5;
    @FXML public TextField tf6;
    @FXML public TextField tf7;
    @FXML public TextField tf8;
    @FXML public TextField tf9;
    @FXML public TextField tf10;
    @FXML public TextField tf11;
    @FXML public TextField tf12;
    @FXML public TextField tf13;
    @FXML public TextField tf14;
    @FXML public TextField tf15;
    @FXML public TextField tf16;
    @FXML public TextField tf17;
    @FXML public TextField tf18;
    @FXML public TextField tf19;
    @FXML public TextField tf20;
    @FXML public TextField tf21;
    @FXML public TextField tf22;
    @FXML public TextField tf23;
    @FXML public TextArea ta1;
    @FXML public TextArea ta2;
    @FXML public TextArea ta3;
    @FXML public TextArea ta4;
    @FXML public TextArea ta5;
    @FXML public TextArea ta6;
    @FXML public TextArea ta7;
    @FXML public TextArea ta8;
    @FXML public TextArea ta9;
    @FXML public TextArea ta10;
    @FXML public ComboBox cb1;
    @FXML public ComboBox cb2;
    @FXML public ComboBox cb3;
    @FXML public ComboBox cb4;
    @FXML public ComboBox cb5;
    @FXML public CheckBox ch1;
    @FXML public CheckBox ch2;
    @FXML public CheckBox ch3;
    @FXML public CheckBox ch4;
    @FXML public RadioButton rb1;
    @FXML public RadioButton rb2;
    @FXML public RadioButton rb3;
    @FXML public RadioButton rb4;
    @FXML public ToggleGroup group;
    @FXML public Button btnSzuro;
    @FXML public Label errorForSzures;
    @FXML public Label errorForVizsgazoHozzaadas;
    @FXML public Label msgForVizsgazoHozzaadas;
    @FXML public Label errorForVizsgazoModositas;
    @FXML public Label msgForVizsgazoModositas;
    @FXML public Label msgForVizsgaTorles;
    @FXML public Label errorForVizsgaTorles;
    @FXML public Label errorForVizsgaTorles2;
    @FXML public Label d??nt??siFaMsg;
    @FXML public TableColumn<Vizsgaadatok, Integer> vizsgazoAzonCol;
    @FXML public TableColumn<Vizsgaadatok, String> nevCol;
    @FXML public TableColumn<Vizsgaadatok, String> osztalyCol;
    @FXML public TableColumn<Vizsgaadatok, Integer> vizsgatargyAzonCol;
    @FXML public TableColumn<Vizsgaadatok, String> vizsgatargyNevCol;
    @FXML public TableColumn<Vizsgaadatok, Integer> vizsgatargySzoMaxCol;
    @FXML public TableColumn<Vizsgaadatok, Integer> vizsgatargyIrMaxCol;
    @FXML public TableColumn<Vizsgaadatok, Integer> vizsgaSzobeliCol;
    @FXML public TableColumn<Vizsgaadatok, Integer> vizsgaIrasbeliCol;
    SessionFactory factory;
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    final String token = "cf80eff8acb5840b59b220e16e409ea4589bae9a86bc4a4cf4c806f8edfe23b8";
    HttpsURLConnection httpsURLConnection;
    protected void ElemekT??rl??se() {
        gr1.setVisible(false);
        gr1.setManaged(false);
        gr2.setVisible(false);
        gr2.setManaged(false);
        gr3.setVisible(false);
        gr3.setManaged(false);
        gr4.setVisible(false);
        gr4.setManaged(false);
        gr5.setVisible(false);
        gr5.setManaged(false);
        gr6.setVisible(false);
        gr6.setManaged(false);
        gr7.setVisible(false);
        gr7.setManaged(false);
        gr8.setVisible(false);
        gr8.setManaged(false);
        gr9.setVisible(false);
        gr9.setManaged(false);
        gr10.setVisible(false);
        gr10.setManaged(false);
        gr11.setVisible(false);
        gr11.setManaged(false);
        gr12.setVisible(false);
        gr12.setManaged(false);
        gr13.setVisible(false);
        gr13.setManaged(false);
        gr14.setVisible(false);
        gr14.setManaged(false);
        gr15.setVisible(false);
        gr15.setManaged(false);
        gr16.setVisible(false);
        gr16.setManaged(false);
        tv1.setVisible(false);
        tv1.setManaged(false);
        errorForSzures.setVisible(false);
        errorForSzures.setManaged(false);
        errorForVizsgazoHozzaadas.setVisible(false);
        errorForVizsgazoHozzaadas.setManaged(false);
        msgForVizsgazoHozzaadas.setVisible(false);
        msgForVizsgazoHozzaadas.setManaged(false);
        errorForVizsgazoModositas.setVisible(false);
        errorForVizsgazoModositas.setManaged(false);
        msgForVizsgazoModositas.setVisible(false);
        msgForVizsgazoModositas.setManaged(false);
        msgForVizsgaTorles.setVisible(false);
        msgForVizsgaTorles.setManaged(false);
        errorForVizsgaTorles.setVisible(false);
        errorForVizsgaTorles.setManaged(false);
        errorForVizsgaTorles2.setVisible(false);
        errorForVizsgaTorles2.setManaged(false);
    }
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ElemekT??rl??se();
        cb1.getItems().addAll("Magyar nyelv ??s irodalom", "T??rt??nelem", "Matematika", "Informatika", "Fizika", "K??mia", "Angol", "N??met", "F??ldrajz", "Biol??gia");
        cb1.getSelectionModel().select("Magyar nyelv ??s irodalom");
        cb5.getItems().addAll("D??nt??si fa", "Support-vector machine", "NaiveBayes", "K-legk??zelebbi szomsz??d", "RandomForest");
        cb5.getSelectionModel().select("D??nt??si fa");
        try {
            initConfig();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void initConfig() throws SQLException {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
        final String URL = "jdbc:mysql://localhost/erettsegi?user=root&characterEncoding=utf8";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(URL);
        statement = connection.createStatement();
    }
    protected void clearControlUIData(TextField... tfList) {
        for(TextField tf : tfList) tf.setText("");
    }
    protected void setTimerForLabel(Label label) {
        Timer tm = new Timer();
        tm.schedule(new TimerTask(){
            @Override
            public void run() {
                Platform.runLater(() -> {
                    label.setText("");
                });
            }
        },3000);
    }
    protected void initTable() {
        ElemekT??rl??se();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        tv1.getItems().removeAll(tv1.getItems());
        vizsgazoAzonCol = new TableColumn("Vizsg??z?? azonos??t??ja");
        nevCol = new TableColumn("Neve");
        osztalyCol = new TableColumn("Oszt??lya");
        vizsgatargyAzonCol = new TableColumn<>("Vizsgat??rgy azonos??t??ja");
        vizsgatargyNevCol = new TableColumn<>("Vizsgat??rgy neve");
        vizsgatargySzoMaxCol = new TableColumn<>("Sz??belin el??rhet?? max. pont");
        vizsgatargyIrMaxCol = new TableColumn<>("??r??sbelin el??rhet?? max. pont");
        vizsgaSzobeliCol = new TableColumn<>("Sz??belin szerzett pontsz??ma");
        vizsgaIrasbeliCol = new TableColumn<>("??r??sbelin szerzett pontsz??ma");
        tv1.getColumns().addAll(vizsgazoAzonCol, nevCol, osztalyCol, vizsgatargyAzonCol, vizsgatargyNevCol, vizsgatargySzoMaxCol, vizsgatargyIrMaxCol, vizsgaSzobeliCol, vizsgaIrasbeliCol);
        vizsgazoAzonCol.setCellValueFactory(new PropertyValueFactory<>("azon"));
        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        osztalyCol.setCellValueFactory(new PropertyValueFactory<>("osztaly"));
        vizsgatargyAzonCol.setCellValueFactory(new PropertyValueFactory<>("targyAzon"));
        vizsgatargyNevCol.setCellValueFactory(new PropertyValueFactory<>("targyNev"));
        vizsgatargySzoMaxCol.setCellValueFactory(new PropertyValueFactory<>("szomax"));
        vizsgatargyIrMaxCol.setCellValueFactory(new PropertyValueFactory<>("irmax"));
        vizsgaSzobeliCol.setCellValueFactory(new PropertyValueFactory<>("szobeli"));
        vizsgaIrasbeliCol.setCellValueFactory(new PropertyValueFactory<>("irasbeli"));
        vizsgazoAzonCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.1));
        nevCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.1));
        vizsgatargyAzonCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.12));
        vizsgatargyNevCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.1));
        vizsgatargySzoMaxCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.13));
        vizsgatargyIrMaxCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.13));
        vizsgaSzobeliCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.13));
        vizsgaIrasbeliCol.prefWidthProperty().bind(tv1.widthProperty().multiply(0.13));
    }
    @FXML
    protected void menuReadClick() throws SQLException {
        initTable();
        ResultSet vizsgaadatokSorai = statement.executeQuery("SELECT va.azon, va.nev, va.osztaly, vt.azon as targyAzon, vt.nev as targyNev, vt.szomax, vt.irmax, v.szobeli, v.irasbeli " +
                "FROM Vizsgazo as va LEFT JOIN Vizsga as v ON va.azon = v.vizsgazoaz LEFT JOIN Vizsgatargy as vt ON v.vizsgatargyaz = vt.azon");
        Vizsgaadatok vizsgaadatok;
        while(vizsgaadatokSorai.next()) {
            vizsgaadatok = new Vizsgaadatok(vizsgaadatokSorai.getInt("azon"), vizsgaadatokSorai.getString("nev"), vizsgaadatokSorai.getString("osztaly"),
                    vizsgaadatokSorai.getInt("targyAzon"), vizsgaadatokSorai.getString("targyNev"), vizsgaadatokSorai.getInt("szomax"),
                    vizsgaadatokSorai.getInt("irmax"), vizsgaadatokSorai.getInt("szobeli"), vizsgaadatokSorai.getInt("irasbeli"));
            tv1.getItems().add(vizsgaadatok);
        }
    }
    @FXML
    protected void menuRead2Click() {
        initTable();
        tv1.getItems().removeAll(tv1.getItems());
        gr1.setVisible(true);
        gr1.setManaged(true);
        rb1.setSelected(true);
        ch1.setSelected(false);
        ch2.setSelected(false);
        ch3.setSelected(false);
        ch4.setSelected(false);
        tf1.setText("");
    }
    @FXML
    protected void menuWriteClick() {
        ElemekT??rl??se();
        gr2.setVisible(true);
        gr2.setManaged(true);

    }
    @FXML
    protected void menuUpdateClick() throws SQLException {
        ElemekT??rl??se();
        gr3.setVisible(true);
        gr3.setManaged(true);
        cb2.getItems().removeAll(cb2.getItems());
        ResultSet vizsgazoAzonositok = statement.executeQuery("SELECT azon FROM vizsgazo");
        while(vizsgazoAzonositok.next()) {
            cb2.getItems().add(vizsgazoAzonositok.getInt("azon"));
        }
        cb2.getSelectionModel().select("1");
    }
    @FXML
    protected void menuDeleteClick() throws SQLException {
        ElemekT??rl??se();
        gr4.setVisible(true);
        gr4.setManaged(true);
        cb3.getItems().removeAll(cb3.getItems());
        cb4.getItems().removeAll(cb4.getItems());
        ResultSet vizsgazoAzonositok = statement.executeQuery("SELECT DISTINCT vizsgazoaz FROM vizsga");
        int va = 0;
        while(vizsgazoAzonositok.next()) {
            cb3.getItems().add(vizsgazoAzonositok.getInt("vizsgazoaz"));
            int firstNum = vizsgazoAzonositok.getInt("vizsgazoaz");
            if(va == 0) cb3.getSelectionModel().select(firstNum);
            va++;
        }
        ResultSet vizsgatargyAzonositok = statement.executeQuery("SELECT DISTINCT vizsgatargyaz FROM vizsga");
        int vt = 0;
        while(vizsgatargyAzonositok.next()) {
            cb4.getItems().add(vizsgatargyAzonositok.getInt("vizsgatargyaz"));
            int firstNum = vizsgatargyAzonositok.getInt("vizsgatargyaz");
            if(vt == 0) cb4.getSelectionModel().select(firstNum);
            vt++;
        }
    }
    @FXML
    protected void btnSzuro() throws SQLException {
        if((ch1.isSelected() && ch3.isSelected()) || (ch2.isSelected() && ch4.isSelected())) {
            errorForSzures.setVisible(true);
            errorForSzures.setManaged(true);
            tv1.setVisible(false);
            tv1.setManaged(false);
            errorForSzures.setText("Egym??snak ellentmond?? CheckBox -okat jel??lt be! K??rem korrig??lja!");
        } else {
            tv1.setVisible(true);
            tv1.setManaged(true);
            errorForSzures.setVisible(false);
            errorForSzures.setManaged(false);
            tv1.getItems().removeAll(tv1.getItems());
            String preparedQuery = "SELECT va.azon, va.nev, va.osztaly, vt.azon as targyAzon, vt.nev as targyNev, vt.szomax, vt.irmax, v.szobeli, v.irasbeli " +
                    "FROM Vizsgazo as va LEFT JOIN Vizsga as v ON va.azon = v.vizsgazoaz LEFT JOIN Vizsgatargy as vt ON v.vizsgatargyaz = vt.azon " +
                    "WHERE va.nev LIKE ? AND vt.nev = ? AND va.osztaly LIKE ? AND vt.szomax BETWEEN ? AND ? AND vt.irmax BETWEEN ? AND ?";
            preparedStatement = connection.prepareStatement(preparedQuery);
            if(tf1.getText().length() == 0) {
                preparedStatement.setString(1, "%");
            } else {
                preparedStatement.setString(1, tf1.getText());
            }
            preparedStatement.setString(2, cb1.getValue() + "");
            RadioButton rb = (RadioButton)group.getSelectedToggle();
            preparedStatement.setString(3, rb.getText() + "%");
            if (ch1.isSelected() == true) {
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 50);
            } else if(ch3.isSelected() == true) {
                preparedStatement.setInt(4, 51);
                preparedStatement.setInt(5, 60);
            } else {
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 60);
            }
            if (ch2.isSelected() == true) {
                preparedStatement.setInt(6, 0);
                preparedStatement.setInt(7, 90);
            } else if(ch4.isSelected() == true) {
                preparedStatement.setInt(6, 91);
                preparedStatement.setInt(7, 120);
            } else {
                preparedStatement.setInt(6, 0);
                preparedStatement.setInt(7, 120);
            }
            ResultSet vizsgaadatokSorai = preparedStatement.executeQuery();
            while(vizsgaadatokSorai.next()) {
                Vizsgaadatok vizsgaadatok = new Vizsgaadatok(vizsgaadatokSorai.getInt("azon"), vizsgaadatokSorai.getString("nev"), vizsgaadatokSorai.getString("osztaly"),
                        vizsgaadatokSorai.getInt("targyAzon"), vizsgaadatokSorai.getString("targyNev"), vizsgaadatokSorai.getInt("szomax"),
                        vizsgaadatokSorai.getInt("irmax"), vizsgaadatokSorai.getInt("szobeli"), vizsgaadatokSorai.getInt("irasbeli"));
                tv1.getItems().add(vizsgaadatok);
            }
        }
    }
    @FXML
    protected void btnVizsgazoHozzaad() throws SQLException {
        if(tf2.getText().length() == 0 || tf3.getText().length() == 0) {
            errorForVizsgazoHozzaadas.setVisible(true);
            errorForVizsgazoHozzaadas.setManaged(true);
            msgForVizsgazoHozzaadas.setVisible(false);
            msgForVizsgazoHozzaadas.setManaged(false);
        } else {
            errorForVizsgazoHozzaadas.setVisible(false);
            errorForVizsgazoHozzaadas.setManaged(false);
            preparedStatement = connection.prepareStatement("INSERT INTO vizsgazo (nev, osztaly) VALUES (?, ?)");
            preparedStatement.setString(1,tf2.getText() + "");
            preparedStatement.setString(2,tf3.getText() + "");
            preparedStatement.executeUpdate();
            msgForVizsgazoHozzaadas.setVisible(true);
            msgForVizsgazoHozzaadas.setManaged(true);
            setTimerForLabel(msgForVizsgazoHozzaadas);
            tf2.setText("");
            tf3.setText("");
        }
    }
    @FXML
    protected void btnVizsgazoModosit() throws SQLException {
        if(tf4.getText().length() == 0 && tf5.getText().length() == 0) {
            errorForVizsgazoModositas.setVisible(true);
            errorForVizsgazoModositas.setManaged(true);
            msgForVizsgazoModositas.setVisible(false);
            msgForVizsgazoModositas.setManaged(false);
        } else {
            errorForVizsgazoModositas.setVisible(false);
            errorForVizsgazoModositas.setManaged(false);
            String vizsgazoAzonosito = cb2.getValue() + "";
            if(tf4.getText().length() != 0) {
                preparedStatement = connection.prepareStatement("UPDATE vizsgazo SET nev = ? WHERE azon = ?");
                preparedStatement.setString(1, tf4.getText());
                preparedStatement.setString(2, vizsgazoAzonosito);
                preparedStatement.executeUpdate();
            }
            if(tf5.getText().length() != 0) {
                preparedStatement = connection.prepareStatement("UPDATE vizsgazo SET osztaly = ? WHERE azon = ?");
                preparedStatement.setString(1, tf5.getText());
                preparedStatement.setString(2, vizsgazoAzonosito);
                preparedStatement.executeUpdate();
            }
            msgForVizsgazoModositas.setVisible(true);
            msgForVizsgazoModositas.setManaged(true);
            setTimerForLabel(msgForVizsgazoModositas);
            tf4.setText("");
            tf5.setText("");
        }
    }
    @FXML
    protected void btnVizsgaTorol() throws SQLException {
        if(cb3.getValue() == null || cb4.getValue() == null) {
            msgForVizsgaTorles.setVisible(false);
            msgForVizsgaTorles.setManaged(false);
            errorForVizsgaTorles2.setVisible(false);
            errorForVizsgaTorles2.setManaged(false);
            errorForVizsgaTorles.setVisible(true);
            errorForVizsgaTorles.setManaged(true);
        } else {
            preparedStatement = connection.prepareStatement("DELETE FROM vizsga WHERE vizsgazoaz = ? AND vizsgatargyaz = ?");
            preparedStatement.setString(1, cb3.getValue() + "");
            preparedStatement.setString(2, cb4.getValue() + "");
            errorForVizsgaTorles.setVisible(false);
            errorForVizsgaTorles.setManaged(false);
            errorForVizsgaTorles2.setVisible(false);
            errorForVizsgaTorles2.setManaged(false);
            if(preparedStatement.executeUpdate() == 0) {
                errorForVizsgaTorles2.setVisible(true);
                errorForVizsgaTorles2.setManaged(true);
            } else {
                msgForVizsgaTorles.setVisible(true);
                msgForVizsgaTorles.setManaged(true);
                setTimerForLabel(msgForVizsgaTorles);
            };
        }
        cb3.getItems().removeAll(cb3.getItems());
        cb4.getItems().removeAll(cb4.getItems());
        ResultSet vizsgazoAzonositok = statement.executeQuery("SELECT DISTINCT vizsgazoaz FROM vizsga");
        int va = 0;
        while(vizsgazoAzonositok.next()) {
            cb3.getItems().add(vizsgazoAzonositok.getInt("vizsgazoaz"));
            int firstNum = vizsgazoAzonositok.getInt("vizsgazoaz");
            if(va == 0) cb3.getSelectionModel().select(firstNum);
            va++;
        }
        ResultSet vizsgatargyAzonositok = statement.executeQuery("SELECT DISTINCT vizsgatargyaz FROM vizsga");
        int vt = 0;
        while(vizsgatargyAzonositok.next()) {
            cb4.getItems().add(vizsgatargyAzonositok.getInt("vizsgatargyaz"));
            int firstNum = vizsgatargyAzonositok.getInt("vizsgatargyaz");
            if(vt == 0) cb4.getSelectionModel().select(firstNum);
            vt++;
        }
    }
    protected void seg??d1(){
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("Authorization", "Bearer " + token);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoOutput(true);
    }
    protected void seg??d2(String params) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8"));
        wr.write(params);
        wr.close();
        httpsURLConnection.connect();
    }
    protected String seg??d3(int code) throws IOException {
        int statusCode = httpsURLConnection.getResponseCode();
        System.out.println("statusCode: "+statusCode);
        if (statusCode == code) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = null;
            while ((readLine = in.readLine()) != null)
                jsonResponseData.append(readLine);
            in.close();
            httpsURLConnection.disconnect();
            return jsonResponseData.toString();
        } else {
            httpsURLConnection.disconnect();
            return "Hiba!!!";
        }
    }
    @FXML
    protected void rest1MenuCreateClick() {
        ElemekT??rl??se();
        clearControlUIData(tf7, tf8, tf9, tf10);
        ta2.setText("");
        gr7.setVisible(true);
        gr7.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuCreateClick() throws IOException {
        ta2.setText("");
        URL postUrl = new URL("https://gorest.co.in/public/v1/users");
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("POST");
        seg??d1();
        String name = tf7.getText();
        String gender = tf8.getText();
        String email = tf9.getText();
        String status = tf10.getText();
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
        seg??d2(params);
        String response = seg??d3(HttpsURLConnection.HTTP_CREATED);
        if(!response.equals("Hiba!!!")) {
            ta2.setText(response);
        } else {
            ta2.setText("Az ??j user l??trehoz??sa sajnos nem siker??lt.");
        }
    }
    @FXML
    protected void rest1MenuReadClick() {
        ElemekT??rl??se();
        clearControlUIData(tf6);
        ta1.setText("");
        gr6.setVisible(true);
        gr6.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuReadClick() throws IOException {
        ta1.setText("");
        String url = "https://gorest.co.in/public/v1/users";
        String ID = tf6.getText();
        if(ID != null)
            url = url + "/" + ID;
        URL usersUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) usersUrl.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        if(ID != null)
            httpsURLConnection.setRequestProperty("Authorization", "Bearer " + token);
        String response = seg??d3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta1.setText(response);
        } else {
            ta1.setText("Nincs user ilyen ID-val az adatb??zisban.");
        }
    }
    @FXML
    protected void rest1MenuUpdateClick() {
        ElemekT??rl??se();
        clearControlUIData(tf11, tf12, tf13, tf14, tf15);
        ta3.setText("");
        gr8.setVisible(true);
        gr8.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuUpdateClick() throws IOException {
        ta3.setText("");
        String ID = tf11.getText();
        String name = tf12.getText();
        String gender = tf13.getText();
        String email = tf14.getText();
        String status = tf15.getText();
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("PUT");
        seg??d1();
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
        seg??d2(params);
        String response = seg??d3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta3.setText(response);
        } else {
            ta3.setText("A user m??dos??t??sa sajnos nem siker??lt.");
        }
    }
    @FXML
    protected void rest1MenuDeleteClick() {
        ElemekT??rl??se();
        clearControlUIData(tf16);
        ta4.setText("");
        gr9.setVisible(true);
        gr9.setManaged(true);
    }
    @FXML
    protected void btnRest1MenuDeleteClick() throws IOException {
        ta4.setText("");
        String ID = tf16.getText();
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("DELETE");
        seg??d1();
        String response = seg??d3(HttpsURLConnection.HTTP_NO_CONTENT);
        if(!response.equals("Hiba!!!")) {
            ta4.setText("Sikeresen t??r??lte a user-t!");
        } else {
            ta4.setText("A user t??rl??se sajnos nem siker??lt.");
        }
    }
    @FXML
    protected void rest2MenuCreateClick() {
        ElemekT??rl??se();
        clearControlUIData(tf17, tf18);
        ta5.setText("");
        gr10.setVisible(true);
        gr10.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuCreateClick() throws IOException {
        ta5.setText("");
        String nev = tf17.getText();
        String osztaly = tf18.getText();
        URL postUrl = new URL("https://danyi-erdosdavid-eloadas-beadando-3feladat.azurewebsites.net/szemelyek");
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("POST");
        seg??d1();
        String params = "{\"nev\":\""+nev+"\", \"osztaly\":\""+osztaly+"\"}";
        seg??d2(params);
        String response = seg??d3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta5.setText(response);
        } else {
            ta5.setText("Az ??j vizsg??z?? l??trehoz??sa sajnos nem siker??lt.");
        }
    }
    @FXML
    protected void rest2MenuReadClick() {
        ElemekT??rl??se();
        clearControlUIData(tf19);
        ta6.setText("");
        gr11.setVisible(true);
        gr11.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuReadClick() throws IOException {
        ta6.setText("");
        String url = "https://danyi-erdosdavid-eloadas-beadando-3feladat.azurewebsites.net/szemelyek";
        String ID = tf19.getText();
        if(ID!=null)
            url=url+"/"+ID;
        URL usersUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) usersUrl.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        String response = seg??d3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta6.setText(response);
        } else {
            ta6.setText("Nincs vizsg??z?? ilyen azonos??t??val az adatb??zisban.");
        }
    }
    @FXML
    protected void rest2MenuUpdateClick() {
        ElemekT??rl??se();
        clearControlUIData(tf20, tf21, tf22);
        ta7.setText("");
        gr12.setVisible(true);
        gr12.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuUpdateClick() throws IOException {
        ta7.setText("");
        String ID = tf20.getText();
        String nev = tf21.getText();
        String osztaly = tf22.getText();
        String url = "https://danyi-erdosdavid-eloadas-beadando-3feladat.azurewebsites.net/szemelyek"+"/"+ID;
        URL postUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("PUT");
        seg??d1();
        String params = "{\"nev\":\""+nev+"\", \"osztaly\":\""+osztaly+"\"}";
        seg??d2(params);
        String response = seg??d3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta7.setText(response);
        } else {
            ta7.setText("A vizsg??z?? m??dos??t??sa sajnos nem siker??lt.");
        }
    }
    @FXML
    protected void rest2MenuDeleteClick() {
        ElemekT??rl??se();
        clearControlUIData(tf23);
        ta8.setText("");
        gr13.setVisible(true);
        gr13.setManaged(true);
    }
    @FXML
    protected void btnRest2MenuDeleteClick() throws IOException {
        ta8.setText("");
        String ID = tf23.getText();
        String url = "https://danyi-erdosdavid-eloadas-beadando-3feladat.azurewebsites.net/szemelyek"+"/"+ID;
        URL postUrl = new URL(url);
        httpsURLConnection = (HttpsURLConnection) postUrl.openConnection();
        httpsURLConnection.setRequestMethod("DELETE");
        seg??d1();
        String response = seg??d3(HttpsURLConnection.HTTP_OK);
        if(!response.equals("Hiba!!!")) {
            ta8.setText("Sikeresen t??r??lte a vizsg??z??t!");
        } else {
            ta8.setText("A vizsg??z?? t??rl??se sajnos nem siker??lt.");
        }
    }
    @FXML
    protected void soapKliensMenuLet??lt??s() {

    }
    @FXML
    protected void soapKliensMenuLet??lt??s2() {

    }
    @FXML
    protected void soapKliensMenuGrafikon() {

    }
    @FXML
    protected void adatb??ny??szatMenuD??nt??siFa() {
        ElemekT??rl??se();
        d??nt??siFaMsg.setText("");
        gr14.setVisible(true);
        gr14.setManaged(true);
    }
    @FXML
    protected void btnAdatb??ny??szatMenuD??nt??siFa() {
        String f??jlN??v = "data/vote.arff";
        int classIndex = 16;
        new G??piTanul??s1(f??jlN??v, classIndex);
        d??nt??siFaMsg.setText("Elvileg siker??lt a m??velet!");
        setTimerForLabel(d??nt??siFaMsg);
    }
    @FXML
    protected void adatb??ny??szatMenuT??bbAlgoritmus() {
        ElemekT??rl??se();
        gr15.setVisible(true);
        gr15.setManaged(true);
    }
    @FXML
    protected void btnAdatb??ny??szatMenuT??bbAlgoritmus() throws Exception {
        String f??jlN??v = "data/vote.arff";
        int classIndex = 16;
        PrintWriter kiir = new PrintWriter("G??pi tanul??s.txt");
        String bestCorrectlyCIClassName = "";
        List<String[]> list = new ArrayList<String[]>();
        String[] arr1 = new G??piTanul??s2CrossValidation(f??jlN??v, classIndex, new J48(), kiir, "D??nt??si fa").getImportantData();
        String[] arr2 = new G??piTanul??s2CrossValidation(f??jlN??v, classIndex, new SMO(), kiir, "Support-vector machine").getImportantData();
        String[] arr3 = new G??piTanul??s2CrossValidation(f??jlN??v, classIndex, new NaiveBayes(), kiir, "NaiveBayes").getImportantData();
        IBk classifier = new IBk();
        classifier.setOptions(Utils.splitOptions("-K 10"));
        String[]arr4 = new G??piTanul??s2CrossValidation(f??jlN??v, classIndex, classifier, kiir, "K-legk??zelebbi szomsz??d").getImportantData();
        String[] arr5 = new G??piTanul??s2CrossValidation(f??jlN??v, classIndex, new RandomForest(), kiir, "RandomForest").getImportantData();
        kiir.close();
        double bestCorrClassIns = 0.0;
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        for(int i = 0; i < list.size(); i++) {
            double value = Double.parseDouble(list.get(i)[0]);
            if(value > bestCorrClassIns) {
                bestCorrClassIns = value;
                bestCorrectlyCIClassName = list.get(i)[1];
            }
        }
        ta9.setText(bestCorrectlyCIClassName);
        ta9.setFont(new Font(36.0));
    }
    @FXML
    protected void adatb??ny??szatMenuT??bbAlgoritmus2() {
        ElemekT??rl??se();
        gr16.setVisible(true);
        gr16.setManaged(true);
        ta10.setText("");
    }
    @FXML
    protected void btnAdatb??ny??szatMenuT??bbAlgoritmus2() throws Exception {
        String f??jlN??v = "data/vote.arff";
        int classIndex = 16;
        ta10.setText("");
        List<String> data = new ArrayList<String>();
        String algoritmus = cb5.getValue() + "";
        switch(algoritmus) {
            case "D??nt??si fa":
                data = new G??piTanul??s3CrossValidation(f??jlN??v, classIndex, new J48()).getData();
                break;
            case "Support-vector machine":
                data = new G??piTanul??s3CrossValidation(f??jlN??v, classIndex, new SMO()).getData();
                break;
            case "NaiveBayes":
                data = new G??piTanul??s3CrossValidation(f??jlN??v, classIndex, new NaiveBayes()).getData();
                break;
            case "K-legk??zelebbi szomsz??d":
                IBk classifier = new IBk();
                classifier.setOptions(Utils.splitOptions("-K 10"));
                data = new G??piTanul??s3CrossValidation(f??jlN??v, classIndex, classifier).getData();
                break;
            case "RandomForest":
                data = new G??piTanul??s3CrossValidation(f??jlN??v, classIndex, new RandomForest()).getData();
                break;
        }
        setTextArea10(data);
    }
    protected void setTextArea10(List<String> data) {
        String text = "";
        for(String d : data) text += d;
        ta10.setText(text);
        ta10.setFont(new Font(25.0));
    }
    @FXML
    protected void egy??bMenuP??rhuzamos() {
        ElemekT??rl??se();
        gr5.setVisible(true);
        gr5.setManaged(true);
    }

    @FXML
    protected void btnP??rhuzamosStart() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("parallel.fxml"));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void egy??bMenuStream() {

    }
}
