/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.dto;

/**
 *
 * @author jp
 */
public class StopsDto extends Dto<PairInteger> {
    private final int idStation;
    
    public StopsDto (int idLine, int idStation, int idOrder) {
        super(new PairInteger(idLine, idOrder));
        this.idStation = idStation;
    }
    
    public Integer getIdLine() {
        return key.getI1();
    }
    
    public Integer getIdStation() {
        return idStation;
    }
    
    public Integer getIdOrder() {
        return key.getI2();
    }

    @Override
    public String toString() {
        return "StopsDto{" + 
                "idLine=" + key.getI1() + 
                "idStation=" + idStation +
                "idOrder=" + key.getI2() +
                '}';
    }
}
