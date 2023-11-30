package br.com.fag.domain.mappers;

import br.com.fag.domain.dto.MerchantDTO;
import br.com.fag.domain.entities.MerchantBO;

public class MerchantMapper {
  public static MerchantBO toBO(MerchantDTO dto) {
    return new MerchantBO(dto.getPostalCode(), dto.getCity(), dto.getCategoryCode(), dto.getName());
  }

  public static MerchantDTO toDTO(MerchantBO bo) {
    MerchantDTO dto = new MerchantDTO();

    dto.setPostalCode(bo.getPostalCode());
    dto.setCity(bo.getCity());
    dto.setCategoryCode(bo.getCategoryCode());
    dto.setName(bo.getName());

    return dto;
  }
}
