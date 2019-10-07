package vn.edu.nhasachphuongnam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import vn.edu.nhasachphuongnam.BillScreen.InsertBillActivity;
import vn.edu.nhasachphuongnam.BillScreen.SellBillActivity;
import vn.edu.nhasachphuongnam.InventoryScreen.InventoryActivity;
import vn.edu.nhasachphuongnam.UserScreen.Recover_PassActivity;
import vn.edu.nhasachphuongnam.UserScreen.UserActivity;

public class HomeActivity extends AppCompatActivity {
    private ImageView imgEdit, imgEdit1;
    private CardView cardview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        innit();
        setOnClick();

    }

    public void innit() {
        imgEdit = findViewById(R.id.imgEdit);
        imgEdit1 = findViewById(R.id.imgEdit1);
        cardview2 = findViewById(R.id.cardView2);
    }

    public void setOnClick() {

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });

        imgEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu1();
            }
        });

        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Cardview2", Toast.LENGTH_LONG).show();
                startActivity(new Intent(HomeActivity.this, BookActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSachbanchay:
                startActivity(new Intent(HomeActivity.this, BookBestSellActivity.class));
                break;
            case R.id.hoadonnhap:
                startActivity(new Intent(HomeActivity.this, InsertBillActivity.class));
                break;
            case R.id.hoadonban:
                startActivity(new Intent(HomeActivity.this, SellBillActivity.class));
                break;
            case R.id.userInpor:
                startActivity(new Intent(HomeActivity.this, UserActivity.class));
                break;
            case R.id.sachtonkho:
                startActivity(new Intent(HomeActivity.this, InventoryActivity.class));
                break;
            case R.id.doanhso:
                break;
            case R.id.infor:

                break;
            case R.id.logout:
                ShowDialogLogout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void ShowMenu() {
        PopupMenu popupMenu = new PopupMenu(HomeActivity.this, imgEdit);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSua:
                        Toast.makeText(HomeActivity.this, "sửa", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menuXoa:
                        Toast.makeText(HomeActivity.this, "xóa", Toast.LENGTH_LONG).show();
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void ShowMenu1() {
        PopupMenu popupMenu = new PopupMenu(HomeActivity.this, imgEdit1);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSua:
                        Toast.makeText(HomeActivity.this, "sửa", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menuXoa:
                        Toast.makeText(HomeActivity.this, "xóa", Toast.LENGTH_LONG).show();
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void openAddbook(View view) {
        startActivity(new Intent(HomeActivity.this, AddBookActivity.class));
    }

    public void ShowDialogLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setMessage("Bạn có muốn đăng xuất?");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "Đã hủy thao tác!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(HomeActivity.this, SplashActivity.class));
                Toast.makeText(HomeActivity.this, "Đăng xuất thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }
}
