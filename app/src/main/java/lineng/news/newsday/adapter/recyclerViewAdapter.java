package lineng.news.newsday.adapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import lineng.news.newsday.R;
import lineng.news.newsday.Util.Info;
import lineng.news.newsday.Util.News;
import lineng.news.newsday.Util.twoinfo;

/**
 * Created by 繁华丶落尽 on 2016/7/27.
 */
public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ItemViewHolder> {
    private ArrayList<twoinfo.NewslistBean> datas;
    private RequestQueue mRequestQueue;

    public void setList(ArrayList<twoinfo.NewslistBean> list) {
        this.datas = list;
        notifyDataSetChanged();
    }

    public recyclerViewAdapter(ArrayList<twoinfo.NewslistBean> datas, RequestQueue mRequestQueue) {
        this.datas = datas;
        this.mRequestQueue = mRequestQueue;


        int l = (int) (Runtime.getRuntime().totalMemory() / 8);
        mLruCache = new LruCache<>(l);
    }

    @Override
    public recyclerViewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(recyclerViewAdapter.ItemViewHolder holder, final int position) {
        holder.tv.setText(datas.get(position).getTitle());
        SetImagepic(holder.iv, datas.get(position).getPicUrl());


    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listener.ItemOnclikck(position);
        }
    });
}

public interface ItemOnclikckListener{
    void ItemOnclikck(int position);
}
    private ItemOnclikckListener listener;
    public void setItemOnclikckListener(ItemOnclikckListener listener){
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_item);
            tv = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }


    private void SetImagepic(final ImageView imageView, final String url) {
        imageView.setTag(url);
        ImageLoader imageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return mLruCache.get(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {
                mLruCache.put(s, bitmap);
            }
        });
        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {
                if (imageContainer.getBitmap() == null) {
                    return;
                }
                if (imageView.getTag().toString().equals(url)) {
                    imageView.setImageBitmap(creatCirclepic(imageContainer.getBitmap()));
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }
        });
    }

    private LruCache<String, Bitmap> mLruCache;


    public static Bitmap creatCirclepic(Bitmap bm) {
        Paint paint = new Paint();//画笔
        paint.setAntiAlias(true);//抗锯齿
        int min = Math.min(bm.getHeight(), bm.getWidth());
        Bitmap target = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);//圆形
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bm, 0, 0, paint);
        return target;
    }

    public Bitmap creatRectflepic(Bitmap bm) {
        Paint paint = new Paint();//画笔
        paint.setAntiAlias(true);//抗锯齿

        Bitmap target = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        RectF rectF = new RectF(0, 0, bm.getWidth(), bm.getHeight());//矩形
        canvas.drawRoundRect(rectF, 20, 20, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bm, 0, 0, paint);
        return target;
    }
}

