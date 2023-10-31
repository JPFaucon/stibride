/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jp
 */
public class Node {
    
    private String name;
    
    private int id;
    
    private List<Node> shortestPath = new LinkedList<>();
    
    private Integer distance = Integer.MAX_VALUE;
    
    Map<Node, Integer> adjacentNodes = new HashMap<>();
    
    public void resetNode() {
        shortestPath.clear();
        distance = Integer.MAX_VALUE;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
 
    public Node(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getDistance() {
        return distance;
    }
    
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    
    public List<Node> getShortestPath() {
        return shortestPath;
    }
    
    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
    
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }
}
