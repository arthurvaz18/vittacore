package com.vittacore.camadas.repository;

import com.vittacore.model.UnidadeEndereco;
import com.vittacore.model.vo.UnidadeEnderecoFilterVO;
import com.vittacore.shared.base.BaseCrudRepository;

import java.util.List;

public interface UnidadeEnderecoRepository extends BaseCrudRepository<UnidadeEndereco, Integer> {
    List<UnidadeEndereco> list(UnidadeEnderecoFilterVO filterVO, Integer max);
}
