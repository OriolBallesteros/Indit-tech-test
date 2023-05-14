package com.zara.technical.domain.vo;

import java.time.LocalDateTime;

public class PriceData {

  private Long productId;

  private Brand brand;

  private Double priceValue;

  private Integer priceList;

  private Currency currency;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  public PriceData() {
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(final Long productId) {
    this.productId = productId;
  }

  public Brand getBrand() { return brand; }

  public void setBrand(final Brand brand) { this.brand = brand; }

  public Double getPriceValue() {
    return priceValue;
  }

  public void setPriceValue(final Double priceValue) { this.priceValue = priceValue; }

  public Integer getPriceList() { return priceList; }

  public void setPriceList(final Integer priceList) { this.priceList = priceList; }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(final LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(final LocalDateTime endDate) {
    this.endDate = endDate;
  }

}
