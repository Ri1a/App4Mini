package com.ims.cmp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.ims.idpa.app.LoginForm;
import com.ims.idpa.app.WelcomeForm;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Riccardo, Joel, Yanick, Alain
 * Version: 1.0.0
 */
public class Bestellungen {
    
    ArrayList<String> ordersArr = new ArrayList<>();
    ArrayList<String> ordersStatusArr = new ArrayList<>();
    ArrayList<String> orderTotal = new ArrayList<>();

    public void getOrders() {
        
        LoginForm loginForm = new LoginForm();
        WelcomeForm tokens = new WelcomeForm();

        try {
            ConnectionRequest r = new ConnectionRequest();
            r.setPost(false);
            r.setUrl("https://" + tokens.getShop_name_token() + ".ch/wp-json/wc/v3/orders?consumer_key=" + tokens.getConsumer_key_token() + "&consumer_secret=" + tokens.getSecret_key_token());
            NetworkManager.getInstance().addToQueueAndWait(r);
            Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));

           //JSON Filter
            ArrayList<Map<String, String>> myList = (ArrayList<Map<String, String>>) result.get("root");
            for (int i = 0; i < myList.size(); i++) {
                Map<String, String> dtls = myList.get(i);
                ordersArr.add(dtls.get("date_created"));
                ordersStatusArr.add(dtls.get("status"));
                orderTotal.add(dtls.get("total"));
            }

        } catch (IOException e) {
            loginForm.show();
            Dialog.show("Bestellungen konnten nicht angezeigt werden.", "", "OK", null);
        }

    }

    public ArrayList<String> getOrdersArr() {
        return ordersArr;
    }  

    public ArrayList<String> getOrdersStatusArr() {
        return ordersStatusArr;
    }

    public ArrayList<String> getOrderTotal() {
        return orderTotal;
    }
    

}
