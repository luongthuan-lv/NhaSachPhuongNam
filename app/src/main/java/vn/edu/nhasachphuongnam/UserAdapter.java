package vn.edu.nhasachphuongnam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.nhasachphuongnam.UserScreen.Infor_UserActivity;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    public Context context;
    public List<User> userList;
    public UserDao userDao;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        this.userDao = new UserDao(context);
    }


    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user, parent, false);
        UserHolder userHolder = new UserHolder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserHolder holder, final int positon) {

        final User user = userList.get(positon);
        holder.ipeUsername.setText(user.userName);


        holder.imgDeleteInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có muốn xóa dữ liệu?");
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Đã hủy thao tác!", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        userDao.deleteUser(user);
                        userList.remove(positon);
                        notifyDataSetChanged();

                        Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create();
                builder.show();
            }
        });


        holder.imgShowInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Infor_UserActivity.class);
                User user = userList.get(holder.getLayoutPosition());
                Bundle bundle = new Bundle();
                bundle.putString("phone",user.Phone);
                bundle.putString("email",user.userName);
                bundle.putString("name",user.hoTen);
                bundle.putString("pass",user.passWord);
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
