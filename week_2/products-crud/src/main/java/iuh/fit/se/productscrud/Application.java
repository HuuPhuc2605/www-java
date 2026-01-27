package iuh.fit.se.productscrud;

import iuh.fit.se.productscrud.util.JpaUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JpaUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       JpaUtil.destroy();
    }
}
