package com.fazil.units;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.multidex.BuildConfig;

import java.util.Objects;

import com.fazil.units.utilities.GradientText;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 1500;
    private static final int REQUEST_CODE = 11;

    TextView versionName;
    int versionCode;

    ImageButton buttonPremiumTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // * Remove Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // * Custom Action Bar.
        ActionBar actionBar = this.getSupportActionBar();
        Window window = this.getWindow();
        Objects.requireNonNull(actionBar).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);

        // Get the Custom Layout of the ActionBar.
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customActionBar = inflater.inflate(R.layout.custom_action_bar_for_main, null);
        // Set the width and height to fill the entire width with some spaces at the corners.
        actionBar.setCustomView(customActionBar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, android.R.color.transparent));
        actionBar.setElevation(0);

        // Make the ActionBar to fit the width.
        Toolbar parent =(Toolbar) customActionBar.getParent();//first get parent toolbar of current action bar
        parent.setContentInsetsAbsolute(0,0);// set padding programmatically to 0dp

        // * Set Gradient TextView for the App Name.
        TextView textViewAppName = findViewById(R.id.textview_app_name);
        new GradientText(this).setGradientText(textViewAppName);

        // * Hide the Pro Subscription Button.
        buttonPremiumTop = findViewById(R.id.button_premium_top);
        buttonPremiumTop.setVisibility(View.GONE);

        // callInAppUpdate();

        // * Display the Version Name.
        versionName = findViewById(R.id.version_name);
        versionName.setText("Version: " + BuildConfig.VERSION_NAME);

        // * Open the Next Activity after some time.
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i = new Intent(MainActivity.this, MainActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//                // * New Activity Animation, Current Activity Animation.
//                overridePendingTransition(R.anim.intent_enter_animation, R.anim.intent_no_animation);
//                finish();
//            }
//        }, SPLASH_SCREEN_TIME_OUT);

    }

}