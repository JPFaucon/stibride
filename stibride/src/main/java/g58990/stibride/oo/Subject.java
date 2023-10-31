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
public interface Subject {
    /**
     * Register a new observer.
     * @param observer the new observer
     */
    public void registerObserver(Observer observer);
    /**
     * Remove an observer.
     * @param observer the observer to remove
     */
    public void removeObserver(Observer observer);
    /**
     * Notify the observer.
     * @param stations
     */
    public void notifyObserver(List<StationsDto> stations);
}
