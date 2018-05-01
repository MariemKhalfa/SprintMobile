/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui.pheonixui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Mariem
 */
public class BaseBabForm extends Form{
	
	public void BaseBabForm (Resources res) {
		  //Image selection = res.getImage("calendar-background.png");
		 // this(com.codename1.ui.util.Resources.getGlobalResources());
		  
//	 Image addImage = null;
//        if(isCurrentInbox()) addImage = selection;
//
//        Image listImage = null;
//        if(isCurrentTrending()) listImage = selection;
//		
//		Image findImage = null;
//        if(isCurrentTrending()) findImage = selection;
//        
//        Image calendarImage = null;
//        if(isCurrentCalendar()) calendarImage = selection;
//        
//        Image statsImage = null;
//        if(isCurrentStats()) statsImage = selection;
//        
//        Button addButton = new Button("Proposer un babysitting", addImage);
//        addButton.setUIID("SideCommand");
//        addButton.getAllStyles().setPaddingBottom(0);
//        Container ajout = FlowLayout.encloseMiddle(addButton, 
//                new Label("10", "SideCommandNumber"));
//        ajout.setLeadComponent(addButton);
//        ajout.setUIID("SideCommand");
//        addButton.addActionListener(e -> new AjoutBabysitting().show());
//        getToolbar().addComponentToSideMenu(ajout);
//        
//        getToolbar().addCommandToSideMenu("Proposer un babysitting", addImage, e -> new AjoutBabysitting(res).show());
//        getToolbar().addCommandToSideMenu("Liste des babysittings", listImage, e -> new ListeBabysittings().show());
//        getToolbar().addCommandToSideMenu("Touver un babysitting", findImage, e -> new StatsForm(res).show());
//        getToolbar().addCommandToSideMenu("Voir sur la carte", calendarImage, e -> new CalendarForm(res).show());
      
        
        // spacer
//        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
//        getToolbar().addComponentToSideMenu(new Label(res.getImage("mbab.png"), "Container"));
//        getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
//        getToolbar().addComponentToSideMenu(new Label("Long Beach, CA", "SideCommandSmall"));
    }

        
    protected boolean isCurrentAjout() {
        return false;
    }
    
    protected boolean isCurrentList() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
	
}
