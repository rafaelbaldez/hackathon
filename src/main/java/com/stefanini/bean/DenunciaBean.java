package com.stefanini.bean;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.stefanini.service.DenunciaService;

@ManagedBean(name = "denunciaMB")
public class DenunciaBean {

    @Inject
    private DenunciaService denunciaService;

    public String chamar() {
        return "teste.jsf";
    }

}
