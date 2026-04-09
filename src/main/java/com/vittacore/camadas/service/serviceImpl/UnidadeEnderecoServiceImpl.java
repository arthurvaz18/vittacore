package com.vittacore.camadas.service.serviceImpl;

import com.vittacore.camadas.repository.UnidadeEnderecoRepository;
import com.vittacore.camadas.service.UnidadeEnderecoService;
import com.vittacore.model.UnidadeEndereco;
import com.vittacore.model.vo.UnidadeEnderecoFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnidadeEnderecoServiceImpl extends AbstractCrudService<UnidadeEndereco, Integer> implements UnidadeEnderecoService {

    @Autowired
    private UnidadeEnderecoRepository repository;

    @Override
    public UnidadeEnderecoRepository getRepository(){return repository;}

    @Override
    public List<UnidadeEndereco> list(UnidadeEnderecoFilterVO filterVO, Integer max) {
        return repository.list(filterVO, max);
    }
}
