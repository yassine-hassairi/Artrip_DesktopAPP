/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Yassine
 * @param <T>
 */

public interface IService<T> {
    
    public void ajouter(T d) ;
    public List<T> afficher() ;
    public void modifier(T d);
    public void supprimer(T d);
    
}
