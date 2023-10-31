/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.repository;

/**
 *
 * @author jp
 */
public class RepositoryException extends Exception {
    
    public RepositoryException(Exception exception) {
        super(exception);
    }
    
    public RepositoryException(String name) {
        super(name);
    }
    
    public RepositoryException() {
        super();
    }
}

