package com.vittacore.camadas.service;

import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.model.vo.UnidadeAtendimentoFilterVO;
import com.vittacore.shared.base.BaseCrudService;

import java.util.List;

public interface UnidadeAtendimentoService extends BaseCrudService<UnidadeAtendimento, Integer> {
    List<UnidadeAtendimento> list(UnidadeAtendimentoFilterVO filterVO, Integer max);
}
