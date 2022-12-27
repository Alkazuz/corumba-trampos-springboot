package com.corumbatrampos.unittests.mapper.mock;

import java.util.ArrayList;
import java.util.List;

import com.corumbatrampos.model.Company;
import com.corumbatrampos.model.Job;
import com.corumbatrampos.vo.v1.JobVO;

public class MockJob {

	public Job mockEntity() {
        return mockEntity(0);
    }
    
    public JobVO mockVO() {
        return mockVO(0);
    }
    
    public List<Job> mockEntityList() {
        List<Job> Jobs = new ArrayList<Job>();
        for (int i = 0; i < 14; i++) {
            Jobs.add(mockEntity(i));
        }
        return Jobs;
    }

    public List<JobVO> mockVOList() {
        List<JobVO> Jobs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Jobs.add(mockVO(i));
        }
        return Jobs;
    }
    
    public Job mockEntity(Integer number) {
        Job job = new Job();
        Company company = new Company(1L, "Company test", "logo test", "cnpj test", null);
        
        job.setName("Desenvolvedor test " + number);
        job.setDescription("Descrição test " + number);
        job.setSalary(100);
        job.setId(number.longValue());
        job.setJobs(2);
        job.setCompany(company);
        return job;
    }

    public JobVO mockVO(Integer number) {
    	Company company = new Company(1L, "Company test", "logo test", "cnpj test", null);
        JobVO job = new JobVO();
        job.setName("Desenvolvedor test " + number);
        job.setDescription("Descrição test " + number);
        job.setSalary(100);
        job.setId(number.longValue());
        job.setJobs(2);
        job.setCompany(company);
        return job;
    }
	
}
