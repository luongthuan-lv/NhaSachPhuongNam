package vn.edu.nhasachphuongnam.UserScreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import vn.edu.nhasachphuongnam.BookBestSellActivity;
import vn.edu.nhasachphuongnam.R;
import vn.edu.nhasachphuongnam.SplashActivity;

public class Recover_PassActivity extends AppCompatActivity {
ImageView imgClose;
Button btnRecover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover__pass);
         khaibao();
         click();
    }
    private void khaibao() {
        imgClose=findViewById(R.id.imgClose);
        btnRecover=findViewById(R.id.btnRecover);
    }
    private void click() {
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Recover_PassActivity.this, SplashActivity.class));
            }
        });

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ShowDialogNotification();
            }
        });
    }

    public void ShowDialogNotification() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Recover_PassActivity.this);
        builder.setMessage( "Truy cập vào email đăng ký để lấy lại mật khẩu!");

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               startActivity(new Intent(Recover_PassActivity.this,SplashActivity.class));
            }
        });

        builder.create();
        builder.show();
    }


}
