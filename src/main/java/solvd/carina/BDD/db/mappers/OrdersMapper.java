package solvd.carina.BDD.db.mappers;

import solvd.carina.BDD.db.models.Orders;
import solvd.carina.BDD.db.models.User;

import java.util.List;

public interface OrdersMapper {
    List<Orders> getAllOrders();

    Orders getOrderById(int id);

    void insertOrder(Orders order);

    void updateOrder(Orders order);

    void deleteOrderById(int id);
}