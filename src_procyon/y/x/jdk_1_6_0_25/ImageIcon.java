package y.x.jdk_1_6_0_25;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class ImageIcon implements Serializable
{
    public static final long UID = 532615968316031794L;
    private static final long serialVersionUID = 532615968316031794L;
    private transient javax.swing.ImageIcon replacement;
    private transient Image image;
    private ImageObserver imageObserver;
    private String description;
    private int width;
    private int height;
    public static boolean z;
    
    public ImageIcon() {
        this.width = -1;
        this.height = -1;
    }
    
    public synchronized javax.swing.ImageIcon asImageIcon() {
        if (this.replacement == null) {
            this.replacement = this.createImageIcon();
        }
        return this.replacement;
    }
    
    private javax.swing.ImageIcon createImageIcon() {
        final javax.swing.ImageIcon imageIcon = new javax.swing.ImageIcon();
        imageIcon.setDescription(this.description);
        if (this.image != null) {
            imageIcon.setImage(this.image);
        }
        imageIcon.setImageObserver(this.imageObserver);
        return imageIcon;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final int int1 = objectInputStream.readInt();
        final int int2 = objectInputStream.readInt();
        final int[] array = (int[])objectInputStream.readObject();
        if (array != null) {
            this.image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(int1, int2, ColorModel.getRGBdefault(), array, 0, int1));
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        throw new IOException("writeObject not supported");
    }
}
