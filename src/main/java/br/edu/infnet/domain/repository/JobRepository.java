package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Integer> {

    List<Job> findByUserId(Integer userId);

    List<Job> findByRoleContainingIgnoreCase(String search);

    List<Job> findByCityContainingIgnoreCase(String search);
}
