/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;


import com.codename1.Entite.Activite;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lynda
 */
public class ServiceActivite {

    public void addActivite(Activite e) {
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://localhost/GitHub4/GitHub/SprintWeb/web/app_dev.php/activite/ajout?type=" + e.getType() + "&sdate=" + e.getDate().toString() + "&ageMin=" + e.getAge_min() + "&heure=" + e.getHeure()
                + "&description=" + e.getDescription() + "&adresse=" + e.getAdresse());

        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void delActivite(Activite e) {

        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://127.0.0.1:8000/activite/" + e.getId() + "/delete");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<Activite> listActivite() {
        ArrayList<Activite> listActivites = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://localhost/GitHub4/GitHub/SprintWeb/web/app_dev.php/activite/list");
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
                        Activite activite = new Activite();
                        float id = Float.parseFloat(obj.get("id").toString());

                        activite.setId((int) id);
                        activite.setType(obj.get("type").toString());
                        activite.setDate(toDate(obj.get("date").toString()));
                        activite.setAge_min((int) id);
                        activite.setHeure(obj.get("heure").toString());
                        activite.setDescription(obj.get("description").toString());

                        listActivites.add(activite);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listActivites;
    }

    public Date toDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.parse(date);
        } catch (ParseException ex) {
        }
        return null;
    }

    
    public ArrayList<Activite> searchActivite(String key) {

        ArrayList<Activite> listActivites = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setPost(true);
        con.setUrl("http://localhost/GitHub4/GitHub/SprintWeb/web/app_dev.php/activite/search/" + key);
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

                        Activite activite = new Activite();
                   float id = Float.parseFloat(obj.get("id").toString());
                        
                        activite.setId((int) id);
                         activite.setType(obj.get("type").toString());
                            activite.setDate(toDate(obj.get("date").toString()));
                            activite.setAge_min((int) id);
                            activite.setHeure(obj.get("heure").toString());
                            activite.setDescription(obj.get("description").toString());
                        listActivites.add(activite);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listActivites;
    }
    
    
    
  

    }


