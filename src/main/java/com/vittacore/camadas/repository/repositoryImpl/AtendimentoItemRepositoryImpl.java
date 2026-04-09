package com.vittacore.camadas.repository.repositoryImpl;

import com.vittacore.camadas.builder.AtendimentoItemListQueryBuilder;
import com.vittacore.camadas.repository.AtendimentoItemRepository;
import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.AtendimentoItemFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AtendimentoItemRepositoryImpl extends AbstractCrudRepository<AtendimentoItem, Integer> implements AtendimentoItemRepository {

    private final AtendimentoItemListQueryBuilder queryBuilder;

    public AtendimentoItemRepositoryImpl(AtendimentoItemListQueryBuilder queryBuilder){
        super(AtendimentoItem.class);
        this.queryBuilder = queryBuilder;
    }

    @Override
    public List<AtendimentoItem> list(AtendimentoItemFilterVO filterVO, Integer max) {
        queryBuilder.reset();
        queryBuilder.build(filterVO);
        int limit = (max != null) ? max : 0;
        return queryBuilder.list(0, limit);
    }
}
