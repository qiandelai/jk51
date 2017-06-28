package cn.itcast.jk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SetDataUtils {

	public static <T> void set(T model, T obj) throws Exception {
		Class clazz = model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(!"serialVersionUID".equals(field.getName())){
				field.setAccessible(true);
				String fieldName = field.getName();
				String getName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
				String setName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
				Method getMethod = clazz.getMethod(getName);
				Method setMethod = clazz.getMethod(setName,field.getType());
				Object value = getMethod.invoke(model);
				if(value!=null){
					setMethod.invoke(obj,value);
				}
			}
		}
	}
	
}
