package vn.edu.nhasachphuongnam.UserScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.nhasachphuongnam.R;


public class Add_User2Activity extends AppCompatActivity {
private TextInputEditText tvPass,tvReturnPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__user2);
        Drawable drawable=getResources().getDrawable(R.drawable.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        innit();

    }

    private void innit() {
        tvPass=findViewById(R.id.tvPass);
        tvReturnPass=findViewById(R.id.tvReturnPass);
    }


    public void openListUser(View view) {
        Bundle bundle=getIntent().getBundleExtra("bds");


        String pass=tvPass.getText().toString().trim();
        String returnpass=tvReturnPass.getText().toString().trim();

        if (pass.isEmpty()){
            Toast.makeText(Add_User2Activity.this,"Vui lòng nhập password",Toast.LENGTH_SHORT).show();
        }else if (returnpass.isEmpty()){
            Toast.makeText(Add_User2Activity.this,"Vui lòng nhập lại password",Toast.LENGTH_SHORT).show();
        }else if (!pass.matches(returnpass)){
            Toast.makeText(Add_User2Activity.this,"Mật khẩu không khớp",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent=new Intent(this,List_UserActivity.class);
            Bundle bundle1=new Bundle();
            bundle1.putString("rpass",returnpass);
            bundle1.putString("remail",bundle.getString("email"));
            bundle1.putString("rname",bundle.getString("name"));
            bundle1.putString("rphone",bundle.getString("phone"));

            intent.putExtra("bd",bundle1);

            startActivity(intent);
        }
    }
}
