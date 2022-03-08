package ru.springCourse.DAO;

import org.springframework.stereotype.Component;
import ru.springCourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount, "Tom"));
        people.add(new Person(++peopleCount, "Bony"));
        people.add(new Person(++peopleCount, "Bob"));

    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }
    public void update(int id, Person updatedPerson) {
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
    }
    public void delete(int id) {
        people.removeIf(p->p.getId() == id);
    }
}
