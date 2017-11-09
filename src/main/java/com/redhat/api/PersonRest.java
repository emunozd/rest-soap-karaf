package com.redhat.api;


import java.util.Date;

import java.text.SimpleDateFormat;

public class PersonRest {
	
    public String getDate(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sdf.format(date);
    }
	
}
