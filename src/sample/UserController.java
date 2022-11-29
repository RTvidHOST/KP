package sample;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<tableProduct> tableView;

    @FXML
    private TableColumn<tableProduct, String> columnName;

    ObservableList<tableProduct> producttableData = FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {
        initUser();
        columnName.setCellValueFactory(new PropertyValueFactory<>("Наименование"));
        tableView.setItems(producttableData);
    }

    private void initUser() throws SQLException {
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.user();
        while (resultSet.next()){
            producttableData.add(new tableProduct(resultSet.getString("Наименование")));
        }
    }
}