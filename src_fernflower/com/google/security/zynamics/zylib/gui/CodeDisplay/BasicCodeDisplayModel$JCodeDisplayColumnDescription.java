package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import java.awt.Color;
import java.awt.Font;

public class BasicCodeDisplayModel$JCodeDisplayColumnDescription {
   final String name;
   final int width;
   final Color defaultFontColor;
   final Color defaultBackgroundColor;
   final Font defaultHeaderFont;
   final FormattedCharacterBuffer headerLine;

   public BasicCodeDisplayModel$JCodeDisplayColumnDescription(String var1, int var2, Color var3, Color var4, Font var5) {
      this.name = var1;
      this.width = var2;
      this.defaultFontColor = var3;
      this.defaultBackgroundColor = var4;
      this.defaultHeaderFont = var5;
      this.headerLine = new FormattedCharacterBuffer(CodeDisplay.padRight(this.name, this.width), this.defaultHeaderFont, this.defaultFontColor, this.defaultBackgroundColor);
   }

   public String getName() {
      return this.name;
   }

   public int getWidth() {
      return this.width;
   }

   public Color getDefaultFontColor() {
      return this.defaultFontColor;
   }

   public Color getDefaultBackgroundColor() {
      return this.defaultBackgroundColor;
   }

   public FormattedCharacterBuffer getHeader() {
      return this.headerLine;
   }
}
