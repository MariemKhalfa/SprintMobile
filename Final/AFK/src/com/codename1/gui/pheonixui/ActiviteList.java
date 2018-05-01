/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui.pheonixui;

import com.codename1.Entite.Activite;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.Service.ServiceActivite;
import com.codename1.components.InteractionDialog;
import com.codename1.components.MultiButton;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Arshavin
 */
public final class ActiviteList extends  com.codename1.ui.Form{

    private Form form;
    private MultiButton mb;
    private Container container;
    ControleSaisie cs  = new ControleSaisie();
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
    ServiceActivite es = new ServiceActivite();

    public ActiviteList() throws IOException {
        form = new Form("Liste des Activités", new BoxLayout(BoxLayout.Y_AXIS));
        theme = UIManager.initFirstTheme("/theme");
        ArrayList<Activite> activites = es.listActivite();
        final DefaultListModel<String> options = new DefaultListModel<>();
        final Form f = new Form("Activité");
        final ArrayList<Activite> activite = activites;
        ArrayList<Integer> ids = new ArrayList<>();
        search = new AutoCompleteTextField(options) {
            @Override
            protected boolean filter(String text) {
                if (text.length() == 0) {
                    return false;
                }
                ArrayList<Activite> l = es.searchActivite(text);

                if (l == null || l.isEmpty()) {
                    return false;
                }

                options.removeAll();
                int i1 =0;
                for (Activite s : l) {
                    options.addItem(s.getType());
                    ids.add(i1);
                    i1++;
                }

                return true;
            }

        };

        search.setHint("Nom activité", FontImage.createMaterial(FontImage.MATERIAL_SEARCH, style));
    search.addListListener((ActionListener) (ActionEvent evt) -> {
            System.out.println(search.getText());
                        int i = ids.get(options.getSelectedIndex());
            for (Activite e : activite) {
                String type = e.getType();
                String sType= options.getItemAt(i);
                if(type.equals(sType))
            f.add(createContainer(e));
            id = e.getId();
        }
            f.show();
        });
        form.add(search);
        search.setMinimumElementsShownInPopup(4);
        f.getToolbar().addCommandToRightBar("", FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE, style), e -> {
            form.show();
            f.removeAll();
        });

