package vn.edu.nhasachphuongnam.InventoryScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import vn.edu.nhasachphuongnam.BillScreen.AddBill2Activity;
import vn.edu.nhasachphuongnam.BillScreen.AddBillActivity;
import vn.edu.nhasachphuongnam.R;

public class Add_InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__inventory);
        Drawable drawable = getResources().getDrawable(R.drawable.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menunext:
                startActivity(new Intent(Add_InventoryActivity.this, Add_Inventory2Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
