package com.example.registrationLoginSecurityThymeleaf.Service;

import com.example.registrationLoginSecurityThymeleaf.Model.Weight;
import com.example.registrationLoginSecurityThymeleaf.Repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    @Autowired
    private WeightRepository repo;

    public List<Weight> listAll(){
        return  repo.findAll();
    }
    public void save(Weight weight){
        repo.save(weight);
    }

    /*public  Weight get(long id){
        return  repo.findAllById(id).get();
    }
    */

    /*


    public Student get(long id) {
        return repo.findById(id).get();

    }
    public void delete(long id) {

        repo.deleteById(id);
    }

     */
}
