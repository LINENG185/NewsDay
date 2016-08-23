package lineng.news.newsday.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lineng.news.newsday.R;
import lineng.news.newsday.Util.Info;
import lineng.news.newsday.adapter.ThreeAdapter;
import lineng.news.newsday.detaleActivity;

/**
 * Created by 繁华丶落尽 on 2016/7/27.
 */
public class Three extends Fragment{

    private RecyclerView recy;
    private ThreeAdapter adapter;
    private SwipeRefreshLayout swipe;
    RequestQueue mRequestQueue;
    private ArrayList<Info.NewslistBean> datas=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two, container, false);

    }
    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        recy = (RecyclerView) view.findViewById(R.id.recy_News);
        swipe = (SwipeRefreshLayout) view.findViewById(R.id.swipe);

        mRequestQueue = Volley.newRequestQueue(getContext());
        adapter=new ThreeAdapter(datas,mRequestQueue);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        recy.setAdapter(adapter);
        adapter.setItemOnclikckListener(new ThreeAdapter.ClikckListener() {
            @Override
            public void ItemOnclikck(int position) {

                Intent intent = new Intent(getContext(), detaleActivity.class);
                intent.putExtra("url",datas.get(position).getUrl());
                startActivity(intent);
            }
        });
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "刷新中", Toast.LENGTH_SHORT).show();
                getStringRr();
            }
        });
        getStringRr();
    }
//        int i =1;
    public void getStringRr() {
        String url = "http://apis.baidu.com/txapi/social/social?num=10&page=1";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Info info=new Gson().fromJson(s,Info.class);
                datas.addAll(info.getNewslist());
                adapter.setList(datas);
                swipe.setRefreshing(false);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                swipe.setRefreshing(false);
                Log.d("debug", volleyError.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                 Map<String,String>getHeaders=new HashMap<>();
                getHeaders.put("apikey","32f540a7ab16c7cf8ebb06896fbc6524");
                return getHeaders;
            }
        };
        mRequestQueue.add(request);
    }

}
