/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.repository;

import g58990.stibride.dto.PairInteger;
import g58990.stibride.dto.StopsDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jp
 */
public class StopsDao implements Dao<PairInteger, StopsDto> {
    
    private Connection connection;
    
    private StopsDao() {
        try {
            connection = DBManager.getInstance().getConnection();
        } catch (RepositoryException e) {
            System.out.println("Crash stopsdao");
        }
    }
    
    public static StopsDao getInstance() throws RepositoryException {
        return StopsDaoHolder.getInstance();
    }

    @Override
    public void insert(StopsDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PairInteger item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(StopsDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public StopsDto get(PairInteger key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id_line,id_station,id_order FROM STOPS "
                + "WHERE  id_line = ? AND id_order = ?";
        StopsDto dto = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, key.getI1());
            pstmt.setInt(2, key.getI2());
            ResultSet rs = pstmt.executeQuery();

            int count = 0;
            while (rs.next()) {
                dto = new StopsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                count++;
            }
            if (count > 1) {
                throw new RepositoryException("Record pas unique " + key);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dto;
    }
    
    public List<StopsDto> getWithStation(Integer station) throws RepositoryException {
        if (station == null) {
            throw new RepositoryException("Aucune station donnée en paramètre");
        }
        String sql = "SELECT id_line,id_station,id_order FROM STOPS "
                + "WHERE  id_station = ?";
        List<StopsDto> dtos = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, station);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dtos.add(new StopsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    @Override
    public List<StopsDto> getAll() throws RepositoryException {
        String sql = "SELECT id_line,id_station,id_order FROM STOPS";
        List<StopsDto> dtos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StopsDto dto = new StopsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }
    
    public int getNumberStationInLine(Integer line) throws RepositoryException {
        String sql = "SELECT count(*) FROM STOPS WHERE id_line = ?";
        int count = -1;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, line);
            ResultSet rs = pstmt.executeQuery();
            count = rs.getInt(1);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return count;
    }
    
    private class StopsDaoHolder {
        
        private static final StopsDao INSTANCE = new StopsDao();
        
        public static StopsDao getInstance() throws RepositoryException {
            return INSTANCE;
        }
    }
}
