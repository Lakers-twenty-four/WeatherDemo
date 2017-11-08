package gson;

/**
 * Created by Administrator on 2017/9/22 0022.
 */

public class Basic {

    /**
     * city : 北京
     * cnty : 中国
     * id : CN101010100
     * lat : 39.90498734
     * lon : 116.40528870
     * update : {"loc":"2017-09-22 09:47","utc":"2017-09-22 01:47"}
     */

    private String city;
    private String cnty;
    private String id;
    private String lat;
    private String lon;
    /**
     * loc : 2017-09-22 09:47
     * utc : 2017-09-22 01:47
     */

    private UpdateBean update;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    public static class UpdateBean {
        private String loc;
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }
}
