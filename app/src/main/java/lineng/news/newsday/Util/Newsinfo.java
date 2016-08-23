package lineng.news.newsday.Util;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/7/27.
 */
public class Newsinfo {
    private String message;
    private int status;
    private ArrayList<News> data;

    public Newsinfo() {
    }

    public Newsinfo(String message, int status, ArrayList<News> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<News> getData() {
        return data;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
    }
}
