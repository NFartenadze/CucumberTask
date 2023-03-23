package solvd.carina.BDD.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.carina.BDD.db.mappers.OrdersMapper;
import solvd.carina.BDD.db.models.Orders;
import solvd.carina.BDD.db.models.User;
import solvd.carina.BDD.utils.MyBatis;

import java.util.List;

public class OrdersDAO implements OrdersMapper {
    private static final Logger logger = LogManager.getLogger(OrdersDAO.class);

    @Override
    public List<Orders> getAllOrders() {
        SqlSession session = MyBatis.getSession();
        try {
            OrdersMapper mapper = session.getMapper(OrdersMapper.class);
            return mapper.getAllOrders();
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public List<Orders> getAllOrdersByUserId(long userId) {
        SqlSession session = MyBatis.getSession();
        try {
            OrdersMapper mapper = session.getMapper(OrdersMapper.class);
            return mapper.getAllOrdersByUserId(userId);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public Orders getOrderById(long id) {
        SqlSession session = MyBatis.getSession();
        try {
            OrdersMapper mapper = session.getMapper(OrdersMapper.class);
            return mapper.getOrderById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public void insertOrder(Orders order) {
        SqlSession session = MyBatis.getSession();
        try {
            OrdersMapper mapper = session.getMapper(OrdersMapper.class);
            mapper.insertOrder(order);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void updateOrder(Orders order) {
        SqlSession session = MyBatis.getSession();
        try{
            OrdersMapper mapper = session.getMapper(OrdersMapper.class);
            mapper.updateOrder(order);
        }catch (Exception e){
            logger.error(e);
        }finally{
            MyBatis.close(session);
        }
    }

    @Override
    public void deleteOrderById(int id) {
        SqlSession session = MyBatis.getSession();
        try{
            OrdersMapper mapper = session.getMapper(OrdersMapper.class);
            mapper.deleteOrderById(id);
        }catch (Exception e){
            logger.error(e);
        }finally{
            MyBatis.close(session);
        }
    }
}