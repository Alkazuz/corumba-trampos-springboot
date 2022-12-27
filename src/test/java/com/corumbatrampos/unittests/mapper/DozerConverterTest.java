package com.corumbatrampos.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.corumbatrampos.mapper.DozerMapper;
import com.corumbatrampos.model.Job;
import com.corumbatrampos.unittests.mapper.mock.MockJob;
import com.corumbatrampos.vo.v1.JobVO;

public class DozerConverterTest {
    
    MockJob inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockJob();
    }

    @Test
    public void parseEntityToVOTest() {
        JobVO output = DozerMapper.parseObject(inputObject.mockEntity(), JobVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Desenvolvedor test 0", output.getName());
        assertEquals("Descrição test 0", output.getDescription());
        assertEquals(100, output.getSalary());
        assertEquals(2, output.getJobs());
        
        assertEquals("Company test", output.getCompany().getName());
        assertEquals("logo test", output.getCompany().getLogo());
        assertEquals("cnpj test", output.getCompany().getCnpj());
    }

    @Test
    public void parseEntityListToVOListTest() {
    	
        List<JobVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), JobVO.class);
        JobVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Desenvolvedor test 0", outputZero.getName());
        assertEquals("Descrição test 0", outputZero.getDescription());
        assertEquals(100, outputZero.getSalary());
        assertEquals(2, outputZero.getJobs());
        assertEquals("Company test", outputZero.getCompany().getName());
        assertEquals("logo test", outputZero.getCompany().getLogo());
        assertEquals("cnpj test", outputZero.getCompany().getCnpj());
        
        JobVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Desenvolvedor test 7", outputSeven.getName());
        assertEquals("Descrição test 7", outputSeven.getDescription());
        assertEquals(100, outputSeven.getSalary());
        assertEquals(2, outputSeven.getJobs());
        
        JobVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Desenvolvedor test 12", outputTwelve.getName());
        assertEquals("Descrição test 12", outputTwelve.getDescription());
        assertEquals(100, outputTwelve.getSalary());
        assertEquals(2, outputTwelve.getJobs());
    }

    @Test
    public void parseVOToEntityTest() {
        Job output = DozerMapper.parseObject(inputObject.mockVO(), Job.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Desenvolvedor test 0", output.getName());
        assertEquals("Descrição test 0", output.getDescription());
        assertEquals(100, output.getSalary());
        assertEquals(2, output.getJobs());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Job> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Job.class);
        Job outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Desenvolvedor test 0", outputZero.getName());
        assertEquals("Descrição test 0", outputZero.getDescription());
        assertEquals(100, outputZero.getSalary());
        assertEquals(2, outputZero.getJobs());
        
        Job outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Desenvolvedor test 7", outputSeven.getName());
        assertEquals("Descrição test 7", outputSeven.getDescription());
        assertEquals(100, outputSeven.getSalary());
        assertEquals(2, outputSeven.getJobs());
        
        Job outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Desenvolvedor test 12", outputTwelve.getName());
        assertEquals("Descrição test 12", outputTwelve.getDescription());
        assertEquals(100, outputTwelve.getSalary());
        assertEquals(2, outputTwelve.getJobs());
    }
}
