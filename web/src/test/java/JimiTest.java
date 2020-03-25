import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiWriter;
import com.sun.jimi.core.options.JPGOptions;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class JimiTest {

    public static void main(String[] args) throws Exception {

        try {
            String path = JimiTest.class.getResource(".").getPath() + "\\jimi.jpg";
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            Image image = Jimi.getImage(fileInputStream);
            Image scaledImage = image.getScaledInstance(240, 524, Image.SCALE_SMOOTH);

            JPGOptions options = new JPGOptions();
            options.setQuality(20);
            FileOutputStream out = new FileOutputStream(new File("jimi.small.jpg"));
            JimiWriter jimiWriter = Jimi.createJimiWriter("image/jpeg", out);
            jimiWriter.setOptions(options);
            jimiWriter.setSource(scaledImage);
            jimiWriter.putImage(out);
        } finally {
            System.gc();
        }

        Thread.sleep(10000);
    }

}
