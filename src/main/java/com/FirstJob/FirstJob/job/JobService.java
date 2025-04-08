package com.FirstJob.FirstJob.job;

import java.util.ArrayList;
import java.util.List;

public interface JobService {
    public List<Job> jobs = new ArrayList<>();
    public List<Job> findAll() ;
    public String addJob(Job job);

    public Job getJobById(long id);

    boolean deleteJobById(long id);

    boolean updateJobDetails(long id,Job job);
}
