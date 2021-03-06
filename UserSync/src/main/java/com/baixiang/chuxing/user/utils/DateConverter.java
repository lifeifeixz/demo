package com.baixiang.chuxing.user.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateConverter implements Converter<String, Date> {
	    private static final String dateFormat      = "yyyy-MM-dd HH:mm:ss";
	    private static final String shortDateFormat = "yyyy-MM-dd";
	    private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);
	    /** 
	     * @see org.springframework.core.convert.converter.Converter#convert(Object)
	     */
	    @Override
	    public Date convert(String source) {
	        if (StringUtils.isBlank(source)) {
	            return null;
	        }
	        source = source.trim();
	        try {
	            if (source.contains("-")) {
	                SimpleDateFormat formatter;
	                if (source.contains(":")) {
	                    formatter = new SimpleDateFormat(dateFormat);
	                } else {
	                    formatter = new SimpleDateFormat(shortDateFormat);
	                }
	                Date dtDate = formatter.parse(source);
	                Calendar cal = Calendar.getInstance();
	        		TimeZone timeZone = cal.getTimeZone();
	               // logger.debug("debug Trip timeZone:id=timeZone.getID() name={}",timeZone.getDisplayName());
	                return dtDate;
	            } else {
	                Long lDate = new Long(source);
	                return new Date(lDate);
	            }
	        } catch (Exception e) {
	            throw new RuntimeException(String.format("parser %s to Date fail", source));
	        }
//	        throw new RuntimeException(String.format("parser %s to Date fail", source));
	    }

	}