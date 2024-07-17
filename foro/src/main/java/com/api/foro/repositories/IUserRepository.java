package com.api.foro.repositories;

import com.api.foro.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository <UserModel, Long> {


}
