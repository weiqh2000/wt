/*@Time : 2021/7/7 9:52
 *@Author : 韦佗
 *@File : MyUtil.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

    public String nowTimeStamp(String newTimeStampUnix) {
        int timeStampUnix = Integer.valueOf(newTimeStampUnix);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String result = simpleDateFormat.format(new Date(timeStampUnix * 1000L));
        return simpleDateFormat.format(new Date(timeStampUnix * 1000L));
    }
}
