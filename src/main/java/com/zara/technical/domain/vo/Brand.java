package com.zara.technical.domain.vo;


import java.util.Arrays;

public enum Brand {
  ZARA(1);

  private final long code;

  /** Enum that links brand with its code. */
  Brand(final long code) { this.code = code; }

  public long getCode() { return code; }

  public static Brand getByValue(long givenCode) {
    return Arrays.stream(Brand.values())
        .filter(brand -> brand.getCode() == givenCode)
        .findFirst()
        .orElse(null);
  }
}
