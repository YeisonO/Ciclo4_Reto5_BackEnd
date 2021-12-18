/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2Web.Reto2Ciclo4.Repositorio;

import Reto2Web.Reto2Ciclo4.Interfaces.InterfaceUser;
import Reto2Web.Reto2Ciclo4.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yeison Orozco
 * @Class UserRepository
 */
@Repository
public class UserRepositorio {
    /**
     * 
     * Inyeccion de Dependencias
     */
    @Autowired
    private InterfaceUser userCrudRepository;
    
    /**
     * Metodo para traer la Lista de todos los usuarios
     * @return 
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
     /**
      * 
      * Metodo para traer un usuario por su id
      * @param id
      * @return 
      */
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    /**
     * 
     * Metodo para crear un nuevo usuario
     * @param user
     * @return 
     */
    public User create(User user){
        return userCrudRepository.save(user);
    }
    
    /**
     * Metodo para actualizar un usuario existente
     * @param user 
     */
    public void update(User user){
        userCrudRepository.save(user);
    }
    
    /**
     * Metodo para borrar un usuario existente
     * @param user 
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }
    
    /**
     * 
     * Metodo para verificar si el email esta registrado
     * @param email
     * @return 
     */
    public boolean emailExists(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    /**
     * Metodo para autenticar a un usuario
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Metodo para traer la lista de usuarios que cumplen en dicho mes
     * @param month
     * @return 
     */
    public List<User> getByMonthBirthtDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
