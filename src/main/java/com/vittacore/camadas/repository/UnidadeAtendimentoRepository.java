package com.vittacore.camadas.repository;

import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.model.vo.UnidadeAtendimentoFilterVO;
import com.vittacore.shared.base.BaseCrudRepository;

import java.util.List;

public interface UnidadeAtendimentoRepository extends BaseCrudRepository<UnidadeAtendimento, Integer> {
    List<UnidadeAtendimento> list(UnidadeAtendimentoFilterVO filterVO, Integer max);
}
