package com.packtpub.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.my_text_view);
        myTextView.setPadding(100, 0, 0, 0);
        Button incrementButton = findViewById(R.id.increment_button);

        //broadcast clicks into a cumulative increment, and display in TextView
        RxView.clicks(incrementButton)
                .map(o -> 1)
                .scan(0,(total, next) -> total + next)
                .subscribe(i -> myTextView.setText(i.toString()));

    }
}
