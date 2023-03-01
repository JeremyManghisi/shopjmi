/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjmi.controller;

import com.mycompany.shopjmi.model.Tienda;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import java.util.Optional;

/**
 *
 * @author Jeremy
 */
@Named
@ApplicationScoped
public class TiendaController extends AbstractController<Tienda> {

    public TiendaController() {
        super(Tienda::new);
        //this.load();
    }

    @Override
    public Tienda getSelected() {
        return super.getSelected();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("PcComponentes");
        this.getSelected().setDireccion("Calle Isabel Catolica");
        this.getSelected().setDescripcion("Tienda ubicada en el centro de Murcia a tu disposición");
        this.getSelected().setCoordenadas("53.481395189138, -4.517183127381");
        
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("PCBox");
         this.getSelected().setDireccion("Calle Alvarez Sereix");
        this.getSelected().setDescripcion("Tienda ubicada en Torrevieja, llámanos si necesitas algo");
        this.getSelected().setCoordenadas("53.481395189138, -4.517183127381");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            this.repositorio.remove(this.getSelected());
            return "remove";
        } else {
            return "";
        }

    }

    @Override
    public String preEdit() {
        return "edit";
    }

    public void selectedChange(ValueChangeEvent event) {
        this.setSelected((Tienda) event.getNewValue());
    }

    public Tienda getTiendaById(int id) {
        Tienda p = null;
        Optional<Tienda> element = this.getItems().stream().filter(item -> {
            return item.getId() == id;
        }).findFirst();
        if (!element.isEmpty()) {
            p = element.get();
        }
        return p;
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected() != null) {
            if (this.getSelected().getId() == -1) {
                this.getSelected().setId(this.repositorio.getAll().size() + 1);
                this.repositorio.create(this.getSelected());
            } else {

                this.repositorio.update(this.getSelected());
            }
        }
        return "sucess";
    }
}
