/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.dto;

import g58990.stibride.repository.RepositoryException;
import g58990.stibride.repository.StopsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class StationsDto extends Dto<Integer> {
    private final String name;
    private List<StopsDto> stops;
    
    public StationsDto(int id, String name) {
        super(id);
        this.name = name;
        StopsRepository stopRep = new StopsRepository();
        try {
            stops = stopRep.getWithStation(id);
        } catch (RepositoryException ex) {
            Logger.getLogger(StationsDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Integer getId() {
        return key;
    }
    
    public String getName() {
        return name;
    }
    
    public List<Integer> getLines() {
        List<Integer> lines = new ArrayList<>();
        for (StopsDto stop : stops) {
            lines.add(stop.getIdLine());
        }
        return lines;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
