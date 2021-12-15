package io.qiniu.demo.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.qiniu.demo.common.entity.BasePO;
import io.qiniu.demo.common.entity.Constant;
import io.qiniu.demo.common.entity.driver.DriverPO;
import io.qiniu.demo.repository.AbstractDatabaseImpl;
import io.qiniu.demo.repository.IDriverDao;
import io.qiniu.demo.service.PandoraService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDaoImpl extends AbstractDatabaseImpl implements IDriverDao {

  @Autowired
  public DriverDaoImpl(PandoraService service) {
    this.service = service;
  }

  @Override
  public void insert(DriverPO driver, Map<String, String> headers) throws IOException {
    service.getClient().insertData(Constant.APP_NAME, Constant.TABLE_DRIVER, headers, driver);
  }

  @Override
  public List<DriverPO> getList(Map<String, String> headers) throws IOException {
    return service
        .getClient()
        .getData(
            Constant.APP_NAME,
            Constant.TABLE_DRIVER,
            "",
            headers,
            new TypeReference<BasePO<DriverPO>>() {})
        .getData();
  }
}
