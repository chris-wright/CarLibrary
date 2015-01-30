package com.arnoldclark.utils;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class SessionUtil {

	/**
	 * Returns the value from the resource bundle that
	 * corresponds to the passed key.
	 * @param key
	 * @return value in resource bundle for key.
	 */

	public static String getResourceBundleValue(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "appbundle");
		if(bundle==null){
			return "";
		}
		return bundle.getString(key);
	}
}
