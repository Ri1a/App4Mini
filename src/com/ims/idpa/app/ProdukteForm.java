package com.ims.idpa.app;

import ca.weblite.codename1.json.JSONException;
import com.codename1.components.MultiButton;
import com.codename1.io.Preferences;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.ims.cmp.Produkte;
import java.util.List;

/**
 *
 * @author Riccardo, Joel, Yanick, Alain Version: 1.0.0
 */
public class ProdukteForm extends com.codename1.ui.Form {

    String productName;

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

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, (ActionListener) (ActionEvent evt) -> {
            new IndexForm().show();
        });
        tb.addMaterialCommandToSideMenu("Produkte", FontImage.MATERIAL_WEB, (ActionListener) (ActionEvent evt) -> {
            new ProdukteForm().show();
        });
        tb.addMaterialCommandToSideMenu("Bestellungen", FontImage.MATERIAL_SHOPPING_CART, (ActionListener) (ActionEvent evt) -> {
            new BestellungenForm().show();
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_POWER_SETTINGS_NEW, (ActionListener) (ActionEvent evt) -> {
            Preferences.clearAll();
            new LoginForm().show();
        });

        Produkte produkte = new Produkte();
        try {
            produkte.getProdukte();
        } catch (JSONException ex) {
        }

        //Show products in app
        //TODO: Scrolling not working
        Container conProducts = new Container(BoxLayout.y());
        conProducts.setScrollableY(true);
        conProducts.setUIID("conProducts");

        //Get elements from array
        for (int i = 0; i < produkte.getProductsArr().size(); i++) {
            String product = produkte.getProductsArr().get(i);
            String stock = produkte.getProductStock().get(i);
            String dateCreated = produkte.getProductDateCreated().get(i);
            //TODO: String cannot be converted to Image
            //Image imgSrc = produkte.getProductImages().get(i);

            //All orders
            MultiButton mbProducts = new MultiButton(product);
            //mbProducts.setIcon(imgSrc); -> Line 72
            switch (stock) {
                case "instock":
                    //Change the second line to color green
                    setLine2Color(mbProducts, 0x4BA42F);
                    mbProducts.setTextLine2("Auf Lager");
                    break;
                case "outofstock":
                    //Change the second line to color yellow
                    setLine2Color(mbProducts, 0x980101);
                    mbProducts.setTextLine2("Nicht auf Lager");
                    break;
                default:
                    mbProducts.setTextLine2(stock);
                    break;
            }

            //Produkte in Detail (Form)
            ProdukteDetailForm produkteDetailForm = new ProdukteDetailForm();
            //Backbutton
            Button btnBack = new Button("Zurück");
            btnBack.addActionListener(b -> {
                new ProdukteForm().show();
            });

            //ProductDetails
            Container conProdukteDetail = new Container(BoxLayout.y());
            conProdukteDetail.add(btnBack);
            conProdukteDetail.add(new Label("Name: " + product));
            switch (stock) {
                case "instock":
                    stock = "Auf Lager";
                    break;
                case "outofstock":
                    stock = "Nicht auf Lager";
                    break;
            }
            conProdukteDetail.add(new Label("Status: " + stock));
            conProdukteDetail.add(new Label("Erstellt am: " + dateCreated));
            produkteDetailForm.add(conProdukteDetail);
            //Show ProductDetails (all Products)
            mbProducts.addActionListener(e -> {
                produkteDetailForm.show();
            });
            conProducts.add(mbProducts);
        }
        this.add(conProducts);
        initGuiBuilderComponents(resourceObjectInstance);

    }
    //-- DON'T EDIT BELOW THIS LINE!!!

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(true);
        setScrollableY(true);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("Produkte");
        setName("ProdukteForm");
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
}
