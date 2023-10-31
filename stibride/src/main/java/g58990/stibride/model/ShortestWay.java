/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.model;

import g58990.stibride.dto.PairInteger;
import g58990.stibride.dto.StationsDto;
import g58990.stibride.dto.StopsDto;
import g58990.stibride.oo.Observer;
import g58990.stibride.oo.Subject;
import g58990.stibride.repository.RepositoryException;
import g58990.stibride.repository.StationsRepository;
import g58990.stibride.repository.StopsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class ShortestWay implements Subject {
    
    private final Graph graph;
    private List<Observer> observers;
    
    public ShortestWay() {
        graph = new Graph();
        initializeGraph();
        observers = new ArrayList();
    }
    
    private void initializeGraph() {
        
        StationsRepository stationsR = new StationsRepository();
        StopsRepository stopR = new StopsRepository();
        
        try {
            for (StationsDto station : stationsR.getAll()) {
                Node node = new Node(station.getName(), station.getId());
                graph.addNode(station.getId(), node);
            }
            
            Map<Integer, Node> nodes = graph.getNodes();
            
            for (var entry : nodes.entrySet()) {
                
                for (var stop : stopR.getWithStation(entry.getKey())) {
                    
                    StopsDto stop1 = null;
                    StopsDto stop2 = null;
                    
                    if (stop.getIdOrder() < stopR.getNumberStationInLine(stop.getIdLine()))
                        stop1 = stopR.get(
                                new PairInteger(stop.getIdLine(), stop.getIdOrder() + 1));
                    if (stop.getIdOrder() > 0)
                        stop2 = stopR.get(
                                new PairInteger(stop.getIdLine(), stop.getIdOrder() - 1));
                    
                    if (stop1 != null)
                        entry.getValue().addDestination(nodes.get(stop1.getIdStation()), 1);
                    
                    if (stop2 != null)
                        entry.getValue().addDestination(nodes.get(stop2.getIdStation()), 1);
                }
            }
        } catch (RepositoryException ex) {
            Logger.getLogger(ShortestWay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getShortestPath(StationsDto station1, StationsDto station2) {
        Graph.calculateShortestPathFromSource(graph, graph.getNodes().get(station1.getId()));
        List<Node> nodes = graph.getNodes().get(station2.getId()).getShortestPath();
        
        List<StationsDto> shortestPath = new ArrayList();
        
        for (Node node : nodes) {
            shortestPath.add(new StationsDto(node.getId(), node.getName()));
        }
        shortestPath.add(new StationsDto(station2.getId(), station2.getName()));
        
        notifyObserver(shortestPath);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(List<StationsDto> stations) {
        for (Observer observer : observers) {
            observer.update(stations);
        }
    }
}