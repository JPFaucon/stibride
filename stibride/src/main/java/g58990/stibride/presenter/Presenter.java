/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.presenter;

import g58990.stibride.dto.RidesDto;
import g58990.stibride.dto.StationsDto;
import g58990.stibride.model.ShortestWay;
import g58990.stibride.oo.Observer;
import g58990.stibride.repository.RepositoryException;
import g58990.stibride.repository.RidesRepository;
import g58990.stibride.repository.StationsRepository;
import g58990.stibride.view.MainViewController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Presenter implements Observer {
    private ShortestWay model;
    private MainViewController view;
    
    public Presenter(ShortestWay model) {
        this.model = model;
        this.model.registerObserver(this);
    }
    
    public void setView(MainViewController view) {
        this.view = view;
    }
    
    public List<StationsDto> getStations() {
        List<StationsDto> stations = new ArrayList<>();
        try {
            stations = new StationsRepository().getAll();
        } catch (RepositoryException ex) {
            Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stations;
    }
    
    public List<RidesDto> getFavoris() {
        List<RidesDto> favoris = new ArrayList<>();
        try {
            favoris = new RidesRepository().getAll();
        } catch (RepositoryException ex) {
            Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return favoris;
        
    }
    
    public void addFav(String name, StationsDto origineStation, StationsDto destinationStation) {
        try {
            RidesRepository rr = new RidesRepository();
            int origine = origineStation.getId();
            int destination = destinationStation.getId();
            RidesDto fav = new RidesDto(0, name, origine, destination);
            rr.add(fav);
            view.updateFav();
        } catch (RepositoryException ex) {
            Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifyFav(RidesDto oldFav, String name, StationsDto origineStation, StationsDto destinationStation) {
        try {
            RidesRepository rr = new RidesRepository();
            int key = oldFav.getKey();
            int origine = origineStation.getId();
            int destination = destinationStation.getId();
            RidesDto fav = new RidesDto(key, name, origine, destination);
            rr.modify(fav);
            view.updateFav();
        } catch (RepositoryException ex) {
            Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteFav(RidesDto fav) {
        try {
            RidesRepository rr = new RidesRepository();
            rr.remove(fav.getKey());
            view.updateFav();
        } catch (RepositoryException ex) {
            Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void shortestPath(StationsDto station1, StationsDto station2) {
        model.getShortestPath(station1, station2);
    }
    
    public void shortestPathFav(RidesDto fav) {
        try {
            StationsRepository sr = new StationsRepository();
            StationsDto station1 = sr.get(fav.getOrigine());
            StationsDto station2 = sr.get(fav.getDestination());
            model.getShortestPath(station1, station2);
        } catch (RepositoryException ex) {
            Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(List<StationsDto> stations) {
        view.updateTable(stations);
    }
}
