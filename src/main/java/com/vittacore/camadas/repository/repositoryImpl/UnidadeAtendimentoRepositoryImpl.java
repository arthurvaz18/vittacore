package com.vittacore.camadas.repository.repositoryImpl;

import com.vittacore.camadas.builder.UnidadeAtendimentoListQueryBuilder;
import com.vittacore.camadas.repository.UnidadeAtendimentoRepository;
import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.model.vo.UnidadeAtendimentoFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadeAtendimentoRepositoryImpl extends AbstractCrudRepository<UnidadeAtendimento, Integer> implements UnidadeAtendimentoRepository {

    private final UnidadeAtendimentoListQueryBuilder queryBuilder;

    public UnidadeAtendimentoRepositoryImpl(UnidadeAtendimentoListQueryBuilder queryBuilder){
        super(UnidadeAtendimento.class);
        this.queryBuilder = queryBuilder;
    }

    @Override
    public List<UnidadeAtendimento> list(UnidadeAtendimentoFilterVO filterVO, Integer max) {
        queryBuilder.reset();
        queryBuilder.build(filterVO);
        int limit = (max != null) ? max : 0;
        return queryBuilder.list(0, limit);
    }
}
