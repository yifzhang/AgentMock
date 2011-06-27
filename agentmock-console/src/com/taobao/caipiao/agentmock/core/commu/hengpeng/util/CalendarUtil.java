package com.taobao.caipiao.agentmock.core.commu.hengpeng.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.alibaba.common.lang.StringUtil;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

/**
 * @author youshan
 */
public class CalendarUtil {
    private static final Logger logger = LoggerFactory.getLogger(CalendarUtil.class);
    
    /** new a Calendar instance */
    static GregorianCalendar cldr = new GregorianCalendar();

    /** the milli second of a day */
    public static final long DAYMILLI = 24 * 60 * 60 * 1000;

    /** the milli seconds of an hour */
    public static final long HOURMILLI = 60 * 60 * 1000;

    /** the milli seconds of a minute */
    public static final long MINUTEMILLI = 60 * 1000;

    /** the milli seconds of a second */
    public static final long SECONDMILLI = 1000;

    /** added time */
    public static final String TIMETO = " 23:59:59";

    /**
     * set the default time zone
     */
    static {
        cldr.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9:00"));
    }

    /** flag before */
    public static final transient int BEFORE = 1;

    /** flag after */
    public static final transient int AFTER = 2;

    /** flag equal */
    public static final transient int EQUAL = 3;

    /** date format dd/MMM/yyyy:HH:mm:ss +0900 */
    public static final String TIME_PATTERN_LONG = "dd/MMM/yyyy:HH:mm:ss +0900";

    /** date format dd/MM/yyyy:HH:mm:ss +0900 */
    public static final String TIME_PATTERN_LONG2 = "dd/MM/yyyy:HH:mm:ss +0900";

    /** date format yyyy-MM-dd HH:mm:ss */
    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /** date format YYYY-MM-DD HH24:MI:SS */
    public static final String DB_TIME_PATTERN = "YYYY-MM-DD HH24:MI:SS";

    /** date format dd/MM/yy HH:mm:ss */
    public static final String TIME_PATTERN_SHORT = "dd/MM/yy HH:mm:ss";

    /** date format dd/MM/yy HH24:mm */
    public static final String TIME_PATTERN_SHORT_1 = "yyyy/MM/dd HH:mm";

    /** date format yyyyMMddHHmmss */
    public static final String TIME_PATTERN_SESSION = "yyyyMMddHHmmss";

    /** date format yyyyMMdd */
    public static final String DATE_FMT_0 = "yyyyMMdd";

    /** date format yyyy/MM/dd */
    public static final String DATE_FMT_1 = "yyyy/MM/dd";

    /** date format yyyy/MM/dd hh:mm:ss */
    public static final String DATE_FMT_2 = "yyyy/MM/dd hh:mm:ss";

    /** date format yyyy-MM-dd */
    public static final String DATE_FMT_3 = "yyyy-MM-dd";

    /**
     * change string to date
     * 将String类型的日期转成Date类型
     * @param sDate the date string
     * @param sFmt the date format
     *
     * @return Date object
     */
    public static java.util.Date toDate(String sDate, String sFmt) {
        if (StringUtil.isBlank(sDate) || StringUtil.isBlank(sFmt)) {
            return null;
        }
        
        SimpleDateFormat sdfFrom = null;
        java.util.Date   dt = null;
        try {
            sdfFrom     = new SimpleDateFormat(sFmt);
            dt          = sdfFrom.parse(sDate);
        } catch (Exception ex) {
            logger.error(ex, ex);
            return null;
        } finally {
            sdfFrom = null;
        }

        return dt;
    }

    /**
     * change date to string
     * 将日期类型的参数转成String类型
     * @param dt a date
     *
     * @return the format string
     */
    public static String toString(java.util.Date dt) {
        return toString(dt, DATE_FMT_0);
    }

