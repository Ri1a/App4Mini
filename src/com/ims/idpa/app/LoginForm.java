/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.idpa.app;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class LoginForm extends com.codename1.ui.Form {

    public LoginForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public LoginForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Button gui_btnStart = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_txtShop = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_txtCK = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_txtSK = new com.codename1.ui.TextField();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btnStart.addActionListener(callback);
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

            if(sourceComponent == gui_btnStart) {
                onbtnStartActionEvent(ev);
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
        addComponent(gui_btnStart);
        addComponent(gui_txtShop);
        addComponent(gui_txtCK);
        addComponent(gui_txtSK);
        gui_btnStart.setPreferredSizeStr("71.69312mm 18.78307mm");
        gui_btnStart.setText("Start");
                gui_btnStart.setInlineStylesTheme(resourceObjectInstance);
        gui_btnStart.setName("btnStart");
        ((com.codename1.ui.layouts.LayeredLayout)gui_btnStart.getParent().getLayout()).setInsets(gui_btnStart, "27.802343% 20.123203% auto 22.587269%").setReferenceComponents(gui_btnStart, "-1 -1 -1 -1").setReferencePositions(gui_btnStart, "0.0 0.0 0.0 0.0");
        gui_txtShop.setText("Shopname");
                gui_txtShop.setInlineStylesTheme(resourceObjectInstance);
        gui_txtShop.setName("txtShop");
        ((com.codename1.ui.layouts.LayeredLayout)gui_txtShop.getParent().getLayout()).setInsets(gui_txtShop, "7.823613% 26.694046% auto 23.408625%").setReferenceComponents(gui_txtShop, "-1 -1 -1 -1").setReferencePositions(gui_txtShop, "0.0 0.0 0.0 0.0");
        gui_txtCK.setText("Consumer Key");
                gui_txtCK.setInlineStylesTheme(resourceObjectInstance);
        gui_txtCK.setName("txtCK");
        ((com.codename1.ui.layouts.LayeredLayout)gui_txtCK.getParent().getLayout()).setInsets(gui_txtCK, "1.322751mm 33.24397% auto 1.3227519mm").setReferenceComponents(gui_txtCK, "1 -1 -1 1 ").setReferencePositions(gui_txtCK, "1.0 0.0 0.0 0.0");
        gui_txtSK.setText("Secret Key");
                gui_txtSK.setInlineStylesTheme(resourceObjectInstance);
        gui_txtSK.setName("txtSK");
        ((com.codename1.ui.layouts.LayeredLayout)gui_txtSK.getParent().getLayout()).setInsets(gui_txtSK, "2.1164017mm 33.695652% auto 0.0mm").setReferenceComponents(gui_txtSK, "2 -1 -1 2 ").setReferencePositions(gui_txtSK, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtnStartActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

}
