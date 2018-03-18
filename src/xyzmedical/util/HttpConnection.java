package xyzmedical.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpConnection {

    private static String dbPath = "http://76.230.142.194/csi3370/sql_query1.php?query=";

    public static String HttpConnection(String query) throws Exception {

        String link = dbPath + query;
        link = replace(link);
        
        URL url = new URL(link);

        //make connection
        URLConnection urlc = url.openConnection();

        //use post mode
        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(false);

        //send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
  //      ps.print(query);
        ps.close();

        //get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc
                .getInputStream()));

        StringBuilder sb = new StringBuilder();

        String l = null;
        while ((l=br.readLine())!=null) {
            sb.append(l);
        }
        br.close();

        return String.valueOf(sb);
    }
    
    
    public static String replace(String url) {
        
        url = url.replaceAll(" ", "+");
        url = url.replaceAll("'", "%27");
        
        
        return url;
    }
    
}
