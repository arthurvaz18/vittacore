package com.vittacore.camadas.repository.repositoryImpl;

import com.vittacore.camadas.builder.AtendimentoListQueryBuilder;
import com.vittacore.camadas.repository.AtendimentoRepository;
import com.vittacore.model.Atendimento;
import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AtendimentoRepositoryImpl extends AbstractCrudRepository<Atendimento, Integer> implements AtendimentoRepository {

    private final AtendimentoListQueryBuilder queryBuilder;

    public AtendimentoRepositoryImpl(AtendimentoListQueryBuilder queryBuilder){
        super(Atendimento.class);
        this.queryBuilder = queryBuilder;
    }

    @Override
    public List<Atendimento> list(AtendimentoFilterVO filterVO, Integer max) {

        queryBuilder.reset();
        queryBuilder.build(filterVO);

        int limit = (max != null) ? max : 0;
        return queryBuilder.list(0, limit);
    }
}
