package com.todolist.todolist.utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class RequestUtil {
	public static <T> T convertJsonData(HttpServletRequest request, Class<T> classOf) throws IOException {
		String requestJsonData = null;
		StringBuilder builder = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String readData = null;
		
		while((readData = reader.readLine()) != null) {
			builder.append(readData);
		}
		
		requestJsonData = builder.toString();
		
		Gson gson = new Gson();
		
		return gson.fromJson(requestJsonData, classOf);
	}
}
