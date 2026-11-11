package br.com.enhmusical.ui;

import br.com.enhmusical.client.ClientService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    private final ClientService service;

    @FXML
    private Label statusLabel;

    public MainController(ClientService service) {
        this.service = service;
    }

    @FXML
    public void initialize() {
        statusLabel.setText("Connecting to the database. Registered customers: " + service.list().size());
    }

}
