/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.repository;

import g58990.stibride.dto.RidesDto;
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
public class RidesDao implements Dao<Integer, RidesDto> {

    private Connection connection;
    
    private RidesDao() {
        try {
            connection = DBManager.getInstance().getConnection();
        } catch (RepositoryException e) {
            System.out.println("Crash ridesdao");
        }
    }
    
    public static RidesDao getInstance() throws RepositoryException {
        return RidesDaoHolder.getInstance();
    }

    @Override
    public void insert(RidesDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        String sql = "INSERT INTO RIDES(name,originestation, destinationstation) values(?, ?, ? )";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getOrigine());
            pstmt.setInt(3, item.getDestination());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "DELETE FROM RIDES WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, key);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }

    }

    @Override
    public void update(RidesDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        String sql = "UPDATE RIDES SET name=?, originestation=?, destinationstation=? where id=? ";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getOrigine());
            pstmt.setInt(3, item.getDestination());
            pstmt.setInt(4, item.getKey());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public RidesDto get(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id, name, originestation, destinationstation FROM RIDES WHERE  id = ?";
        RidesDto dto = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, key);
            ResultSet rs = pstmt.executeQuery();

            int count = 0;
            while (rs.next()) {
                dto = new RidesDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
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

    @Override
    public List<RidesDto> getAll() throws RepositoryException {
        String sql = "SELECT id, name, originestation, destinationstation FROM Rides";
        List<RidesDto> dtos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RidesDto dto = new RidesDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }
    
    private class RidesDaoHolder {
        
        private static final RidesDao INSTANCE = new RidesDao();
        
        public static RidesDao getInstance() throws RepositoryException {
            return INSTANCE;
        }
    }
    
}
