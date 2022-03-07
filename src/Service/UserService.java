/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import model.User;

/**
 *
 * @author ASUS
 */
public class UserService  implements IService<User>{
    private final Connection  cnx;
    public UserService (){
         cnx = Connexion.getInstance().getCnx();
    }

     @Override
    public void ajouter(User u) {
        try {
            String querry = "INSERT INTO `user`(`nom`, `prenom`, `adresse`, `telephone`, `email`, `username`, `password`) VALUES ('" + u.getNom() + "','" + u.getPrenom() + "','" + u.getAdresse() + "','" + u.getTelephone() + "','" + u.getEmail() + "','" + u.getUsername() + "','" + u.getPassword() +"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<User> afficher() {
        List<User> user  = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM user";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setAdresse(rs.getString("adresse"));
                u.setTelephone(rs.getInt("telephone"));
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
               

                user.add(u);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return user;
    }

  
    @Override
    public void supprimer(int t) {
        PreparedStatement ps;

        try {
            String querry = "UPDATE `user` SET `Etat`=1 WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("user deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void modifer(User u) {
        try {
            
            String querry = "UPDATE `user` SET `nom`='" +  u.getNom() + "',`prenom`='" +  u.getPrenom() + "',`adresse`='" + u.getAdresse() + "',`telephone`='" + u.getTelephone() + "' ,`email`='" + u.getEmail() + "',`username`='" + u.getUsername() +"',`password`='" + u.getPassword()+ "' WHERE `id`='" + u.getId() +  "'";

            Statement ps = cnx.createStatement();
            ps.executeUpdate(querry);
            System.out.println("user modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
    }

      
    
    public  List<User> findById(int id) {
       List<User> users = afficher();
        List<User> resultat = users.stream().filter(user -> id ==user.getId()).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }

    public List<User> sortedById() {
         List<User> users = afficher();
        List<User>  resultat = users.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
        resultat.forEach(System.out::println);
        return resultat;

    }
       
}
