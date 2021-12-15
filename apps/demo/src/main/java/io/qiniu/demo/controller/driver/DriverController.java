package io.qiniu.demo.controller.driver;

import io.qiniu.demo.common.entity.driver.DriverPO;
import io.qiniu.demo.common.entity.pandora.PhoenixEmptyResponse;
import io.qiniu.demo.repository.IDriverDao;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

  private IDriverDao driverDao;

  @Autowired
  public DriverController(IDriverDao driverDao) {
    this.driverDao = driverDao;
  }

  @GetMapping("/driver")
  private List<DriverPO> GetDriver(@RequestHeader HttpHeaders headers) throws Exception {
    return driverDao.getList(headers.toSingleValueMap());
  }

  @PostMapping("/driver")
  private PhoenixEmptyResponse PostDriver(
      InputStream inputStream,
      @RequestParam("filename") String filename,
      @RequestHeader HttpHeaders headers)
      throws Exception {
    byte[] buffer = IOUtils.toByteArray(inputStream);
    driverDao.insert(
        new DriverPO(filename, Base64.getEncoder().encodeToString(buffer)),
        headers.toSingleValueMap());
    return new PhoenixEmptyResponse();
  }
}
