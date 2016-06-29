package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.CRegisterHotKeys$CActionHotKey;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import y.h.ch;
import y.h.cm;

public class CRegisterHotKeys {
   public static void register(AbstractZyGraph var0) {
      ch var1 = var0.getView();
      cm var2 = new cm(var1);
      ActionMap var3 = var2.v();
      InputMap var4 = var2.a(var3);
      var1.setActionMap(var3);
      var1.setInputMap(0, var4);
      var1.getCanvasComponent().setActionMap(var3);
      var1.getCanvasComponent().setInputMap(0, var4);
      var4.put(KeyStroke.getKeyStroke(40, 0), "DOWN");
      var4.put(KeyStroke.getKeyStroke(38, 0), "UP");
      var4.put(KeyStroke.getKeyStroke(37, 0), "LEFT");
      var4.put(KeyStroke.getKeyStroke(39, 0), "RIGHT");
      var4.put(KeyStroke.getKeyStroke(521, 0), "+");
      var4.put(KeyStroke.getKeyStroke(45, 0), "-");
      var4.put(KeyStroke.getKeyStroke(77, 0), "m");
      var4.put(KeyStroke.getKeyStroke(83, 0), "s");
      var4.put(KeyStroke.getKeyStroke(153, 0), "<");
      var4.put(KeyStroke.getKeyStroke(65, 128), "SELECT_VISIBLE_NODES");
      var4.put(KeyStroke.getKeyStroke(67, 128), "COPY_CONTENT_FROM_SELECTED_NODES");
      var3.remove(cm.u);
      var3.remove(cm.B);
      registerActions(var0);
   }

   public static void registerActions(AbstractZyGraph var0) {
      ActionMap var1 = var0.getView().getCanvasComponent().getActionMap();
      var1.put("DOWN", new CRegisterHotKeys$CActionHotKey("DOWN", var0));
      var1.put("UP", new CRegisterHotKeys$CActionHotKey("UP", var0));
      var1.put("LEFT", new CRegisterHotKeys$CActionHotKey("LEFT", var0));
      var1.put("RIGHT", new CRegisterHotKeys$CActionHotKey("RIGHT", var0));
      var1.put("+", new CRegisterHotKeys$CActionHotKey("+", var0));
      var1.put("-", new CRegisterHotKeys$CActionHotKey("-", var0));
      var1.put("m", new CRegisterHotKeys$CActionHotKey("m", var0));
      var1.put("s", new CRegisterHotKeys$CActionHotKey("s", var0));
      var1.put("<", new CRegisterHotKeys$CActionHotKey("<", var0));
      var1.put("SELECT_VISIBLE_NODES", new CRegisterHotKeys$CActionHotKey("SELECT_VISIBLE_NODES", var0));
      var1.put("COPY_CONTENT_FROM_SELECTED_NODES", new CRegisterHotKeys$CActionHotKey("COPY_CONTENT_FROM_SELECTED_NODES", var0));
      var0.getView().setActionMap(var1);
      var0.getView().getCanvasComponent().setActionMap(var1);
   }

   public static void unregisterActions(AbstractZyGraph var0) {
      ActionMap var1 = var0.getView().getCanvasComponent().getActionMap();
      ActionMap var2 = var0.getView().getActionMap();
      var1.remove("F2");
      var1.remove("DOWN");
      var1.remove("UP");
      var1.remove("LEFT");
      var1.remove("RIGHT");
      var1.remove("+");
      var1.remove("-");
      var1.remove("m");
      var1.remove("s");
      var1.remove("<");
      var1.remove("SELECT_VISIBLE_NODES");
      var1.remove("COPY_CONTENT_FROM_SELECTED_NODES");
      var2.remove("DOWN");
      var2.remove("UP");
      var2.remove("LEFT");
      var2.remove("RIGHT");
      var2.remove("+");
      var2.remove("-");
      var2.remove("m");
      var2.remove("s");
      var2.remove("<");
      var2.remove("SELECT_VISIBLE_NODES");
      var2.remove("COPY_CONTENT_FROM_SELECTED_NODES");
   }
}
