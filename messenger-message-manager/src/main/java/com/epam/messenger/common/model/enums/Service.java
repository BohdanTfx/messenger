package com.epam.messenger.common.model.enums;

public enum Service {
  FILE_MANAGER("FileManager");

  private String name;

  private Service(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
