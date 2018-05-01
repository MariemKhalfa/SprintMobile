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
import com.codename1.Entite.Voiture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mariem
 */
public class ServiceVoiture {

	public void ajoutVoiture(Voiture V) {
		ConnectionRequest con = new ConnectionRequest();

		String Url = "http://localhost/GitHub/SprintWeb/web/app_dev.php/api/newVoit?mat=" + V.getMatricule() + "&mar="
				+ V.getMarque() + "&mod=" + V.getModele() + "&col=" + V.getCouleur() + "&nb=" + V.getNbSieges() + "&prop=" + V.getProprio();

		con.setUrl(Url);

		con.addResponseListener((e) -> {
			String str = new String(con.getResponseData());
			System.out.println(str);
		});
		NetworkManager.getInstance().addToQueueAndWait(con);
	}

	public ArrayList<Voiture> getListV() {
		ArrayList<Voiture> listVoitures = new ArrayList<>();
		ConnectionRequest con = new ConnectionRequest();
		con.setUrl("http://localhost/GitHub/SprintWeb/web/app_dev.php/api/allVoit");
		con.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				JSONParser jsonp = new JSONParser();

				try {
					Map<String, Object> voitures = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
					System.out.println(voitures);
					List<Map<String, Object>> list = (List<Map<String, Object>>) voitures.get("root");
					for (Map<String, Object> obj : list) {
						Voiture v = new Voiture();
						//float p=Float.parseFloat(obj.get("proprio").toString());
						float nb=Float.parseFloat(obj.get("nbSieges").toString());
						//int nb=Integer.parseInt(obj.get("nbSieges").toString());
						
						v.setMatricule(obj.get("matricule").toString());
						v.setMarque(obj.get("marque").toString());
						v.setModele(obj.get("modele").toString());
						v.setCouleur(obj.get("couleur").toString());
						v.setNbSieges((int)nb);
				
						//v.setProprio((int)p);
						listVoitures.add(v);

					}
				} catch (IOException ex) {
				}

			}
		});
		NetworkManager.getInstance().addToQueueAndWait(con);
		return listVoitures;
	}

}
