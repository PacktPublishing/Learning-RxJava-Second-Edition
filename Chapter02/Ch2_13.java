import io.reactivex.rxjava3.core.Observable;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ch2_13 extends Application {

    /*
      Before running this application, make sure to do these two steps:

      1) Download JavaFX SDK for your OS from https://gluonhq.com/products/javafx/
      and unzip it in any directory.

      2) Assuming you have unzipped JavaFX SDK into the folder /path/JavaFX/,
       add the following VM options to the Java command that launches this class:

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
        ToggleButton toggleButton = new ToggleButton("TOGGLE ME");
        Label label = new Label();
        Observable<Boolean> selectedStates =
                valuesOf(toggleButton.selectedProperty());
        selectedStates.map(selected -> selected ? "DOWN" : "UP")
                .subscribe(label::setText);
        VBox vBox = new VBox(toggleButton, label);
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    private static <T> Observable<T> valuesOf(final
                                              ObservableValue<T> fxObservable) {
        return Observable.create(observableEmitter -> {
            //emit initial state
            observableEmitter.onNext(fxObservable.getValue());
            //emit value changes uses a listener
            final ChangeListener<T> listener = (observableValue, prev,
                                                current) -> observableEmitter.onNext(current);
            fxObservable.addListener(listener);
        });
    }
}