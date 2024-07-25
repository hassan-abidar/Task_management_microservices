package hassan.abidar.taskmicroservice.service;

import hassan.abidar.taskmicroservice.modal.Task;
import hassan.abidar.taskmicroservice.modal.TaskStatus;

import java.util.List;

public interface TaskService {

    Task createTask(Task task,String requesterRole) throws Exception;
    Task getTaskById(Long id) throws Exception;

    List<Task> getAllTask(TaskStatus status);

    Task updateTask(Long id , Task upatedTask , Long UserId) throws Exception;

    void deleteTask(Long id) throws Exception;

    Task assignToUser(Long userId, Long taskId) throws Exception;

    List<Task> assigneduserstask(Long userId);

    Task completeTask(Long taskId) throws Exception;







}
