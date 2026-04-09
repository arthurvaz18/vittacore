package com.vittacore.camadas.service.serviceImpl;

import com.vittacore.camadas.repository.AtendimentoRepository;
import com.vittacore.camadas.service.AtendimentoService;
import com.vittacore.model.Atendimento;
import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoServiceImpl extends AbstractCrudService<Atendimento, Integer> implements AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    public AtendimentoRepository getRepository(){
            return repository;
    }

    @Override
    public List<Atendimento> list(AtendimentoFilterVO filterVO, Integer max) {
        return repository.list(filterVO, max);
    }
}
