package com.vittacore.camadas.repository.repositoryImpl;

import com.vittacore.camadas.repository.ProfissionalRepository;
import com.vittacore.model.Profissional;
import com.vittacore.shared.Abstract.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProfissionalRepositoryImpl extends AbstractCrudRepository<Profissional, Integer> implements ProfissionalRepository {

    public ProfissionalRepositoryImpl() {
        super(Profissional.class);
    }
}