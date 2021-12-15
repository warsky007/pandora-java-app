package io.qiniu.demo.repository.impl;

import io.qiniu.demo.common.entity.Constant;
import io.qiniu.demo.common.entity.task.Task;
import io.qiniu.demo.repository.AbstractDatabaseImpl;
import io.qiniu.demo.repository.ITaskDao;
import io.qiniu.demo.service.PandoraService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl extends AbstractDatabaseImpl implements ITaskDao {

  @Autowired
  public TaskDaoImpl(PandoraService service) {
    this.service = service;
  }

  @Override
  public Task get(long id, Map<String, String> headers) throws Exception {
    return service
        .getClient()
        .getDataById(
            Constant.APP_NAME, Constant.TABLE_TASK, String.valueOf(id), headers, Task.class);
  }

  @Override
  public void insert(Task task, Map<String, String> headers) throws Exception {
    service.getClient().insertData(Constant.APP_NAME, Constant.TABLE_TASK, headers, task);
  }
}
