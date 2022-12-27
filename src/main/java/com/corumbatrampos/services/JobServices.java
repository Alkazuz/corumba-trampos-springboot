package com.corumbatrampos.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corumbatrampos.exceptions.repositories.ResourceNotFoundException;
import com.corumbatrampos.mapper.DozerMapper;
import com.corumbatrampos.model.Job;
import com.corumbatrampos.repositories.JobRepository;
import com.corumbatrampos.vo.v1.JobVO;

/**
 * Classe de serviço para operações relacionadas a vagas.
 */
@Service
public class JobServices {
	
	// String usada para gerar uma mensagem de erro quando um trabalho não é encontrado.
	private static final String NOT_FOUND_FORMAT = "No records found for id %d!";
	
	// Utilizado para registrar informações sobre as operações realizadas.
    private Logger logger = Logger.getLogger(JobServices.class.getName());

    // Repositório usado para acessar os dados.
    @Autowired(required = true)
    JobRepository repository;

    /**
     * Encontra todos os trabalhos.
     * 
     * @return Uma lista de trabalhos.
     */
    public List<JobVO> findAll() {
        // Registra uma mensagem informando que está sendo realizada a busca por todos os trabalhos.
        logger.info("Finding all job!");

        // Utiliza o método findAll do repositório para encontrar todos os trabalhos e o método parseListObjects
        // da classe DozerMapper para converter a lista de entidades em uma lista de objetos de visualização de dados.
        return DozerMapper.parseListObjects(repository.findAll(), JobVO.class);
    }

    /**
     * Cria um novo trabalho.
     * 
     * @param jobVO O trabalho a ser criado.
     * @return O trabalho criado.
     */
    public JobVO create(JobVO jobVO) {
    	// Registra uma mensagem informando que está sendo realizada a criação da vaga.
        logger.info("Creating one jobs!");

        Job entity = repository.save(DozerMapper.parseObject(jobVO, Job.class));

        return DozerMapper.parseObject(entity, JobVO.class);
    }

    /**
     * Atualiza um trabalho existente.
     * 
     * @param jobVO O trabalho atualizado.
     * @return O trabalho atualizado.
     * @throws ResourceNotFoundException Se o trabalho não for encontrado.
     */
    public JobVO update(JobVO jobVO) throws ResourceNotFoundException {
        // Registra uma mensagem informando que está sendo realizada a atualização de um trabalho.
        logger.info("Updating one job!");

        // Utiliza o método findById do repositório para encontrar o trabalho com o ID especificado.
        // Se o trabalho não for encontrado, lança uma exceção ResourceNotFoundException.
        Job entity = repository.findById(jobVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(jobVO.getId(), String.format(NOT_FOUND_FORMAT, jobVO.getId())));

        // Atualiza os atributos da entidade com os valores do objeto de visualização de dados.
        entity.setName(jobVO.getName());
        entity.setDescription(jobVO.getDescription());
        entity.setSalary(jobVO.getSalary());
        entity.setJobs(jobVO.getJobs());

        // Utiliza o método save do repositório para atualizar a entidade e o método parseObject da classe
        // DozerMapper para converter a entidade atualizada em um objeto de visualização de dados.
        entity = repository.save(DozerMapper.parseObject(jobVO, Job.class));

        // Utiliza o método parseObject da classe DozerMapper para converter a entidade em um objeto de visualização de dados
        // e o retorna.
        return DozerMapper.parseObject(entity, JobVO.class);
    }
	
	/**
     * Exclui um trabalho existente.
     * 
     * @param id O ID do trabalho a ser excluído.
     * @throws ResourceNotFoundException Se o trabalho não for encontrado.
     */
    public void delete(Long id) throws ResourceNotFoundException {
    	// Registra uma mensagem informando que está sendo realizada a exclusão de um trabalho.
        logger.info("Deleting one job!");

        // Utiliza o método findById do repositório para encontrar o trabalho com o ID especificado.
        // Se o trabalho não for encontrado, lança uma exceção ResourceNotFoundException.
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, String.format(NOT_FOUND_FORMAT, id)));
        
        // Utiliza o método delete do repositorio para deletar a vaga
        repository.delete(entity);
    }

    /**
     * Encontra um trabalho pelo seu ID.
     * 
     * @param id O ID do trabalho a ser encontrado.
     * @return O trabalho encontrado.
     * @throws ResourceNotFoundException Se o trabalho não for encontrado.
     */
    public JobVO findById(Long id) throws ResourceNotFoundException {
        // Registra uma mensagem informando que está sendo realizada a busca por um trabalho.
        logger.info("Finding one job!");

        // Utiliza o método findById do repositório para encontrar o trabalho com o ID especificado.
        // Se o trabalho não for encontrado, lança uma exceção ResourceNotFoundException.
        Job entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, String.format(NOT_FOUND_FORMAT, id)));

        // Utiliza o método parseObject da classe DozerMapper para converter a entidade em um objeto de visualização de dados
        // e o retorna.
        return DozerMapper.parseObject(entity, JobVO.class);
    }
	
}
