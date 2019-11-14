package com.wmp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Date date = new Date(1339856904*1000L);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        System.out.println(df.format(date));

    }
}


