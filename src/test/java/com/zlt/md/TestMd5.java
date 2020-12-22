package com.zlt.md;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/11/25 20:43
 * @version: 1.0
 * @modified By:
 */
public class TestMd5 {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex()); //十六进制的32位

        Md5Hash md5Hash1 = new Md5Hash("123", "@#%$@$%&");
        System.out.println(md5Hash1.toHex());

        Md5Hash md5Hash2 = new Md5Hash("123", "@#%$@$%&", 1024);
        System.out.println(md5Hash2.toHex());
    }
}
