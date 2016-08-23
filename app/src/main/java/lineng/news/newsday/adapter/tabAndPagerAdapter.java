package lineng.news.newsday.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 繁华丶落尽 on 2016/7/28.
 */
public class tabAndPagerAdapter extends FragmentPagerAdapter {
    ArrayList<String> title;
    ArrayList<Fragment> fragments;

    public tabAndPagerAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> fragments) {
        super(fm);
        this.title = title;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return title.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
