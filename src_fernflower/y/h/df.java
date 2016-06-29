package y.h;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.WeakHashMap;
import javax.swing.JLabel;
import y.h.fj;

public class df extends fj {
   private static final Hashtable a = new Hashtable(11);
   private static final WeakHashMap b = new WeakHashMap(11);
   private static final Set c = new HashSet(11);
   private static OutputStream d = null;
   private static final Component e = new JLabel();
   private static final MediaTracker f;
   private URL g;
   private Image h;
   private BufferedImage i;
   private static final BufferedImage k;

   public df() {
   }

   public df(fj var1) {
      super(var1);
      if(var1 instanceof df) {
         df var2 = (df)var1;
         this.h = var2.h;
         this.i = var2.i;
         this.g = var2.g;
      }

   }

   public boolean contains(double var1, double var3) {
      if(this.i != null) {
         var1 -= this.getX();
         var3 -= this.getY();
         var1 *= (double)this.i.getWidth() / this.getWidth();
         var3 *= (double)this.i.getHeight() / this.getHeight();
         return var1 >= 0.0D && var3 >= 0.0D && var1 < (double)this.i.getWidth() && var3 < (double)this.i.getHeight()?(this.i.getRGB((int)var1, (int)var3) >> 24 & 255) > 127:false;
      } else {
         return super.contains(var1, var3);
      }
   }

   public void a(boolean var1) {
      this.b(var1);
      this.invalidatePortPositions();
      this.setEdgesDirty();
   }

   private void b(boolean var1) {
      boolean var13 = fj.z;
      if(!var1) {
         this.i = null;
         if(!var13) {
            return;
         }
      }

      if(this.h == null) {
         this.i = k;
      } else {
         WeakHashMap var2 = b;
         synchronized(b) {
            this.i = (BufferedImage)b.get(this.h);
         }

         if(this.i == null) {
            if(this.h == null) {
               this.i = k;
               if(!var13) {
                  return;
               }
            }

            if(this.h instanceof BufferedImage) {
               this.i = (BufferedImage)this.h;
               if(!var13) {
                  return;
               }
            }

            int var20 = (int)((double)this.h.getWidth(e) * 1.0D);
            int var3 = (int)((double)this.h.getHeight(e) * 1.0D);
            if(var20 > 0 && var3 > 0) {
               BufferedImage var4 = new BufferedImage(var20, var3, 2);
               Graphics2D var5 = var4.createGraphics();
               var5.drawImage(this.h, AffineTransform.getScaleInstance(1.0D, 1.0D), (ImageObserver)null);
               var5.setComposite(AlphaComposite.getInstance(5, 1.0F));
               var5.setColor(new Color(128, 128, 128));
               var5.fillRect(0, 0, var20, var3);
               var5.dispose();
               Color var6 = new Color(128, 128, 128, 0);
               Color var7 = new Color(0, 0, 0, 0);
               IndexColorModel var8 = new IndexColorModel(1, 2, new byte[]{(byte)var7.getRed(), (byte)var6.getRed()}, new byte[]{(byte)var7.getGreen(), (byte)var6.getGreen()}, new byte[]{(byte)var7.getBlue(), (byte)var6.getBlue()}, 0);
               BufferedImage var9 = new BufferedImage(var20, var3, 13, var8);
               Graphics2D var10 = var9.createGraphics();

               try {
                  var10.drawImage(var4, 0, 0, (Color)null, (ImageObserver)null);
               } finally {
                  var10.dispose();
               }

               this.i = var9;
            }

            WeakHashMap var21 = b;
            synchronized(b) {
               b.put(this.h, this.i);
            }
         }

      }
   }

   public boolean a() {
      return this.i != null;
   }

   public fj createCopy(fj var1) {
      return new df(var1);
   }

   public static Image a(URL var0) {
      return (Image)a.get(var0);
   }

   public void paintNode(Graphics2D var1) {
      if(this.h != null) {
         var1.drawImage(this.h, (int)this.x, (int)this.y, (int)this.width, (int)this.height, (ImageObserver)null);
      }

      if(b(this, var1)) {
         this.paintHotSpots(var1);
      }

      if(b(var1, false)) {
         this.paintPorts(var1);
      }

      if(c(var1, false)) {
         this.paintText(var1);
      }

   }

