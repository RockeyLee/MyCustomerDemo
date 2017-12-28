package com.rockey.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BasicFactory {
	
	private static BasicFactory mBfactory;
	private static Properties prop;
	private BasicFactory(){

	}
	
	static{
		//get and resolve properties file 
		prop =new Properties();
		try {
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
	}
	
	public static BasicFactory getInstance(){
		if(mBfactory==null){
			synchronized(BasicFactory.class){
				if(mBfactory==null){
					mBfactory = new BasicFactory();
				}
			}
		}
		return mBfactory;
	}
	
	/**
	 * @param <T>
	 * @param clazz Class object of interface
	 * @return impl class object of interface 
	 */
	public <T> T getImplInstance(Class<T> clazz){
		try {
			String cName = clazz.getSimpleName();
			String cImplName = prop.getProperty(cName);
			return (T) Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	/**
	 * @return the number of items show in page 
	 */
	public  static int getRowPage(){
		
		return Integer.parseInt(prop.getProperty("RowPage"));
	}
}
