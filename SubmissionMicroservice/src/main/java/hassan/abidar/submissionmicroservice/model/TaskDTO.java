package hassan.abidar.submissionmicroservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TaskDTO {
    private String title;
    private String description;
    private String image;
    private Long assignedUserId;
    private List<String> tags = new ArrayList<>();
    private TaskStatus status;
    private LocalDateTime deadLine;
    private LocalDateTime createdAt;
}
