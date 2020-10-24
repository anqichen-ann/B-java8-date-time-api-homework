package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static LocalDate getNextWorkDate(LocalDate date) {
    ZonedDateTime zdt = date.atStartOfDay(ZoneId.systemDefault());
    Date newDate = Date.from(zdt.toInstant());
    Calendar cal= Calendar.getInstance();
    cal.setTime(newDate);
    int weekDay = cal.get(Calendar.DAY_OF_WEEK);
    int plusDay;
    if (weekDay >= 1 && weekDay <= 5){
      plusDay =1;
    }else if(weekDay == 6){
      plusDay = 3;
    }else {
      plusDay = 2;
    }
    return date.plusDays(plusDay);
  }
}
