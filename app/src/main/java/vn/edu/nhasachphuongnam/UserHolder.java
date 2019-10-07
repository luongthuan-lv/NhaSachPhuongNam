package vn.edu.nhasachphuongnam;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

class UserHolder extends RecyclerView.ViewHolder {
    public TextInputEditText ipeUsername;
    public ImageView imgShowInfor,imgDeleteInfor;

    public UserHolder(@NonNull View itemView) {
        super(itemView);

        ipeUsername=itemView.findViewById(R.id.ipeUsername);
        imgShowInfor=itemView.findViewById(R.id.imgShowInfor);
        imgDeleteInfor=itemView.findViewById(R.id.imgDeleteInfor);
    }
}
