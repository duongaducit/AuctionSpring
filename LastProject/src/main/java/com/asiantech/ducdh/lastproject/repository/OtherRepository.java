package com.asiantech.ducdh.lastproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asiantech.ducdh.lastproject.entity.User;

public interface OtherRepository extends JpaRepository<User, Integer>,OtherRepositoryCustom{


}
