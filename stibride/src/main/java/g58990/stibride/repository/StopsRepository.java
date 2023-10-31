/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.repository;

import g58990.stibride.dto.Dto;
import g58990.stibride.dto.PairInteger;
import g58990.stibride.dto.StopsDto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class StopsRepository implements Repository<PairInteger, StopsDto> {
    
    private StopsDao stopsDao;
    
    public StopsRepository() {
        try {
            this.stopsDao = StopsDao.getInstance();
        } catch (RepositoryException ex) {
            Logger.getLogger(StopsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(StopsDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(PairInteger item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StopsDto get(PairInteger item) throws RepositoryException {
        return stopsDao.get(item);
    }

    @Override
    public List<StopsDto> getAll() throws RepositoryException {
        return stopsDao.getAll();
    }
    
    public List<StopsDto> getWithStation(int station) throws RepositoryException {
        return stopsDao.getWithStation(station);
    }
    
    public int getNumberStationInLine(int line) throws RepositoryException {
        return stopsDao.getNumberStationInLine(line);
    }

    @Override
    public boolean contains(PairInteger item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modify(StopsDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
