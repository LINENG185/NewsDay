package lineng.news.newsday.Util;

/**
 * Created by 繁华丶落尽 on 2016/7/28.
 */
public class item {
    public item() {
    }

    private  String mandroid="安卓";
    private  String sichuan="四川";
    private   String constellation="星座";
    private  String military="军事";
    private   String internet="互联网";
    private   String hotspot="热点";

    @Override
    public String toString() {
        return "item{" +
                "mandroid='" + mandroid + '\'' +
                ", sichuan='" + sichuan + '\'' +
                ", constellation='" + constellation + '\'' +
                ", military='" + military + '\'' +
                ", internet='" + internet + '\'' +
                ", hotspot='" + hotspot + '\'' +
                '}';
    }

    public String getMandroid() {
        return mandroid;
    }

    public void setMandroid(String mandroid) {
        this.mandroid = mandroid;
    }

    public String getSichuan() {
        return sichuan;
    }

    public void setSichuan(String sichuan) {
        this.sichuan = sichuan;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getMilitary() {
        return military;
    }

    public void setMilitary(String military) {
        this.military = military;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getHotspot() {
        return hotspot;
    }

    public void setHotspot(String hotspot) {
        this.hotspot = hotspot;
    }

    public item(String mandroid, String sichuan, String constellation, String military, String internet, String hotspot) {
        this.mandroid = mandroid;
        this.sichuan = sichuan;
        this.constellation = constellation;
        this.military = military;
        this.internet = internet;
        this.hotspot = hotspot;
    }
}
