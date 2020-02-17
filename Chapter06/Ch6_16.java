import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Scanner;

public final class Ch6_16 extends Application {

    /*
      Before running this application, make sure to do these two steps:

      1) Download JavaFX SDK for your OS (from https://gluonhq.com/products/javafx/)
      and unzip it in any directory.

      2) Assuming you have unzipped JavaFX SDK into the folder /path/JavaFX/,
       add the following options to the Java command that launches this class:

        --module-path /path/JavaFX/lib
        --add-modules=javafx.controls,javafx.fxml

      If you run it from IDE, add these VM options to Run Configuration.
      Use JRE 9.* to execute this example since JRE 1.8 does not have these options.
    */
    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        ListView<String> listView = new ListView<>();
        Button refreshButton = new Button("REFRESH");
        JavaFxObservable.actionEventsOf(refreshButton)
                        .observeOn(Schedulers.io())
                        .flatMapSingle(a -> Observable.fromArray(getResponse("https://goo.gl/S0xuOi").split("\\r?\\n"))
                                                      .toList())
                        .observeOn(JavaFxScheduler.platform())
                        .subscribe(list -> listView.getItems().setAll(list));
        root.getChildren().addAll(listView, refreshButton);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private static String getResponse(String path) {
        try {
            return new Scanner(new URL(path).openStream(),
                    "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}