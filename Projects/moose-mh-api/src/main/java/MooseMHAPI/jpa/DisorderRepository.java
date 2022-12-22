package MooseMHAPI.jpa;

import MooseMHAPI.disorder.Disorder;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface DisorderRepository extends JpaRepository<Disorder, Integer> {

    @Modifying
    @Query(
            value = "UPDATE hibernate_sequence SET next_val = 1 where next_val > 0",
            nativeQuery = true)
    @Transactional
    void resetIncrementor();

}

