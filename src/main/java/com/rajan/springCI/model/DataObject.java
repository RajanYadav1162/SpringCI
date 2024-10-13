package com.rajan.springCI.model;


public class DataObject {

  private String data;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "DataObject{" +
        "data='" + data + '\'' +
        '}';
  }
}