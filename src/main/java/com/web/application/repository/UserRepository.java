package com.web.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.application.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	public UserModel getUserByUserId(long user_id);

}
