package com.kanchan.dao;
import java.util.List;

import com.kanchan.model.ApplyJob;
import com.kanchan.model.Job;

public interface JobDAO {
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int jobId);
	public List<Job> listAllJobs();
	public boolean applyJob(ApplyJob applyJob);
	public List<ApplyJob> getAllAppliedJobDetails();
}
