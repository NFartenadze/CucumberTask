package solvd.carina.BDD.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import solvd.carina.BDD.db.mappers.OrdersMapper;
import solvd.carina.BDD.db.mappers.UserMapper;

import java.io.IOException;
import java.io.Reader;

public class ConnectionFactory {
    private static SqlSessionFactory factory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

    public static UserMapper getUserMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(UserMapper.class);
    }

    public static OrdersMapper getUserPreferenceMapperMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(OrdersMapper.class);
    }
}
