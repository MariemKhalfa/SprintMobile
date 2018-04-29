/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.Entite.Activite;
import com.codename1.Entite.Evenement;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class ServiceEvenements {
    
    public ArrayList<Evenement> listEvenement() {
        ArrayList<Evenement> listEvenements= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://localhost/GitHub4/GitHub/SprintWeb/web/app_dev.php/evenement/liste");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> activites = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(activites);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) activites.get("root");
                    for (Map<String, Object> obj : list) {
                        Evenement evenement = new Evenement();
                        float id = Float.parseFloat(obj.get("id").toString());
       
                        
                        evenement.setId((int) id);
                        evenement.setIntitule(obj.get("intitule").toString());
                        evenement.setDate(toDate(obj.get("date").toString()));
                        evenement.setNbParticipants((int) id);
                        evenement.setBudget((int) id);

                        evenement.setCategorie(obj.get("categorie").toString());
                        evenement.setDescription(obj.get("description").toString());
                        evenement.setAdresse(obj.get("adresse").toString());
                        
                        listEvenements.add(evenement);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }

    public Date toDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("y-m-d");
            return sdf.parse(date);
        } catch (ParseException ex) {
        }
        return null;
    }
  public ArrayList<Evenement> searchEvenement(String key) {

        ArrayList<Evenement> listEvenements= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://localhost/GitHub4/GitHub/SprintWeb/web/app_dev.php/evenement/search/" + key);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> evenements = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(evenements);

                    List<Map<String, Object>> list = (List<Map<String, Object>>) evenements.get("root");
                    for (Map<String, Object> obj : list) {

             Evenement evenement= new Evenement();
                   float id = Float.parseFloat(obj.get("id").toString());
                        evenement.setId((int) id);
                        evenement.setIntitule(obj.get("intitule").toString());
                        evenement.setDate(toDate(obj.get("date").toString()));
                        evenement.setNbParticipants((int) id);
                        evenement.setBudget((int) id);
                        evenement.setCategorie(obj.get("categorie").toString());
                        evenement.setDescription(obj.get("description").toString());
                        evenement.setAdresse(obj.get("adresse").toString());
                        listEvenements.add(evenement);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }
  public void addEvenement(Evenement e) {
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://localhost/GitHub4/GitHub/SprintWeb/web/app_dev.php/activite/ajout?type=" + e.getIntitule() );

        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
