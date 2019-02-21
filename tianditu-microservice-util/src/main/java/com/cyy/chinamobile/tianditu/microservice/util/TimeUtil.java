package com.cyy.chinamobile.tianditu.microservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TimeUtil
 * @author: WangChao
 * @description: 时间工具类
 * @date: 下午 3:57 2017/12/11 0011
 */
public class TimeUtil {
    /**设置日期格式*/
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    /**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTimeString
     * @param endTimeString
     * @return
     */
    public static boolean belongCalendar(Date nowTime, String beginTimeString, String endTimeString) throws ParseException {

        Date beginTime = simpleDateFormat.parse(beginTimeString);
        Date endTime = simpleDateFormat.parse(endTimeString);

        return belongCalendar(nowTime, beginTime, endTime);
    }

    /**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) throws ParseException {
        nowTime = simpleDateFormat.parse(simpleDateFormat.format(nowTime));
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
