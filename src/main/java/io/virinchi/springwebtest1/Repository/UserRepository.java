package io.virinchi.springwebtest1.Repository;

//repository - we dont make class we use abstraction -> interface

import io.virinchi.springwebtest1.Model.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository -> communicates with the model table for CURD operation
//Rule
//1.Model needs to be provided to repository
//2.CRUD Operation needs to be extended by Repository
@Repository
public interface UserRepository extends JpaRepository<UserTbl,Integer> {  //jparepository is the superclass of curd-> curd function haru

    //Custom function however, notice that existsBy Function is provided by repo itself
    Boolean existsByUsernameAndPassword(String username, String password);
}
