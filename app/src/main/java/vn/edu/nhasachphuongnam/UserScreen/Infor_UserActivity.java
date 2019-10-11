package vn.edu.nhasachphuongnam.UserScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import vn.edu.nhasachphuongnam.R;
import vn.edu.nhasachphuongnam.User;
import vn.edu.nhasachphuongnam.UserDao;

public class Infor_UserActivity extends AppCompatActivity {
    public TextInputEditText ipePass, ipeName, ipeEmail, ipeNumberphone;
    public Button btnUpdate;
    private UserDao userDao;
    public List<User> userList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor__user);
        Drawable drawable = getResources().getDrawable(R.drawable.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setHomeButtonEnabled(true);

        // userList=new ArrayList<>();

        kb();


        Bundle bundle = getIntent().getBundleExtra("bundle");
        if (bundle != null) {
            int value = bundle.getInt("stt");
            position = value;

            Log.e("PoSition11111", position + "");

            ipeName.setText(bundle.getString("name"));
            ipeNumberphone.setText(bundle.getString("phone"));
            ipeEmail.setText(bundle.getString("email"));
            ipePass.setText(bundle.getString("pass"));
            onClick();
        }
    }

    public void kb() {
        ipeEmail = findViewById(R.id.ipeEmail);
        ipeName = findViewById(R.id.ipeName);
        ipeNumberphone = findViewById(R.id.ipeNumberphone);
        ipePass = findViewById(R.id.ipePass);
        btnUpdate = findViewById(R.id.btnXacNhan);

    }

    public void onClick() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDao = new UserDao(Infor_UserActivity.this);

                String hoten = ipeName.getText().toString().trim();
                String email = ipeEmail.getText().toString().trim();
                String pass = ipePass.getText().toString().trim();
                String number = ipeNumberphone.getText().toString().trim();

                if (hoten.equals("") || email.equals("") || pass.equals("") || number.equals("")) {
                    Toast.makeText(Infor_UserActivity.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
//                   userList = userDao.getAllUser();


                    User user = new User();
                    user.userName = email;
                    user.hoTen = hoten;
                    user.passWord = pass;
                    user.Phone = number;

                    long up = userDao.updateUser(user);

                    Log.e("uuuuu1111111111", email + "");
                    Intent intent=new Intent(Infor_UserActivity.this,UserActivity.class);
                    startActivityForResult(intent,0);

                    if (up > 0) {
                        Toast.makeText(Infor_UserActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Infor_UserActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                    }

                    finish();
                }

            }
        });
    }
}
