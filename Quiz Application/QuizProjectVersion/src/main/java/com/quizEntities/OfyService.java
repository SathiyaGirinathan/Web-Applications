package com.quizEntities;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

@WebListener
public class OfyService implements ServletContextListener{

	public static Objectify ofy()
	{
		return ObjectifyService.ofy();
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ObjectifyService.init();
		ObjectifyService.register(AdminInfo.class);
		ObjectifyService.register(QuestionPaper.class);
		ObjectifyService.register(TestTable.class);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Context Destroyed");
	}
}
