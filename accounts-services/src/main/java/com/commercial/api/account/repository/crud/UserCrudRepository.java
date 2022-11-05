package com.commercial.api.account.repository.crud;


import com.commercial.api.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
