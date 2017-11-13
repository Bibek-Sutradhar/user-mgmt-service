package com.cts.user_mgmt_service.Repository;

import com.cts.user_mgmt_service.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{

    //boolean validateUser(String username, String password);
    public Users findByUsername(String username);


}
