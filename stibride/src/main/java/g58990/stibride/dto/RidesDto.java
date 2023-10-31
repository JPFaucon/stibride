/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.dto;

/**
 *
 * @author jp
 */
public class RidesDto extends Dto<Integer> {
    private String name;
    private int id_origine;
    private int id_destination;
    
    public RidesDto(int id, String name, int id_origine, int id_destination) {
        super(id);
        this.name = name;
        this.id_origine = id_origine;
        this.id_destination = id_destination;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setOrigine(int origine) {
        this.id_origine = origine;
    }
    
    public void setDestination(int destination) {
        this.id_destination = destination;
    }

    public String getName() {
        return name;
    }

    public int getOrigine() {
        return id_origine;
    }

    public int getDestination() {
        return id_destination;
    }

    @Override
    public Integer getKey() {
        return key;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
