/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui.pheonixui;

import com.codename1.Entite.Activite;
import com.codename1.Entite.Evenement;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.Service.ServiceEvenements;
import com.codename1.components.InteractionDialog;
import com.codename1.components.MultiButton;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Arshavin
 */
public final class EvenementsListe extends  com.codename1.ui.Form{

    private Form form;
    private MultiButton mb;
    private Container container;
    protected final AutoCompleteTextField search;
    private Resources theme;
    private int id;
    
    
    Style s = UIManager.getInstance().getComponentStyle("Button");
    Style style = UIManager.getInstance().getComponentStyle("Label");
    FontImage p = FontImage.createMaterial(FontImage.MATERIAL_REMOVE_CIRCLE, s);
    EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 4, p.getHeight() * 5), false);
    Font smallPlainSystemFont = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL);
    Font mediumPlainMonospaceFont = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
    Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
    Font smallUnderlineMonospaceFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED, Font.SIZE_SMALL);
    ServiceEvenements es = new ServiceEvenements();

    public EvenementsListe() throws IOException {
        form = new Form("Liste des Evenements", new BoxLayout(BoxLayout.Y_AXIS));
        theme = UIManager.initFirstTheme("/theme");
        ArrayList<Evenement> evenements = es.listEvenement();
        final DefaultListModel<String> options = new DefaultListModel<>();
        final Form f = new Form("Evenement");
        final ArrayList<Evenement> evenement = evenements;
        ArrayList<Integer> ids = new ArrayList<>();
        search = new AutoCompleteTextField(options) {
            @Override
            protected boolean filter(String text) {
                if (text.length() == 0) {
                    return false;
                }
                ArrayList<Evenement> l = es.searchEvenement(text);

                if (l == null || l.isEmpty()) {
                    return false;
                }

                options.removeAll();
                for (Evenement s : l) {
                    options.addItem(s.getIntitule());
                    ids.add(s.getId());
                }

                return true;
            }

        };

        search.setHint("Nom evenement", FontImage.createMaterial(FontImage.MATERIAL_SEARCH, style));
        search.addListListener((ActionListener) (ActionEvent evt) -> {
            System.out.println(search.getText());
            int i = ids.get(options.getSelectedIndex());

            f.show();
        });
        
        form.add(search);


        search.setMinimumElementsShownInPopup(4);
        f.getToolbar().addCommandToRightBar("", FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE, style), e -> {
            form.show();
            f.removeAll();
        });

        for (Evenement e : evenements) {

            form.add(createContainer(e));
            id = e.getId();
        }
        form.getToolbar().addCommandToLeftBar("", FontImage.createMaterial(FontImage.MATERIAL_ADD, style), (ActionEvent e) -> {
            InteractionDialog dlg = new InteractionDialog("");
            dlg.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
            Button ok = new Button("OK");

            Button cancel = new Button("Cancel");

            Label intitule = new Label("intitule", "Container");
            intitule.getAllStyles().setAlignment(Component.CENTER);

            Label nbParticipants = new Label("nbParticipants", "Container");
            nbParticipants.getAllStyles().setAlignment(Component.CENTER);
            
             Label budget = new Label("budget", "Container");
            budget.getAllStyles().setAlignment(Component.CENTER);

            Label DateLabel = new Label("Date", "Container");
            DateLabel.getAllStyles().setAlignment(Component.CENTER);

            Label descriptionLabel = new Label("Description", "Container");
            descriptionLabel.getAllStyles().setAlignment(Component.CENTER);
            
             Label adresseLabel = new Label("Adresse", "Container");
            adresseLabel.getAllStyles().setAlignment(Component.CENTER);

             Label categorieLabel = new Label("Categorie", "Container");
            categorieLabel.getAllStyles().setAlignment(Component.CENTER);
            
            TextField Intitule = new TextField("", "intitule", 20, TextArea.ANY);
            TextField NbParticipants = new TextField("", "NbParticipants", 20, TextArea.ANY);
            TextField description = new TextField("", "Description", 20, TextArea.ANY);
            TextField Budget = new TextField("", "Budget", 20, TextArea.ANY);
            TextField adresse = new TextField("", "Adresse", 20, TextArea.ANY);
             TextField categorie = new TextField("", "categorie", 20, TextArea.ANY);
            
            Picker Date = new Picker();
            Date.setType(Display.PICKER_TYPE_DATE);
            TextField nbTable = new TextField("", "Number of table", 20, TextArea.ANY);
            System.out.println("DAaaaaaaaaaaaaaaaaaaaaate " + Date.getDate());
            ok.addActionListener((evt) -> {
                es.addEvenement(new Evenement(id + 1,
                        Intitule.getText(), 
                        Integer.parseInt(NbParticipants.getText()),
                          Integer.parseInt(budget.getText()),
                        Date.getDate(),
                        categorie.getText(),
                       description.getText(),
                        adresse.getText()
                )
                );
                        
                         

            });

            setDesign(Intitule.getAllStyles());
            setDesign(NbParticipants.getAllStyles());
            setDesign(Budget.getAllStyles());
            setDesign(Date.getAllStyles());
            setDesign(categorie.getAllStyles());
            setDesign(description.getAllStyles());
            setDesign(adresse.getAllStyles());
            Container box = BoxLayout.encloseY(
                    intitule,
                    Intitule,
                   nbParticipants,
                    NbParticipants,
                    budget,
                    Budget,
                    DateLabel,
                    Date,
                    categorieLabel,
                    categorie,
                    descriptionLabel,
                    description,
                    adresseLabel,
                    adresse,
                    
                    GridLayout.encloseIn(2, cancel, ok));

            Container layers = LayeredLayout.encloseIn(box);
            layers.setScrollableY(true);

            Button close = new Button("Close");
            cancel.addActionListener((ee) -> dlg.dispose());

            dlg.addComponent(BorderLayout.CENTER, layers);
            Dimension pre = dlg.getContentPane().getPreferredSize();
            dlg.getAllStyles().setBgColor(0xffffff);
            dlg.show(0, 0, 0, 0);
        });
        form.show();
    }

    public Container createContainer(Evenement e) {

        Label delete = new Label(FontImage.createMaterial(FontImage.MATERIAL_REMOVE_CIRCLE_OUTLINE, style));

        delete.addPointerPressedListener((evt) -> {
            try {
                new EvenementsListe();
            } catch (IOException ex) {
            }
        });

        Label evenements = new Label(FontImage.createMaterial(FontImage.MATERIAL_GROUP_ADD, style));
        evenements.getAllStyles().setAlignment(Component.RIGHT);

        Label intitule = new Label("Intitule de l'evenement : " + e.getIntitule(), "Container");
        intitule.getAllStyles().setAlignment(Component.LEFT);
        Label description = new Label("Description: " + e.getDescription(), "Container");
        description.getAllStyles().setAlignment(Component.W_RESIZE_CURSOR);

        String date = e.getDate().toString();
        Label Date = new Label("Aura lieu le = " + date, "Container");
        Date.getAllStyles().setAlignment(Component.LEFT);

        Label categorie = new Label("Categorie : " + e.getCategorie() ,  "Container");
        categorie.getAllStyles().setAlignment(Component.LEFT);

           Label budget = new Label("Budget: " + e.getBudget() ,  "Container");
        budget.getAllStyles().setAlignment(Component.LEFT);
        
     
        
           Label adresse = new Label("L'adresse est: " + e.getAdresse() ,  "Container");
        adresse.getAllStyles().setAlignment(Component.LEFT);
        
         Label nbParticipants = new Label("nbParticipants: " + e.getNbParticipants() ,  "Container");
        nbParticipants.getAllStyles().setAlignment(Component.LEFT);
        
        
        
        Container box = BoxLayout.encloseY(
                intitule,
                    
                   nbParticipants,
                   
                    budget,
                    
                    
                    Date,
                    
                    categorie,
                    
                    description,
                   
                    adresse,
                
                
                GridLayout.encloseIn(2, delete, evenements));
        Style boxStyle = box.getUnselectedStyle();
        boxStyle.setBgTransparency(255);
        boxStyle.setBgColor(0xeeeeee);
        boxStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle.setMargin(1, 1, 1, 1);
        boxStyle.setPadding(1, 1, 1, 1);

        Container layers = LayeredLayout.encloseIn(box);
        return layers;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public void setDesign(Style s) {
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        s.setBorder(RoundBorder.create().
                rectangle(true).
                color(0xffffff).
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        s.setMarginUnit(Style.UNIT_TYPE_DIPS);
        s.setMargin(Component.BOTTOM, 3);
    }

 
 
}
