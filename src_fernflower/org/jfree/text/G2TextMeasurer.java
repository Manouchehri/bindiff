package org.jfree.text;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.text.TextMeasurer;
import org.jfree.text.TextUtilities;

public class G2TextMeasurer implements TextMeasurer {
   private Graphics2D g2;

   public G2TextMeasurer(Graphics2D var1) {
      this.g2 = var1;
   }

   public float getStringWidth(String var1, int var2, int var3) {
      FontMetrics var4 = this.g2.getFontMetrics();
      Rectangle2D var5 = TextUtilities.getTextBounds(var1.substring(var2, var3), this.g2, var4);
      float var6 = (float)var5.getWidth();
      return var6;
   }
}
