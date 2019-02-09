package com.ims.cmp;

import ca.weblite.codename1.json.JSONException;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.ims.idpa.app.IndexForm;
import com.ims.idpa.app.LoginForm;
import com.ims.idpa.app.WelcomeForm;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Riccardo, Joel, Yanick, Alain Version: 1.0.0
 */
public class Produkte {

    ArrayList<String> productsArr = new ArrayList<>();
    ArrayList<String> productStock = new ArrayList<>();
    ArrayList<String> productDateCreated = new ArrayList<>();
    ArrayList<String> productImages = new ArrayList<>();
    
    int responseCode;

    public void getProdukte() throws JSONException {

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
                productsArr.add(dtls.get("name"));
                productStock.add(dtls.get("stock_status"));
                productDateCreated.add(dtls.get("date_created"));
            }
            //Filter out the source of the image. Code from: https://stackoverflow.com/questions/54252836/java-extract-index-src-from-multiarray
            for (Map<String, Object> element : (List<Map<String, Object>>) result.get("root")) {
                for (Map<String, Object> image : (List<Map<String, Object>>) element.get("images")) {
                    productImages.add((String) image.get("src"));
                }
            }
            
            //Check if connection was successfull
            responseCode = r.getResponseCode();
            
            if(responseCode != 200) {
                Dialog.show("Es konnte keine Verbindung hergestellt werden.", "", "OK", null);
                new IndexForm().show();
            }
            
        } catch (IOException e) {
            loginForm.show();
            Dialog.show("Produkte konnten nicht angezeigt werden.", "", "OK", null);
        }
    }

    public ArrayList<String> getProductsArr() {
        return productsArr;
    }

    public ArrayList<String> getProductStock() {
        return productStock;
    }

    public ArrayList<String> getProductDateCreated() {
        return productDateCreated;
    }

    public ArrayList<String> getProductImages() {
        return productImages;
    }
}
