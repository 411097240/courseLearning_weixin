package com.able.courseLearning_weixin.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    /**
     *
     * @Title：getSystemDateByYmd
     * @Description: 获得格式化后的日期（yyy-MM-dd）的系统时间
     * @return 格式化后的日期（yyy-MM-dd）的系统时间
     */
    public static String getSystemDateByYmd() throws ParseException{
        Date d = new Date();//获取时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String ymd = sdf.format(d);
        return ymd ;
    }
    /**
     * @Title: tranDate
     * @Description: TODO(将DATE转成想要的string)
     * @param @param date
     * @param @param parm string 格式
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */

    public static String tranDate(Date date,String parm){
        String dateStr = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(parm);
            dateStr = sdf.format(date);
        } catch (Exception e) {
// TODO: handle exception
            System.out.println(e.getMessage());
        }
        return dateStr;
    }
    /**
     *
     * @Title：getSystemDateByYYYYMMDD
     * @Description: 获得格式化后的日期（yyyyMMddHHmmss）的系统时间
     * @return
     * @throws ParseException
     */
    public static String getSystemDateByYYYYMMDD() throws ParseException{
        Date d = new Date();//获取时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String ymd = sdf.format(d);
        return ymd ;
    }
    /**
     *
     * @Title：getSystemDateByYmd
     * @Description: 获得格式化后的日期（yyyMMdd）的系统时间
     * @return 格式化后的日期（yyyMMdd）的系统时间
     */
    public static String getSystemDateByyymmdd() throws ParseException{
        Date d = new Date();//获取时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(d);
        return ymd ;
    }
    /**
     *
     * @Title：getSystemDateByYmd
     * @Description: 获得格式化后的日期（MM）的系统时间
     * @return 格式化后的日期（MM）的系统时间
     */
    public static String getSystemMM() throws ParseException{
        Date d = new Date();//获取时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
        String ymd = sdf.format(d);
        return ymd ;
    }
    /**
     *
     * @Title：getSystemDateByYmd
     * @Description: 获得格式化后的日期（yyyMMdd）的系统时间
     * @return 格式化后的日期（yyyMMdd）的系统时间
     */
    public static String getSystemYY() throws ParseException{
        Date d = new Date();//获取时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String ymd = sdf.format(d);
        return ymd ;
    }
    /**
     *
     * @Title：getSystemDateByYYYYMMDD
     * @Description: 获得格式化后的日期（yyyyMMddHHmmss）的系统时间
     * @return
     * @throws ParseException
     */
    public static String getSystemDateByYYYYMMDDHHMMSSSSS() throws ParseException{
        Date d = new Date();//获取时间

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String ymd = sdf.format(d);
        return ymd ;
    }


    /**
     *
     * @Title：getSystemDateByYYYYMMDD
     * @Description: 获得格式化后的日期（根据传入的字符串格式）的系统时间
     * @return
     * @throws ParseException
     */
    public static String getSystemDateByParm(String parm) {
        String ymd =null;
        try {
            Date d = new Date();//获取时间
            SimpleDateFormat sdf=new SimpleDateFormat(parm);
            ymd = sdf.format(d);
        } catch (Exception e) {
// TODO: handle exception
        }
        return ymd ;
    }

    /**
     *
     * @Title：getMonthDayForDate
     * @Description: 根据字符型日期，获取该日期所在月份共有多少天
     * @param dateFormat 格式化后的日期（yyy-MM-dd）
     * @return 该日期所在月份共多少天
     */
    public static int getMonthDayForDate(String dateFormat) throws ParseException{
        Calendar cDay = Calendar.getInstance();
        DateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
        Date date = dd.parse(dateFormat);
        cDay.setTime(date);
        int lastDay = cDay.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDay ;
    }

    /**
     *
     * @Title：getCalendarByYearMonth
     * @Description: 根据日期（周一yyyy-MM-dd）获取本周都有哪些天。
     * @param dateFormat
     * @return
     * @throws ParseException
     */
    public static String[] getCalendarByYearMonth(String dateFormat) throws ParseException {


        Calendar cDay = Calendar.getInstance();
        DateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
        Date date = dd.parse(dateFormat);
        cDay.setTime(date);


        String[] weeks = new String[7];
        String sDay0 = ""+cDay.get(Calendar.DATE) ;
        if(sDay0.length()>1){
            weeks[0]=sDay0;
        }else{
            weeks[0]="0"+sDay0;
        }
        for (int i = 1; i < 7; i++) {
            cDay.add(Calendar.DATE, 1);
            String sDay = ""+cDay.get(Calendar.DATE);
            if(sDay.length()>1){
                weeks[i]=sDay;
            }else{
                weeks[i]="0"+sDay;
            }
        }

        return weeks ;
    }

    /**
     *
     * @Title：getCalendarByweek
     * @Description: 根据传递过来的日期，返回当前日期所在周的时间段
     * @param dateFormat 日期（"2014-09-19"）
     * @return
     * @throws ParseException
     */
    public static String[] getCalendarByweek(String dateFormat) throws ParseException{
        String[] resultarr = new String[2] ;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = Calendar.getInstance();

        Date d = sdf.parse(dateFormat);

        cl.setTime(d); //nd为传过来的日期，Date 型，此步可省为当前日期
        int day_of_week = cl.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        cl.add(Calendar.WEEK_OF_MONTH, 0); //idx 参数，0为当前，1为下周 -1为上周以此类推
        cl.add(Calendar.DATE, -day_of_week + 1);
        String week1 = sdf.format(cl.getTime());//周一
        resultarr[0] = week1 ;
        //System.out.println(week1);
        cl.add(Calendar.DATE, +6);
        String week2 = sdf.format(cl.getTime());//周日
        resultarr[1] = week2 ;
        //System.out.println(week2);

        return resultarr;
    }

    /**
     *
     * @Title：getWeekForDate
     * @Description: 根据日期（yyyy-MM-dd）获得其是该月的第几周
     * @param dateFormat 日期（"2014-09-19"）
     * @return
     * @throws ParseException
     */
    public static Integer getWeekForDate(String dateFormat) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONTH);
        calendar.setTime(date);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        return weekOfMonth ;
    }

    /**
     * @Title: convertToDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param dateString 要转化的字符串
     * @param @param parms 转化后的格式，yyyy-MM-dd HH:mm:ss
     * @param @return    设定文件
     * @return Date    返回类型
     * @throws
     */
    public static Date convertToDate(String dateString,String parms){
        SimpleDateFormat df = new SimpleDateFormat(parms);
        try {
            Date date = df.parse(dateString);
            return date;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /**
     * @Title: countAge
     * @Description: TODO(计算目标日期距离系统当前日期多少天)
     * @param @param createDate yyyy-MM-dd HH:mm:ss
     * @param @return    设定文件
     * @return Long    返回类型
     * @throws
     */
    public static Long countAge(String createDate){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Long day =0l;
        try {
            String nowDate = DateUtil.getSystemDateByParm("yyyy-MM-dd");
            long to = df.parse(nowDate).getTime();
            long from = df.parse(createDate).getTime();
            day = (to - from) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return day;
    }
    /**
     * @Title: getBetweenDay
     * @Description: TODO(判断两个日期之间相差多少天)
     * @param @param date1
     * @param @param date2
     * @param @return    设定文件
     * @return int    返回类型
     * @throws
     */
    public static int getBetweenDay(Date date1, Date date2) {
        Calendar d1 = new GregorianCalendar();
        d1.setTime(date1);
        Calendar d2 = new GregorianCalendar();
        d2.setTime(date2);
        int days = d2.get(Calendar.DAY_OF_YEAR)- d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
//          d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }
    /**
     * @Title: getCompareDate
     * @Description: TODO(比较两个日期的大小，精确到秒)
     * @param @param date1
     * @param @param date2
     * @param @return    设定文件
     * @return Boolean    返回类型
     * @throws
     */
    public static Boolean getCompareDate(Date date1,Date date2){
        java.util.Calendar c1=java.util.Calendar.getInstance();
        java.util.Calendar c2=java.util.Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int result=c1.compareTo(c2);
        if (result <=0) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * @throws Exception
     * @Title: getSystemDate
     * @Description: TODO(获取yyyy-MM-dd HH:mm:ss的Date类型)
     * @param @return    设定文件
     * @return Date    返回类型
     * @throws
     */
    public static Date getSystemDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        System.out.println(date);
        Date dateSyDate = null;
        try {
            dateSyDate =  df.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return dateSyDate;
    }
    /**
     * @Title: DateDifferentExample
     * @Description: TODO(计算出两个日期之间相差多少天多少小时多少分多少秒)
     * @param @param d1
     * @param @param d2
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String DateDifferentExample (Date d1,Date d2){
        StringBuilder resultString = new StringBuilder();
        try {
            //毫秒ms
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long  diffMinutes  = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            resultString.append(diffDays+"天,");
            resultString.append(diffHours +"小时,");
            resultString.append(diffMinutes + " 分钟");
            resultString.append(diffSeconds +"秒.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString.toString();
    }
}
