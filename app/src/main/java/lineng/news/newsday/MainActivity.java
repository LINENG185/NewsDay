package lineng.news.newsday;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import lineng.news.newsday.Fragment.One;
import lineng.news.newsday.Fragment.Three;
import lineng.news.newsday.Fragment.Two;
import lineng.news.newsday.Util.ShareUtil;
import lineng.news.newsday.adapter.recyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fm;
    FragmentTransaction ft;
    One one;
    Two two;
    Three three;
    RelativeLayout one1, one2, one3;
    private TextView tc;
    private DrawerLayout drawe;
    private NavigationView navig;
    private ImageView iv_user;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tc.setText((String) msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        one = new One();
        two = new Two();
        three = new Three();
        ft.add(R.id.ll, one).add(R.id.ll, two).add(R.id.ll, three);
        ft.hide(one).hide(two).hide(three);
        ft.show(one);
        ft.commit();


        setContentView(R.layout.activity_main);
        tc = (TextView) findViewById(R.id.tc);
        drawe = (DrawerLayout) findViewById(R.id.drawer);
        navig = (NavigationView) findViewById(R.id.naviga);
        one1 = (RelativeLayout) findViewById(R.id.one1);
        one2 = (RelativeLayout) findViewById(R.id.one2);
        one3 = (RelativeLayout) findViewById(R.id.one3);
        one1.setOnClickListener(this);
        one2.setOnClickListener(this);
        one3.setOnClickListener(this);

        navig.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_menu1:
                        Intent intent = new Intent(getBaseContext(), LikeActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        Date curData = new Date(System.currentTimeMillis());
                        String str = format.format(curData);
                        handler.sendMessage(handler.obtainMessage(1000, str));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        iv_user = (ImageView) navig.getHeaderView(0).findViewById(R.id.iv_user);

        iv_user.setImageBitmap(recyclerViewAdapter.creatCirclepic(BitmapFactory.decodeResource(getResources(), R.drawable.user)));
        Toolbar tb = (Toolbar) findViewById(R.id.tb);
        tb.setTitle("  新闻天天看");
        setSupportActionBar(tb);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawe, tb, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawe.addDrawerListener(toggle);

    }

    @Override
    public void onBackPressed() {
        if (drawe.isDrawerOpen(GravityCompat.START)) {
            drawe.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        ft = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.one1:
                ft.hide(one).hide(two).hide(three);
                ft.show(one);
                break;
            case R.id.one2:
                ft.hide(one).hide(two).hide(three);
                ft.show(two);
                break;
            case R.id.one3:
                ft.hide(one).hide(two).hide(three);
                ft.show(three);
                break;
        }
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        one.uptitle();

    }
}
