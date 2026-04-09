package com.vittacore.camadas.repository.repositoryImpl;

import com.vittacore.camadas.builder.UnidadeEnderecoListQueryBuilder;
import com.vittacore.camadas.repository.UnidadeEnderecoRepository;
import com.vittacore.model.UnidadeEndereco;
import com.vittacore.model.vo.UnidadeEnderecoFilterVO;
import com.vittacore.shared.Abstract.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadeEnderecoRepositoryImpl extends AbstractCrudRepository<UnidadeEndereco, Integer> implements UnidadeEnderecoRepository {

    private final UnidadeEnderecoListQueryBuilder queryBuilder;

    public UnidadeEnderecoRepositoryImpl(UnidadeEnderecoListQueryBuilder queryBuilder) {
        super(UnidadeEndereco.class);
        this.queryBuilder = queryBuilder;
    }

    @Override
    public List<UnidadeEndereco> list(UnidadeEnderecoFilterVO filterVO, Integer max) {
        queryBuilder.reset();
        queryBuilder.build(filterVO);
        int limit = (max != null) ? max : 0;
        return queryBuilder.list(0, limit);
    }
}
