package lineng.news.newsday.Util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/8/2.
 */
public class ShareUtil {
    private SharedPreferences preferences;
    private final String FILE_NAME = "title";
    private static ShareUtil shareUtil;

    private ShareUtil(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static ShareUtil getInstance(Context context) {
        if (shareUtil == null) {
            shareUtil = new ShareUtil(context);
        }
        return shareUtil;
    }

    public String getData() {

        return preferences.getString("title","");
    }

    public void setData(String titl) {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("title",titl);
        editor.commit();
    }

}
