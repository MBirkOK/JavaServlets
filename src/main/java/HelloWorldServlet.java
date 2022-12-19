import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static javax.print.DocFlavor.URL.GIF;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;


public class HelloWorldServlet extends HttpServlet {
    public Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType(String.valueOf(GIF));
        PrintWriter pw = res.getWriter();
        pw.println(createGrafic());
        pw.close();
    }

    public ImageOutputStream createGrafic() throws IOException {
        int width = 600, height = 600;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D ig2 = bi.createGraphics();
        ig2.fillRect(0, 0, width - 1, height - 1);
        Iterator imageWriters = ImageIO.getImageWritersByFormatName("gif");
        ImageWriter imageWriter = (ImageWriter)imageWriters.next();
        File file = new File("filename.gif");
        ImageOutputStream ios = ImageIO.createImageOutputStream(file);
        imageWriter.setOutput(ios);
        imageWriter.write(bi);
        return ios;
    }


}
