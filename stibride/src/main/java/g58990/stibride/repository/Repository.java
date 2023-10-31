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
public interface Repository<K, T extends Dto<K>> {
    
    public void add(T item) throws RepositoryException;
    
    public void remove(K item) throws RepositoryException;
    
    public void modify(T item) throws RepositoryException;
    
    public T get(K item) throws RepositoryException;
    
    public List<T> getAll() throws RepositoryException;
    
    public boolean contains(K item) throws RepositoryException;
}
