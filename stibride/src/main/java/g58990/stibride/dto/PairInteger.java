/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.dto;

import java.util.Objects;

/**
 *
 * @author jp
 */
public class PairInteger {
    private Integer i1;
    private Integer i2;
    
    public PairInteger(Integer i1, Integer i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public Integer getI1() {
        return i1;
    }

    public Integer getI2() {
        return i2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.i1);
        hash = 79 * hash + Objects.hashCode(this.i2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PairInteger other = (PairInteger) obj;
        if (!Objects.equals(this.i1, other.i1)) {
            return false;
        }
        return Objects.equals(this.i2, other.i2);
    }
    
    
}
