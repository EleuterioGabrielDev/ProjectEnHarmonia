package br.com.enhmusical.ui;

import br.com.enhmusical.client.Client;
import br.com.enhmusical.client.ClientService;
import jakarta.validation.ConstraintViolationException;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

@Component
public class ClientFormController {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");

    private final ClientService service;
    private Client editing; // cliente carregado para edição (null = novo cadastro)

    @FXML private TextField couplesNameField;
    @FXML private TextField phoneField;
    @FXML private DatePicker dateEventPicker;
    @FXML private TextField timeEventField;
    @FXML private TextField localEventField;
    @FXML private Label messageLabel;

    @FXML private TableView<Client> clientTable;
    @FXML private TableColumn<Client, String> coupleColumn;
    @FXML private TableColumn<Client, String> phoneColumn;
    @FXML private TableColumn<Client, String> dateColumn;
    @FXML private TableColumn<Client, String> timeColumn;
    @FXML private TableColumn<Client, String> localColumn;

    public ClientFormController(ClientService service) {
        this.service = service;
    }

    @FXML
    public void initialize() {
        coupleColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCouplesName()));
        phoneColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhone()));
        dateColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDateEvent().format(DATE_FMT)));
        timeColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTimeEvent().format(TIME_FMT)));
        localColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLocalEvent()));

        clientTable.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            if (selected != null) {
                fillForm(selected);
            }
        });

        refresh();
    }

    @FXML
    private void onSave() {
        String phone = phoneField.getText().replaceAll("\\D", "");
        if (phone.length() < 10 || phone.length() > 11) {
            messageLabel.setText("Telefone inválido: informe DDD + número (10 ou 11 dígitos).");
            return;
        }

        LocalTime time;
        try {
            time = LocalTime.parse(timeEventField.getText().trim());
        } catch (DateTimeParseException e) {
            messageLabel.setText("Horário inválido. Use o formato HH:mm, por exemplo 17:30.");
            return;
        }

        try {
            Client client = new Client();
            client.setId(editing != null ? editing.getId() : null); // com id, o save atualiza
            client.setCouplesName(couplesNameField.getText().trim());
            client.setPhone(phone);
            client.setDateEvent(dateEventPicker.getValue());
            client.setTimeEvent(time);
            client.setLocalEvent(localEventField.getText().trim());

            boolean updating = editing != null;
            service.save(client);

            clearForm();
            refresh();
            messageLabel.setText(updating ? "Cliente atualizado com sucesso!" : "Cliente salvo com sucesso!");
        } catch (ConstraintViolationException e) {
            String details = e.getConstraintViolations().stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining("\n"));
            messageLabel.setText("Verifique os campos:\n" + details);
        } catch (RuntimeException e) {
            messageLabel.setText("Erro ao salvar: " + e.getMessage());
        }
    }

    @FXML
    private void onNew() {
        clearForm();
        messageLabel.setText("");
    }

    @FXML
    private void onDelete() {
        Client selected = clientTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Selecione um cliente na tabela para excluir.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Excluir o cliente \"" + selected.getCouplesName() + "\"?",
                ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(null);

        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            service.delete(selected.getId());
            clearForm();
            refresh();
            messageLabel.setText("Cliente excluído.");
        }
    }

    private void fillForm(Client c) {
        editing = c;
        couplesNameField.setText(c.getCouplesName());
        phoneField.setText(c.getPhone());
        dateEventPicker.setValue(c.getDateEvent());
        timeEventField.setText(c.getTimeEvent().format(TIME_FMT));
        localEventField.setText(c.getLocalEvent());
        messageLabel.setText("Editando: " + c.getCouplesName());
    }

    private void clearForm() {
        editing = null;
        clientTable.getSelectionModel().clearSelection();
        couplesNameField.clear();
        phoneField.clear();
        dateEventPicker.setValue(null);
        timeEventField.clear();
        localEventField.clear();
    }

    private void refresh() {
        clientTable.getItems().setAll(service.list());
    }
}