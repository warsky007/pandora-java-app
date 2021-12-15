package io.qiniu.demo.common.entity;

import java.util.List;

public class BasePO<T> {

  private int total;

  private List<T> data;

  public BasePO() {}

  public BasePO(int total, List<T> data) {
    this.total = total;
    this.data = data;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
