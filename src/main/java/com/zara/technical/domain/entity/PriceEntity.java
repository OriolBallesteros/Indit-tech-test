package com.zara.technical.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICES")
public class PriceEntity {

  @Id
  private Long id;

  @Column(name = "BRAND_ID")
  private Long brandId;

  @Column(name = "START_DATE")
  private LocalDateTime startDate;

  @Column(name = "END_DATE")
  private LocalDateTime endDate;

  @Column(name = "PRICE_LIST")
  private Integer priceList;

  @Column(name = "PRODUCT_ID")
  private Long productId;

  @Column(name = "PRIORITY")
  private Integer priority;

  @Column(name = "PRICE")
  private Double priceValue;

  @Column(name = "CURR")
  private String curr;

  public PriceEntity() {
  }

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(final Long brandId) {
    this.brandId = brandId;
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

  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(final Integer priceList) {
    this.priceList = priceList;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(final Long productId) {
    this.productId = productId;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(final Integer priority) {
    this.priority = priority;
  }

  public Double getPriceValue() {
    return priceValue;
  }

  public void setPriceValue(final Double priceValue) {
    this.priceValue = priceValue;
  }

  public String getCurr() {
    return curr;
  }

  public void setCurr(final String curr) {
    this.curr = curr;
  }
}
