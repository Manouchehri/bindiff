package org.jfree.chart.plot;

import java.io.Serializable;
import org.jfree.chart.plot.ColorPalette;

public class GreyPalette extends ColorPalette implements Serializable {
   private static final long serialVersionUID = -2120941170159987395L;

   public GreyPalette() {
      this.initialize();
   }

   public void initialize() {
      this.setPaletteName("Grey");
      this.r = new int[256];
      this.g = new int[256];
      this.b = new int[256];
      this.r[0] = 255;
      this.g[0] = 255;
      this.b[0] = 255;
      this.r[1] = 0;
      this.g[1] = 0;
      this.b[1] = 0;

      for(int var1 = 2; var1 < 256; this.b[var1] = var1++) {
         this.r[var1] = var1;
         this.g[var1] = var1;
      }

   }
}
