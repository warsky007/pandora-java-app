package io.qiniu.demo.common.entity.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Blob;

public class Driver {

  @JsonProperty("name")
  private String name;

  @JsonProperty("file")
  private Blob file;

  public Driver(String name, Blob file) {
    this.name = name;
    this.file = file;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Blob getFile() {
    return file;
  }

  public void setFile(Blob file) {
    this.file = file;
  }
}
