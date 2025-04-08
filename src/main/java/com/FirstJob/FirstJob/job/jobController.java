package com.FirstJob.FirstJob.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/jobApi")
public class jobController {

    private JobService jobService ;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(path="/allJobs")
    public ResponseEntity<List<Job>> findAll()
    {
        return  new ResponseEntity(jobService.findAll(),HttpStatus.OK);
    }

    @PostMapping(path = "/addJob")
    public ResponseEntity<String> addJob(@RequestBody Job job)
    {
        jobService.addJob(job);
        return  new ResponseEntity("Job added successfully",HttpStatus.OK);
    }

    //get single job
    @GetMapping(path = "/getJobById/{Id}")
    public ResponseEntity<Job> getJobById(@PathVariable long Id)
    {
        Job job = jobService.getJobById(Id);
        if(job!=null)
            return new ResponseEntity(job, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //delete job
    @DeleteMapping(path = "/deleteJobById/{Id}")
    public ResponseEntity<String> deleteJobById(@PathVariable long Id) {
        boolean isDeleted = jobService.deleteJobById(Id);
        if (isDeleted != false)
            return new ResponseEntity("Job Deleted!!!", HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @PutMapping(path = "/updateJobDetails/{Id}")
    public ResponseEntity<String> updateJobById(@PathVariable long Id , @RequestBody Job job) {
        boolean isUpdated = jobService.updateJobDetails(Id,job);
        if (isUpdated != false)
            return new ResponseEntity("Job Details updatee!!!", HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
