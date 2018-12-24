/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.idpa.app;

import com.codename1.components.MultiButton;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.ims.cmp.Bestellungen;
import com.ims.cmp.Produkte;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class BestellungenForm extends com.codename1.ui.Form {

    MultiButton mb = new MultiButton();

    public BestellungenForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public BestellungenForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        IndexForm indexForm = new IndexForm();
        ProdukteForm produkteForm = new ProdukteForm();

        //Menu
        Toolbar tb = this.getToolbar();
        Container topBar = BorderLayout.east(new Label(""));
        topBar.add(BorderLayout.SOUTH, new Label(""));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                indexForm.show();
            }
        });
        tb.addMaterialCommandToSideMenu("Produkte", FontImage.MATERIAL_WEB, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                produkteForm.show();
            }
        });
        tb.addMaterialCommandToSideMenu("Bestellungen", FontImage.MATERIAL_SHOPPING_CART, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new BestellungenForm().show();
            }
        });

        Bestellungen bestellungen = new Bestellungen();
        bestellungen.getOrders();

        //Show orders in app
        //PROBLEM: Just one order is being shown
        Container conOrders = new Container(BoxLayout.y());
        conOrders.setUIID("conOrders");
        conOrders.setScrollableY(true);

        //Get elements from array
        for (int i = 0; i < bestellungen.getOrdersArr().size(); i++) {
            String order = bestellungen.getOrdersArr().get(i++);

            MultiButton mb = new MultiButton(order);
            mb.setTextLine2("Mehr Details...");
            conOrders.add(mb);

        }

        this.add(conOrders);

        initGuiBuilderComponents(resourceObjectInstance);

    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("BestellungenForm");
        setName("BestellungenForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
