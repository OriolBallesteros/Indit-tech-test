package com.zara.technical.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.zara.technical.domain.entity.PriceEntity;
import com.zara.technical.domain.vo.Brand;
import com.zara.technical.domain.vo.Currency;
import com.zara.technical.domain.vo.PriceData;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceMapperTest {

  private PriceMapper mapper;

  @BeforeEach
  void onBefore() {
    this.mapper = new PriceMapper();
  }

  @Test
  void mapPriceEntityToData_whenNullParam_shouldReturnNull() {
    assertNull(mapper.mapPriceEntityToData(null));
  }

  @Test
  void mapPriceEntityToData_whenFilledParam_shouldReturnExpectedResult() {
    final EasyRandom random = new EasyRandom();
    final PriceEntity entity = random.nextObject(PriceEntity.class);
    entity.setCurr(Currency.EURO.getCode());
    entity.setBrandId(Brand.ZARA.getCode());

    final PriceData result = mapper.mapPriceEntityToData(entity);

    assertNotNull(result);
    assertNotNull(result.getProductId());
    assertEquals(entity.getProductId(), result.getProductId());
    assertNotNull(result.getBrand());
    assertEquals(entity.getBrandId(), result.getBrand().getCode());
    assertNotNull(result.getPriceValue());
    assertEquals(entity.getPriceValue(), result.getPriceValue());
    assertNotNull(result.getPriceList());
    assertEquals(entity.getPriceList(), result.getPriceList());
    assertNotNull(result.getCurrency());
    assertEquals(entity.getCurr(), result.getCurrency().getCode());
    assertNotNull(result.getStartDate());
    assertEquals(entity.getStartDate(), result.getStartDate());
    assertNotNull(result.getEndDate());
    assertEquals(entity.getEndDate(), result.getEndDate());
  }
}