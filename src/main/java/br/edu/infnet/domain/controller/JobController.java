package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.Job;
import br.edu.infnet.domain.model.Requirement;
import br.edu.infnet.domain.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/jobs"})
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping(path = "/all-jobs")
    public ResponseEntity listJobs() {
        List<Job> list = (List<Job>) jobRepository.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity listByUserId(@PathVariable Integer userId) {
        List<Job> list = jobRepository.findByUserId(userId);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/role/{search}")
    public ResponseEntity listByRole(@PathVariable String search) {

        ResponseEntity response = ResponseEntity.notFound().build();
        try {
            List<Job> list = jobRepository.findByRoleContainingIgnoreCase(search);
            if (!list.isEmpty()) {
                response = ResponseEntity.ok().body(list);
            }
        } catch (Exception e) {
        }

        return response;
    }

    @GetMapping(path = "/city/{search}")
    public ResponseEntity listByCity(@PathVariable String search) {

        ResponseEntity response = ResponseEntity.notFound().build();
        try {
            List<Job> list = jobRepository.findByCityContainingIgnoreCase(search);
            if (!list.isEmpty()) {
                response = ResponseEntity.ok().body(list);
            }
        } catch (Exception e) {
        }

        return response;
    }

    @PostMapping
    public ResponseEntity postJob(@RequestBody Job job) {

        ResponseEntity response = ResponseEntity.badRequest().build();
        List<Requirement> requirementList = job.getRequirementList();
        if (requirementList != null && !requirementList.isEmpty()) {

            for (Requirement requirement : requirementList) {
                requirement.setJob(job);
            }
            Job registered = jobRepository.save(job);
            response = ResponseEntity.status(HttpStatus.CREATED).body(registered);
        }

        return response;
    }
}
