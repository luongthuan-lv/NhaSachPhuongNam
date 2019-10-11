package vn.edu.nhasachphuongnam;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookBestDao {

    @Query("SELECT*FROM sachbanchay")
    List<SachBanChay> getAll();

    @Insert
    long[] insert(SachBanChay... sachBanChay);

    @Delete
    int delete(SachBanChay sachBanChay);
}
