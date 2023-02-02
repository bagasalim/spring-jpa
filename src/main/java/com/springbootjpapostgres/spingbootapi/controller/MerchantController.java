package com.springbootjpapostgres.spingbootapi.controller;


import com.springbootjpapostgres.spingbootapi.dto.MerchantDTO;
import com.springbootjpapostgres.spingbootapi.model.Merchant;
import com.springbootjpapostgres.spingbootapi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/merchant")
public class MerchantController<id> {
    @Autowired
    MerchantService merchantService;

    @GetMapping("/get")
    public List<MerchantDTO> getAll(){
        return merchantService
                .getAll()
                .stream()
                .map(merchant -> merchantService.mapToDto(merchant))
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public MerchantDTO create(@RequestBody MerchantDTO request){
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result = merchantService.create(merchant);
        return merchantService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public MerchantDTO  update(@PathVariable Long id, @RequestBody MerchantDTO request){
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result =  merchantService.update(id, merchant);
        return  merchantService.mapToDto(result);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return merchantService.delete(id);
    }
}
