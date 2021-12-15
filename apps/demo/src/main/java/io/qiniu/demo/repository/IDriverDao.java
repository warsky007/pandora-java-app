package io.qiniu.demo.repository;

import io.qiniu.demo.common.entity.driver.DriverPO;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IDriverDao {

  void insert(DriverPO driver, Map<String, String> headers) throws IOException;

  List<DriverPO> getList(Map<String, String> headers) throws IOException;
}
