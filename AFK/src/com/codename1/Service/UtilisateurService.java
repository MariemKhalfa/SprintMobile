/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ali
 */
public class UtilisateurService {
	private ConnectionRequest con;
    
    /*public Utilisateur findUser(String login)
    {
        Utilisateur user = new  Utilisateur();
        user.setId(null);
        con = new ConnectionRequest();
        con.setUrl("http://localhost/MobileCupCakes/ScriptPHP/Utilisateur/info_id.php?uid='" +login+"'"); 
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
                public void actionPerformed(NetworkEvent evt) {
                    try {
                        JSONParser j = new JSONParser();
                        Map<String, Object> Users = j.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                        System.out.println(Users);
                        List<Map<String, Object>> list = (List<Map<String, Object>>) Users.get("info");
                        System.out.println("info : " + list);
                        if( list!=null)
                        {
                            for (Map<String, Object> obj : list) { 
                                user.setId(Integer.parseInt(obj.get("id").toString()));
                                user.setUsername(obj.get("username").toString());
                                user.setPassword(obj.get("password").toString());
                                user.setEmail(obj.get("email").toString());
                                user.setPhotodeprofil(obj.get("imageProfil").toString());
                                user.setAdresse(obj.get("adresse").toString());
                                user.setRoles(obj.get("roles").toString());
                                user.setTelephone(obj.get("telephone").toString());
                                user.setNomVisiteur(obj.get("nomVisiteur").toString());
                                user.setPrenomVisiteur(obj.get("prenomVisiteur").toString());
                            }
                        }
                    } catch (IOException ex) {
                    }
                }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return user;
    }*/
	
	public boolean verifFailed(String s,String toVerif){
		System.out.println(s.substring(1,s.length()-1).equals("Failed"));
		return s.substring(1,s.length()-1).equals(toVerif);
	}
	public User login(String json)  {
		ArrayList<User> user = new ArrayList<>();
		if(!verifFailed(json,"Failed")){
			try {
				System.out.println(json);
				JSONParser j = new JSONParser();
				System.out.println("	uuuuuuuu");
				Map<String, Object> obj = j.parseJSON(new CharArrayReader(json.toCharArray()));
				System.out.println(obj);
				System.out.println("");
				//List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("root");
				User u = new User();
				System.out.println(obj.get("id"));
				float id = Float.parseFloat(obj.get("id").toString());
				System.out.println(id);
				u.setId((int) id);
				u.setNom(""+obj.get("nom"));
				u.setPrenom(""+obj.get("prenom"));
				u.setEmail(""+obj.get("email"));
				
				float tel = Float.parseFloat(obj.get("telephone").toString());
				u.setTelephone((int)tel);
				u.setVille(""+obj.get("ville"));
				System.out.println(u);
				user.add(u);
				System.out.println(user);
				return user.get(0);
			} catch (IOException ex) {
			}
		}
		User u=new User();
		u.setId(-1);
		return u;
        }	}
	
	
        
