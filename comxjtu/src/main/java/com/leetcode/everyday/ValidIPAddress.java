package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/29 16:54
 * @description 468. 验证IP地址
 */
public class ValidIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")){
            if (queryIP.startsWith(".") || queryIP.endsWith(".")) return "Neither";
            String[] strings = queryIP.split("\\.");

            if (strings.length!=4) return "Neither";
            for (String string : strings) {
                if(!string.matches("[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]"))
                    return "Neither";
            }
            return "IPv4";
        }else if (queryIP.contains(":")){
            if (queryIP.startsWith(":") || queryIP.endsWith(":")) return "Neither";
            String[] strings = queryIP.split(":");
            if (strings.length!=8) return "Neither";
            for (String string : strings) {
                if(string.length()>4||string.length()<1) return "Neither";
                if(!string.matches("[0-9a-fA-F]{1,4}"))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        String queryIP = "172.16.254.1";
        String[] strings = queryIP.split("\\.");
        System.out.println(validIPAddress.validIPAddress(queryIP));
        queryIP ="2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(validIPAddress.validIPAddress(queryIP));
    }
}
