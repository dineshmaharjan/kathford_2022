package np.edu.kathford.sqlliteexample.handler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    public DbHandler(@Nullable Context context,
                     @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create tables

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrade

    }
}
