/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.shopjmi.controller.repository;

import java.util.ArrayList;

/**
 *
 * @author Jeremy
 * @param <T>
 */
public interface IRepository<T> {
    public void create(T item);
    public void update(T item);
    public void remove(int id);
    public void remove (T item);
    public ArrayList<T> getAll();
    public T getByid(int id);
    
    
}