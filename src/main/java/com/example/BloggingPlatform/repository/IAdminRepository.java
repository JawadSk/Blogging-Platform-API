package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
}
