package com.vittacore.camadas.service.serviceImpl;

import com.vittacore.camadas.repository.AtendimentoItemRepository;
import com.vittacore.camadas.service.AtendimentoItemService;
import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.AtendimentoItemFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AtendimentoItemServiceImpl extends AbstractCrudService<AtendimentoItem, Integer> implements AtendimentoItemService {

    @Autowired
    private AtendimentoItemRepository repository;

    public AtendimentoItemRepository getRepository(){return repository;}

    @Override
    public List<AtendimentoItem> list(AtendimentoItemFilterVO filterVO, Integer max) {
        return repository.list(filterVO, max);
    }
}
