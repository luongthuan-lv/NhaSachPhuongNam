package vn.edu.nhasachphuongnam;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import vn.edu.nhasachphuongnam.BillScreen.InsertBillActivity;

public class BookBestSellActivity extends AppCompatActivity {
    private ImageView imgEditbc,imgEdit, imgDelete, imgClose;
   private Dialog dialog;
   private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_best_sell);
        innit();
        onClick();
    }

    public void innit() {
        imgEditbc = findViewById(R.id.imgEditbc);
        dialog = new Dialog(this);
    }

    public void onClick() {
        imgEditbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupMenu();
            }
        });
    }

    public void ShowPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(BookBestSellActivity.this, imgEditbc);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSua:
                        ShowDialogEdit();
                        break;
                    case R.id.menuXoa:
                        ShowDialogDelete();
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void ShowDialogDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(BookBestSellActivity.this);
        builder.setMessage("Bạn có muốn xóa dữ liệu?");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BookBestSellActivity.this, "Đã hủy thao tác!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(BookBestSellActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }

    public void ShowDialogEdit() {
        dialog.setContentView(R.layout.dialog_edit_book_best);
        imgClose = dialog.findViewById(R.id.imgClose);
        btnAccept = dialog.findViewById(R.id.btnAccept);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookBestSellActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void openAddBookBest(View view) {
        startActivity(new Intent(BookBestSellActivity.this,AddTopBookActivity.class));
    }
}
