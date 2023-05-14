package com.zara.technical.domain.vo;


import java.util.Arrays;

public enum Currency {
  EURO("EUR");

  private final String code;

  /** Enum that links currency with its code. */
  Currency(final String code) { this.code = code; }

  public String getCode() { return code; }

  public static Currency getByValue(String givenCode) {
    return Arrays.stream(Currency.values())
        .filter(currency -> currency.getCode().equals(givenCode))
        .findFirst()
        .orElse(null);
  }

}
