package br.com.enhmusical;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        context = SpringApplication.run(EnhMusicalApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setControllerFactory(context::getBean);

        stage.setTitle("EnhMusical");
        stage.setScene(new Scene(loader.load(), 900, 600));
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }
}