   public void write(ObjectOutputStream var1) {
      boolean var10;
      label54: {
         var10 = fj.z;
         if(this.a()) {
            var1.writeByte(1);
            if(!var10) {
               break label54;
            }
         }

         var1.writeByte(0);
      }

      super.write(var1);
      var1.writeObject(this.g);
      if(d != var1) {
         c.clear();
         d = var1;
      }

      if(this.g != null && c.contains(this.g)) {
         var1.writeBoolean(false);
         if(!var10) {
            return;
         }
      }

      var1.writeBoolean(true);
      if(this.h == null) {
         var1.writeInt(0);
         var1.writeInt(0);
         var1.write(new byte[0]);
         if(!var10) {
            return;
         }
      }

      try {
         int var2 = this.h.getWidth(e);
         int var3 = this.h.getHeight(e);
         int[] var4 = new int[var2 * var3];
         PixelGrabber var5 = new PixelGrabber(this.h, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         var1.writeInt(var2);
         var1.writeInt(var3);
         byte[] var6 = new byte[var4.length * 4];
         int var7 = 0;

         label36: {
            while(var7 < var4.length) {
               int var8 = var4[var7];
               int var9 = var7 * 4;
               var6[var9 + 3] = (byte)(var8 & 255);
               var6[var9 + 2] = (byte)(var8 >>> 8 & 255);
               var6[var9 + 1] = (byte)(var8 >>> 16 & 255);
               var6[var9] = (byte)(var8 >>> 24 & 255);
               ++var7;
               if(var10) {
                  break label36;
               }

               if(var10) {
                  break;
               }
            }

            var1.write(var6);
         }

         if(this.g != null) {
            c.add(this.g);
         }
      } catch (InterruptedException var11) {
         y.g.o.a((Object)"grabbing interrupted while serializing");
      }

   }

   public void read(ObjectInputStream var1) {
      boolean var10 = fj.z;
      byte var2 = var1.readByte();
      switch(var2) {
      case 0:
      case 1:
         label62: {
            super.read(var1);
            this.g = (URL)var1.readObject();
            if(var1.readBoolean()) {
               int var3 = var1.readInt();
               int var4 = var1.readInt();
               byte[] var5 = new byte[var3 * var4 * 4];
               int var6 = 0;

               int var10000;
               label58: {
                  while(var6 < var5.length - 1) {
                     int var7 = var1.read(var5, var6, var5.length - var6);
                     var10000 = var7;
                     if(var10) {
                        break label58;
                     }

                     if(var7 < 0) {
                        throw new EOFException("Unexpected end of file");
                     }

                     var6 += var7;
                     if(var10) {
                        break;
                     }
                  }

                  var10000 = var3 * var4;
               }

               int[] var11 = new int[var10000];
               int var8 = 0;

               label46: {
                  while(var8 < var11.length) {
                     int var9 = var8 * 4;
                     var11[var8] = ((var5[var9] & 255) << 24) + ((var5[var9 + 1] & 255) << 16) + ((var5[var9 + 2] & 255) << 8) + ((var5[var9 + 3] & 255) << 0);
                     ++var8;
                     if(var10) {
                        break label46;
                     }

                     if(var10) {
                        break;
                     }
                  }

                  this.h = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(var3, var4, var11, 0, var3));
               }

               if(this.g != null) {
                  a.put(this.g, this.h);
               }

               a(this.h);
               if(!var10) {
                  break label62;
               }
            }

            if(this.g != null) {
               this.h = a(this.g);
            }
         }

         this.a(var2 == 1);
         if(!var10) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }

   private static Image a(Image var0) {
      MediaTracker var1 = f;
      synchronized(f) {
         f.addImage(var0, 0);

         try {
            f.waitForID(0, 5000L);
         } catch (InterruptedException var4) {
            y.g.o.a((Object)"INTERRUPTED while loading Image");
         }

         int var2 = f.statusID(0, false);
         f.removeImage(var0, 0);
         switch(var2) {
         case 2:
            return null;
         case 4:
            return null;
         default:
            return var0;
         }
      }
   }

   static {
      f = new MediaTracker(e);

      BufferedImage var0;
      try {
         var0 = new BufferedImage(1, 1, 12);
      } catch (Exception var3) {
         var0 = new BufferedImage(8, 8, 2);
      }

      k = var0;

      for(int var1 = 0; var1 < k.getHeight(); ++var1) {
         for(int var2 = 0; var2 < k.getWidth(); ++var2) {
            k.setRGB(var2, var1, Color.black.getRGB());
         }
      }

   }
}
