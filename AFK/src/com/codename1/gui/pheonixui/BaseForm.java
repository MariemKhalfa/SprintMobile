/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.gui.pheonixui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
		
		Image babImage = null;
        if(isCurrentTrending()) babImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
         Image activiteImage = null;
        if(isCurrentStats()) activiteImage = selection;
        
<<<<<<< Updated upstream
           Image evenementImage = null;
        if(isCurrentStats()) evenementImage = selection;
=======
             Image statImage = null;
        if(isCurrentStats()) statImage = selection;
        
        
>>>>>>> Stashed changes
        
        Button inboxButton = new Button("Mon Profil", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new InboxForm().show());
        getToolbar().addComponentToSideMenu(inbox);
        
        
        getToolbar().addCommandToSideMenu("Activités", activiteImage, e -> {
            try {
                new ActiviteList();
            } catch (IOException ex) {
            }
        });
        
<<<<<<< Updated upstream
         getToolbar().addCommandToSideMenu("Evenement", evenementImage, e -> {
            try {
                new EvenementsListe();
            } catch (IOException ex) {
            }
        });
        
        
=======
   
        
        getToolbar().addCommandToSideMenu("Statistique", statImage, e -> new Statistic().createPieChartForm().show());
>>>>>>> Stashed changes
        getToolbar().addCommandToSideMenu("Garderies", statsImage, e -> new StatsForm(res).show());
        getToolbar().addCommandToSideMenu("Covoiturages", calendarImage, e -> new CalendarForm(res).show());
        getToolbar().addCommandToSideMenu("Babysittings", babImage, e -> new AjoutBabysitting().show());
        getToolbar().addCommandToSideMenu("Medecins", trendingImage, e -> new TrendingForm(res).show());
	getToolbar().addCommandToSideMenu("Recettes", null, e -> new AccueilRecette(res).show());
	getToolbar().addCommandToSideMenu("Jeux", null, e -> new Game());
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label("Long Beach, CA", "SideCommandSmall"));
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
