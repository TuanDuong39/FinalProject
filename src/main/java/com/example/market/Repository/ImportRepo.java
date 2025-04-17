package com.example.market.Repository;

import com.example.market.Entity.Import_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportRepo extends JpaRepository<Import_Order,Long> {
}
