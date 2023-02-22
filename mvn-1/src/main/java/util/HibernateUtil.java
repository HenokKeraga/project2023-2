package util;

import model.Author;
import model.Book;
import model.Category;
import model.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;
    static {
        try {
            Configuration config = getConfiguration();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    config.getProperties()).getBootstrapServiceRegistry();
            config.setSessionFactoryObserver(new SessionFactoryObserver() {
                private static final long  serialVersionUID = 1L;

                @Override
                public void sessionFactoryCreated(SessionFactory factory) {
                }

                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    StandardServiceRegistryBuilder.destroy(serviceRegistry);
                }
            });
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    private static  Configuration getConfiguration() {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Book.class );
        cfg.addAnnotatedClass(Author.class );
        cfg.addAnnotatedClass(Category.class );
        cfg.addAnnotatedClass(Publisher.class );
        cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/mydatabase?zeroDateTimeBehavior=convertToNull");
        cfg.setProperty("hibernate.connection.username", "user1");
        cfg.setProperty("hibernate.connection.password", "secret");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        cfg.setProperty("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        return cfg;
    }
}
