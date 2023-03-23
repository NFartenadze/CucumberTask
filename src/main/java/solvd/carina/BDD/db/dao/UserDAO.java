package solvd.carina.BDD.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.carina.BDD.db.mappers.UserMapper;
import solvd.carina.BDD.db.models.User;
import solvd.carina.BDD.utils.MyBatis;

import java.util.List;

public class UserDAO implements UserMapper {
    private static final Logger logger = LogManager.getLogger(UserDAO.class);
    @Override
    public User getUserById(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getUserById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        SqlSession session = MyBatis.getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getAllUsers();
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        SqlSession session = MyBatis.getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insertUser(user);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void updateUser(User user) {
        SqlSession session = MyBatis.getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateUser(user);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void deleteUserById(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.deleteUserById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }
}