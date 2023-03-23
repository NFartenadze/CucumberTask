package solvd.carina.BDD.db.mappers;

import solvd.carina.BDD.db.models.User;

import java.util.List;

public interface UserMapper {
        User getUserById(int id);

        List<User> getAllUsers();

        void insertUser(User user);

        void updateUser(User user);

        void deleteUserById(int id);
}
