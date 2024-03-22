package restapp.DAOImpl;



import restapp.DAO.PersonService;
import restapp.model.Person;
import restapp.model.Responsee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonServiceImpl implements PersonService {

    private static Map<Integer, Person> people = new HashMap<Integer, Person>();

    @Override
    @POST
    @Path("/add")
    public Responsee addPerson(Person p) {
        Responsee response = new Responsee(); if(people.get(p.getId()) != null){
            response.setStatus(false);
            response.setMessage("Person Already Exists");
            return response;
        }
        people.put(p.getId(), p); response.setStatus(true); response.setMessage("Person created successfully"); return response;
    }

    @Override
    @GET
    @Path("/{id}/delete")
    public Responsee deletePerson(@PathParam("id") int id) {
        Responsee response = new Responsee(); if(people.get(id) == null){
            response.setStatus(false);
            response.setMessage("Person Doesn't Exists");
            return response;
        }
        people.remove(id);
        response.setStatus(true); response.setMessage("Person deleted successfully"); return response;
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Person getPerson(@PathParam("id") int id) {
        return people.get(id); }
    @GET
    @Path("/{id}/getDummy")
    public Person getDummyPerson(@PathParam("id") int id) {
        Person p = new Person();
        p.setAge(99);
        p.setName("Dummy");
        p.setId(id);
        return p; }

    @Override
    @GET
    @Path("/getAll")
    public Person[] getAllPersons() {
        Person p1 = new Person();p1.setName("Ali");p1.setId(1); p1.setAge(30); Person p2 =new Person();p2.setName("Ahmed");p2.setId(2);p2.setAge(25);
        people.put(p1.getId(), p1); people.put(p2.getId(), p2);
        Set<Integer> ids = people.keySet(); Person[] p = new Person[ids.size()]; int i=0;
        for(Integer id : ids){ p[i] = people.get(id);
            i++; }
        return p; }
}
