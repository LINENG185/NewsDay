package lineng.news.newsday.Util;

import java.util.List;

/**
 * Created by 繁华丶落尽 on 2016/8/1.
 */
public class Info {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-08-04 11:20","title":"准大一新生骑摩托 疑被洒水车冲倒碾亡","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/9/92/92EE2742A62F22E6398438EF33A13B7C.jpg.119x83.jpg","url":"http://news.163.com/16/0804/11/BTKDDQCO00011229.html#f=slist"},{"ctime":"2016-08-04 11:23","title":"年轻女子提供女友出租服务:被强奸还遭窃","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/8/4/201608041006240f622.jpg.119x83.jpg","url":"http://news.163.com/16/0804/11/BTKDJO2800011229.html#f=slist"},{"ctime":"2016-08-04 11:53","title":"天津公安首次跨国追击电信诈骗 39名嫌犯被批捕","description":"网易社会","picUrl":"http://s.cimg.163.com/photo/0001/2016-08-04/t_BTKAO0AF00AP0001.jpg.119x83.jpg","url":"http://news.163.com/16/0804/11/BTKFAL5Q00014JB5.html#f=slist"},{"ctime":"2016-08-04 12:12","title":"陕西缉毒警车抓捕涉毒分子时，涉毒车辆被撞致村民1死1","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/8/4/20160804111912d8911.jpg.119x83.jpg","url":"http://news.163.com/16/0804/12/BTKGE6AA00014SEH.html#f=slist"},{"ctime":"2016-08-04 12:24","title":"女子为与消失8年男友复合 拐骗堂哥儿子逼其叫妈","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/0/03/0328029F0EDD1EA783D77B0E39E63BF0.jpg.119x83.jpg","url":"http://news.163.com/16/0804/12/BTKH43GV00011229.html#f=slist"},{"ctime":"2016-08-04 12:44","title":"香港一家北海道自驾发生车祸 导致一死三伤","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/8/4/2016080412232346103_550.jpg.119x83.jpg","url":"http://news.163.com/16/0804/12/BTKI8VJE0001124J.html#f=slist"},{"ctime":"2016-08-04 09:12","title":"中国留学生在美开豪车狂飙被捕 美网友:有钱无脑","description":"网易社会","picUrl":"http://s.cimg.163.com/cnews/2016/8/4/20160804090352a6355.jpg.119x83.jpg","url":"http://news.163.com/16/0804/09/BTK63D2Q00014JB6.html#f=slist"},{"ctime":"2016-08-04 09:36","title":"陕西一中学52人毕业证没钢印 因低于分数线入学","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/D/D6/D6DCEE37976B8C6F39D49D0056BA8D79.jpg.119x83.jpg","url":"http://news.163.com/16/0804/09/BTK7GFSP00014SEH.html#f=slist"},{"ctime":"2016-08-04 09:53","title":"成都：恋人玩浪漫约会金马河 遇上游放水险被冲走","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/0/04/040FCC5429D7EDCC1EA51BBD8E8DCA2E.jpg.119x83.jpg","url":"http://news.163.com/16/0804/09/BTK8F0MB00014SEH.html#f=slist"},{"ctime":"2016-08-04 10:08","title":"乘客出租车上找不到安全带 司机:没用就拆掉了","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/9/92/92EE2742A62F22E6398438EF33A13B7C.jpg.119x83.jpg","url":"http://news.163.com/16/0804/10/BTK99OP400011229.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-08-04 11:20
     * title : 准大一新生骑摩托 疑被洒水车冲倒碾亡
     * description : 网易社会
     * picUrl : http://s.cimg.163.com/catchpic/9/92/92EE2742A62F22E6398438EF33A13B7C.jpg.119x83.jpg
     * url : http://news.163.com/16/0804/11/BTKDDQCO00011229.html#f=slist
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
