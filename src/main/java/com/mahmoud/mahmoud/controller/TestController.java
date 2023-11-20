package com.mahmoud.mahmoud.controller;

import com.mahmoud.mahmoud.dao.TestDAO;
import com.mahmoud.mahmoud.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {



    @Autowired
    private TestDAO testDAO;


    @GetMapping(path = "test")
    public String getName(){
        return testDAO.getName();
    }


    @GetMapping(path = "/test-users")
    public Iterable<TestEntity> getUsers(){
        return this.testDAO.getUsers();
    }
    @GetMapping(path = "/test-optional")
    public void testOptional(){
        String x="suiii";
        Optional<String> optional = Optional.ofNullable(x);

//        if (optional.isPresent())
//            System.out.println(x);
//        else
//            System.out.println("mahmoud");

//        optional.ifPresent(s -> System.out.println("suiii"));
//        x=optional.orElse("ddd");
//        x=optional.orElseGet(() -> "suii");
//        optional=optional.filter(s -> s.length()<10);
//        if(optional.isPresent())
//        System.out.println(optional.toString());
//        else
//            System.out.println("null");
//        Optional<String> upperOptional = optional.map(s -> s.toUpperCase());
//        Optional<String> upperOptionall = optional.flatMap(s -> Optional.of(s.toUpperCase()));

//        String s ="suiiii";
//        Optional<String> a = Optional.of(s);
//        if (optional.equals(a))
//            System.out.println(a);
//        else
//            System.out.println("not "+a);
        System.out.println(optional.hashCode());
    }


    @GetMapping("id")
 public Optional<TestEntity> getUser(@RequestParam(name = "userId") Integer userId){
        Optional<TestEntity> user = testDAO.getUsreById(userId);
        return user;
    }


    @GetMapping("delete")
    public String deleteUser(@RequestParam(name = "userId") Integer userId) {
        return this.testDAO.deleteById(userId);
    }

    @PostMapping("/save-user")
    public TestEntity saveUser(@RequestBody TestEntity testEntity){
        return this.testDAO.saveUser(testEntity);
    }


    @PostMapping ("/update-user")
    public TestEntity updateUser(@RequestBody TestEntity testEntity){
        return this.testDAO.updateUser(testEntity);
    }



    @GetMapping("/getAllUsers")
    public List<TestEntity> getAllUsers(){
        return this.testDAO.getAllUsers();
    }

    @GetMapping("/getUserById2")
    public TestEntity getUserById2(@RequestParam Integer id){
        return this.testDAO.getUserById2(id);
    }


    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody TestEntity testEntity){
        this.testDAO.resetPassword(testEntity.getPassword(),testEntity.getUserID());
    }


    @GetMapping("/deleteById2")
    void deleteById(@RequestParam Integer id){
        this.testDAO.deleteById2(id);
    }
    }
