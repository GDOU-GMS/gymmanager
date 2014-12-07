package com.gms.factory;

/**
 * DAO工厂类
 * @author Rose
 */
public class DAOFactory
{
	private static DAOFactory factory = new DAOFactory();
	
	/* 将默认构造器私有 */
	private DAOFactory()
	{}
	
	/**
	 * 返回本类对象
	 * @return
	 */
	public static DAOFactory getInstance()
	{
		return factory;
	}
	
	/**
	 * 根据泛型参数,生成DAO对象
	 * @param className
	 * @param clazz
	 * @return
	 */
	public  <T> T createDAO(String className)
	{
		try
		{
			T t = (T) Class.forName(className).newInstance();
			return t;
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
