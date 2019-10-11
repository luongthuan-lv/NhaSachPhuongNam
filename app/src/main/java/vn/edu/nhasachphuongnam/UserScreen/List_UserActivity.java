package vn.edu.nhasachphuongnam.UserScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.nhasachphuongnam.R;
import vn.edu.nhasachphuongnam.User;
import vn.edu.nhasachphuongnam.UserDao;

public class List_UserActivity extends AppCompatActivity {
private TextInputEditText tvPw,tvNbp,tvEm,tvNa;
private Button btnXacNhan;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__user);
        userDao=new UserDao(this);
        userDao.createDataBase();

        Drawable drawable = getResources().getDrawable(R.drawable.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setHomeButtonEnabled(true);

        innitedt();

        Bundle bundle=getIntent().getBundleExtra("bd");
        if (bundle!=null){
            tvPw.setText(bundle.getString("rpass"));
            tvEm.setText(bundle.getString("remail"));
            tvNa.setText(bundle.getString("rname"));
            tvNbp.setText(bundle.getString("rphone"));
        }
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tsdt=tvNbp.getText().toString().trim();
                String temail=tvEm.getText().toString().trim();
                String tname=tvNa.getText().toString().trim();
                String tpass=tvPw.getText().toString().trim();
                User user=new User();
                user.Phone=tsdt;
                user.passWord=tpass;
                user.hoTen=tname;
                user.userName=temail;
              long isuser=  userDao.insertUser(user);
                if (isuser > 0) {
                    Toast.makeText(List_UserActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(List_UserActivity.this,UserActivity.class));
                } else {
                    Toast.makeText(List_UserActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void innitedt() {
        tvEm=findViewById(R.id.tvEm);
        tvPw=findViewById(R.id.tvPw);
        tvNa=findViewById(R.id.tvNa);
        tvNbp=findViewById(R.id.tvNbp);
        btnXacNhan=findViewById(R.id.btnXacNhan);
    }


}
