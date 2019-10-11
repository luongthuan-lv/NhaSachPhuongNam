package vn.edu.nhasachphuongnam;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SachBanChay {
    @PrimaryKey(autoGenerate = true)
    public int stt;

    @ColumnInfo(name = "bookname")
    public String bookname;

    @ColumnInfo(name = "bookcategory")
    public String bookcategory;

    @ColumnInfo(name = "bookprice")
    public String bookprice;
}
