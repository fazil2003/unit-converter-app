package com.fazil.units;

import static android.view.View.GONE;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fazil.units.utilities.CustomActionBar;
import com.fazil.units.utilities.TinyDB;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertActivity extends AppCompatActivity {

    // * Set the Title of the Activity.
    String ACTIVITY_TITLE = "Subscription";
    TextView textViewActivityTitle;
    ImageButton actionBarButton;

    String questionUnit, answerUnit;

    String[] lengthItems = {
            "Centimeter",
            "Kilometer",
            "Meter"
    };

    AutoCompleteTextView dropdownQuestion, dropdownAnswer;
    ArrayAdapter<String> arrayAdapter;

    EditText questionField, answerField;

    TinyDB tinyDB;
    // * TinyDB Instances.
    String settingsAppTheme = "settings_app_theme";

    String unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // * To set the theme of the app.
        tinyDB = new TinyDB(this);
        switch (tinyDB.getString(settingsAppTheme)){
            case "light":
                setTheme(R.style.LightTheme);
                break;
            case "dark":
                setTheme(R.style.DarkTheme);
                break;
            default:
                setTheme(R.style.LightTheme);
                break;
        }

        setContentView(R.layout.activity_convert);

        unit = getIntent().getStringExtra("unit");

        // * Remove the Dark Mode.
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // * Custom ActionBar.
        ActionBar actionBar = this.getSupportActionBar();
        Window window = this.getWindow();
        new CustomActionBar(this).setCustomActionBar(actionBar, window);

        // * Set the Title of the Activity.
        textViewActivityTitle = findViewById(R.id.textview_activity_title);
        textViewActivityTitle.setText(unit);

        // * Set the Action Bar Button.
        actionBarButton = findViewById(R.id.action_bar_button);
        actionBarButton.setVisibility(GONE);

        questionField = findViewById(R.id.edittext_question);
        answerField = findViewById(R.id.edittext_answer);

        questionUnit = "kilometer";
        answerUnit = "centimeter";

        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        theme.resolveAttribute(R.attr.backgroundColor, typedValue, true);
        @ColorInt int color = typedValue.data;

        int positionOne = new ArrayList<String>(Arrays.asList(lengthItems)).indexOf("Kilometer");
        int positionTwo = new ArrayList<String>(Arrays.asList(lengthItems)).indexOf("Meter");

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, lengthItems);

        dropdownQuestion = findViewById(R.id.dropdown_question);
        dropdownAnswer = findViewById(R.id.dropdown_answer);

        dropdownQuestion.setText(arrayAdapter.getItem(positionOne), true);
        dropdownAnswer.setText(arrayAdapter.getItem(positionTwo), true);

        dropdownQuestion.setDropDownBackgroundDrawable(new ColorDrawable(color));
        dropdownQuestion.setAdapter(arrayAdapter);

        dropdownAnswer.setDropDownBackgroundDrawable(new ColorDrawable(color));
        dropdownAnswer.setAdapter(arrayAdapter);

        dropdownQuestion.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                questionUnit = s.toString().toLowerCase();
                changeValues(questionField.getText().toString());
            }
        });

        dropdownAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                answerUnit = s.toString().toLowerCase();
                changeValues(questionField.getText().toString());
            }
        });

        questionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    changeValues(s.toString());
                }
                else{
                    answerField.setText("0");
                }
            }
        });

    }

    private void changeValues(String s){
        Float value = Float.parseFloat(s);
        value = convertQuestionToCommon(questionUnit, value);
        value = convertCommonToAnswer(answerUnit, value);
        answerField.setText(String.valueOf(value));
    }

    private float convertQuestionToCommon(String unit, Float value){
        float result = 0.0F;
        switch(unit){
            case "centimeter":
                result = value / 100;
                break;
            case "kilometer":
                result = value * 1000;
                break;
            case "meter":
                result = value;
                break;
        }
        return result;
    }

    private float convertCommonToAnswer(String unit, Float value){
        float result = 0.0F;
        switch(unit){
            case "centimeter":
                result = value * 100;
                break;
            case "kilometer":
                result = value / 1000;
                break;
            case "meter":
                result = value;
                break;
        }
        return result;
    }

}