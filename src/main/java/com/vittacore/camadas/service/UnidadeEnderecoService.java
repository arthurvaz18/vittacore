package com.vittacore.camadas.service;

import com.vittacore.model.UnidadeEndereco;
import com.vittacore.model.vo.UnidadeEnderecoFilterVO;
import com.vittacore.shared.base.BaseCrudService;

import java.util.List;

public interface UnidadeEnderecoService extends BaseCrudService<UnidadeEndereco, Integer> {
    List<UnidadeEndereco> list(UnidadeEnderecoFilterVO filterVO, Integer max);
}
