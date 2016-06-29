package y.x.jdk_1_6_0_25;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ImageIcon implements Serializable {
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
      if(this.replacement == null) {
         this.replacement = this.createImageIcon();
      }

      return this.replacement;
   }

   private javax.swing.ImageIcon createImageIcon() {
      javax.swing.ImageIcon var1 = new javax.swing.ImageIcon();
      var1.setDescription(this.description);
      if(this.image != null) {
         var1.setImage(this.image);
      }

      var1.setImageObserver(this.imageObserver);
      return var1;
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = var1.readInt();
      int var3 = var1.readInt();
      int[] var4 = (int[])var1.readObject();
      if(var4 != null) {
         Toolkit var5 = Toolkit.getDefaultToolkit();
         ColorModel var6 = ColorModel.getRGBdefault();
         this.image = var5.createImage(new MemoryImageSource(var2, var3, var6, var4, 0, var2));
      }

   }

   private void writeObject(ObjectOutputStream var1) {
      throw new IOException("writeObject not supported");
   }
}
