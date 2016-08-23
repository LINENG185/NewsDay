package lineng.news.newsday.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import lineng.news.newsday.MainActivity;
import lineng.news.newsday.R;
import lineng.news.newsday.Util.ShareUtil;
import lineng.news.newsday.Util.item;
import lineng.news.newsday.adapter.tabAndPagerAdapter;
import lineng.news.newsday.addActivity;

/**
 * Created by 繁华丶落尽 on 2016/7/27.
 */
public class One extends Fragment {
    private item mItem;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> title;
    private ArrayList<Fragment> fragments;
    tabAndPagerAdapter adapter;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), addActivity.class);
                startActivityForResult(intent, 110);
            }
        });
        initData();
        ShareUtil.getInstance(getContext());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(4);


        return view;

    }

    Two two;
    Thread thread;
    Bundle bundle;

    public void initData() {
        mItem = new item();
        title = new ArrayList<String>();
        fragments = new ArrayList<Fragment>();
        String titl = ShareUtil.getInstance(getContext()).getData();
        title.add(titl);
        title.add(mItem.getSichuan());
        title.add(mItem.getMandroid());
        title.add(mItem.getMilitary());
        title.add(mItem.getInternet());
        title.add(mItem.getConstellation());
        title.add(mItem.getHotspot());
        for (int i = 0; i < title.size(); i++) {
            two = new Two();
            thread = new Thread();
            bundle = new Bundle();
            bundle.putString("title", title.get(i));
            two.setArguments(bundle);
            fragments.add(two);
        }
        adapter = new tabAndPagerAdapter(getChildFragmentManager(), title, fragments);
    }

    public void uptitle() {
        String titl = ShareUtil.getInstance(getContext()).getData();
        title.add(titl);
        two = new Two();
        bundle = new Bundle();
        bundle.putString("titl", titl);
        two.setArguments(bundle);
        fragments.add(two);
        adapter.notifyDataSetChanged();


    }

}