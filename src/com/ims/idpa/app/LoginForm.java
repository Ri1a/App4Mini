package com.ims.idpa.app;

import com.codename1.io.Preferences;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 * GUI builder created Form
 *
 * @author Riccardo, Joel, Yanick, Alain
 */
public class LoginForm extends com.codename1.ui.Form {

    private String shop_name;
    private String consumer_key;
    private String secret_key;

    IndexForm indexForm = new IndexForm();

    public LoginForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public LoginForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        IndexForm indexForm = new IndexForm();

        Container conLogin = new Container(BoxLayout.y());
        TextComponent gui_txtShop = new TextComponent().label("Shop:");
        TextComponent gui_txtCK = new TextComponent().label("Consumer Key:");
        TextComponent gui_txtSK = new TextComponent().label("Secret Key:");

        Button btnLogin = new Button("Login");
        btnLogin.addActionListener(e -> {

            shop_name = gui_txtShop.getText();
            consumer_key = gui_txtCK.getText();
            secret_key = gui_txtSK.getText();

            if (shop_name == null || consumer_key == null || secret_key == null) {
                this.show();
            } else {

                //Using the Preferences API
                //Preferences.clearAll();
                Preferences.set("shop_name", shop_name);
                Preferences.set("consumer_key", consumer_key);
                Preferences.set("secret_key", secret_key);

                indexForm.show();
            }
        });

        conLogin.add(gui_txtShop);
        conLogin.add(gui_txtCK);
        conLogin.add(gui_txtSK);
        conLogin.add(btnLogin);

        this.add(conLogin);

        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("LoginForm");
        setName("LoginForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
//    public void onStartActionEvent(com.codename1.ui.events.ActionEvent ev) {
//
////        LoginForm loginForm = new LoginForm();
//        // IndexForm indexForm = new IndexForm();
//        if (shop_name == null || consumer_key == null || secret_key == null) {
//            this.show();
//        } else {
//
//            //Using the Preferences API
//            //Preferences.clearAll();
//            Preferences.set("shop_name", shop_name);
//            Preferences.set("consumer_key", consumer_key);
//            Preferences.set("secret_key", secret_key);
//
//            indexForm.show();
//
//        }
//    }
}
