/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui.pheonixui;

import com.codename1.Entite.Babysitting;
import com.codename1.Service.ServiceBabysitting;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author Mariem
 */
public class AjoutBabysitting extends  com.codename1.ui.Form{

	Form f;
//    TextField tnom;
//    TextField tetat;
	TextField  nbr, adr, hD, hF;
	Picker dat;
	Button btnajout, btnaff;
	public AjoutBabysitting(){
		 this(com.codename1.ui.util.Resources.getGlobalResources());
		 f = new Form("Babysitting");
//        tnom = new TextField();
//        tetat = new TextField();
		dat = new Picker();
		adr = new TextField();
		nbr = new TextField();
		hD = new TextField();
		hF = new TextField();
		btnajout = new Button("Ajouter");
		btnaff = new Button("Afficher Liste");
		
		f.add(dat);
		f.add(adr);
		f.add(nbr);
		f.add(hD);
		f.add(hF);
		f.add(btnajout);
		f.add(btnaff);
		btnajout.addActionListener((e) -> {
			ServiceBabysitting ser = new ServiceBabysitting();
			Babysitting b = new Babysitting(dat.getDate(), adr.getText(), hD.getText(), hF.getText(), Integer.parseInt(nbr.getText()));
			ser.ajoutBabysitting(b);

		});
		btnaff.addActionListener((e) -> {
//        Affichage a=new Affichage();
//		a.getF().show();
			ListeBabysittings l = new ListeBabysittings();
			l.getF().show();

		});
		
	}
	public Form getF() {
		return f;
	}

	public void setF(Form f) {
		this.f = f;
	}
	 public AjoutBabysitting(com.codename1.ui.util.Resources resourceObjectInstance) {
		
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("ListeBabysittings");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "mBab.png", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e -> new ListeBabysittings().show());
        getContentPane().setUIID("ListeBabysittings");
    }
	    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Sign In");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Text_Field_2.setText("TextField");
        gui_Text_Field_2.setName("Text_Field_2");
        gui_Text_Field_1.setText("TextField");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("profile_image.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Sign In");
        gui_Button_2.setName("Button_2");
        gui_Button_3.setText("Forgot Your Password");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Create New Account");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
      if(gui_Text_Field_1.getText().equals("admin") && gui_Text_Field_2.getText().equals("admin"))
	  {
		  StatsForm s=new StatsForm(com.codename1.ui.util.Resources.getGlobalResources());
		  s.show();
	  }}
	
}
