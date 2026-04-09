package com.vittacore.camadas.service;

import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.AtendimentoItemFilterVO;
import com.vittacore.shared.base.BaseCrudService;

import java.util.List;

public interface AtendimentoItemService extends BaseCrudService<AtendimentoItem, Integer> {
    List<AtendimentoItem> list(AtendimentoItemFilterVO filterVO, Integer max);
}
