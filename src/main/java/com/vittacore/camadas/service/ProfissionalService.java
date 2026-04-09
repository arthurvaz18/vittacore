package com.vittacore.camadas.service;

import com.vittacore.model.Profissional;
import com.vittacore.model.vo.ProfissionalFilterVO;
import com.vittacore.shared.base.BaseCrudService;

import java.util.List;

public interface ProfissionalService extends BaseCrudService<Profissional, Integer> {
    List<Profissional> list(ProfissionalFilterVO filterVO, Integer max);
}
