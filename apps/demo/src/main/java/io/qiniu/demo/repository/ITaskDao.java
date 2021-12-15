package io.qiniu.demo.repository;

import io.qiniu.demo.common.entity.task.Task;
import java.util.Map;

public interface ITaskDao {

  Task get(long id, Map<String, String> headers) throws Exception;

  void insert(Task task, Map<String, String> headers) throws Exception;
}
