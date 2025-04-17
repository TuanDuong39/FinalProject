package com.example.market.Repository;

import com.example.market.Entity.Inventory;
import com.example.market.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProduct(Product product);
}
