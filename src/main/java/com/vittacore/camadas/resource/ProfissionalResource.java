package com.vittacore.camadas.resource;

import com.vittacore.camadas.service.ProfissionalService;
import com.vittacore.model.Profissional;
import com.vittacore.model.vo.ProfissionalFilterVO;
import com.vittacore.shared.base.BaseCrudResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalResource extends BaseCrudResource<Profissional, Integer> {

    private final ProfissionalService service;

    public ProfissionalResource(ProfissionalService service) {
        this.service = service;
    }

    @Override
    protected ProfissionalService getService() {
        return service;
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> findAll(ProfissionalFilterVO filterVO, @RequestParam(required = false) Integer max) {
        return ResponseEntity.ok(getService().list(filterVO, max));
    }
}
