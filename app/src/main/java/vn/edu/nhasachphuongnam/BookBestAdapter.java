package vn.edu.nhasachphuongnam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookBestAdapter extends RecyclerView.Adapter<BookHolder> {

    public Context context;
    public List<SachBanChay> sachBanChayList;
    public AppDataBase appDataBase;

    public BookBestAdapter(Context context, List<SachBanChay> sachBanChayList, AppDataBase appDataBase) {
        this.context = context;
        this.sachBanChayList = sachBanChayList;
        this.appDataBase = appDataBase;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bookbestseller,parent,false);
        BookHolder bookHolder=new BookHolder(view);
        return bookHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {

       SachBanChay sachbanchay = sachBanChayList.get(position);
        holder.tvBookName.setText(sachbanchay.bookname);
        holder.tvBookCategory.setText(sachbanchay.bookcategory);
        holder.tvBookPrice.setText(sachbanchay.bookprice+"");
        Log.e("45346456456",sachbanchay.bookname);



    }

    @Override
    public int getItemCount() {
        return sachBanChayList.size();
    }
}
