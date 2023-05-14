package com.zara.technical.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zara.technical.TestUtils;
import com.zara.technical.domain.dto.PriceDTO;
import com.zara.technical.domain.vo.PriceConstants;
import com.zara.technical.domain.vo.PriceData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIT {

  private static final String URL = "/prices/price/{brand}/{productId}";

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getPriceDataForGivenBrandProductIdAndDate_whenOk_shouldReturnExpectedStatus()
      throws Exception {
    final Long brand = TestUtils.VALID_BRAND_ID;
    final Long productId = TestUtils.VALID_PRODUCT_ID;
    final String date = TestUtils.VALID_DATE;

    mockMvc
        .perform(get(URL, brand, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
  }

  @Test
  void getPriceDataForGivenBrandProductIdAndDate_whenNotFound_shouldReturnExpectedStatus()
      throws Exception {
    final Long invalidBrandId = 9999L;
    final Long productId = TestUtils.VALID_PRODUCT_ID;
    final String date = TestUtils.VALID_DATE;

    mockMvc
        .perform(get(URL, invalidBrandId, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isNotFound());
  }

  // -- Required tests:
  @Test
  void getPriceDataForGivenBrandProductIdAndDate_scenario1() throws Exception {
    final Long brandId = 1L;
    final Long productId = 35455L;
    final String date = "2020-06-14 10:00:00";

    final MvcResult result = mockMvc.perform(get(URL, brandId, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    final PriceDTO response = mapResultToPriceDTO(result);
    commonChecksAndAssertions(response, brandId, productId, date);
  }

  @Test
  void getPriceDataForGivenBrandProductIdAndDate_scenario2() throws Exception {
    final Long brandId = 1L;
    final Long productId = 35455L;
    final String date = "2020-06-14 16:00:00";

    final MvcResult result = mockMvc.perform(get(URL, brandId, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    final PriceDTO response = mapResultToPriceDTO(result);
    commonChecksAndAssertions(response, brandId, productId, date);
  }

  @Test
  void getPriceDataForGivenBrandProductIdAndDate_scenario3() throws Exception {
    final Long brandId = 1L;
    final Long productId = 35455L;
    final String date = "2020-06-14 21:00:00";

    final MvcResult result = mockMvc.perform(get(URL, brandId, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    final PriceDTO response = mapResultToPriceDTO(result);
    commonChecksAndAssertions(response, brandId, productId, date);
  }

  @Test
  void getPriceDataForGivenBrandProductIdAndDate_scenario4() throws Exception {
    final Long brandId = 1L;
    final Long productId = 35455L;
    final String date = "2020-06-15 10:00:00";

    final MvcResult result = mockMvc.perform(get(URL, brandId, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    final PriceDTO response = mapResultToPriceDTO(result);
    commonChecksAndAssertions(response, brandId, productId, date);
  }

  @Test
  void getPriceDataForGivenBrandProductIdAndDate_scenario5() throws Exception {
    final Long brandId = 1L;
    final Long productId = 35455L;
    final String date = "2020-06-16 21:00:00";

    final MvcResult result = mockMvc.perform(get(URL, brandId, productId)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(date))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    final PriceDTO response = mapResultToPriceDTO(result);
    commonChecksAndAssertions(response, brandId, productId, date);
  }

  private void commonChecksAndAssertions(final PriceDTO response, final Long brandId, final Long productId, final String date) {
    assertNotNull(response);
    assertNotNull(response.getPriceDataList());
    assertFalse(response.getPriceDataList().isEmpty());

    final PriceData responseData = response.getPriceDataList().get(0);
    assertNotNull(responseData.getProductId());
    assertEquals(productId, responseData.getProductId());
    assertNotNull(responseData.getBrand());
    assertEquals(brandId, responseData.getBrand().getCode());
    assertNotNull(responseData.getStartDate());
    assertTrue(responseData.getStartDate().isBefore(mapStringToLocalDateTime(date)));
    assertNotNull(responseData.getEndDate());
    assertTrue(responseData.getEndDate().isAfter(mapStringToLocalDateTime(date)));
    assertNotNull(responseData.getPriceList());
    assertNotNull(responseData.getPriceValue());
    assertNotNull(responseData.getCurrency());
  }

  private LocalDateTime mapStringToLocalDateTime(String dateString) {
    dateString = dateString.replace(PriceConstants.DATE_REMOVE_CHAR,
        PriceConstants.DATE_REPLACE_CHAR);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PriceConstants.DATE_FORMAT);
    return LocalDateTime.parse(dateString, formatter);
  }

  private PriceDTO mapResultToPriceDTO(final MvcResult result) throws Exception {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    return mapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);
  }

}
