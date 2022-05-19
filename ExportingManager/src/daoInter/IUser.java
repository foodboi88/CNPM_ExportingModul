/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInter;

import entity.User;

/**
 *
 * @author admin
 */
public interface IUser {
    boolean checkLogin(User user);
}
