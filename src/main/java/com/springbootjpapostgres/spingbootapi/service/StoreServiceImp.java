package com.springbootjpapostgres.spingbootapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootjpapostgres.spingbootapi.dto.StoreDTO;
import com.springbootjpapostgres.spingbootapi.model.Merchant;
import com.springbootjpapostgres.spingbootapi.model.Store;
import com.springbootjpapostgres.spingbootapi.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class StoreServiceImp implements StoreService{

    @Autowired
    MerchantService merchantService;
    @Autowired
    StoreRepository storeRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Store addStore(Long merchantId, Store store) {
        final Merchant merchant = merchantService.getById(merchantId);
        if (merchant != null) {
            store = storeRepository.save(store);
            if (merchant.getStores() != null){
                List<Store> stores =  merchant.getStores();
                stores.add(store);
                merchant.setStores(stores);
            } else {
                merchant.setStores(Collections.singletonList(store));
            }
            merchantService.create(merchant);
            return store;
        }

        return null;
    }

    @Override
    public StoreDTO mapToDto(Store store) {
        return objectMapper.convertValue(store, StoreDTO.class);
    }

    @Override
    public Store mapToEntity(StoreDTO storeDTO) {
        return objectMapper.convertValue(storeDTO, Store.class);
    }
}
