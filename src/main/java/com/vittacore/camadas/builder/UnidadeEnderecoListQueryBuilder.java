package com.vittacore.camadas.builder;

import com.vittacore.model.UnidadeEndereco;
import com.vittacore.model.vo.UnidadeEnderecoFilterVO;
import com.vittacore.shared.base.BaseQueryBuilder;
import org.springframework.stereotype.Component;

@Component
public class UnidadeEnderecoListQueryBuilder extends BaseQueryBuilder<UnidadeEnderecoFilterVO, UnidadeEndereco> {

    public UnidadeEnderecoListQueryBuilder(){
        super(UnidadeEndereco.class, "unidadeEndereco");
    }

    @Override
    public void build(UnidadeEnderecoFilterVO filterVO){
        if(filterVO == null)return;

        andLike("logradouro", filterVO.getLogradouro());
        andLike("numero", filterVO.getNumero());
        andLike("complemento", filterVO.getComplemento());
        andLike("bairro", filterVO.getBairro());
        andLike("cidade", filterVO.getCidade());
        andLike("estado", filterVO.getEstado());
        andLike("cep", filterVO.getCep());
        andEquals("id", filterVO.getId());
    }

}
