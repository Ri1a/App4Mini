/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.idpa.app;

import com.codename1.components.MultiButton;
import com.codename1.io.Preferences;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.ims.cmp.Bestellungen;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class BestellungenForm extends com.codename1.ui.Form {

    Bestellungen bestellungen = new Bestellungen();
    String order;
    MultiButton mbOrders = new MultiButton();

    Container conOrdersCompleted = new Container(BoxLayout.y());
    Container conOrdersProcessing = new Container(BoxLayout.y());

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
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, (ActionListener) (ActionEvent evt) -> {
            indexForm.show();
        });
        tb.addMaterialCommandToSideMenu("Produkte", FontImage.MATERIAL_WEB, (ActionListener) (ActionEvent evt) -> {
            produkteForm.show();
        });
        tb.addMaterialCommandToSideMenu("Bestellungen", FontImage.MATERIAL_SHOPPING_CART, (ActionListener) (ActionEvent evt) -> {
            new BestellungenForm().show();
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_POWER_SETTINGS_NEW, (ActionListener) (ActionEvent evt) -> {
            Preferences.clearAll();
            new LoginForm().show();
        });
        
        bestellungen.getOrders();
        
        //Show orders in app
        Container conOrders = new Container(BoxLayout.y());
        conOrders.setUIID("conOrders");
        conOrders.setScrollableY(true);
        
        //Get elements from array
        for (int i = 0; i < bestellungen.getOrdersArr().size(); i++) {
            String status = bestellungen.getOrdersStatusArr().get(i);
            order = bestellungen.getOrdersArr().get(i);

            //All orders
            mbOrders = new MultiButton(order);

            switch (status) {
                case "completed":
                    //Change the second line to color green
                    setLine2Color(mbOrders, 0x4BA42F);
                    mbOrders.setTextLine2("Abgeschlossen");
                    break;
                case "processing":
                    //Change the second line to color yellow
                    setLine2Color(mbOrders, 0xE7E04C);
                    mbOrders.setTextLine2("Verarbeitung");
                    break;
                case "cancelled":
                    //Change the second line to color red
                    setLine2Color(mbOrders, 0x980101);
                    mbOrders.setTextLine2("Abgebrochen");
                    break;
                default:
                    mbOrders.setTextLine2(status);
                    break;
            }

            //Filters for tabs
            String orderProcessing;
            if ("Verarbeitung".equals(mbOrders.getTextLine2())) {
                orderProcessing = order;
                MultiButton mbOrderProcessing = new MultiButton(orderProcessing);
                setLine2Color(mbOrderProcessing, 0xE7E04C);
                mbOrderProcessing.setTextLine2("Verarbeitung");
                conOrdersProcessing.setUIID("conOrdersCompleted");
                conOrdersProcessing.setScrollableY(true);
                conOrdersProcessing.add(mbOrderProcessing);

                //Show Orderdetails
                mbOrderProcessing.addActionListener(e -> {
                    bestellungDetailForm();
                });
            }
            //Show Orderdetails
            mbOrders.addActionListener(e -> {
                bestellungDetailForm();
            });

            conOrders.add(mbOrders);
        }

        //Tabs for filter
        //TODO: Do we need a tab with completed orders?
        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
        FontImage icon1 = FontImage.createMaterial(FontImage.MATERIAL_QUESTION_ANSWER, s);
        t.addTab("Alle", icon1, conOrders);
        //t.addTab("Abgeschlossen", icon1, conOrdersCompleted);
        t.addTab("Verarbeitung", icon1, conOrdersProcessing);
        this.add(t);
        initGuiBuilderComponents(resourceObjectInstance);

    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("BestellungenForm");
        setName("BestellungenForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    //Set the colors of Multibutton Line2
    private void setLine2Color(MultiButton multiButton, int color) {
        List<Component> childsLevel1 = multiButton.getChildrenAsList(false);
        Container firstContainerLevel1 = (Container) childsLevel1.get(0);
        List<Component> childsLevel2 = firstContainerLevel1.getChildrenAsList(false);
        Container targetContainerLevel2 = (Container) childsLevel2.get(multiButton.isHorizontalLayout() ? 2 : 0);
        List<Component> childsLevel3 = targetContainerLevel2.getChildrenAsList(false);
        Label firstLabelLevel3 = (Label) childsLevel3.get(0);
        firstLabelLevel3.getAllStyles().setFgColor(color);
    }

    public void bestellungDetailForm() {

        BestellungDetailForm bestellungDetailForm = new BestellungDetailForm();

        //Backbutton
        Button btnBack = new Button("Zurück");
        //TODO set Buttonsize
        //btnBack.setSize(d);
        btnBack.addActionListener(b -> {
            new BestellungenForm().show();
        });

        //Orderdetails
        Container conBestellungDetail = new Container(BoxLayout.y());
        conBestellungDetail.add(btnBack);
        bestellungDetailForm.add(conBestellungDetail);
        bestellungDetailForm.show();

    }
}
