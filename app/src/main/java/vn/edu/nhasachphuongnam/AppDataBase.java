package vn.edu.nhasachphuongnam;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SachBanChay.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract BookBestDao bookBestDao();
}
