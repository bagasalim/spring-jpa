package com.springbootjpapostgres.spingbootapi.service;

import com.springbootjpapostgres.spingbootapi.dto.MerchantDTO;
import com.springbootjpapostgres.spingbootapi.dto.StoreDTO;
import com.springbootjpapostgres.spingbootapi.model.Merchant;
import com.springbootjpapostgres.spingbootapi.model.Store;

public interface StoreService {

    Store addStore(Long merchantId, Store store);

    StoreDTO mapToDto(Store store);
    Store mapToEntity(StoreDTO storeDTO);
}
