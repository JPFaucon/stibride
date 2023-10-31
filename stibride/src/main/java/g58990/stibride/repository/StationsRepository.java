/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.repository;

import g58990.stibride.dto.Dto;
import g58990.stibride.dto.StationsDto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class StationsRepository implements Repository<Integer, StationsDto> {
    
    private StationsDao stationsDao;
    
    public StationsRepository() {
        try {
            this.stationsDao = StationsDao.getInstance();
        } catch (RepositoryException ex) {
            Logger.getLogger(StationsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(StationsDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(Integer item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StationsDto get(Integer item) throws RepositoryException {
        return stationsDao.get(item);
    }

    @Override
    public List<StationsDto> getAll() throws RepositoryException {
        return stationsDao.getAll();
    }

    @Override
    public boolean contains(Integer item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modify(StationsDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
