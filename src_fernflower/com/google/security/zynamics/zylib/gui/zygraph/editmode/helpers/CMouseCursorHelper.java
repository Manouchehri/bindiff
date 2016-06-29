package com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.Cursor;

public class CMouseCursorHelper {
   private static Cursor DEFAULT_CURSOR = Cursor.getDefaultCursor();
   private static Cursor MOVE_CURSOR = Cursor.getPredefinedCursor(13);
   private static Cursor HAND_CURSOR = Cursor.getPredefinedCursor(12);

   public static void setDefaultCursor(AbstractZyGraph var0) {
      if(var0.getViewCursor() != DEFAULT_CURSOR) {
         var0.setViewCursor(DEFAULT_CURSOR);
      }

   }

   public static void setHandCursor(AbstractZyGraph var0) {
      if(var0.getViewCursor() != HAND_CURSOR) {
         var0.setViewCursor(HAND_CURSOR);
      }

   }

   public static void setMoveCursor(AbstractZyGraph var0) {
      if(var0.getViewCursor() != MOVE_CURSOR) {
         var0.setViewCursor(MOVE_CURSOR);
      }

   }
}
