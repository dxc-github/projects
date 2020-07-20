package com.dxc.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext contesxt=servletContextEvent.getServletContext();
        contesxt.setAttribute("dxc",contesxt.getContextPath());
        System.out.println("---------Servlet容器创建成功 leiyujia被放到ServletContext作用域-------");
    }
}
