package lineng.news.newsday.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/8/11.
 */
public class DBUtil {
    private DBHelper helper;
    private static DBUtil sInstance;
    private SQLiteDatabase database;

    private DBUtil(Context context) {
        helper = new DBHelper(context);
        database = helper.getWritableDatabase();
    }

    public static DBUtil getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBUtil(context);

        }
        return sInstance;


    }

    public void savaNews(DbInfo info) {
        ContentValues values = new ContentValues();
        values.put("title", info.getTitle());
        values.put("description", info.getDescription());
        values.put("picUrl", info.getPicUrl());
        values.put("url", info.getUrl());
        database.insert(DBHelper.TABLE_NAME, null, values);
    }

    public ArrayList<DbInfo> getNews() {
        ArrayList<DbInfo> list = new ArrayList<>();
        Cursor cursor = database.query(true, DBHelper.TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            String picUrl = cursor.getString(cursor.getColumnIndex("picUrl"));
            String url = cursor.getString(cursor.getColumnIndex("url"));
            list.add(new DbInfo(title, description, picUrl, url));
        }
        return list;
    }
    public void deleteSQL(String title){
        String sql = "delete from " + DBHelper.TABLE_NAME + " where " + DBHelper.NEWS_TITLE + " = '" + title + "'";

        database.execSQL(sql);

    }

}
