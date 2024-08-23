package hassan.abidar.submissionmicroservice.service;

import hassan.abidar.submissionmicroservice.model.Submission;

import java.util.List;

public interface SubmissionService {

    Submission submitTask(Long taskId, String githubLink, Long userId,String jwt) throws Exception ;
    Submission getTaskSubmissionById(Long submissionId) throws Exception;
    List<Submission> getAllTaskSubmissions();
    List<Submission> getTaskSubmissionsByTaskId(Long taskId);
    Submission acceptDeclineSubmission(Long id , String status) throws Exception;

}
