package app.fx.soap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConsumSoapFxApplication extends Application {

    public static ConfigurableApplicationContext context;
    public static void main(String[] args) {

        launch();
        SpringApplication.run(ConsumSoapFxApplication.class,args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        context = SpringApplication.run(ConsumSoapFxApplication.class);

        var fxml = new FXMLLoader(getClass().getResource("/ConsultaRucUI.fxml"));

        fxml.setControllerFactory(context::getBean);

        var scene = new Scene(fxml.load());

        String titulo = context.getBean("titulo", String.class);

        stage.setTitle(titulo);

        stage.setScene(scene);

        stage.show();
    }
}
