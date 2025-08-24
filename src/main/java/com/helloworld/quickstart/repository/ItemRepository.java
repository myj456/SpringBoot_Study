package com.helloworld.quickstart.repository;

import com.helloworld.quickstart.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// db 접근
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
