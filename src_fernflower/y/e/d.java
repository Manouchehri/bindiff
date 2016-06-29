package y.e;

import java.awt.image.BufferedImage;
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

public class d extends e {
   private ImageWriter b;
   private ImageWriteParam c;
   private boolean d;

   public d(ImageWriter var1) {
      this.a(var1);
   }

   public boolean a() {
      return this.d;
   }

   public void a(ImageWriter var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         if(this.b != var1) {
            this.b = var1;
            this.c = var1.getDefaultWriteParam();
         }

      }
   }

   protected void a(BufferedImage var1, OutputStream var2) {
      a(this.b, var1, var2, this.b());
   }

   protected BufferedImage a(int var1, int var2) {
      return this.a()?new BufferedImage(var1, var2, 2):new BufferedImage(var1, var2, 1);
   }

   public ImageWriteParam b() {
      return this.c;
   }

   static void a(ImageWriter var0, BufferedImage var1, OutputStream var2, ImageWriteParam var3) {
      ImageOutputStream var4 = ImageIO.createImageOutputStream(var2);

      try {
         var0.setOutput(var4);
         var0.write((IIOMetadata)null, new IIOImage(var1, (List)null, (IIOMetadata)null), var3);
      } finally {
         var4.close();
      }

   }

   static ImageWriter a(String var0) {
      Iterator var1 = ImageIO.getImageWritersByFormatName(var0);
      return var1.hasNext()?(ImageWriter)var1.next():null;
   }

   static String b(String var0) {
      return System.getProperty("java.vm.vendor") + " " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version") + " for Java " + System.getProperty("java.version") + " does not support writing " + var0 + " format.";
   }
}
