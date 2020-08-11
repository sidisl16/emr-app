package com.emr.app.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	private static final String DATE_FORMAT = "dd-MMM-yyyy hh:mm:ss a";
	private static SimpleDateFormat simpleDateFormat;
	static {
		simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
	}

	public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static String formatDate(Date date) {
		return simpleDateFormat.format(date);
	}
}
