package io.qiniu.demo.controller.task;

import io.qiniu.demo.common.entity.pandora.PhoenixEmptyResponse;
import io.qiniu.demo.common.entity.task.Task;
import io.qiniu.demo.repository.ITaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  private ITaskDao taskDao;

  @Autowired
  public TaskController(ITaskDao taskDao) {
    this.taskDao = taskDao;
  }

  @GetMapping("/task/{id}")
  private Task GetTask(@PathVariable long id, @RequestHeader HttpHeaders headers) throws Exception {
    return taskDao.get(id, headers.toSingleValueMap());
  }

  @PostMapping("/task")
  private PhoenixEmptyResponse PostTask(@RequestBody Task task, @RequestHeader HttpHeaders headers)
      throws Exception {
    taskDao.insert(task, headers.toSingleValueMap());
    return new PhoenixEmptyResponse();
  }
}
