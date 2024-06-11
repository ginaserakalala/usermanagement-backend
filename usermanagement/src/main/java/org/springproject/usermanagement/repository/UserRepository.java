package org.springproject.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springproject.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
