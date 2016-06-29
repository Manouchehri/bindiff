/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import y.e.e;

public class d
extends e {
    private ImageWriter b;
    private ImageWriteParam c;
    private boolean d;

    public d(ImageWriter imageWriter) {
        this.a(imageWriter);
    }

    public boolean a() {
        return this.d;
    }

    public void a(ImageWriter imageWriter) {
        if (imageWriter == null) {
            throw new NullPointerException();
        }
        if (this.b == imageWriter) return;
        this.b = imageWriter;
        this.c = imageWriter.getDefaultWriteParam();
    }

    @Override
    protected void a(BufferedImage bufferedImage, OutputStream outputStream) {
        d.a(this.b, bufferedImage, outputStream, this.b());
    }

    @Override
    protected BufferedImage a(int n2, int n3) {
        if (!this.a()) return new BufferedImage(n2, n3, 1);
        return new BufferedImage(n2, n3, 2);
    }

    public ImageWriteParam b() {
        return this.c;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void a(ImageWriter imageWriter, BufferedImage bufferedImage, OutputStream outputStream, ImageWriteParam imageWriteParam) {
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        try {
            imageWriter.setOutput(imageOutputStream);
            imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);
            return;
        }
        finally {
            imageOutputStream.close();
        }
    }

    static ImageWriter a(String string) {
        Iterator<ImageWriter> iterator = ImageIO.getImageWritersByFormatName(string);
        if (!iterator.hasNext()) return null;
        return iterator.next();
    }

    static String b(String string) {
        return new StringBuffer().append(System.getProperty("java.vm.vendor")).append(" ").append(System.getProperty("java.vm.name")).append(" ").append(System.getProperty("java.vm.version")).append(" for Java ").append(System.getProperty("java.version")).append(" does not support writing ").append(string).append(" format.").toString();
    }
}

