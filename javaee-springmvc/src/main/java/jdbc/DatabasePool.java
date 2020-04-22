package jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(null != hikariDataSource){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){
            if(null != hikariDataSource){
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("root");
                hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
                hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/school?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
                hikariDataSource = new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }
        return null;
    }

    public static void main(String[] args) {
       while(true){
           getHikariDataSource();
//           try{
//               Thread.sleep(3000);
//           }catch (InterruptedException e){
//               e.printStackTrace();
//           }
       }

    }
}
