package vn.edu.nhasachphuongnam.BillScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

import vn.edu.nhasachphuongnam.R;

public class InsertBillActivity extends AppCompatActivity {
    ImageView imgEdit, imgDelete, imgClose;
    Dialog dialog;
    Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_bill);
        innit();
        onClick();
    }

    public void innit() {
        imgEdit = findViewById(R.id.imgEdit);
        imgDelete = findViewById(R.id.imgDelete);
        dialog = new Dialog(this);
    }

    public void onClick() {
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogEdit();
            }
        });

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogDelete();
            }
        });
    }


    public void ShowDialogEdit() {
        dialog.setContentView(R.layout.dialog_edit_bill);
        imgClose = dialog.findViewById(R.id.imgClose);
        btnAccept = dialog.findViewById(R.id.btnAccept);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InsertBillActivity.this, "Hello", Toast.LENGTH_SHORT).show();
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

    public void ShowDialogDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(InsertBillActivity.this);
        builder.setMessage("Bạn có muốn xóa dữ liệu?");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(InsertBillActivity.this, "Đã hủy thao tác!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(InsertBillActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void openAddBill(View view) {
        startActivity(new Intent(InsertBillActivity.this, AddBillActivity.class));
    }
}
