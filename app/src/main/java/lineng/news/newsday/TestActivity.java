package lineng.news.newsday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import lineng.news.newsday.Util.MyButton;
import lineng.news.newsday.Util.MyView;

/**
 * Created by 繁华丶落尽 on 2016/8/3.
 */
public class TestActivity extends AppCompatActivity {
    Button button;
    MyView myview;
    MyButton but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma);
        button = (Button) findViewById(R.id.button);
        myview= (MyView) findViewById(R.id.myview);
        but= (MyButton) findViewById(R.id.mybut);
      but.setMyOnclickListener(new MyButton.MyOnclickListener() {
          @Override
          public void myOnClick(View view) {
              myview.changex();
              myview.changeY();
          }
      });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myview.changex();
                myview.changeY();
            }
        });
    }
}
