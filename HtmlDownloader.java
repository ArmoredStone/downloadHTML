/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Lesha
 */
public class HtmlDownloader implements Callback {
        Callback callback;

    public void htmlDownloader(String URL) throws IOException {
        URL url;
        String fileDest = "C:\\Users\\Lesha\\Desktop\\downloadedHTML.html";
        File file = new File(fileDest);
        InputStream is = null;
        BufferedReader br;
        String line;
        FileWriter fw;
        BufferedWriter bw;

        try {
            fw = new FileWriter(fileDest);
            bw = new BufferedWriter(fw);
            url = new URL(URL);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                bw.write(line);
            }
            callback.callingBack();
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
            }
        }
    }

    public void registerCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void callingBack() {
        System.out.println("Вызов коллбека, окончание загрузки");
    }
}
