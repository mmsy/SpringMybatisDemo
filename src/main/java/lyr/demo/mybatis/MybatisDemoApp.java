package lyr.demo.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by TYZ016 on 2017/4/26.
 */
@SpringBootApplication
public class MybatisDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApp.class, args);
    }

    @Bean
    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://59.110.165.229:3306/ordersys");
        dataSource.setUsername("root");
        dataSource.setPassword("linyr13579");

        return dataSource;
    }

    @Bean
    public static SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public static SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
        SqlSession sqlSession = new SqlSessionTemplate(sqlSessionFactory);

        return sqlSession;
    }
}
