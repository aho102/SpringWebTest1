package io.virinchi.springwebtest1.RestAPIController;

import io.virinchi.springwebtest1.Model.UserTbl;
import lombok.RequiredArgsConstructor;
import io.virinchi.springwebtest1.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
//controller and rest controller follows same patterns of  http request and response handling
//however rest controller helps creating rest api that we can use and test as well
public class RestTest {
    private final UserRepository uRepo;
    @GetMapping("/getAllUsers")
    public List<UserTbl> getAllUsers(){
        List<UserTbl>totalUsers = uRepo.findAll();
        return totalUsers;
    }

        @PostMapping("/saveUser")
        public String userSave(@RequestBody UserTbl user){
        uRepo.save(user);
        return "SavedSuccessfully";
    }

    @GetMapping("/getOneUser/{id}")        //{id} -> change hudai aauxa id

    public UserTbl oneUser(@PathVariable("id") int id){        //postman ko path ma change huney variable(id) lai pathvariable bhanxa

       //  UserTbl user = uRepo.getById()       //-> we can directly send id , (provide me id details)
        UserTbl user = uRepo.findById(id).get();

//        if (uRepo.findById(id).isPresent()){                //mostly used
//            UserTbl user = uRepo.findById(id).get();
//            return user;
//        }          // here u cannot write else and send the error message



        return user;
    }

    @GetMapping("/getIdRE/{id}")
    public ResponseEntity<?>getIdRE(@PathVariable("id") int id){

        if(uRepo.findById(id).isPresent()){
            return ResponseEntity.ok(uRepo.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Id Invalid");    // in this way we can send error msg

    }

}
