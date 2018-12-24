/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.idpa.app;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.Preferences;
import com.codename1.ui.Form;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class IndexForm extends com.codename1.ui.Form {
    
    private String shop_name_token;
    private String consumer_key_token;
    private String secret_key_token;
    
    //For building the different URL's
    private final String products = "products";
    private final String orders = "orders";

    private String productNames;
    ArrayList<String> productsArr = new ArrayList<>();

    public IndexForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public IndexForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("IndexForm");
        setName("IndexForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    
    //How to load before loading the form???
//    protected void beforeMain(Form f) {
//        
//        //CN1 components
//        LoginForm loginForm = new LoginForm();
//        IndexForm indexForm = new IndexForm();
//
//        //Preferences.clearAll();
//        shop_name_token = Preferences.get("shop_name", null);
//        consumer_key_token = Preferences.get("consumer_key", null);
//        secret_key_token = Preferences.get("secret_key", null);
//
//        //Check if the user is already authenticated
//        if (shop_name_token == null || consumer_key_token == null || secret_key_token == null) {
//            loginForm.show();
//        }
//
//        //Get Products from Woocommerce Rest API
//        try {
//            ConnectionRequest reqP = new ConnectionRequest();
//            reqP.setPost(false);
//            reqP.setUrl("https://" + shop_name_token + ".ch/wp-json/wc/v3/" + products + "?consumer_key=" + consumer_key_token + "&consumer_secret=" + secret_key_token);
//            NetworkManager.getInstance().addToQueueAndWait(reqP);
//            Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(reqP.getResponseData()), "UTF-8"));
//
//            //JSON Filter
//            ArrayList<Map<String, String>> rootList = (ArrayList<Map<String, String>>) result.get("root");
//            for (int i = 0; i < rootList.size(); i++) {
//                Map<String, String> dtls = rootList.get(i);
//                productNames = dtls.get("name");
//                productsArr.add(productNames);
//
//            }
//
//            //For testing -> Delete after testing
//            System.out.println("Products: " + productsArr + "\nShopname: " + shop_name_token + "\nConsumer Key: " + consumer_key_token + "\nSecret Key: " + secret_key_token);
//
//        } catch (IOException err) {
//            loginForm.show();
//        }
//        
//    }
}
