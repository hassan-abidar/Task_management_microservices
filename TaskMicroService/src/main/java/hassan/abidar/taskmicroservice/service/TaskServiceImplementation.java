package hassan.abidar.taskmicroservice.service;

import hassan.abidar.taskmicroservice.modal.Task;
import hassan.abidar.taskmicroservice.modal.TaskStatus;
import hassan.abidar.taskmicroservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImplementation implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task createTask(Task task, String requesterRole) throws Exception {
        if(!requesterRole.equals("ADMIN")){
            throw new Exception("Only admin can create a task !!");
        }
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) throws Exception {
        return taskRepository.findById(id).orElseThrow(()->new Exception("Task not found"));
    }

    @Override
    public List<Task> getAllTask(TaskStatus status) {
        List<Task> tasks = taskRepository.findAll();
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> status == null || task.getStatus().name().equalsIgnoreCase(status.toString()))
                .collect(Collectors.toList());
        return filteredTasks;
    }


    @Override
    public Task updateTask(Long id, Task updatedTask, Long UserId) throws Exception {
        Task existingTask = getTaskById(id);
        if(updatedTask.getTitle()!=null){
            existingTask.setTitle(updatedTask.getTitle());
        }
        if(updatedTask.getDescription()!=null){
            existingTask.setDescription(updatedTask.getDescription());
        }
        if(updatedTask.getDeadLine()!=null){
            existingTask.setDeadLine(updatedTask.getDeadLine());
        }
        if(updatedTask.getImage()!=null){
            existingTask.setImage(updatedTask.getImage());
        }
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) throws Exception {
            getTaskById(id);
            taskRepository.deleteById(id);
    }

    @Override
    public Task assignToUser(Long userId, Long taskId) throws Exception {
        Task task = getTaskById(taskId);
        task.setStatus(TaskStatus.DONE);
        task.setAssignedUserId(userId);
        return taskRepository.save(task);
    }



    @Override
    public List<Task> assignedUsersTask(Long userId,TaskStatus status) {
        List<Task> tasks = taskRepository.findByAssignedUserId(userId);
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> status == null || task.getStatus().name().equalsIgnoreCase(status.toString()))
                .collect(Collectors.toList());
        return filteredTasks;
    }

    @Override
    public Task completeTask(Long taskId) throws Exception {
        Task task = getTaskById(taskId);
        task.setStatus(TaskStatus.DONE);
        return taskRepository.save(task);
    }
}
