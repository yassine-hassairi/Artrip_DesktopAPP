/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Jnounou
 */
public class SMS {
    
    public SMS(String msg) throws IOException{

                         String key="1BAvmxoVRxs-jCdBeaxr5oyTmvjOzmgTEchbGS4sze";
                        String sen="Artrip";
                        String num="0021623838844";
                        String apiKey = "apikey=" + key;
            String message = "&message=" +msg;
            String sender = "&sender=" + sen;
            String numbers = "&numbers=" + num;

            // Send data
         HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?%22").openConnection();            
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
            }
            //return stringBuffer.toString();
        }
       
        }
}
