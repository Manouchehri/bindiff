package com.google.security.zynamics.zylib.gui.zygraph;

import java.text.ParseException;

public enum MouseWheelAction {
   ZOOM,
   SCROLL;

   public static MouseWheelAction parseInt(int var0) {
      if(var0 == ZOOM.ordinal()) {
         return ZOOM;
      } else if(var0 == SCROLL.ordinal()) {
         return SCROLL;
      } else {
         throw new ParseException("Error: Invalid action", 0);
      }
   }
}
