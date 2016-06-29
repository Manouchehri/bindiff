package org.jfree.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import org.jfree.util.Log;

public class WaitingImageObserver implements ImageObserver, Serializable, Cloneable {
   static final long serialVersionUID = -807204410581383550L;
   private boolean lock;
   private Image image;
   private boolean error;

   public WaitingImageObserver(Image var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.image = var1;
         this.lock = true;
      }
   }

   public synchronized boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      if((var2 & 32) == 32) {
         this.lock = false;
         this.error = false;
         this.notifyAll();
         return false;
      } else if((var2 & 128) != 128 && (var2 & 64) != 64) {
         return true;
      } else {
         this.lock = false;
         this.error = true;
         this.notifyAll();
         return false;
      }
   }

   public synchronized void waitImageLoaded() {
      if(this.lock) {
         BufferedImage var1 = new BufferedImage(1, 1, 1);
         Graphics var2 = var1.getGraphics();

         while(this.lock) {
            if(var2.drawImage(this.image, 0, 0, var1.getWidth(this), var1.getHeight(this), this)) {
               return;
            }

            try {
               this.wait(500L);
            } catch (InterruptedException var4) {
               Log.info("WaitingImageObserver.waitImageLoaded(): InterruptedException thrown", var4);
            }
         }

      }
   }

   public Object clone() {
      return (WaitingImageObserver)super.clone();
   }

   public boolean isLoadingComplete() {
      return !this.lock;
   }

   public boolean isError() {
      return this.error;
   }
}
