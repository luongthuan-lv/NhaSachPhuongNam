package vn.edu.nhasachphuongnam;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class BookHolder extends RecyclerView.ViewHolder {
    public TextView tvBookName,tvBookCategory,tvBookPrice;
    public ImageButton ibImageBook;
    public BookHolder(@NonNull View itemView) {
        super(itemView);
        tvBookName=itemView.findViewById(R.id.tvBookName);
        tvBookCategory=itemView.findViewById(R.id.tvBookCategory);
        tvBookPrice=itemView.findViewById(R.id.tvBookPrice);
        ibImageBook=itemView.findViewById(R.id.ibImageBook);
    }
}
