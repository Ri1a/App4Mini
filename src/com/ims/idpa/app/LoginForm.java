package com.ims.idpa.app;

import com.codename1.io.Preferences;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
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

    public LoginForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public LoginForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        //TODO Create nice login

        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.TextField gui_txtShop = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_txtCK = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_txtSK = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Start = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Start.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Start) {
                onStartActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("LoginForm");
        setName("LoginForm");
        addComponent(gui_txtShop);
        addComponent(gui_txtCK);
        addComponent(gui_txtSK);
        addComponent(gui_Start);
        gui_txtShop.setText("Shopname");
                gui_txtShop.setInlineStylesTheme(resourceObjectInstance);
        gui_txtShop.setName("txtShop");
        ((com.codename1.ui.layouts.LayeredLayout)gui_txtShop.getParent().getLayout()).setInsets(gui_txtShop, "14.246947% 30.801105% auto auto").setReferenceComponents(gui_txtShop, "-1 -1 -1 -1").setReferencePositions(gui_txtShop, "0.0 0.0 0.0 0.0");
        gui_txtCK.setText("Consumer Key");
                gui_txtCK.setInlineStylesTheme(resourceObjectInstance);
        gui_txtCK.setName("txtCK");
        ((com.codename1.ui.layouts.LayeredLayout)gui_txtCK.getParent().getLayout()).setInsets(gui_txtCK, "2.3809528mm 49.202732% auto 1.8518524mm").setReferenceComponents(gui_txtCK, "0 -1 -1 0 ").setReferencePositions(gui_txtCK, "1.0 0.0 0.0 0.0");
        gui_txtSK.setText("Secret Key");
                gui_txtSK.setInlineStylesTheme(resourceObjectInstance);
        gui_txtSK.setName("txtSK");
        ((com.codename1.ui.layouts.LayeredLayout)gui_txtSK.getParent().getLayout()).setInsets(gui_txtSK, "9.166667% 50.0% auto 0.0mm").setReferenceComponents(gui_txtSK, "0 -1 -1 1 ").setReferencePositions(gui_txtSK, "1.0 0.0 0.0 0.0");
        gui_Start.setPreferredSizeStr("34.391533mm 9.78836mm");
        gui_Start.setText("Log In");
                gui_Start.setInlineStylesTheme(resourceObjectInstance);
        gui_Start.setName("Start");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Start.getParent().getLayout()).setInsets(gui_Start, "26.366467% auto auto 0.0mm").setReferenceComponents(gui_Start, "2 -1 -1 -1").setReferencePositions(gui_Start, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onStartActionEvent(com.codename1.ui.events.ActionEvent ev) {
        LoginForm loginForm = new LoginForm();
        IndexForm indexForm = new IndexForm();

        shop_name = gui_txtShop.getText();
        consumer_key = gui_txtCK.getText();
        secret_key = gui_txtSK.getText();

        if (shop_name == null || consumer_key == null || secret_key == null) {
            loginForm.show();
        } else {

            //Using the Preferences API
            //Preferences.clearAll();
            Preferences.set("shop_name", shop_name);
            Preferences.set("consumer_key", consumer_key);
            Preferences.set("secret_key", secret_key);

            indexForm.show();

        }
    }

}
