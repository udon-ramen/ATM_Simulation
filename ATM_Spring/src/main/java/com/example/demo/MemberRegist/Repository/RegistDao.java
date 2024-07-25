package com.example.demo.MemberRegist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.MemberRegist.Entity.RegistEntity;

public interface RegistDao extends JpaRepository<RegistEntity, String>{}
