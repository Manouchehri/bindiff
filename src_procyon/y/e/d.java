package y.e;

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.imageio.metadata.*;
import javax.imageio.stream.*;
import java.util.*;

public class d extends e
{
    private ImageWriter b;
    private ImageWriteParam c;
    private boolean d;
    
    public d(final ImageWriter imageWriter) {
        this.a(imageWriter);
    }
    
    public boolean a() {
        return this.d;
    }
    
    public void a(final ImageWriter b) {
        if (b == null) {
            throw new NullPointerException();
        }
        if (this.b != b) {
            this.b = b;
            this.c = b.getDefaultWriteParam();
        }
    }
    
    protected void a(final BufferedImage bufferedImage, final OutputStream outputStream) {
        a(this.b, bufferedImage, outputStream, this.b());
    }
    
    protected BufferedImage a(final int n, final int n2) {
        if (this.a()) {
            return new BufferedImage(n, n2, 2);
        }
        return new BufferedImage(n, n2, 1);
    }
    
    public ImageWriteParam b() {
        return this.c;
    }
    
    static void a(final ImageWriter imageWriter, final BufferedImage bufferedImage, final OutputStream outputStream, final ImageWriteParam imageWriteParam) {
        final ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        try {
            imageWriter.setOutput(imageOutputStream);
            imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);
        }
        finally {
            imageOutputStream.close();
        }
    }
    
    static ImageWriter a(final String s) {
        final Iterator<ImageWriter> imageWritersByFormatName = ImageIO.getImageWritersByFormatName(s);
        if (imageWritersByFormatName.hasNext()) {
            return imageWritersByFormatName.next();
        }
        return null;
    }
    
    static String b(final String s) {
        return System.getProperty("java.vm.vendor") + " " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version") + " for Java " + System.getProperty("java.version") + " does not support writing " + s + " format.";
    }
}
