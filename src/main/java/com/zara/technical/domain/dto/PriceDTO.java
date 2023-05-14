package com.zara.technical.domain.dto;

import com.zara.technical.domain.vo.PriceData;
import java.util.List;

public class PriceDTO {

  private List<PriceData> priceDataList;

  public PriceDTO() { }

  public List<PriceData> getPriceDataList() {
    return priceDataList;
  }

  public void setPriceDataList(final List<PriceData> priceDataList) {
    this.priceDataList = priceDataList;
  }
}
