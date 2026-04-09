package com.vittacore.camadas.repository.repositoryImpl;

import com.vittacore.camadas.builder.ProfissionalListQueryBuilder;
import com.vittacore.camadas.repository.ProfissionalRepository;
import com.vittacore.model.Profissional;
import com.vittacore.model.vo.ProfissionalFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfissionalRepositoryImpl extends AbstractCrudRepository<Profissional, Integer> implements ProfissionalRepository {

    private final ProfissionalListQueryBuilder queryBuilder;

    public ProfissionalRepositoryImpl(ProfissionalListQueryBuilder queryBuilder) {
        super(Profissional.class);
        this.queryBuilder = queryBuilder;
    }

    @Override
    public List<Profissional> list(ProfissionalFilterVO filterVO, Integer max) {

        queryBuilder.reset();
        queryBuilder.build(filterVO);

        int limit = (max != null) ? max : 0;
        return queryBuilder.list(0, limit);
    }
}