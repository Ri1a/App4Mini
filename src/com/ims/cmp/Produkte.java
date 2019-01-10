package com.ims.cmp;

import ca.weblite.codename1.json.JSONException;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
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
 */
public class Produkte {

    ArrayList<String> productsArr = new ArrayList<>();
    ArrayList<String> productImages = new ArrayList<>();
    ArrayList<String> productStock = new ArrayList<>();

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
                //Get name, image, stock
                productsArr.add(dtls.get("name"));
                productImages.add(dtls.get("images"));
                productStock.add(dtls.get("stock_status"));
                //TODO: Filter out image-source
            }
            
        } catch (IOException err) {
            loginForm.show();
        }
    }

    public ArrayList<String> getProductsArr() {
        return productsArr;
    }

    public ArrayList<String> getProductImages() {
        return productImages;
    }

    public ArrayList<String> getProductStock() {
        return productStock;
    }

}
