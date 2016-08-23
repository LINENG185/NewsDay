package lineng.news.newsday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TableLayout;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

import lineng.news.newsday.Util.DBUtil;
import lineng.news.newsday.Util.DbInfo;
import lineng.news.newsday.adapter.LikeAdapter;
import lineng.news.newsday.adapter.ThreeAdapter;
import lineng.news.newsday.adapter.tabAndPagerAdapter;

public class LikeActivity extends AppCompatActivity {
    private RecyclerView like_view;
    private LikeAdapter adapter;
    private ArrayList<DbInfo> list=new ArrayList<>();
    RequestQueue mRequestQueue;
    private DBUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        like_view = (RecyclerView) findViewById(R.id.like_view);
        util=DBUtil.getsInstance(getBaseContext());
        list=util.getNews();
        adapter = new LikeAdapter(list,mRequestQueue);
        adapter.notifyDataSetChanged();
        like_view.setLayoutManager(new LinearLayoutManager(this));
        like_view.setAdapter(adapter);
        String liketitle=getIntent().getStringExtra("liketitle");
        list.remove(liketitle);
        adapter.notifyDataSetChanged();
      adapter.setItemOnclikckListener(new LikeAdapter.OnClikckListener() {
          @Override
          public void ItemOnclikck(int position) {
              Intent intent = new Intent(getBaseContext(), detaleActivity.class);
              intent.putExtra("url",list.get(position).getUrl());
              intent.putExtra("title",list.get(position).getTitle());
              startActivity(intent);
              finish();
          }
      });

    }
}
