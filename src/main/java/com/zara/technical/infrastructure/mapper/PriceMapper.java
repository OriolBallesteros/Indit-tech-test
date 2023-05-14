package com.zara.technical.infrastructure.mapper;

import com.zara.technical.domain.entity.PriceEntity;
import com.zara.technical.domain.vo.Brand;
import com.zara.technical.domain.vo.Currency;
import com.zara.technical.domain.vo.PriceData;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

  public PriceData mapPriceEntityToData(final PriceEntity entity) {

    if (entity == null) {
      return null;
    }

    final PriceData data = new PriceData();
    if (entity.getProductId() != null) {
      data.setProductId(entity.getProductId());
    }
    if (entity.getBrandId() != null) {
      data.setBrand(Brand.getByValue(entity.getBrandId()));
    }
    if (entity.getPriceValue() != null) {
      data.setPriceValue(entity.getPriceValue());
    }
    if (entity.getPriceList() != null) {
      data.setPriceList(entity.getPriceList());
    }
    if (entity.getCurr() != null) {
      data.setCurrency(Currency.getByValue(entity.getCurr()));
    }
    if (entity.getStartDate() != null) {
      data.setStartDate(entity.getStartDate());
    }
    if (entity.getEndDate() != null) {
      data.setEndDate(entity.getEndDate());
    }

    return data;
  }

}
