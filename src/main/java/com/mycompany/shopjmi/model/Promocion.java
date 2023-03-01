/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjmi.model;

/**
 *
 * @author Jeremy
 */
public class Promocion implements Comparable<Promocion>, Cloneable {

    private String nombre;
    private boolean activo;
    private int id;
    private String descripcion;
    private String fechainicio;
    private String fechafin;

    public Promocion() {
        this.id = -1;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Promocion o) {
        if (o == null) {
            return -1;
        } else {
            if (o.getId() == this.id) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    protected Object clone() {
        Promocion l = new Promocion();
        l.activo = this.activo;
        l.id = this.id;
        l.nombre = this.nombre;
        l.setDescripcion(this.getDescripcion());
        l.setFechainicio(this.getFechainicio());
        l.setFechafin(this.getFechafin());
        return l;
    }
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getFechainicio() {
        return fechainicio;
    }
    
    public String getFechafin() {
        return fechafin;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
}