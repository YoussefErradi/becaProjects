package org.nttdata.restappdb.services;


import org.nttdata.restappdb.model.Response;
import org.nttdata.restappdb.model.User;

public interface UserService {
    public Response addUser(User p);
    public Response deleteUser(int id);
    public User getUser(int id);
    public User[] getAllUsers();
}