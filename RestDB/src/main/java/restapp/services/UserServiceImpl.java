package restapp.services;


import restapp.dao.impl.UserDAOImpl;
import restapp.model.Response;
import restapp.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users = new HashMap<Integer, User>();
    private static UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    @POST
    @Path("/")
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
    @Path("/{id}/")
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
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        return userDAO.getUserById(id);
    }


    @Override
    @GET
    @Path("/")
    public User[] getAllUsers() {
        return (User[])userDAO.listUsers().stream().toArray();
    }
}
