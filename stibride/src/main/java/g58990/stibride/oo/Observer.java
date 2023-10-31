/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package g58990.stibride.oo;

import g58990.stibride.dto.StationsDto;
import java.util.List;

/**
 *
 * @author jp
 */
public interface Observer {
    /**
     * This method is called whenever the observed object has changed.
     * @param stations
     */
    public void update(List<StationsDto> stations);
}
