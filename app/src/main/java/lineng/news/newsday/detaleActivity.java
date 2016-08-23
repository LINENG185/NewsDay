package lineng.news.newsday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;

import lineng.news.newsday.Util.DBUtil;
import lineng.news.newsday.Util.DbInfo;

/**
 * Created by 繁华丶落尽 on 2016/7/28.
 */
public class detaleActivity extends Activity {
    private WebView wv_detail;
    private ProgressBar pb_detail;
    private Button button;
    private DBUtil util;
    private ImageView btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatle);
        btn= (ImageView) findViewById(R.id.btnn);
        img= (ImageView) findViewById(R.id.img);
        wv_detail = (WebView) findViewById(R.id.wv_detail);
        pb_detail = (ProgressBar) findViewById(R.id.pb_detail);
        util=DBUtil.getsInstance(getBaseContext());
        final String title=getIntent().getStringExtra("title");
        final String url = getIntent().getStringExtra("url");
        final Serializable newsInfo = getIntent().getSerializableExtra("newsInfo");

        wv_detail.setWebViewClient(new MyClient());
        wv_detail.setWebChromeClient(new MyChrome());
        WebSettings settings = wv_detail.getSettings();
        settings.setDisplayZoomControls(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"收藏成功",Toast.LENGTH_SHORT).show();
                util.savaNews((DbInfo) newsInfo);
                Intent intent =new Intent(getBaseContext(),LikeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"取消收藏成功",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getBaseContext(),LikeActivity.class);

                startActivity(intent);
                util.deleteSQL(title);
                finish();
            }
        });

        if (url != null) {
            wv_detail.loadUrl(url);
        }
    }

    private class MyClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private class MyChrome extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress < 100) {
                pb_detail.setProgress(newProgress);
                pb_detail.setVisibility(View.VISIBLE);
            } else {
                pb_detail.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (wv_detail.canGoBack()) {
            wv_detail.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
