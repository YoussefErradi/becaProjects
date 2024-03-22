package restapp.DAO;


import restapp.model.Person;
import restapp.model.Responsee;

public interface PersonService {
    public Responsee addPerson(Person p);
    public Responsee deletePerson(int id);
    public Person getPerson(int id);
    public Person[] getAllPersons();
}