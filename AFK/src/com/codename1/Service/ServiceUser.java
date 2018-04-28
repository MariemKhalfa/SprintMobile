/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.Entite.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sofien
 */
public class ServiceUser {
    
    
        public ArrayList<User> getEnseignant() {
        ArrayList<User> listEnseignant = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/EnseignantAjax");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        User User = new User();
                        float id = Float.parseFloat(obj.get("id").toString());
                        User.setId((int)id);
                        System.out.println(obj.get("description"));
                        User.setDescription(obj.get("description").toString());
                        User.setPhoto(obj.get("photo").toString());
                        User.setNom(obj.get("nom").toString());
                        User.setPrenom(obj.get("prenom").toString());
                        User.setSpecialite(obj.get("specialite").toString());
                        User.setEmail(obj.get("email").toString());
                        float Telephone=Float.parseFloat(obj.get("telephone").toString());
                        User.setTelephone((int)Telephone);
                        
                        // Recette.setLikeCount((int) Float.parseFloat(obj.get("like_count").toString()));
                       // Recette.setDislikeCount((int) Float.parseFloat(obj.get("dislike_count").toString()));

                        listEnseignant.add(User);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEnseignant;
    }
}

