package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
