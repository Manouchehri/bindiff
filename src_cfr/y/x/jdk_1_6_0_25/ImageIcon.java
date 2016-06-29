/*
 * Decompiled with CFR 0_115.
 */
package y.x.jdk_1_6_0_25;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ImageIcon
implements Serializable {
    public static final long UID = 532615968316031794L;
    private static final long serialVersionUID = 532615968316031794L;
    private transient javax.swing.ImageIcon replacement;
    private transient Image image;
    private ImageObserver imageObserver;
    private String description;
    private int width = -1;
    private int height = -1;
    public static boolean z;

    public synchronized javax.swing.ImageIcon asImageIcon() {
        if (this.replacement != null) return this.replacement;
        this.replacement = this.createImageIcon();
        return this.replacement;
    }

    private javax.swing.ImageIcon createImageIcon() {
        javax.swing.ImageIcon imageIcon = new javax.swing.ImageIcon();
        imageIcon.setDescription(this.description);
        if (this.image != null) {
            imageIcon.setImage(this.image);
        }
        imageIcon.setImageObserver(this.imageObserver);
        return imageIcon;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n2 = objectInputStream.readInt();
        int n3 = objectInputStream.readInt();
        int[] arrn = (int[])objectInputStream.readObject();
        if (arrn == null) return;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ColorModel colorModel = ColorModel.getRGBdefault();
        this.image = toolkit.createImage(new MemoryImageSource(n2, n3, colorModel, arrn, 0, n2));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        throw new IOException("writeObject not supported");
    }
}

