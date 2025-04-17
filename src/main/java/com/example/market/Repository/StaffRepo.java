package com.example.market.Repository;

import com.example.market.Entity.Staff;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);
}
