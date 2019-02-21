package com.digitalsoftware.firstbelajar.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashAct extends AppCompatActivity {

    Animation app_splash, btt;
    ImageView app_logo;
    TextView app_subtitle;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        // load element
        app_logo = findViewById(R.id.app_logo);
        app_subtitle = findViewById(R.id.app_subtitle);

        // run animation
        app_logo.startAnimation(app_splash);
        app_subtitle.startAnimation(btt);

        getUsernameLocal();

    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
        if(username_key_new.isEmpty()){
            // setting timer untuk 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // merubah activity ke activity lain
                    Intent gogetstarted = new Intent(SplashAct.this,GetStartedAct.class);
                    startActivity(gogetstarted);
                    finish();
                }
            }, 2000); // 2000 ms = 2s
        }
        else {
            // setting timer untuk 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // merubah activity ke activity lain
                    Intent gogethome = new Intent(SplashAct.this,HomeAct.class);
                    startActivity(gogethome);
                    finish();
                }
            }, 2000); // 2000 ms = 2s
        }
    }

}
