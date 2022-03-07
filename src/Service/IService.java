/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IService <T> {
       public void ajouter(T H );
    public List<T > afficher();
    public void modifer(T H );
    public void supprimer(int t);
    
}

