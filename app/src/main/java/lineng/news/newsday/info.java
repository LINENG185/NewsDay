package lineng.news.newsday;

import java.io.Serializable;

/**
 * Created by 繁华丶落尽 on 2016/8/5.
 */
public class info implements Serializable{
    int age;
    String name;

    public info(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
