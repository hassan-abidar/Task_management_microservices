package hassan.abidar.submissionmicroservice.repository;

import hassan.abidar.submissionmicroservice.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Long, Submission> {
}