    /**
     * change date object to string
     * 将String类型的日期转成Date类型
     * @param dt date object
     * @param sFmt the date format
     *
     * @return the formatted string
     */
    public static String toString(java.util.Date dt, String sFmt) {
        if (null == dt || StringUtil.isBlank(sFmt)) {
            return null;
        }
        
        SimpleDateFormat sdfFrom = null;
        String           sRet = null;
        try {
            sdfFrom     = new SimpleDateFormat(sFmt);
            sRet        = sdfFrom.format(dt).toString();
        } catch (Exception ex) {
            logger.error(ex, ex);
            return null;
        } finally {
            sdfFrom = null;
        }

        return sRet;
    }

    /**
     * 获取Date所属月的最后一天日期
     * @param date
     * @return Date 默认null
     */
    public static Date getMonthLastDate(Date date) {
        if (null == date) {
            return null;
        }
        
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        ca.add(Calendar.MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, -1);

        Date lastDate = ca.getTime();
        return lastDate;
    }

    /**
     * 获取Date所属月的最后一天日期
     * @param date
     * @param pattern
     * @return String 默认null
     */
    public static String getMonthLastDate(Date date, String pattern) {
        Date lastDate = getMonthLastDate(date);
        if (null == lastDate) {
            return null;
        }
        
        if (StringUtil.isBlank(pattern)) {
            pattern = TIME_PATTERN;
        }
        
        return toString(lastDate, pattern);
    }

    /**
     * 获取Date所属月的第一天日期
     * @param date
     * @return Date 默认null
     */
    public static Date getMonthFirstDate(Date date) {
        if (null == date) {
            return null;
        }
        
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.DAY_OF_MONTH, 1);

