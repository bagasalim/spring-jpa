package com.springbootjpapostgres.spingbootapi.dto;

import java.util.List;

public record MerchantDTO(Long id, String name, List<StoreDTO> storeDTOS){
}
