package com.fazil.units;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.fazil.units.fragments.HomeFragment;
import com.fazil.units.utilities.ButtonScaleAnimation;
import com.fazil.units.utilities.CustomPrompt;
import com.fazil.units.utilities.GradientText;
import com.fazil.units.utilities.TinyDB;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;

    public Fragment homeFragment = new HomeFragment();

    ImageButton buttonPremiumTop;

    TinyDB tinyDB;
    // * TinyDB Instances.
    String settingsAppTheme = "settings_app_theme";

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

        setContentView(R.layout.activity_home);

        // * Remove the Dark Mode.
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // * Custom Action Bar.
        ActionBar actionBar = this.getSupportActionBar();
        Window window = this.getWindow();
        Objects.requireNonNull(actionBar).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);

        // Get the Custom Layout of the ActionBar.
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customActionBar = inflater.inflate(R.layout.custom_action_bar_for_home, null);
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

        // * Show the Advertisements.
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String isSubscribed = sharedPreferences.getString("subscribed_or_not","0");
        AdView mAdView = findViewById(R.id.adView);
        if(isSubscribed.equals("1")){
            mAdView.setVisibility(View.GONE);
        }
        else{
            // * Advertisements.
            mAdView.setVisibility(View.VISIBLE);
            MobileAds.initialize(this, initializationStatus -> {});
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

            // * Open the Pro Subscription Dialog at the starting of the app.
            // subscribeProDialogAtStarting();
        }

        // * Subscribe Button at the top.
        buttonPremiumTop = findViewById(R.id.button_premium_top);
        if(!isSubscribed.equals("1")){
            buttonPremiumTop.setVisibility(View.VISIBLE);
            buttonPremiumTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    // * New Activity Animation, Current Activity Animation.
                    overridePendingTransition(R.anim.intent_enter_animation, R.anim.intent_no_animation);
                }
            });

            buttonPremiumTop.setOnTouchListener((view, motionEvent) -> new ButtonScaleAnimation(HomeActivity.this).animateButton(view, motionEvent));

        }

        chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        chipNavigationBar.setOnItemSelectedListener(item -> {
            if (item == R.id.home) {
                fragment = homeFragment;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

    }


    @Override
    public void onBackPressed(){

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        assert currentFragment != null;

        if(!currentFragment.toString().contains("HomeFragment")){
            if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
                getSupportFragmentManager().popBackStack();
            }
            else{
                ChipNavigationBar bottomNavigationView;
                bottomNavigationView = findViewById(R.id.chipNavigation);
                bottomNavigationView.setItemSelected(R.id.home, true);

                fragment = homeFragment;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        }
        else{

            LayoutInflater layoutInflater = LayoutInflater.from(this);
            View promptView = layoutInflater.inflate(R.layout.prompt_confirm_exit, null);

            Button promptButtonYes = promptView.findViewById(R.id.prompt_button_yes);
            Button promptButtonNo = promptView.findViewById(R.id.prompt_button_no);

            AlertDialog alertDialog = new CustomPrompt(this).showPrompt(promptView);

            promptButtonYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            promptButtonNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.cancel();
                }
            });

        }

    }

}