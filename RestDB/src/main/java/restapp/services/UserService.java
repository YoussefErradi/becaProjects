package restapp.services;


import restapp.model.Response;
import restapp.model.User;

public interface UserService {
    public Response addUser(User p);
    public Response deleteUser(int id);
    public User getUser(int id);
    public User[] getAllUsers();
}