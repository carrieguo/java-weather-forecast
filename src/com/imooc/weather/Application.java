package com.imooc.weather;

import com.imooc.weather.impl.WeatherUtilsImpl;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("查询最近天气预报：");
        System.out.println("输入1：查询未来24小时天气预报");
        System.out.println("输入2：查询未来3天天气预报");
        System.out.println("输入3：查询未来7天天气预报");
        System.out.print("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("用户输入数字 " + i);
        if(i==1){
            System.out.print("请输入城市名称查询未来24小时天气预报：");
            String city = scanner.next();
            WeatherUtils weatherUtils = new WeatherUtilsImpl();
            List<HourWeather> weatherList = weatherUtils.w24h("6ca21db2c6f642db9fe8fb6ee49048ce", city);
            System.out.println(weatherList);
            if(weatherList.size()==0){
                System.out.println("抱歉，未收录您查询的城市天气数据。");
            }else{
                for(HourWeather hourWeather: weatherList){
                    String template = "%s月%s日%s时|%-3s|%-20s|%-8s|%-4s℃";
                    String row = String.format(template, new String[]{
                            hourWeather.getMonth(),
                            hourWeather.getDay(),
                            hourWeather.getHour(),
                            hourWeather.getWindDirection(),
                            hourWeather.getWindPower(),
                            hourWeather.getWeather(),
                            hourWeather.getTemperature()
                    });
                    System.out.println(row);
                }
            }
        } else if (i==2) {
            System.out.print("请输入城市名称查询未来3天天气预报：");
            String city = scanner.next();
            WeatherUtils weatherUtils = new WeatherUtilsImpl();
            List<DayWeather> weatherList = weatherUtils.w3d("6ca21db2c6f642db9fe8fb6ee49048ce", city);
            if(weatherList.size()==0){
                System.out.println("抱歉，未收录您查询的城市天气数据");
            } else{
                for(DayWeather weather:weatherList){
                    String template = "%-2s月%-2s日 | 气温：%s℃（日） %s℃（夜） | 天气：%s（日） %s（夜） | 风力：%s（日） %s（夜）";
                    String row = String.format(template, new String[]{
                            weather.getMonth(),
                            weather.getDay(),
                            weather.getDayAirTemperature(),
                            weather.getNightAirTemperature(),
                            weather.getDayWeather(),
                            weather.getNightWeather(),
                            weather.getDayWindPower(),
                            weather.getNightWindPower()
                    });
                    System.out.println(row);
                }
            }
        } else if(i==3){
            System.out.print("请输入城市名称查询未来7天天气预报：");
            String city = scanner.next();
            WeatherUtils weatherUtils = new WeatherUtilsImpl();
            List<DayWeather> weatherList = weatherUtils.w7d("6ca21db2c6f642db9fe8fb6ee49048ce", city);
            if(weatherList.size()==0){
                System.out.println("抱歉，未收录您查询的城市天气数据");
            } else{
                for(DayWeather dayWeather:weatherList){
                    String template = "%-2s月%-2s日 | 气温：%s℃（日） %s℃（夜） | 天气：%s（日） %s（夜） | 风力：%s（日） %s（夜）";
                    String row = String.format(template, new String[]{
                            dayWeather.getMonth(),
                            dayWeather.getDay(),
                            dayWeather.getDayAirTemperature(),
                            dayWeather.getNightAirTemperature(),
                            dayWeather.getDayWeather(),
                            dayWeather.getNightWeather(),
                            dayWeather.getDayWindPower(),
                            dayWeather.getNightWindPower()
                    });
                    System.out.println(row);
                }
            }
        }
    }
}
