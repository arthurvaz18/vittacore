package com.vittacore.camadas.resource;

import com.vittacore.camadas.service.AtendimentoService;
import com.vittacore.camadas.service.ProfissionalService;
import com.vittacore.model.Atendimento;
import com.vittacore.model.vo.AtendimentoFilterVO;
import com.vittacore.shared.base.BaseCrudResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoResource extends BaseCrudResource<Atendimento, Integer> {

    private final AtendimentoService service;

    public AtendimentoResource(AtendimentoService service){
        this.service = service;
    }
    @Override
    protected AtendimentoService getService() {
        return service;
    }

    @GetMapping
    public ResponseEntity<List<Atendimento>> findAll(AtendimentoFilterVO filterVO, @RequestParam(required = false) Integer max){
        return ResponseEntity.ok(getService().list(filterVO, max));
    }

}
