package lineng.news.newsday.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 繁华丶落尽 on 2016/8/5.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="db_name";
    public static final String TABLE_NAME="table_name";
    public static final String NEWS_TITLE = "title";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
//当这个类第一次调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table if not exists " +TABLE_NAME + "( " + NEWS_TITLE + " varchar(255),description varchar(255),url varchar(255),picUrl varchar(255) ) ");
    }
//当数据库更新的时候调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
