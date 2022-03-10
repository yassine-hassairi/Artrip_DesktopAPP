/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.Service;


import java.util.List;

/**
 *
 * @author Sarra
 * @param <T>
 */
public interface IService<T> {
    public void ajouter(T d);
    public List<T> afficher();
    public void modifer(T d);
    public void supprimer( int t);
    
}
