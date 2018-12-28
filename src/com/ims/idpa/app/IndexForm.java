package com.ims.idpa.app;

import ca.weblite.codename1.json.JSONException;
import com.codename1.io.Preferences;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;

/**
 * GUI builder created Form
 *
 * @author Riccardo, Joel, Yanick, Alain
 */
public class IndexForm extends com.codename1.ui.Form {

    public IndexForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public IndexForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        //TODO: Make an epic index site
        

        //Menu
        Toolbar tb = this.getToolbar();
        Container topBar = BorderLayout.east(new Label(""));
        topBar.add(BorderLayout.SOUTH, new Label(""));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, (ActionListener) (ActionEvent evt) -> {
            new IndexForm().show();
        });
        tb.addMaterialCommandToSideMenu("Produkte", FontImage.MATERIAL_WEB, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    new ProdukteForm().show();
            }
        });
        tb.addMaterialCommandToSideMenu("Bestellungen", FontImage.MATERIAL_SHOPPING_CART, (ActionListener) (ActionEvent evt) -> {
            new BestellungenForm().show();
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_POWER_SETTINGS_NEW, (ActionListener) (ActionEvent evt) -> {
            Preferences.clearAll();
            new LoginForm().show();
        });

        Label top = new Label("Willkommen, " + Preferences.get("shop_name", null));
        top.setTextPosition(Component.TOP);
        this.add(top);

        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("IndexForm");
        setName("IndexForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