        for (Activite e : activites) {

            form.add(createContainer(e));
            id = e.getId();
        }
        form.getToolbar().addCommandToLeftBar("", FontImage.createMaterial(FontImage.MATERIAL_ADD, style), (ActionEvent e) -> {
            InteractionDialog dlg = new InteractionDialog("");
            dlg.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
            Button ok = new Button("Valider");

            Button cancel = new Button("Retour");

            Label typeLabel = new Label("Type", "Container");
            typeLabel.getAllStyles().setAlignment(Component.CENTER);

            Label Age_minLabel = new Label("Age minimal", "Container");
            Age_minLabel.getAllStyles().setAlignment(Component.CENTER);

            Label DateLabel = new Label(" Date", "Container");
            DateLabel.getAllStyles().setAlignment(Component.CENTER);

            Label heureLabel = new Label("Heure", "Container");
            heureLabel.getAllStyles().setAlignment(Component.CENTER);

            Label descriptionLabel = new Label("Description", "Container");
            descriptionLabel.getAllStyles().setAlignment(Component.CENTER);
            
             Label adresseLabel = new Label("Adresse", "Container");
            adresseLabel.getAllStyles().setAlignment(Component.CENTER);

            
            TextField type = new TextField("", "Type", 20, TextArea.ANY);
            TextField age_min = new TextField("", "Age minimal", 20, TextArea.ANY);
            TextField description = new TextField("", "Description", 20, TextArea.ANY);
            TextField heure = new TextField("", "hh:mm", 20, TextArea.ANY);
            TextField adresse = new TextField("", "Adresse", 20, TextArea.ANY);

           
            Picker Date = new Picker();
            Date.setType(Display.PICKER_TYPE_DATE);
            TextField nbTable = new TextField("", "Number of table", 20, TextArea.ANY);
            ok.addActionListener((evt) -> {
        if (!cs.isString(adresse.getText())  ) {

                    showDialog("L'adresse doit être une chaine de caractères");
                }
              else if (!cs.isString(type.getText())  ) {

                    showDialog("Le type doit être une chaine de caractères");
                }
              else if (!cs.isString(description.getText())  ) {

                    showDialog("La description doit être une chaine de caractères");
                }
                else if (!cs.isNumberAge(age_min.getText())) {

                    showDialog("L'age minimal doit etre compris entre 1 et 18");
                }
                
                  else if (!cs.isHeure(heure.getText())) {

                    showDialog("Heure incorrecte");
                }
                 else if (!cs.isValidDate(Date.getDate())) {

                    showDialog("Date incorrecte");
                }
                else 
                {                         
                         es.addActivite(new Activite(id + 1,
                        type.getText(),
                        Integer.parseInt(age_min.getText()),
                        Date.getDate(),
                           heure.getText(),
                        description.getText(),
                     adresse.getText()
                         
                   )
                );
                dlg.dispose();
                }
            });

            setDesign(type.getAllStyles());
            setDesign(age_min.getAllStyles());
            setDesign(Date.getAllStyles());
            setDesign(heure.getAllStyles());
            setDesign(description.getAllStyles());
            Container box = BoxLayout.encloseY(
                    typeLabel,
                    type,
                    Age_minLabel,
                    age_min,
                    DateLabel,
                    Date,
                    heureLabel,
                    heure,
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

    public Container createContainer(Activite e) {
         final Form f = new Form("Activité");

      
           f.getToolbar().addCommandToRightBar("", FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE, style), g -> {
            form.show();
            f.removeAll();
        });
         
        
      
            Label activite = new Label("", "Container");



        Label type = new Label("Type de l'activité : " + e.getType(), "Container");
        type.getAllStyles().setAlignment(Component.LEFT);
        Label description = new Label("Description: " + e.getDescription(), "Container");
        description.getAllStyles().setAlignment(Component.W_RESIZE_CURSOR);

        String date =  new SimpleDateFormat("dd-mm-yyyy").format( e.getDate());
        Label Date = new Label("Aura lieu le = " + date, "Container");
        Date.getAllStyles().setAlignment(Component.LEFT);

        Label age_min = new Label("L'Age minimal est: " + e.getAge_min() ,  "Container");
        age_min.getAllStyles().setAlignment(Component.LEFT);

           Label heure = new Label("L'heure est: " + e.getHeure() ,  "Container");
        heure.getAllStyles().setAlignment(Component.W_RESIZE_CURSOR);
        
     
        
           Label adresse = new Label("L'adresse est: " + e.getAdresse() ,  "Container");
        adresse.getAllStyles().setAlignment(Component.LEFT);
        
        
        
        Container box = BoxLayout.encloseY(
                type,
                description,
                Date,
                age_min,
                heure,
                
                
                GridLayout.encloseIn(2, activite ));
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

 	public void showDialog(String msg) {

        Dialog dlg = new Dialog("");
        Style dlgStyle = dlg.getDialogStyle();
        dlgStyle.setBorder(Border.createEmpty());
        dlgStyle.setBgTransparency(255);
        dlgStyle.setBgColor(0xffffff);

        dlg.setLayout(BoxLayout.y());
        Label blueLabel = new Label();
        blueLabel.setShowEvenIfBlank(true);
        blueLabel.getUnselectedStyle().setBgColor(0xff);
        blueLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
        blueLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
        dlg.add(blueLabel);
        TextArea ta = new TextArea(msg);
        ta.setEditable(false);
        ta.setUIID("DialogBody");
        ta.getAllStyles().setFgColor(0);
        dlg.add(ta);

        Label grayLabel = new Label();
        grayLabel.setShowEvenIfBlank(true);
        grayLabel.getUnselectedStyle().setBgColor(0xcccccc);
        grayLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
        grayLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
        dlg.add(grayLabel);

        Button ok = new Button(new Command("OK"));
        
        dlg.add(ok);
        dlg.showDialog();

    }
 
}
