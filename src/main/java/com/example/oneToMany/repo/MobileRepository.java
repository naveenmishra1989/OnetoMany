package com.example.oneToMany.repo;

import com.example.oneToMany.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile, Long> {
  Mobile findByMobile(String number);
}