package org.timedesk.web.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorHandler 
{
	public static void addError(Object entity, BindingResult result, Exception e)
	{
		if(e.getMessage().indexOf("Duplicate entry") > 0)
    	{
        	ObjectError error = new ObjectError(entity.toString(),  processClassName(entity.getClass().getSimpleName()) + " already exists! Try again with a different value.");
        	result.addError(error);
    	}
    	else
    	{
    		ObjectError error = new ObjectError(entity.toString(), e.getMessage());
        	result.addError(error);
    	}
	}
	
	private static String processClassName(String simpleName)
	{
		StringBuffer buffer = new StringBuffer();
		if(simpleName != null)
		{
			String[] r = simpleName.split("(?=\\p{Lu})");
			for(String value : r)
			{
				buffer.append(value).append(" ");
			}
		}
		return buffer.toString();
	}
}
