package vn.edu.nhasachphuongnam.UserScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.nhasachphuongnam.R;

public class Add_UserActivity extends AppCompatActivity {
    private TextInputEditText tvNumberPhone, tvEmail, tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__user);
        Drawable drawable = getResources().getDrawable(R.drawable.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        innituser();
    }

    private void innituser() {
        tvEmail = findViewById(R.id.tvEmail);
        tvName = findViewById(R.id.tvName);
        tvNumberPhone = findViewById(R.id.tvNumberPhone);


        tvName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menunext:
                String email = tvEmail.getText().toString().trim();
                String name = tvName.getText().toString().trim();
                String phone = tvNumberPhone.getText().toString().trim();

                if (phone.isEmpty()) {
                    Toast.makeText(Add_UserActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(Add_UserActivity.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                } else if (name.isEmpty()) {
                    Toast.makeText(Add_UserActivity.this, "Vui lòng nhập họ tên", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, Add_User2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("name", name);
                    bundle.putString("phone", phone);
                    intent.putExtra("bds", bundle);

                    startActivity(intent);
                    break;
                }

        }
        return super.onOptionsItemSelected(item);
    }


}
