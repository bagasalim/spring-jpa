package com.springbootjpapostgres.spingbootapi.repository;

import com.springbootjpapostgres.spingbootapi.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
