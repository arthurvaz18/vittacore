package com.vittacore.camadas.service;

import com.vittacore.model.Atendimento;
import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.shared.base.BaseCrudService;

import java.util.List;

public interface AtendimentoService extends BaseCrudService<Atendimento, Integer> {
    List<Atendimento> list(AtendimentoFilterVO filterVO, Integer max);
}
