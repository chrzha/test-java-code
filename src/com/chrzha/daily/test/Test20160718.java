package com.chrzha.daily.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Test20160718 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String forwardedIp = "*,192.168.179.3212s,dscd";
        String ipReg = "\\d+\\.\\d+\\.\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(ipReg);
        String[] ipArray = forwardedIp.split(",");
        String userLocalIp = "123";

        for (int i = 0; i < ipArray.length; i++) {
            Matcher matcher = pattern.matcher(ipArray[i]);
            if (matcher.matches()) {
                userLocalIp = ipArray[i];
                break;
            }
        }

        System.out.println(userLocalIp);
    }

    private static long convertIPToNumber(String ip) {
        if (ip != null && !"".equals(ip)) {
            ip = ip.trim();

            String[] subArr = ip.split("\\.");
            long o1 = Long.valueOf(subArr[0]);
            long o2 = Long.valueOf(subArr[1]);
            long o3 = Long.valueOf(subArr[2]);
            long o4 = Long.valueOf(subArr[3]);

            long ipNum = (16777216 * o1) + (65536 * o2) + (256 * o3) + o4;
            return ipNum;
        }
        return -1;
    }

}
