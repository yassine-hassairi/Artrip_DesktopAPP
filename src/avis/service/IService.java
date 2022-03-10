/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avis.service;

import java.util.List;

/**
 *
 * @author IMEN
 * @param <T>
 */
public interface IService <T> {
    public void ajouter (T d);
    public List <T>affcher();
    public void modifier(T d);
    public void supprimer (int t);
    
}
