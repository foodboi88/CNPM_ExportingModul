/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInter;

import entity.Agency;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public interface IAgency {
    ArrayList<Agency> searchAgency(String key);
    Agency getAgencyById(int key);
    ArrayList<Agency> getAllAgency();
    void addAgency(Agency agency);
    void editAgency(Agency agency);
    void deleteAgency(int id);
}
