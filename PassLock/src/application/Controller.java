package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import java.io.IOException;

public class Controller {

    @FXML
    private TableView<Entry> tableView;

    @FXML
    private TableColumn<Entry, String> platformColumn;

    @FXML
    private TableColumn<Entry, String> usernameColumn;

    @FXML
    private TableColumn<Entry, String> passwordColumn;

    @FXML
    private TextField platformField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    public void initialize() {
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        try {
            ObservableList<Entry> entries = DataManager.loadEntries();
            tableView.setItems(entries);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddEntry(ActionEvent event) {
        String platform = platformField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!platform.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            Entry newEntry = new Entry(platform, username, password);
            tableView.getItems().add(newEntry);

            try {
                DataManager.saveEntries(tableView.getItems());
            } catch (IOException e) {
                e.printStackTrace();
            }

            platformField.clear();
            usernameField.clear();
            passwordField.clear();
        }
    }

    @FXML
    private void handleDeleteEntry(ActionEvent event) {
        Entry selectedEntry = tableView.getSelectionModel().getSelectedItem();

        if (selectedEntry != null) {
            tableView.getItems().remove(selectedEntry);

            try {
                DataManager.saveEntries(tableView.getItems());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
