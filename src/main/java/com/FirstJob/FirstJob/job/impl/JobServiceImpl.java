package com.FirstJob.FirstJob.job.impl;

import com.FirstJob.FirstJob.job.Job;
import com.FirstJob.FirstJob.job.JobService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private long id=1;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String addJob(Job job) {
        job.setJobId(id++);
        jobs.add(job);
        return  "Job added successfully";
    }

    @Override
    public Job getJobById(long id) {
        for(Job job : jobs)
        {
            if(job.getJobId() == id)
            {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(long id) {
        Iterator<Job>it = jobs.iterator();
        while(it.hasNext())
        {
            Job job = it.next();
            if(job.getJobId() == id)
            {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobDetails(long id ,Job job) {
        Job curJob = getJobById(id);
        if(curJob!=null)
        {
            curJob.setJobTitle(job.getJobTitle());
            curJob.setJobDescription(job.getJobDescription());
            return true;
        }
        return false;
    }
}

