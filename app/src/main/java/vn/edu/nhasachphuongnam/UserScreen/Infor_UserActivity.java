package vn.edu.nhasachphuongnam.UserScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        userDao = new UserDao(Infor_UserActivity.this);
        kb();

        Bundle bundle = getIntent().getBundleExtra("bundle");
        if (bundle != null) {
            //int value=bundle.getInt()

            ipeName.setText(bundle.getString("name"));
            ipeNumberphone.setText(bundle.getString("phone"));
            ipeEmail.setText(bundle.getString("email"));
            ipePass.setText(bundle.getString("pass"));

        }
    }

    public void kb() {
        ipeEmail = findViewById(R.id.ipeEmail);
        ipeName = findViewById(R.id.ipeName);
        ipeNumberphone = findViewById(R.id.ipeNumberphone);
        ipePass = findViewById(R.id.ipePass);
        btnUpdate = findViewById(R.id.btnUpdate);

    }

    public void onClick() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                User user=userList.get()
//                userDao.updateUser()
            }
        });
    }
}
