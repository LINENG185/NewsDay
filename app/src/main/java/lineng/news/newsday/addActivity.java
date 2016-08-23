package lineng.news.newsday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import lineng.news.newsday.Util.ShareUtil;

/**
 * Created by 繁华丶落尽 on 2016/7/29.
 */
public class addActivity extends Activity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addactivity);
        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText() == null || editText.getText().toString().equals("")) {
                    Snackbar.make(v, "无内容", Snackbar.LENGTH_LONG).show();
                } else {
                    String titl = editText.getText().toString();
//                    Intent intent = new Intent();
//                    intent.putExtra("titl", titl);
                    ShareUtil.getInstance(addActivity.this).setData(titl);
                    setResult(210, getIntent());
                   finish();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        String titl = editText.getText().toString();
//        Intent intent = new Intent();
//        intent.putExtra("titl", titl);
        ShareUtil.getInstance(addActivity.this).setData(titl);
        setResult(210, getIntent());
        super.onBackPressed();
    }
}
