package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleAPI {

    public void downloadMap(String location){
        try {
            String imageURL = "https://maps.googleapis.com/maps/api/staticmap?center="
                    + URLEncoder.encode(location, "UTF-8") + "&zoom=16&size=712x712&scale2&key=AIzaSyB23p1sJG90yw1UMLr1gX7VxlZQe-GqZt8";
            URL url = new URL(imageURL);
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(location);
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) != -1){
                outputStream.write(b, 0, length);
            }
            inputStream.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ImageIcon getMap(String location){
        return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(312, 312, Image.SCALE_SMOOTH));
    }

    public void  fileDelete(String fileName){
        File file = new File(fileName);
        file.delete();
    }
}
