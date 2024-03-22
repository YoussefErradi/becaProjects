package restapp.dao;

import restapp.model.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User user);
    public void updateUser(User user);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);
    public User getUserByLogin(String login);
    public User getUserByLoginAndPassword(String login, String password);
}
