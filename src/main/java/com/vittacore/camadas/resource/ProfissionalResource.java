package com.vittacore.camadas.resource;

import com.vittacore.camadas.service.ProfissionalService;
import com.vittacore.model.Profissional;
import com.vittacore.shared.base.BaseCrudResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
