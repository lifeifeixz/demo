package com.baixiang.chuxing.user.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * .
 * 
 * <pre><b>描述：</b>
 *    
 * </pre>
 * 
 * <pre><b>修改记录：</b>
 *    
 * </pre>
 * 
 * @author <a href="mailto:littcai@hotmail.com">蔡源</a>
 * @since 2013-11-20
 * @version 1.0
 */
public class JsonUtils {
	
private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		//objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static String toJSON(Object obj) throws IOException
	{
		String ret = objectMapper.writeValueAsString(obj);
		return ret;
	}	
	
	public static <T> T toObject(String jsonString,  Class<T> clazz) throws IOException
	{		
		return objectMapper.readValue(jsonString, clazz);
	}
	
	public static JsonNode toJsonNode(String jsonString) throws IOException
	{		
		return objectMapper.readTree(jsonString);
	}
	
	public static <T> List<T> toList(String jsonString) throws IOException
  {    
    List<T> list = objectMapper.readValue(jsonString, new TypeReference<List<T>>(){});
    return list;
  }
	
	public static <T> List<T> toList(String jsonString, Class<T> clazz) throws IOException
  {    
	 if(StringUtils.isEmpty(jsonString)){
		 return null;
	 }
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);// clz.selGenType().getClass()
	  
    List<T> list = objectMapper.readValue(jsonString, javaType);
    return list;
  }
	
	public static Map<String, ?> toMap(String jsonString) throws IOException
  {   
	  Map<String, Object> map = new HashMap<String, Object>();

    // convert JSON string to Map
    map = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>(){});
    return map;
  }

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", new Integer(1));
		paramMap.put("code", "0001");
		paramMap.put("age", 18);
		paramMap.put("createDatetime", new Date());
		
		String jsonString = JsonUtils.toJSON(paramMap);
		System.out.println(jsonString);
		
		Map<String, Object> newMap = JsonUtils.toObject(jsonString, Map.class);
		System.out.println(paramMap.get("id"));
		System.out.println(paramMap.get("code"));
		System.out.println(paramMap.get("age"));
		System.out.println(paramMap.get("createDatetime"));
		
//		HelloWorld newHelloWorld = (HelloWorld)JsonUtils.toObject(jsonString, HelloWorld.class);
//		System.out.println(newHelloWorld);
	}

}
