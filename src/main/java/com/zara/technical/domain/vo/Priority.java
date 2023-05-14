package com.zara.technical.domain.vo;


public enum Priority {
  LOW(0),
  HIGH(1);

  private final Integer code;

  /** Enum that links priority with its value or code. */
  Priority(final Integer code) { this.code = code; }

  public Integer getCode() { return code; }

}
