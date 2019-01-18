package com.ims.idpa.app;

import com.codename1.components.SpanLabel;
import com.codename1.io.Preferences;
import com.codename1.io.Util;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.ims.cmp.Produkte;

/**
 *
 * @author Riccardo, Joel, Yanick, Alain Version: 1.0.0
 */
public class IndexForm extends com.codename1.ui.Form {

    Produkte productNumber = new Produkte();

    //Email
    TextField tfSubject = new TextField("", "Titel", 20, TextArea.ANY);
    TextField tfBody = new TextField("", "Text", 20, TextArea.ANY);
    Button btnEmail = new Button("Email senden");

    public IndexForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public IndexForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        //TODO: Make an epic index site / Add more content
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

        Container conIndex = new Container(BoxLayout.y());
        Label lblWelcome = new Label("Willkommen");

        if (Preferences.get("shop_name", null) == null) {
            lblWelcome = new Label("Willkommen");
        } else {
            lblWelcome = new Label("Willkommen, " + Preferences.get("shop_name", null));
        }

        SpanLabel slblText = new SpanLabel("Sie können Ihre Produkte und Bestellungen anschauen, indem Sie oben links auf das Menü drücken. Bei Fragen und Anregungen scheuen Sie sich nicht uns eine Email zu schreiben:");

        tfBody.setRows(6);
        btnEmail.addActionListener((ActionListener) (ActionEvent b) -> {
            sendEmail();
        });

        conIndex.add(lblWelcome);
        conIndex.add(slblText);
        conIndex.add(tfSubject);
        conIndex.add(tfBody);
        conIndex.add(btnEmail);
        this.add(conIndex);

        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(false);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Home");
        setName("IndexForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    private void sendEmail() {
        //Code from: https://stackoverflow.com/questions/43708365/sending-email-with-codenameone-message-class
        if ("".equals(tfBody.getText()) || "".equals(tfSubject.getText())) {
            Dialog.show("Fehler", "Bitte füllen Sie alle Felder aus", "OK", null);
        } else {
            Message m = new Message(tfBody.getText());
            m.getAttachments().put("/resources/test.txt", "text/plain");
            Display.getInstance().sendMessage(new String[]{"web4mini@gmx.ch"}, tfSubject.getText(), m);
        }
    }
}
