package com.mahmoud.mahmoud.dao;

import com.mahmoud.mahmoud.entity.TestEntity;
import com.mahmoud.mahmoud.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestDAO {


    @Autowired
    private TestRepo testRepo;
    public String getName(){
        return "Mahmoud Mushtaha";
    }

    public Iterable<TestEntity> getUsers(){
        return this.testRepo.findAll();
    }

    public Optional<TestEntity> getUsreById(Integer id){
        return testRepo.findById(id);
    }



    public String deleteById(Integer id){

        Optional<TestEntity> user = this.testRepo.findById(id);

        if (user.isPresent()){
            testRepo.deleteById(id);
            return "User Deleted .";
        }else
            return "User not Exest !";

    }


    public TestEntity saveUser(TestEntity testEntity){
        return this.testRepo.save(testEntity);
    }


    public TestEntity updateUser(TestEntity testEntity){
        Optional<TestEntity> user = this.getUsreById(testEntity.getUserID());
        if (user.isPresent()){
            return testRepo.save(testEntity);
        }else
            return null;
    }


    public List<TestEntity> getAllUsers(){
        return this.testRepo.getAllUsers();
    }



    public TestEntity getUserById2(Integer id){
        return this.testRepo.getUsersById(id);
    }


    public void resetPassword(String password, Integer id){
        this.testRepo.resetPassword(password,id);
    }

    public void deleteById2(Integer id){
        this.testRepo.deleteById(id);
    }

}
