package com.keypoint;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PngEncoder {
   public static final boolean ENCODE_ALPHA = true;
   public static final boolean NO_ALPHA = false;
   public static final int FILTER_NONE = 0;
   public static final int FILTER_SUB = 1;
   public static final int FILTER_UP = 2;
   public static final int FILTER_LAST = 2;
   protected static final byte[] IHDR = new byte[]{(byte)73, (byte)72, (byte)68, (byte)82};
   protected static final byte[] IDAT = new byte[]{(byte)73, (byte)68, (byte)65, (byte)84};
   protected static final byte[] IEND = new byte[]{(byte)73, (byte)69, (byte)78, (byte)68};
   protected static final byte[] PHYS = new byte[]{(byte)112, (byte)72, (byte)89, (byte)115};
   protected byte[] pngBytes;
   protected byte[] priorRow;
   protected byte[] leftBytes;
   protected Image image;
   protected int width;
   protected int height;
   protected int bytePos;
   protected int maxPos;
   protected CRC32 crc;
   protected long crcValue;
   protected boolean encodeAlpha;
   protected int filter;
   protected int bytesPerPixel;
   private int xDpi;
   private int yDpi;
   private static float INCH_IN_METER_UNIT = 0.0254F;
   protected int compressionLevel;

   public PngEncoder() {
      this((Image)null, false, 0, 0);
   }

   public PngEncoder(Image var1) {
      this(var1, false, 0, 0);
   }

   public PngEncoder(Image var1, boolean var2) {
      this(var1, var2, 0, 0);
   }

   public PngEncoder(Image var1, boolean var2, int var3) {
      this(var1, var2, var3, 0);
   }

   public PngEncoder(Image var1, boolean var2, int var3, int var4) {
      this.crc = new CRC32();
      this.xDpi = 0;
      this.yDpi = 0;
      this.image = var1;
      this.encodeAlpha = var2;
      this.setFilter(var3);
      if(var4 >= 0 && var4 <= 9) {
         this.compressionLevel = var4;
      }

   }

   public void setImage(Image var1) {
      this.image = var1;
      this.pngBytes = null;
   }

   public Image getImage() {
      return this.image;
   }

   public byte[] pngEncode(boolean var1) {
      byte[] var2 = new byte[]{(byte)-119, (byte)80, (byte)78, (byte)71, (byte)13, (byte)10, (byte)26, (byte)10};
      if(this.image == null) {
         return null;
      } else {
         this.width = this.image.getWidth((ImageObserver)null);
         this.height = this.image.getHeight((ImageObserver)null);
         this.pngBytes = new byte[(this.width + 1) * this.height * 3 + 200];
         this.maxPos = 0;
         this.bytePos = this.writeBytes(var2, 0);
         this.writeHeader();
         this.writeResolution();
         if(this.writeImageData()) {
            this.writeEnd();
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.maxPos);
         } else {
            this.pngBytes = null;
         }

         return this.pngBytes;
      }
   }

   public byte[] pngEncode() {
      return this.pngEncode(this.encodeAlpha);
   }

   public void setEncodeAlpha(boolean var1) {
      this.encodeAlpha = var1;
   }

   public boolean getEncodeAlpha() {
      return this.encodeAlpha;
   }

   public void setFilter(int var1) {
      this.filter = 0;
      if(var1 <= 2) {
         this.filter = var1;
      }

   }

   public int getFilter() {
      return this.filter;
   }

   public void setCompressionLevel(int var1) {
      if(var1 >= 0 && var1 <= 9) {
         this.compressionLevel = var1;
      }

   }

   public int getCompressionLevel() {
      return this.compressionLevel;
   }

   protected byte[] resizeByteArray(byte[] var1, int var2) {
      byte[] var3 = new byte[var2];
      int var4 = var1.length;
      System.arraycopy(var1, 0, var3, 0, Math.min(var4, var2));
      return var3;
   }

   protected int writeBytes(byte[] var1, int var2) {
      this.maxPos = Math.max(this.maxPos, var2 + var1.length);
      if(var1.length + var2 > this.pngBytes.length) {
         this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, var1.length));
      }

      System.arraycopy(var1, 0, this.pngBytes, var2, var1.length);
      return var2 + var1.length;
   }

   protected int writeBytes(byte[] var1, int var2, int var3) {
      this.maxPos = Math.max(this.maxPos, var3 + var2);
      if(var2 + var3 > this.pngBytes.length) {
         this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, var2));
      }

      System.arraycopy(var1, 0, this.pngBytes, var3, var2);
      return var3 + var2;
   }

   protected int writeInt2(int var1, int var2) {
      byte[] var3 = new byte[]{(byte)(var1 >> 8 & 255), (byte)(var1 & 255)};
      return this.writeBytes(var3, var2);
   }

   protected int writeInt4(int var1, int var2) {
      byte[] var3 = new byte[]{(byte)(var1 >> 24 & 255), (byte)(var1 >> 16 & 255), (byte)(var1 >> 8 & 255), (byte)(var1 & 255)};
      return this.writeBytes(var3, var2);
   }

   protected int writeByte(int var1, int var2) {
      byte[] var3 = new byte[]{(byte)var1};
      return this.writeBytes(var3, var2);
   }

   protected void writeHeader() {
      int var1 = this.bytePos = this.writeInt4(13, this.bytePos);
      this.bytePos = this.writeBytes(IHDR, this.bytePos);
      this.width = this.image.getWidth((ImageObserver)null);
      this.height = this.image.getHeight((ImageObserver)null);
      this.bytePos = this.writeInt4(this.width, this.bytePos);
      this.bytePos = this.writeInt4(this.height, this.bytePos);
      this.bytePos = this.writeByte(8, this.bytePos);
      this.bytePos = this.writeByte(this.encodeAlpha?6:2, this.bytePos);
      this.bytePos = this.writeByte(0, this.bytePos);
      this.bytePos = this.writeByte(0, this.bytePos);
      this.bytePos = this.writeByte(0, this.bytePos);
      this.crc.reset();
      this.crc.update(this.pngBytes, var1, this.bytePos - var1);
      this.crcValue = this.crc.getValue();
      this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
   }

   protected void filterSub(byte[] var1, int var2, int var3) {
      int var4 = this.bytesPerPixel;
      int var5 = var2 + var4;
      int var6 = var3 * this.bytesPerPixel;
      int var7 = var4;
      int var8 = 0;

      for(int var9 = var5; var9 < var2 + var6; ++var9) {
         this.leftBytes[var7] = var1[var9];
         var1[var9] = (byte)((var1[var9] - this.leftBytes[var8]) % 256);
         var7 = (var7 + 1) % 15;
         var8 = (var8 + 1) % 15;
      }

   }

   protected void filterUp(byte[] var1, int var2, int var3) {
      int var4 = var3 * this.bytesPerPixel;

      for(int var5 = 0; var5 < var4; ++var5) {
         byte var6 = var1[var2 + var5];
         var1[var2 + var5] = (byte)((var1[var2 + var5] - this.priorRow[var5]) % 256);
         this.priorRow[var5] = var6;
      }

   }

   protected boolean writeImageData() {
      int var1 = this.height;
      int var2 = 0;
      this.bytesPerPixel = this.encodeAlpha?4:3;
      Deflater var10 = new Deflater(this.compressionLevel);
      ByteArrayOutputStream var11 = new ByteArrayOutputStream(1024);
      DeflaterOutputStream var12 = new DeflaterOutputStream(var11, var10);

      try {
         while(var1 > 0) {
            int var3 = Math.min(32767 / (this.width * (this.bytesPerPixel + 1)), var1);
            var3 = Math.max(var3, 1);
            int[] var13 = new int[this.width * var3];
            PixelGrabber var9 = new PixelGrabber(this.image, 0, var2, this.width, var3, var13, 0, this.width);

            try {
               var9.grabPixels();
            } catch (Exception var15) {
               System.err.println("interrupted waiting for pixels!");
               return false;
            }

            if((var9.getStatus() & 128) != 0) {
               System.err.println("image fetch aborted or errored");
               return false;
            }

            byte[] var4 = new byte[this.width * var3 * this.bytesPerPixel + var3];
            if(this.filter == 1) {
               this.leftBytes = new byte[16];
            }

            if(this.filter == 2) {
               this.priorRow = new byte[this.width * this.bytesPerPixel];
            }

            int var5 = 0;
            int var6 = 1;

            for(int var14 = 0; var14 < this.width * var3; ++var14) {
               if(var14 % this.width == 0) {
                  var4[var5++] = (byte)this.filter;
                  var6 = var5;
               }

               var4[var5++] = (byte)(var13[var14] >> 16 & 255);
               var4[var5++] = (byte)(var13[var14] >> 8 & 255);
               var4[var5++] = (byte)(var13[var14] & 255);
               if(this.encodeAlpha) {
                  var4[var5++] = (byte)(var13[var14] >> 24 & 255);
               }

               if(var14 % this.width == this.width - 1 && this.filter != 0) {
                  if(this.filter == 1) {
                     this.filterSub(var4, var6, this.width);
                  }

                  if(this.filter == 2) {
                     this.filterUp(var4, var6, this.width);
                  }
               }
            }

            var12.write(var4, 0, var5);
            var2 += var3;
            var1 -= var3;
         }

         var12.close();
         byte[] var7 = var11.toByteArray();
         int var8 = var7.length;
         this.crc.reset();
         this.bytePos = this.writeInt4(var8, this.bytePos);
         this.bytePos = this.writeBytes(IDAT, this.bytePos);
         this.crc.update(IDAT);
         this.bytePos = this.writeBytes(var7, var8, this.bytePos);
         this.crc.update(var7, 0, var8);
         this.crcValue = this.crc.getValue();
         this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
         var10.finish();
         return true;
      } catch (IOException var16) {
         System.err.println(var16.toString());
         return false;
      }
   }

   protected void writeEnd() {
      this.bytePos = this.writeInt4(0, this.bytePos);
      this.bytePos = this.writeBytes(IEND, this.bytePos);
      this.crc.reset();
      this.crc.update(IEND);
      this.crcValue = this.crc.getValue();
      this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
   }

   public void setXDpi(int var1) {
      this.xDpi = Math.round((float)var1 / INCH_IN_METER_UNIT);
   }

   public int getXDpi() {
      return Math.round((float)this.xDpi * INCH_IN_METER_UNIT);
   }

   public void setYDpi(int var1) {
      this.yDpi = Math.round((float)var1 / INCH_IN_METER_UNIT);
   }

   public int getYDpi() {
      return Math.round((float)this.yDpi * INCH_IN_METER_UNIT);
   }

   public void setDpi(int var1, int var2) {
      this.xDpi = Math.round((float)var1 / INCH_IN_METER_UNIT);
      this.yDpi = Math.round((float)var2 / INCH_IN_METER_UNIT);
   }

   protected void writeResolution() {
      if(this.xDpi > 0 && this.yDpi > 0) {
         int var1 = this.bytePos = this.writeInt4(9, this.bytePos);
         this.bytePos = this.writeBytes(PHYS, this.bytePos);
         this.bytePos = this.writeInt4(this.xDpi, this.bytePos);
         this.bytePos = this.writeInt4(this.yDpi, this.bytePos);
         this.bytePos = this.writeByte(1, this.bytePos);
         this.crc.reset();
         this.crc.update(this.pngBytes, var1, this.bytePos - var1);
         this.crcValue = this.crc.getValue();
         this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
      }

   }
}
