import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public final class Ch7_16 extends Application {
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
        Label counterLabel = new Label("");
        counterLabel.relocate(20, 30);

        ToggleButton startStopButton = new ToggleButton();
        startStopButton.relocate(20, 60);

        root.getChildren().addAll(counterLabel, startStopButton);
        stage.setScene(new Scene(root,100, 100));
        stage.show();

        setObservers(counterLabel, startStopButton);
    }

    private void setObservers(Label label, ToggleButton button){
        // Multicast the ToggleButton's true/false selected state
        Observable<Boolean> selectedState =
                JavaFxObservable.valuesOf(button.selectedProperty())
                        .publish()
                        .autoConnect(2);

        // Using switchMap() with ToggleButton's selected state drives
        // whether to kick off an Observable.interval()
        // or dispose of it by switching to empty Observable
        selectedState
                .switchMap(selected -> {
                    System.out.println(selected);
                    if (selected) {
                        return Observable.interval(1, TimeUnit.MILLISECONDS);
                    } else {
                        return Observable.empty();
                    }
                })
                .observeOn(JavaFxScheduler.platform()) // Observe on JavaFX UI thread
                .map(Object::toString)
                .subscribe(label::setText);

        // Change ToggleButton's text depending on its state
        selectedState.subscribe(selected ->
                button.setText(selected ? "STOP" : "START"));


    }
}