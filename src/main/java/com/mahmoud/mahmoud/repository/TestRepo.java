package com.mahmoud.mahmoud.repository;

import com.mahmoud.mahmoud.entity.TestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.beans.Transient;
import java.util.List;

public interface TestRepo extends JpaRepository<TestEntity,Integer> {

    @Query(value = "select t from TestEntity t")
    List<TestEntity> getAllUsers();

    @Query(value = "select t from TestEntity t where t.userID=:id")
    TestEntity getUsersById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TestEntity t set t.password=:password where t.userID=:id")
    void resetPassword(String password,Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from TestEntity t where t.userID=: id")
    void deleteById(Integer id);


}
