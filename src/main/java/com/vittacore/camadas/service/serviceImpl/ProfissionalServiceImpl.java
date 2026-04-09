package com.vittacore.camadas.service.serviceImpl;

import com.vittacore.camadas.repository.ProfissionalRepository;
import com.vittacore.camadas.service.ProfissionalService;
import com.vittacore.model.Profissional;
import com.vittacore.shared.Abstract.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalServiceImpl extends AbstractCrudService<Profissional, Integer>
        implements ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    @Override
    public ProfissionalRepository getRepository() {
        return repository;
    }
}
