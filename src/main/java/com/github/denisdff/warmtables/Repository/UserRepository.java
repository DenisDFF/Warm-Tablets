package com.github.denisdff.warmtables.Repository;

import com.github.denisdff.warmtables.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
