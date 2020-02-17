import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public final class Ch7_17 extends Application {
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

        Pane root = new Pane();
        Label typedTextLabel = new Label("");
        typedTextLabel.relocate(20, 30);
        root.getChildren().addAll(typedTextLabel);

        Scene scene = new Scene(root, 100, 100);
        stage.setScene(scene);
        stage.show();

        setObservers(scene, typedTextLabel);
    }

    private void setObservers(Scene scene, Label label){
        Observable<String> typedLetters =
                JavaFxObservable.eventsOf(scene, KeyEvent.KEY_TYPED)
                                .map(KeyEvent::getCharacter);

        // Signal 1 sec of inactivity
        typedLetters.throttleWithTimeout(1000, TimeUnit.MILLISECONDS)
                    .startWith("") //trigger initial
                    .switchMap(s -> typedLetters.scan("", (rolling, next) -> rolling + next))
                    .observeOn(JavaFxScheduler.platform())
                    .subscribe(s -> {
                        label.setText(s);
                        System.out.println(s);
                    });
    }

}