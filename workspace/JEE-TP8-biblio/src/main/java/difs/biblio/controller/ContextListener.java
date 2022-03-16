package difs.biblio.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import difs.biblio.model.LivreManager;


public class ContextListener implements ServletContextListener {

    public ContextListener() {
    }

    public void contextDestroyed(ServletContextEvent contextEvent)  {
    }

    public void contextInitialized(ServletContextEvent contextEvent)  { 
    	contextEvent.getServletContext().setAttribute(LivreManager.MANAGER_ATTRIBUTE, new LivreManager());
    }
	
}
