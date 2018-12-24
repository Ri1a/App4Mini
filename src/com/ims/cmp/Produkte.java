/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.cmp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.ims.idpa.app.IndexForm;
import com.ims.idpa.app.LoginForm;
import com.ims.idpa.app.WelcomeForm;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ricky
 */
public class Produkte {

    private String productNames;
    ArrayList<String> productsArr = new ArrayList<>();

    public void getProdukte() {
        LoginForm loginForm = new LoginForm();

        WelcomeForm tokens = new WelcomeForm();

        try {
            ConnectionRequest r = new ConnectionRequest();
            r.setPost(false);
            r.setUrl("https://" + tokens.getShop_name_token() + ".ch/wp-json/wc/v3/products?consumer_key=" + tokens.getConsumer_key_token() + "&consumer_secret=" + tokens.getSecret_key_token());
            NetworkManager.getInstance().addToQueueAndWait(r);
            Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));

            //JSON Filter
            ArrayList<Map<String, String>> myList = (ArrayList<Map<String, String>>) result.get("root");
            for (int i = 0; i < myList.size(); i++) {
                Map<String, String> dtls = myList.get(i);
                productNames = dtls.get("name");
                productsArr.add(productNames);
                //GET PRODUCT IMAGES, DESCRIPTION

            }

        } catch (IOException err) {
            loginForm.show();
        }

    }

    public ArrayList<String> getProductsArr() {
        return productsArr;
    }

}
