package com.vittacore.camadas.resource;

import com.vittacore.camadas.service.AtendimentoItemService;
import com.vittacore.model.AtendimentoItem;
import com.vittacore.model.AtendimentoItemFilterVO;
import com.vittacore.shared.base.BaseCrudResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/atendimentoItens")
public class AtendimentoItemResource extends BaseCrudResource<AtendimentoItem, Integer> {

    private final AtendimentoItemService service;

    public AtendimentoItemResource(AtendimentoItemService service){
        this.service = service;
    }

    @Override
    protected AtendimentoItemService getService(){
        return service;
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoItem>> findAll(AtendimentoItemFilterVO filterVO, @RequestParam(required = false) Integer max){
        return ResponseEntity.ok(getService().list(filterVO, max));
    }
}
