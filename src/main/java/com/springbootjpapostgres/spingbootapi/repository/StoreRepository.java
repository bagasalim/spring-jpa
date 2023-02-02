package com.springbootjpapostgres.spingbootapi.repository;

import com.springbootjpapostgres.spingbootapi.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
