package org.nttdata.restappdb.services;




import org.nttdata.restappdb.dao.impl.UserDAOImpl;
import org.nttdata.restappdb.model.Response;
import org.nttdata.restappdb.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users = new HashMap<Integer, User>();
    private static UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    @POST
    @Path("/add")
    public Response addUser(User p) {
        Response response = new Response();
        if (userDAO.getUserById(p.getId()) != null) {
            response.setStatus(false);
            return response;
        }
        userDAO.addUser(p);
        response.setStatus(true);
        response.setMessage("User created successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/delete")
    public Response deleteUser(@PathParam("id") int id) {
        Response response = new Response();
        if (userDAO.getUserById(id) == null) {
            response.setStatus(false);
            response.setMessage("User Doesn't Exists");
            return response;
        }
        userDAO.removeUser(id);
        response.setStatus(true);
        response.setMessage("User deleted successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/get")
    public User getUser(@PathParam("id") int id) {
        return userDAO.getUserById(id);
    }


    @Override
    @GET
    @Path("/getAll")
    public User[] getAllUsers() {
        return (User[])userDAO.listUsers().stream().toArray();
    }
}
