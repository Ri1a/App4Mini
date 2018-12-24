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
import com.ims.cmp.Produkte;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class ProdukteForm extends com.codename1.ui.Form {

    public ProdukteForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public ProdukteForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        //Menu
        Toolbar tb = this.getToolbar();
        Container topBar = BorderLayout.east(new Label(""));
        topBar.add(BorderLayout.SOUTH, new Label(""));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new IndexForm().show();
            }
        });
        tb.addMaterialCommandToSideMenu("Produkte", FontImage.MATERIAL_WEB, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ProdukteForm().show();
            }
        });
        tb.addMaterialCommandToSideMenu("Bestellungen", FontImage.MATERIAL_SHOPPING_CART, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new BestellungenForm().show();
            }
        });

        Produkte produkte = new Produkte();
        produkte.getProdukte();

        //Show products in app
        Container conProducts = new Container(BoxLayout.y());
        conProducts.setUIID("conProducts");
        conProducts.setScrollableY(true);

        //Get elements from array
        for (int i = 0; i < produkte.getProductsArr().size(); i++) {
            String product = produkte.getProductsArr().get(i++);

            MultiButton mb = new MultiButton(product);
            mb.setTextLine2("Mehr Details...");
            conProducts.add(mb);

        }

        this.add(conProducts);

        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ProdukteForm");
        setName("ProdukteForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
