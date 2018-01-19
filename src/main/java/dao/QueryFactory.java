package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


/**
 * Description: 创建一个单例的QueryRunner,保证每个dao对象都
 * 持有的同一个QueryRunner。之所以这样做,是为了后续给QueryRunner
 * 注入线程池
 * <p>
 * Created by lzm on 2017/12/8.
 */
public class QueryFactory {

    private static QueryRunner qrSingleton;

    // TODO 需要选定一个线程池lib
    private static DataSource ds = new DataSource();


    public static synchronized QueryRunner getQR() {

        if (qrSingleton == null) {
            PoolProperties p = new PoolProperties();
            p.setUrl("jdbc:mysql://localhost:3306/spider");
            p.setDriverClassName("com.mysql.jdbc.Driver");
            p.setUsername("root");
            p.setPassword("1234");
            p.setJmxEnabled(true);
            p.setTestWhileIdle(false);
            p.setTestOnBorrow(true);
            p.setValidationQuery("SELECT 1");
            p.setTestOnReturn(false);
            p.setValidationInterval(30000);
            p.setTimeBetweenEvictionRunsMillis(30000);
            p.setMaxActive(100);
            p.setInitialSize(10);
            p.setMaxWait(10000);
            p.setRemoveAbandonedTimeout(60);
            p.setMinEvictableIdleTimeMillis(30000);
            p.setMinIdle(10);
            p.setLogAbandoned(true);
            p.setRemoveAbandoned(true);
            p.setJdbcInterceptors(
                    "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                            "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
            ds.setPoolProperties(p);
            qrSingleton = new QueryRunner(ds);
            return qrSingleton;
        } else return qrSingleton;
    }

}
