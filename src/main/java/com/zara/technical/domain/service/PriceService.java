package com.zara.technical.domain.service;

import com.zara.technical.domain.vo.PriceData;
import java.util.List;

public interface PriceService {

  List<PriceData> getPriceDataForGivenBrandProductIdAndDate(final Long brand, final Long productId,
      final String date);

}
