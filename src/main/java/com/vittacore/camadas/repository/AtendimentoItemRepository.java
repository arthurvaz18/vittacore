package com.vittacore.camadas.repository;

import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.AtendimentoItemFilterVO;
import com.vittacore.shared.base.BaseCrudRepository;

import java.util.List;

public interface AtendimentoItemRepository extends BaseCrudRepository<AtendimentoItem, Integer> {
    List<AtendimentoItem> list(AtendimentoItemFilterVO filterVO, Integer max);
}
