package vn.edu.nhasachphuongnam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.nhasachphuongnam.RegistraionScreen.RegistraionActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void openHome(View view) {
        startActivity(new Intent(this,HomeActivity.class));
    }

    public void openResgistraion(View view) {
        startActivity(new Intent(this, RegistraionActivity.class));
    }
}
