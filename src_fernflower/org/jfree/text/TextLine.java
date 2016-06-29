package org.jfree.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.text.TextFragment;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;

public class TextLine implements Serializable {
   private static final long serialVersionUID = 7100085690160465444L;
   private List fragments;
   protected static final LogContext logger;
   static Class class$org$jfree$text$TextLine;

   public TextLine() {
      this.fragments = new ArrayList();
   }

   public TextLine(String var1) {
      this(var1, TextFragment.DEFAULT_FONT);
   }

   public TextLine(String var1, Font var2) {
      this.fragments = new ArrayList();
      TextFragment var3 = new TextFragment(var1, var2);
      this.fragments.add(var3);
   }

   public TextLine(String var1, Font var2, Paint var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.fragments = new ArrayList();
         TextFragment var4 = new TextFragment(var1, var2, var3);
         this.fragments.add(var4);
      }
   }

   public void addFragment(TextFragment var1) {
      this.fragments.add(var1);
   }

   public void removeFragment(TextFragment var1) {
      this.fragments.remove(var1);
   }

   public void draw(Graphics2D var1, float var2, float var3, TextAnchor var4, float var5, float var6, double var7) {
      float var9 = var2;
      float var10 = this.calculateBaselineOffset(var1, var4);

      Size2D var13;
      for(Iterator var11 = this.fragments.iterator(); var11.hasNext(); var9 += (float)var13.getWidth()) {
         TextFragment var12 = (TextFragment)var11.next();
         var13 = var12.calculateDimensions(var1);
         var12.draw(var1, var9, var3 + var10, TextAnchor.BASELINE_LEFT, var5, var6, var7);
      }

   }

   public Size2D calculateDimensions(Graphics2D var1) {
      double var2 = 0.0D;
      double var4 = 0.0D;
      Iterator var6 = this.fragments.iterator();

      while(var6.hasNext()) {
         TextFragment var7 = (TextFragment)var6.next();
         Size2D var8 = var7.calculateDimensions(var1);
         var2 += var8.getWidth();
         var4 = Math.max(var4, var8.getHeight());
         if(logger.isDebugEnabled()) {
            logger.debug("width = " + var2 + ", height = " + var4);
         }
      }

      return new Size2D(var2, var4);
   }

   public TextFragment getFirstTextFragment() {
      TextFragment var1 = null;
      if(this.fragments.size() > 0) {
         var1 = (TextFragment)this.fragments.get(0);
      }

      return var1;
   }

   public TextFragment getLastTextFragment() {
      TextFragment var1 = null;
      if(this.fragments.size() > 0) {
         var1 = (TextFragment)this.fragments.get(this.fragments.size() - 1);
      }

      return var1;
   }

   private float calculateBaselineOffset(Graphics2D var1, TextAnchor var2) {
      float var3 = 0.0F;

      TextFragment var5;
      for(Iterator var4 = this.fragments.iterator(); var4.hasNext(); var3 = Math.max(var3, var5.calculateBaselineOffset(var1, var2))) {
         var5 = (TextFragment)var4.next();
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(var1 instanceof TextLine) {
         TextLine var2 = (TextLine)var1;
         return this.fragments.equals(var2.fragments);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.fragments != null?this.fragments.hashCode():0;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      logger = Log.createContext(class$org$jfree$text$TextLine == null?(class$org$jfree$text$TextLine = class$("org.jfree.text.TextLine")):class$org$jfree$text$TextLine);
   }
}
