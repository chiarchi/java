package it.spindox.tutor.spindoxspring.service;

import it.spindox.tutor.spindoxspring.manager.ChannelManager;
import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.repository.MongoDBRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.spindox.tutor.spindoxspring.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final ChannelManager manager;


    @Autowired
   MongoDBRepository repository;
    public People getPeople() {
        return new People("chiara","burato", 2);
    }

    public void sendPeople(People people) {

        manager.sendMessage(new People("","", 3));
    }


    public List<People> getListPeople() {

        List<People> listPeople = new ArrayList<People>();
        listPeople.add(new People("chiara", "burato",1));
        listPeople.add(new People("chiara", "burato",2));
        
        return listPeople;
    }

/*     public People findById(int id)
    {
        People people = new People("", "", 0);
        
        for (int i = 0; i < getListPeople().size(); i++) {
            people = getListPeople().get(i);
            if (people.getId()==id)
            break;     
          }

        return people;
    } */

    // Use repository.deleteById() to delete an Employee record
        public void deleteEmployeeById(int id) {
            repository.deleteById(id);
            
        }

        public void saveOrUpdate(People employee) {
            repository.save(employee);
         }

         
        public Optional<People> findPeopleById(int id) {
     
              repository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
             return repository.findById(id);
         }

        public Iterable<People> findPeople() {
     
            return repository.findAll();
        }
}