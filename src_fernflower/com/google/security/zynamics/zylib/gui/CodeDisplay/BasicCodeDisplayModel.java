package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import java.awt.Font;

public abstract class BasicCodeDisplayModel implements ICodeDisplayModel {
   public static final Font HEADER_FONT_BOLD;
   public static final Font STANDARD_FONT;

   static {
      HEADER_FONT_BOLD = GuiHelper.MONOSPACED_FONT.deriveFont(1);
      STANDARD_FONT = GuiHelper.MONOSPACED_FONT;
   }
}
