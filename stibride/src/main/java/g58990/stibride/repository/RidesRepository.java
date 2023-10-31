/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.repository;

import g58990.stibride.dto.RidesDto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class RidesRepository implements Repository<Integer, RidesDto> {
    
    private RidesDao ridesDao;
    
    public RidesRepository() {
        try {
            this.ridesDao = RidesDao.getInstance();
        } catch (RepositoryException ex) {
            Logger.getLogger(StationsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(RidesDto item) throws RepositoryException {
        StationsRepository sr = new StationsRepository();
        try {
            sr.get(item.getDestination());
            sr.get(item.getOrigine());
        } catch (RepositoryException e) {
            throw e;
        }
        ridesDao.insert(item);
    }

    @Override
    public void remove(Integer item) throws RepositoryException {
        ridesDao.delete(item);
    }

    @Override
    public RidesDto get(Integer item) throws RepositoryException {
        return ridesDao.get(item);
    }

    @Override
    public List<RidesDto> getAll() throws RepositoryException {
        return ridesDao.getAll();
    }

    @Override
    public boolean contains(Integer item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modify(RidesDto item) throws RepositoryException {
        StationsRepository sr = new StationsRepository();
        try {
            sr.get(item.getDestination());
            sr.get(item.getOrigine());
        } catch (RepositoryException e) {
            throw e;
        }
        ridesDao.update(item);
    }
    
}