        Date firstDate = ca.getTime();
        return firstDate;
    }

    /**
     * 获取Date所属月的第一天日期
     * @param date
     * @param pattern
     * @return String 默认null
     */
    public static String getMonthFirstDate(Date date, String pattern) {
        Date firstDate = getMonthFirstDate(date);
        if (null == firstDate) {
            return null;
        }
        
        if (StringUtil.isBlank(pattern)) {
            pattern = TIME_PATTERN;
        }
        
        return toString(firstDate, pattern);
    }

    /**
     * 计算两个日期间隔的天数
     * 
     * @param firstDate 小者
     * @param lastDate 大者
     * @return int 默认-1
     */
    public static int getIntervalDays(java.util.Date firstDate, java.util.Date lastDate) {
        if (null == firstDate || null == lastDate) {
            return -1;
        }
        
        long intervalMilli = lastDate.getTime() - firstDate.getTime();
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

    /**
     * 计算两个日期间隔的小时数
     * 
     * @param firstDate 小者
     * @param lastDate 大者
     * @return int 默认-1
     */
    public static int getTimeIntervalHours(Date firstDate, Date lastDate) {
        if (null == firstDate || null == lastDate) {
            return -1;
        }
        
        long intervalMilli = lastDate.getTime() - firstDate.getTime();
        return (int) (intervalMilli / (60 * 60 * 1000));
    }

    /**
     * 计算两个日期间隔的分钟数
     * 
     * @param firstDate 小者
     * @param lastDate 大者
     * @return int 默认-1
     */
    public static int getTimeIntervalMins(Date firstDate, Date lastDate) {
        if (null == firstDate || null == lastDate) {
            return -1;
        }
        
        long intervalMilli = lastDate.getTime() - firstDate.getTime();
        return (int) (intervalMilli / (60 * 1000));
    }

    /**
     * format the date in given pattern 格式化日期
     * 
     * @param d date
     * @param pattern time pattern
     * @return the formatted string
     */
    public static String formatDate(java.util.Date d, String pattern) {
        if (null == d || StringUtil.isBlank(pattern)) {
            return null;
        }
        
        SimpleDateFormat formatter = (SimpleDateFormat) DateFormat.getDateInstance();

        formatter.applyPattern(pattern);
        return formatter.format(d);
    }

    /**
     * 比较两个日期的先后顺序
     * @param src
     * @param desc
     * @return
     */
    public static int compareDate(java.util.Date src, java.util.Date desc) {
        if ((src == null) && (desc == null)) {
            return EQUAL;
        } else if (desc == null) {
            return BEFORE;
        } else if (src == null) {
            return AFTER;
        } else {
            long timeSrc  = src.getTime();
            long timeDesc = desc.getTime();

            if (timeSrc == timeDesc) {
                return EQUAL;
            } else {
                return (timeDesc > timeSrc) ? AFTER
                                            : BEFORE;
            }
        }
    }

    /**
     * 比较两个日期的先后顺序
     *
     * @param first date1
     * @param second date2
     *
     * @return EQUAL  - if equal BEFORE - if before than date2 AFTER  - if over than date2
     */
    public static int compareTwoDate(Date first, Date second) {
        if ((first == null) && (second == null)) {
            return EQUAL;
        } else if (first == null) {
            return BEFORE;
        } else if (second == null) {
            return AFTER;
        } else if (first.before(second)) {
            return BEFORE;
        } else if (first.after(second)) {
            return AFTER;
        } else {
            return EQUAL;
        }
    }

    /**
     * 比较日期是否介于两者之间
     * @param date the specified date
     * @param begin date1
     * @param end date2
     *
     * @return true  - between date1 and date2 false - not between date1 and date2
     */
    public static boolean isDateBetween(Date date, Date begin, Date end) {
        int c1 = compareTwoDate(begin, date);
        int c2 = compareTwoDate(date, end);

        return (((c1 == BEFORE) && (c2 == BEFORE)) || (c1 == EQUAL) || (c2 == EQUAL));
    }

    /**
     * 比较日期是否介于当前日期的前后数天内
     * @param myDate
     * @param begin
     * @param end
     * @return
     */
    public static boolean isDateBetween(java.util.Date myDate, int begin, int end) {
        return isDateBetween(myDate, getCurrentDateTime(), begin, end);
    }

    /**
     * 比较日期是否介于指定日期的前后数天内
     * @param utilDate
     * @param dateBaseLine
     * @param begin
     * @param end
     * @return
     */
    public static boolean isDateBetween(java.util.Date utilDate, java.util.Date dateBaseLine,
        int begin, int end) {
        String pattern = TIME_PATTERN;

        String my     = toString(utilDate, pattern);
        Date   myDate = parseString2Date(my, pattern);

        String baseLine = toString(dateBaseLine, pattern);

        //		Date baseLineDate = parseString2Date(baseLine, pattern);
        String from     = addDays(baseLine, begin);
        Date   fromDate = parseString2Date(from, pattern);

        String to     = addDays(baseLine, end);
        Date   toDate = parseString2Date(to, pattern);

        return isDateBetween(myDate, fromDate, toDate);
    }

    /**
     * change string to Timestamp
     * 字符串类型转成Timestamp
     * 如果传入的String是数字格式的则优先会转化成Long构造Date
     * @deprecated plz use <code>Calendar.toDate(String sDate, String sFmt)</code>
     * 
     * @param str formatted timestamp string
     * @param sFmt string format
     *
     * @return timestamp
     */
    public static Timestamp parseString2Timestamp(String str, String sFmt) {
        if ((str == null) || str.equals("")) {
            return null;
        }

        try {
            long time = Long.parseLong(str);

            return new Timestamp(time);
        } catch (Exception ex) {
            try {
                DateFormat     df = new SimpleDateFormat(sFmt);
                java.util.Date dt = df.parse(str);

                return new Timestamp(dt.getTime());
            } catch (Exception pe) {
                try {
                    return Timestamp.valueOf(str);
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }

    /**
     * parse a string into date  in a patter
     * 如果传入的String是数字格式的则优先会转化成Long构造Date
     * @deprecated plz use <code>Calendar.toDate(String sDate, String sFmt)</code>
     *
     * @param str string
     * @param sFmt date pattern
     *
     * @return date
     */
    @SuppressWarnings("deprecation")
    public static Date parseString2Date(String str, String sFmt) {
        if ((str == null) || str.equals("")) {
            return null;
        }

        try {
            long time = Long.parseLong(str);

            return new Date(time);
        } catch (Exception ex) {
            try {
                DateFormat     df = new SimpleDateFormat(sFmt);
                java.util.Date dt = df.parse(str);

                return new Date(dt.getTime());
            } catch (Exception pe) {
                logger.warn(pe, pe);
                try {
                    return new Date(str);
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }

    /**
     * 增加天数
     * @param date
     * @param day
     * @return Date
     */
    public static java.util.Date addDate(java.util.Date date, int day) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        return calendar.getTime();
    }

    /**
     * 增加天数
     * @param date
     * @param day
     * @param pattern
     * @return
     */
    public static String addDays(java.util.Date date, int day, String pattern) {
        return addDays(toString(date, pattern), day, pattern);
    }

    /**
     * 增加天数
     * @param date
     * @param day
     * @return
     */
    public static String addDays(java.util.Date date, int day) {
        return addDays(toString(date, TIME_PATTERN), day);
    }

    /**
     * 增加天数
     * @param date
     * @param day
     * @return
     */
    public static String addDays(String date, int day) {
        return addDays(date, day, TIME_PATTERN);
    }

    /**
     * get the time of the specified date after given days
     *
     * @param date the specified date
     * @param day day distance
     *
     * @return the format string of time
     */
    public static String addDays(String date, int day, String pattern) {
        if (date == null) {
            return "";
        }

        if (date.equals("")) {
            return "";
        }

        if (day == 0) {
            return date;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Calendar         calendar = dateFormat.getCalendar();

            calendar.setTime(dateFormat.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
            return dateFormat.format(calendar.getTime());
        } catch (Exception ex) {
            logger.error(ex, ex);
            return "";
        }
    }

    /**
     * change timestamp to formatted string
     *
     * @param t Timestamp
     * @param sFmt date format
     *
     * @return formatted string
     */
    public static String formatTimestamp(Timestamp t, String sFmt) {
        if (t == null || StringUtil.isBlank(sFmt)) {
            return "";
        }

        t.setNanos(0);

        DateFormat ft  = new SimpleDateFormat(sFmt);
        String     str = "";

        try {
            str = ft.format(t);
        } catch (NullPointerException ex) {
            logger.error(ex, ex);
        }

        return str;
    }

    /**
     * change string to Timestamp
     * 如果传入的String是数字格式的则优先会转化成Long构造Date
     * @deprecated plz use <code>Calendar.toDate(String sDate, String sFmt)</code>
     *
     * @param str formatted timestamp string
     * @param sFmt string format
     *
     * @return timestamp
     */
    public static Timestamp parseString(String str, String sFmt) {
        if ((str == null) || str.equals("")) {
            return null;
        }

        try {
            long time = Long.parseLong(str);

            return new Timestamp(time);
        } catch (Exception ex) {
            try {
                DateFormat     df = new SimpleDateFormat(sFmt);
                java.util.Date dt = df.parse(str);

                return new Timestamp(dt.getTime());
            } catch (Exception pe) {
                try {
                    return Timestamp.valueOf(str);
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }

    /**
     * return current date
     *
     * @return current date
     */
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * return current calendar instance
     *
     * @return Calendar
     */
    public static Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }

    /**
     * return current time
     *
     * @return current time
     */
    public static Timestamp getCurrentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取年份
     * @param date Date
     * @return int
     */
    public static final int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
    
    /**
     * 获取年份
     * @param millis long
     * @return int
     */
    public static final int getYear(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     * @param date Date
     * @return int
     */
    public static final int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 获取月份
     * @param millis long
     * @return int
     */
    public static final int getMonth(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期
     * @param date Date
     * @return int
     */
    public static final int getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }
    
    /**
     * 获取日期
     * @param millis long
     * @return int
     */
    public static final int getDate(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取小时
     * @param date Date
     * @return int
     */
    public static final int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    /**
     * 获取小时
     * @param millis long
     * @return int
     */
    public static final int getHour(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
     * @param date Date
     * @return Date
     */
    public static final Date zerolizedTime(Date fullDate) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(fullDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}

