package com.cts.user_mgmt_service.Repository;

import com.cts.user_mgmt_service.Entity.UserPolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPolicyRepository extends CrudRepository<UserPolicy, Integer>{
}
