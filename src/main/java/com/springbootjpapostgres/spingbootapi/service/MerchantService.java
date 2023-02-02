package com.springbootjpapostgres.spingbootapi.service;

import com.springbootjpapostgres.spingbootapi.dto.MerchantDTO;
import com.springbootjpapostgres.spingbootapi.model.Merchant;

import java.util.List;

public interface MerchantService {

    Merchant create(Merchant merchant);

    Merchant update(Long id, Merchant merchant);

    Boolean delete(Long id);

    List<Merchant> getAll();

    Merchant getById(Long id);

    MerchantDTO mapToDto(Merchant merchant);

    Merchant mapToEntity(MerchantDTO merchantDTO);


}
