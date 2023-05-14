package com.zara.technical.application.port.primary;

import com.zara.technical.domain.dto.PriceDTO;

public interface PricePrimaryPort {

  PriceDTO getPriceDataForGivenBrandProductIdAndDate(final Long brand, final Long productId,
      final String date);

}
