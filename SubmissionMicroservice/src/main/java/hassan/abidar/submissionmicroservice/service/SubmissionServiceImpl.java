package hassan.abidar.submissionmicroservice.service;

import hassan.abidar.submissionmicroservice.model.Submission;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SubmissionServiceImpl implements SubmissionService{
    @Override
    public Submission submitTask(Long taskId, String githubLink, Long userId) throws Exception {
        return null;
    }

    @Override
    public Submission getTaskSubmissionById(Long submissionId) throws Exception {
        return null;
    }

    @Override
    public List<Submission> getAllTaskSubmissions() {
        return null;
    }

    @Override
    public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
        return null;
    }

    @Override
    public Submission acceptDeclineSubmission(Long id, String status) throws Exception {
        return null;
    }
}
