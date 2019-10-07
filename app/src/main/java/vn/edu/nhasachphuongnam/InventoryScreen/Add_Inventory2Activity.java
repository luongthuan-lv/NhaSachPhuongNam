package vn.edu.nhasachphuongnam.InventoryScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import vn.edu.nhasachphuongnam.R;

public class Add_Inventory2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__inventory2);
        Drawable drawable = getResources().getDrawable(R.drawable.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void openListInventory(View view) {
        startActivity(new Intent(Add_Inventory2Activity.this,List_InventoryActivity.class));
    }
}
