/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author duy
 * @param <T>
 */
public interface CRUD<T> {
    public T getByID(Integer id);
    
    public List<T> getAll();
    
    public T add(T entity);
    
    public boolean addAll(List<T> entity);
    
    public boolean delete(T entity);
}
