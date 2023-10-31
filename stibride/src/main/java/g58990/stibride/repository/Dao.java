/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package g58990.stibride.repository;

import g58990.stibride.dto.Dto;
import java.util.List;

/**
 *
 * @author jp
 * @param <K>
 * @param <T>
 */
public interface Dao<K, T extends Dto<K>> {
    
    public void insert(T item) throws RepositoryException;
    
    public void delete(K item) throws RepositoryException;
    
    public void update(T item) throws RepositoryException;
    
    public T get(K item) throws RepositoryException;
    
    public List<T> getAll() throws RepositoryException;
}