package com.ims.idpa.app;

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

        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("IndexForm");
        setName("IndexForm");
        addComponent(gui_Label);
        gui_Label.setText("Index");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:6.0mm;");
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "13.872135% 43.78453% auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
