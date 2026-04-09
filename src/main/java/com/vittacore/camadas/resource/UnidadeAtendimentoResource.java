package com.vittacore.camadas.resource;

import com.vittacore.camadas.service.UnidadeAtendimentoService;
import com.vittacore.model.UnidadeAtendimento;
import com.vittacore.model.vo.UnidadeAtendimentoFilterVO;
import com.vittacore.shared.base.BaseCrudResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidadeatendimentos")
public class UnidadeAtendimentoResource extends BaseCrudResource<UnidadeAtendimento, Integer> {

    private final UnidadeAtendimentoService service;

    public UnidadeAtendimentoResource(UnidadeAtendimentoService service){this.service = service;}

    @Override
    protected UnidadeAtendimentoService getService() {return service;}

    @GetMapping
    public ResponseEntity<List<UnidadeAtendimento>> findAll(UnidadeAtendimentoFilterVO filterVO, @RequestParam(required = false) Integer max){
        return ResponseEntity.ok(getService().list(filterVO, max));
    }
}
