package com.edival.conversorAPI;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAPI {
	
	@Value("${currencylayer.api.url}")
	private String apiUrl;
	
	@Value("${currencylayer.api.key}")
	private String apiKey;
	
	static CloseableHttpClient httpClient = HttpClients.createDefault();
	
	@Test
	public void consumirAPI() {
		HttpGet get = new HttpGet(apiUrl + "live?access_key="+apiKey+"&source=GBP");

		try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            System.out.println("taxas de câmbio ao vivo");

            Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000)); 
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(timeStampDate);
            System.out.println("1 " + exchangeRates.getString("source") + " vale " + exchangeRates.getJSONObject("quotes").getDouble("GBPBRL") + " BRL | (Date: " + formattedDate + ")");   
            response.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}
