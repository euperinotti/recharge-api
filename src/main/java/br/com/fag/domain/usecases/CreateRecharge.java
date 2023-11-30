package br.com.fag.domain.usecases;

import br.com.fag.domain.dto.RechargeDTO;
import br.com.fag.domain.entities.RechargeBO;
import br.com.fag.domain.mappers.RechargeMapper;
import br.com.fag.domain.repositories.IRechargeDatabaseRepository;
import br.com.fag.domain.repositories.IRechargeVendor;

public class CreateRecharge {

  private IRechargeVendor vendor;

  private IRechargeDatabaseRepository dbRepository;

  public CreateRecharge(IRechargeVendor vendor, IRechargeDatabaseRepository dbRepository) {
    this.vendor = vendor;
    this.dbRepository = dbRepository;
  }

  public RechargeDTO execute(RechargeDTO dto) {
    RechargeBO bo = RechargeMapper.toBO(dto);

    RechargeDTO rechargeResponse = vendor.create(dto);

    if (rechargeResponse.isSuccess()) {
      bo.handleSuccess(rechargeResponse.getReceipt(), rechargeResponse.getTransactionId());
    } else {
      bo.handleError();
    }

    dbRepository.persist(bo);

    return rechargeResponse;
  }

}
