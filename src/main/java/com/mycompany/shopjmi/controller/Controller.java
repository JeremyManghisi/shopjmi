/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopjmi.controller;

import com.mycompany.shopjmi.model.Model;
import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public abstract class Controller {
    
    public abstract Model crear();
    public abstract ArrayList<Model> listar();
    public abstract void eliminar();
    public abstract Model editar();
}
