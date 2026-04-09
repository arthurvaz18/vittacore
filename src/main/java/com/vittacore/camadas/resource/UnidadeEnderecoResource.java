package com.vittacore.camadas.resource;

import com.vittacore.camadas.service.UnidadeEnderecoService;
import com.vittacore.model.UnidadeEndereco;
import com.vittacore.model.vo.UnidadeEnderecoFilterVO;
import com.vittacore.shared.base.BaseCrudResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidadeendereco")
public class UnidadeEnderecoResource extends BaseCrudResource<UnidadeEndereco, Integer> {

    private final UnidadeEnderecoService service;

    public UnidadeEnderecoResource(UnidadeEnderecoService service){
        this.service = service;
    }

    @Override
    protected UnidadeEnderecoService getService(){
        return service;
    }

    @GetMapping
    public ResponseEntity<List<UnidadeEndereco>> findAll(UnidadeEnderecoFilterVO filterVO, @RequestParam(required = false) Integer max){
        return ResponseEntity.ok(getService().list(filterVO,max));
    }

}
