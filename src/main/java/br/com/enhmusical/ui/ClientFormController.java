package br.com.enhmusical.ui;

import br.com.enhmusical.client.Client;
import br.com.enhmusical.client.ClientService;
import jakarta.validation.ConstraintViolationException;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

@Component
public class ClientFormController {

    private final ClientService service;

    @FXML private TextField couplesNameField;
    @FXML private TextField phoneField;
    @FXML private DatePicker dateEventPicker;
    @FXML private TextField timeEventField;
    @FXML private TextField localEventField;
    @FXML private Label messageLabel;

    public ClientFormController(ClientService service) {
        this.service = service;
    }

    @FXML
    private void onSave() {
        String phone = phoneField.getText().replaceAll("\\D", "");
        if (phone.length() < 10 || phone.length() > 11) {
            messageLabel.setText("Telefone inválido: informe DDD + número (11 dígitos).");
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
            client.setCouplesName(couplesNameField.getText().trim());
            client.setPhone(phone);
            client.setDateEvent(dateEventPicker.getValue());
            client.setTimeEvent(time);
            client.setLocalEvent(localEventField.getText().trim());

            service.save(client);

            messageLabel.setText("Cliente salvo com sucesso!");
            clearForm();
        } catch (ConstraintViolationException e) {
            String details = e.getConstraintViolations().stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining("\n"));
            messageLabel.setText("Verifique os campos:\n" + details);
        } catch (RuntimeException e) {
            messageLabel.setText("Erro ao salvar: " + e.getMessage());
        }
    }

    private void clearForm() {
        couplesNameField.clear();
        phoneField.clear();
        dateEventPicker.setValue(null);
        timeEventField.clear();
        localEventField.clear();
    }
}