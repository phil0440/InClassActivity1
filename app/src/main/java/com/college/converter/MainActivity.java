package com.college.converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.college.converter.databinding.ActivityMainBinding;


/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {
    static private final Float CONVERSION_RATE = 0.80F;
    //Declare a binding variable
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate the binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //Set the content view to the root of the binding
        setContentView(binding.getRoot());

        // Now use binding to find the button and set the click listener
        binding.convertButton.setOnClickListener(this::convertCurrency);


        }

    public void convertCurrency(View view) {

        //EditText inputView = findViewById(R.id.entryId);
        //using variable binding
        String inputAmount = binding.entryId.getText().toString();

        //TextView resultView = findViewById(R.id.resultId);

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);

            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;

            binding.resultId.setText( resultFloat + " Euros" );
        }
    }
}