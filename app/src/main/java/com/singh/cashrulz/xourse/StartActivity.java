package com.singh.cashrulz.xourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        final Handler handler_logo = new Handler();
        handler_logo.postDelayed(new Runnable() {

            @Override
            public void run() {
                ImageView image = (ImageView) findViewById(R.id.xourse_logo);
                image.setImageResource(R.mipmap.video);
                handler_logo.postDelayed(this, 1000);
            }
        }, 1000);

        final Handler handler_text = new Handler();
        handler_text.postDelayed(new Runnable() {

            @Override
            public void run() {
                TextView text = (TextView) findViewById(R.id.xourse);
                text.setText("Xourse");
                handler_text.postDelayed(this, 2000);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(mainIntent);
                StartActivity.this.finish();
            }
        }, 4000);


    }

}
