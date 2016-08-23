package lineng.news.newsday.Util;

import java.util.List;

/**
 * Created by 繁华丶落尽 on 2016/8/4.
 */
public class twoinfo {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-08-04 10:28","title":"App Store迎来新里程碑：已向开发者支付500亿美元","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461793474_300240/0","url":"http://tech.qq.com/a/20160804/018581.htm"},{"ctime":"2016-08-04 07:57","title":"这段视频中的手机或许就是iPhone 7 Plus","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461393879_300240/0","url":"http://tech.qq.com/a/20160804/006441.htm"},{"ctime":"2016-08-04 08:41","title":"媒体揭空中巴士疑理财骗局 总设计师仅小学文化","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461451954_300240/0","url":"http://tech.qq.com/a/20160804/009622.htm"},{"ctime":"2016-08-04 08:54","title":"发改委反垄断局：关注滴滴优步并购会否涉及价格垄断","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461525052_300240/0","url":"http://tech.qq.com/a/20160804/010578.htm"},{"ctime":"2016-08-03 19:31","title":"三星Note 7的这八个功能 iPhone没有","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/460647931_300240/0","url":"http://tech.qq.com/a/20160803/042602.htm"},{"ctime":"2016-08-04 06:55","title":"虚拟现实大众化 光靠设备降价还不够","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461340027_300240/0","url":"http://digi.tech.qq.com/a/20160804/003348.htm"},{"ctime":"2016-08-04 07:01","title":"别人家的月亮不仅有活火山 还会\u201c下雪结霜\u201d","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461377104_300240/0","url":"http://tech.qq.com/a/20160804/003527.htm"},{"ctime":"2016-08-04 07:09","title":"科学家：2015年地球\u201c体检报告\u201d非常糟糕","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461376944_300240/0","url":"http://tech.qq.com/a/20160804/003879.htm"},{"ctime":"2016-08-04 07:23","title":"科学家讨论打造新的探测器接替卡西尼号","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461376814_300240/0","url":"http://tech.qq.com/a/20160804/004568.htm"},{"ctime":"2016-08-04 07:14","title":"最新研究表明银河系中心严重缺少年轻恒星","description":"腾讯科技","picUrl":"http://inews.gtimg.com/newsapp_ls/0/461376881_300240/0","url":"http://tech.qq.com/a/20160804/004117.htm"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-08-04 10:28
     * title : App Store迎来新里程碑：已向开发者支付500亿美元
     * description : 腾讯科技
     * picUrl : http://inews.gtimg.com/newsapp_ls/0/461793474_300240/0
     * url : http://tech.qq.com/a/20160804/018581.htm
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
