package com.fazil.units;

import static android.view.View.GONE;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fazil.units.utilities.CustomActionBar;
import com.fazil.units.utilities.TinyDB;

public class ConvertActivity extends AppCompatActivity {

    // * Set the Title of the Activity.
    String ACTIVITY_TITLE = "Subscription";
    TextView textViewActivityTitle;
    ImageButton actionBarButton;

    String questionUnit, answerUnit;

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

        questionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    Float value = Float.parseFloat(s.toString());
                    value = convertQuestionToCommon(questionUnit, value);
                    value = convertCommonToAnswer(answerUnit, value);
                    answerField.setText(String.valueOf(value));
                }
            }
        });

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
        }
        return result;
    }

}