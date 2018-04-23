/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.myapp.Service;

import afk.myapp.Entite.Babysitting;
import afk.myapp.Entite.User;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author Mariem
 */
public class ServiceBabysitting {
	
	 public void ajoutBabysitting(Babysitting B) {
        ConnectionRequest con = new ConnectionRequest();
		
        String Url = "http://localhost/GitHub/SprintWeb/web/app_dev.php/api/babysitting/" + B.getTitre() + "/" + 
				B.getDate()+ "/" + B.getAdresse() + "/"  + "/" + B.getNbrEnfants() + "/" +B.getDescription();
//		+ B.getHeureDeb() + "/" +
//				B.getHeureFin()
		//+"/" +B.setBabysitteur(currentUser.getId());
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
