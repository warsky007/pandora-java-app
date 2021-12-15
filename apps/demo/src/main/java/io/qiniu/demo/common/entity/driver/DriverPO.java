package io.qiniu.demo.common.entity.driver;

public class DriverPO {

  private String name;

  private String file;

  public DriverPO() {}

  public DriverPO(String name, String file) {
    this.name = name;
    this.file = file;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }
}
