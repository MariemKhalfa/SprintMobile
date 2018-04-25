/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Service;

import com.codename1.Entite.Covoiturage;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author Mariem
 */
public class ServiceCovoiturage {
	
	 public void ajoutBabysitting(Covoiturage C) {
        ConnectionRequest con = new ConnectionRequest();
		
		String Url = "http://localhost/GitHub/SprintWeb/web/app_dev.php/api/newCov?tit=" + C.getTitre() + "&dat=" + 
				C.getDate()+"&lDep="+ C.getLieuDep() + "&lDest="+ C.getLieuDest()+"&desc="
				+C.getDescription()+"&nbr=" + C.getNbPlaces()+ "&cov=" +C.getCovoitureur();
		
        /*String Url = "http://localhost/GitHub/SprintWeb/web/app_dev.php/api/newBab?tit=" + B.getTitre() + "&dat=" + 
				B.getDate()+ "&deb=" + B.getHeureDeb() +" &fin="+B.getHeureFin()+"&adr="+ B.getAdresse() + "&desc="
				+B.getDescription()+"&nbr=" + B.getNbrEnfants()+ "&bab=" +B.getBabysitteur();*/

        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
	
}
