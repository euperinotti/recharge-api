package br.com.fag.infra.celcoin.mappers;

import br.com.fag.domain.dto.MerchantDTO;
import br.com.fag.infra.celcoin.dto.request.CelcoinMerchantDTO;

public class CelcoinMerchantMapper {

  public static MerchantDTO toAppDTO(CelcoinMerchantDTO vendorDTO) {
    MerchantDTO dto = new MerchantDTO();

    dto.setPostalCode(vendorDTO.getPostalCode());
    dto.setCity(vendorDTO.getCity());
    dto.setCategoryCode(vendorDTO.getMerchantCategoryCode());
    dto.setName(vendorDTO.getName());

    return dto;
  }

  public static CelcoinMerchantDTO toVendorDTO(MerchantDTO appDTO) {
    CelcoinMerchantDTO dto = new CelcoinMerchantDTO();

    dto.setPostalCode(appDTO.getPostalCode());
    dto.setCity(appDTO.getCity());
    dto.setMerchantCategoryCode(appDTO.getCategoryCode());
    dto.setName(appDTO.getName());

    return dto;
  }
}
