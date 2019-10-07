package vn.edu.nhasachphuongnam.UserScreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.nhasachphuongnam.InventoryScreen.InventoryActivity;
import vn.edu.nhasachphuongnam.R;
import vn.edu.nhasachphuongnam.User;
import vn.edu.nhasachphuongnam.UserAdapter;
import vn.edu.nhasachphuongnam.UserDao;

public class UserActivity extends AppCompatActivity {
public ImageView imgDeleteInfor,imgShowInfor;
public RecyclerView rvUser_list;
public List<User> userList;
private UserAdapter userAdapter;
private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        userDao=new UserDao(this);
        userDao.createDataBase();
        innit();
        userList=new ArrayList<>();
        for (int i=0;i<10;i++){
            User user=new User();
            user.setHoTen("Luong Thuan");
            user.setPassWord("123456");
            user.setPhone("0963131729");
            user.setUserName("luongthuan2k "+i);
            userList.add(user);
        }

        rvUser_list.setHasFixedSize(true);
        userAdapter=new UserAdapter(UserActivity.this,userList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(UserActivity.this,RecyclerView.VERTICAL,false);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(UserActivity.this,7,RecyclerView.HORIZONTAL,false);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL);

        rvUser_list.setLayoutManager(linearLayoutManager);
        rvUser_list.setAdapter(userAdapter);
    }

    public void innit(){
        rvUser_list=findViewById(R.id.rvUser_list);
        imgDeleteInfor=findViewById(R.id.imgDeleteInfor);
        imgShowInfor=findViewById(R.id.imgShowInfor);
    }




    public void OpenAddUser(View view) {
        startActivity(new Intent(UserActivity.this,Add_UserActivity.class));
    }
}
