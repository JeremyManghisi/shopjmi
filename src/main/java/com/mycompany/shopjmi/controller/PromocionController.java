/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjmi.controller;

import com.mycompany.shopjmi.model.Promocion;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author Jeremy
 */
@Named
@ApplicationScoped
public class PromocionController extends AbstractController<Promocion> {
    @Inject
    TiendaController tiendacontroller;
    public PromocionController() {
        super(Promocion::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(1);
        this.getSelected().setNombre("Oferta Express");
        this.getSelected().setDescripcion("2x1 en la primera compra");
        this.getSelected().setFechainicio("22/5/2023");
        this.getSelected().setFechafin("23/5/2023");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(2);
        this.getSelected().setNombre("Oferta 3x1");
        this.getSelected().setDescripcion("3x1 en la tercera compra");
        this.getSelected().setFechainicio("22/7/2024");
        this.getSelected().setFechafin("23/7/2024");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(3);
        this.getSelected().setNombre("2 ordenadores en uno");
        this.getSelected().setDescripcion("300€ por 2 ordenadores");
        this.getSelected().setFechainicio("22/4/2022");
        this.getSelected().setFechafin("23/4/2022");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            if (this.tiendacontroller.getItems().stream().filter(item -> {
                return item.getPromocion()== this.getSelected();
            }).count() == 0) {
                this.repositorio.remove(this.getSelected());
                return "remove";
            } else {
                return "";
            }

        }
        //se tiene que poner el error
        return "";

    }

    @Override
    public String preEdit() {

        return "edit";
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.create(this.getSelected());
        } else {
            this.repositorio.update(this.getSelected());
            //si ya existe
    
        }
        return "sucess";
    }
}