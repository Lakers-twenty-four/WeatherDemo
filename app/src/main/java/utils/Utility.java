package utils;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.City;
import db.County;
import db.Province;
import gson.Weather;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean hanldeProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvbince = new JSONArray(response);
                for(int i=0;i<allProvbince.length();i++){
                    JSONObject provinceObjrct = allProvbince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObjrct.getString("name"));
                    province.setProvinceCode(provinceObjrct.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean hanldeCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCity = new JSONArray(response);
                for(int i=0;i<allCity.length();i++){
                    JSONObject cityObjrct = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObjrct.getString("name"));
                    city.setCityCode(cityObjrct.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 解析和处理服务器返回的县级数据
     */

    public static boolean hanldeCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounty = new JSONArray(response);
                for(int i=0;i<allCounty.length();i++){
                    JSONObject countyObjrct = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObjrct.getString("name"));
                    county.setWeatherId(countyObjrct.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 將返回的 JSON 数据解析成 Weather 实体类
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.get(0).toString();
            return  new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
