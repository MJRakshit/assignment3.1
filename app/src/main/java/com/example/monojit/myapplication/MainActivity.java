package com.example.monojit.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void searchWebContent(View v) {
        Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(web,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if (isIntentSafe==true)
        startActivity(web);
        else
            Toast.makeText(getApplicationContext(),"there is no browser in your device",Toast.LENGTH_LONG).show();
    }
}
