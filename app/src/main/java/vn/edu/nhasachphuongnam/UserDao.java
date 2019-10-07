package vn.edu.nhasachphuongnam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends SQLiteOpenHelper {
    private static String DB_NAME = "nguoidung.db";
    private static String DB_PATH = "";
    private Context mcontext;

    private String USER = "nguoidung";

    public String EMAIL = "userName";
    public String PASS = "passWord";
    public String PHONE = "Phone";
    public String NAME = "hoTen";

    public UserDao(Context context) {
        super(context, DB_NAME, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDataBase() {
        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e("done", "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }


    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }


    private void copyDataBase() throws IOException {
        InputStream mInput = mcontext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT*FROM "+ USER;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor != null && cursor.getCount() > 0) {

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                User user=new User();
                user.hoTen=cursor.getString(cursor.getColumnIndex(NAME));
                user.passWord=cursor.getString(cursor.getColumnIndex(PASS));
                user.Phone=cursor.getString(cursor.getColumnIndex(PHONE));
                user.userName=cursor.getString(cursor.getColumnIndex(EMAIL));

                users.add(user);
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();

        }
        return users;
    }

    public long insertUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, user.userName);
        contentValues.put(PASS, user.passWord);
        contentValues.put(PHONE, user.Phone);
        contentValues.put(NAME,user.hoTen);
        return sqLiteDatabase.insert(USER, null, contentValues);
    }

    public long deleteUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result= sqLiteDatabase.delete(USER, EMAIL + "=?", new String[]{String.valueOf(user.userName)});
        sqLiteDatabase.close();
        return result;
    }

    public long updateUser(User user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, user.userName);
        contentValues.put(PASS, user.passWord);
        contentValues.put(PHONE, user.Phone);
        contentValues.put(NAME,user.hoTen);

        return sqLiteDatabase.update(USER, contentValues, EMAIL +"=?",new String[]{user.userName});

    }

    public void Close(){
        this.close();
    }




}
