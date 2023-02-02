package com.springbootjpapostgres.spingbootapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootjpapostgres.spingbootapi.dto.MerchantDTO;
import com.springbootjpapostgres.spingbootapi.model.Merchant;
import com.springbootjpapostgres.spingbootapi.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantServiceImp implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        final Merchant result = merchantRepository.save(merchant);
        return result;
    }

    @Override
    public Merchant update(Long id, Merchant merchant) {
        final Merchant result = getById(id);
        if (result != null) {
            result.setName(merchant.getName());
            return merchantRepository.save(merchant);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Merchant result = getById(id);
        if (result != null) {
            merchantRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<Merchant> getAll() {
        final List<Merchant> result = merchantRepository.findAll();
        return result;
    }

    @Override
    public Merchant getById(Long id) {
        Optional<Merchant> result = merchantRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        }
        return null;

    }

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public MerchantDTO mapToDto(Merchant merchant) {
        return objectMapper.convertValue(merchant, MerchantDTO.class);
    }

    @Override
    public Merchant mapToEntity(MerchantDTO merchantDTO) {
        return objectMapper.convertValue(merchantDTO, Merchant.class);
    }
}
