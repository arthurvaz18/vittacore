package com.vittacore.camadas.service.serviceImpl;

import com.vittacore.camadas.repository.UnidadeAtendimentoRepository;
import com.vittacore.camadas.service.UnidadeAtendimentoService;
import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.model.vo.UnidadeAtendimentoFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudService;
import com.vittacore.shared.base.BaseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeAtendimentoServiceImpl extends AbstractCrudService<UnidadeAtendimento, Integer> implements UnidadeAtendimentoService {

    @Autowired
    private UnidadeAtendimentoRepository repository;

    @Override
    public UnidadeAtendimentoRepository getRepository(){
        return repository;
    }

    @Override
    public List<UnidadeAtendimento> list(UnidadeAtendimentoFilterVO filterVO, Integer max) {
        return repository.list(filterVO, max);
    }

}
