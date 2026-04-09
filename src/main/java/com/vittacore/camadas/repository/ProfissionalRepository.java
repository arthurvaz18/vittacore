package com.vittacore.camadas.repository;

import com.vittacore.model.Profissional;
import com.vittacore.model.vo.ProfissionalFilterVO;
import com.vittacore.shared.base.BaseCrudRepository;

import java.util.List;

public interface ProfissionalRepository extends BaseCrudRepository<Profissional, Integer> {
    List<Profissional> list(ProfissionalFilterVO filterVO, Integer max);
}
