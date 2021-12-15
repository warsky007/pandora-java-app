package io.qiniu.demo.common.entity.task;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

  @JsonProperty("name")
  private String name;

  public Task() {}

  public Task(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
