package com.vittacore.camadas.repository;

import com.vittacore.model.Atendimento;
import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.shared.base.BaseCrudRepository;

import java.util.List;

public interface AtendimentoRepository extends BaseCrudRepository<Atendimento,Integer> {
    List<Atendimento> list(AtendimentoFilterVO filterVO, Integer max);
}
