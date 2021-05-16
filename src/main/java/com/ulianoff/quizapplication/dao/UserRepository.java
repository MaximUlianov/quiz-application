package com.ulianoff.quizapplication.dao;

import com.ulianoff.quizapplication.model.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
