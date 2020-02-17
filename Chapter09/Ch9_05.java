import io.reactivex.Observable;
import io.reactivex.rxjavafx.observers.JavaFxObserver;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public final class Ch9_05 extends Application {
    /*
      Before running this application, make sure to do these two steps:

      1) Download JavaFX SDK for your OS (from https://gluonhq.com/products/javafx/)
      and unzip it in any directory.

      2) Assuming you have unzipped JavaFX SDK into the folder /path/JavaFX/,
       add the following options to the Java command that launches this class:

        --module-path /path/JavaFX/lib
        --add-modules=javafx.controls,javafx.fxml
        --add-exports javafx.base/com.sun.javafx.binding=ALL-UNNAMED

      If you run it from IDE, add these VM options to Run Configuration.
      Use JRE 9.* to execute this example since JRE 1.8 does not have these options.
    */
    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Label label = new Label("0");
        label.setScaleX(2.00);
        label.setScaleY(2.00);
        label.relocate(40, 40);
        root.getChildren().addAll(label);

        Scene scene = new Scene(root, 100, 100);
        stage.setScene(scene);
        stage.show();

        setBinding(label);
    }

    private static void setBinding(Label label){
        Observable<String> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(i -> i.toString())
                        .observeOn(JavaFxScheduler.platform());

        Binding<String> binding = JavaFxObserver.toBinding(seconds);
        label.textProperty().bind(binding);
    }
}