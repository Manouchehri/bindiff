package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import y.h.*;
import javax.swing.*;

public class CRegisterHotKeys
{
    public static void register(final AbstractZyGraph abstractZyGraph) {
        final ch view = abstractZyGraph.getView();
        final cm cm = new cm(view);
        final ActionMap v = cm.v();
        final InputMap a = cm.a(v);
        view.setActionMap(v);
        view.setInputMap(0, a);
        view.getCanvasComponent().setActionMap(v);
        view.getCanvasComponent().setInputMap(0, a);
        a.put(KeyStroke.getKeyStroke(40, 0), "DOWN");
        a.put(KeyStroke.getKeyStroke(38, 0), "UP");
        a.put(KeyStroke.getKeyStroke(37, 0), "LEFT");
        a.put(KeyStroke.getKeyStroke(39, 0), "RIGHT");
        a.put(KeyStroke.getKeyStroke(521, 0), "+");
        a.put(KeyStroke.getKeyStroke(45, 0), "-");
        a.put(KeyStroke.getKeyStroke(77, 0), "m");
        a.put(KeyStroke.getKeyStroke(83, 0), "s");
        a.put(KeyStroke.getKeyStroke(153, 0), "<");
        a.put(KeyStroke.getKeyStroke(65, 128), "SELECT_VISIBLE_NODES");
        a.put(KeyStroke.getKeyStroke(67, 128), "COPY_CONTENT_FROM_SELECTED_NODES");
        v.remove(y.h.cm.u);
        v.remove(y.h.cm.B);
        registerActions(abstractZyGraph);
    }
    
    public static void registerActions(final AbstractZyGraph abstractZyGraph) {
        final ActionMap actionMap = abstractZyGraph.getView().getCanvasComponent().getActionMap();
        actionMap.put("DOWN", new CRegisterHotKeys$CActionHotKey("DOWN", abstractZyGraph));
        actionMap.put("UP", new CRegisterHotKeys$CActionHotKey("UP", abstractZyGraph));
        actionMap.put("LEFT", new CRegisterHotKeys$CActionHotKey("LEFT", abstractZyGraph));
        actionMap.put("RIGHT", new CRegisterHotKeys$CActionHotKey("RIGHT", abstractZyGraph));
        actionMap.put("+", new CRegisterHotKeys$CActionHotKey("+", abstractZyGraph));
        actionMap.put("-", new CRegisterHotKeys$CActionHotKey("-", abstractZyGraph));
        actionMap.put("m", new CRegisterHotKeys$CActionHotKey("m", abstractZyGraph));
        actionMap.put("s", new CRegisterHotKeys$CActionHotKey("s", abstractZyGraph));
        actionMap.put("<", new CRegisterHotKeys$CActionHotKey("<", abstractZyGraph));
        actionMap.put("SELECT_VISIBLE_NODES", new CRegisterHotKeys$CActionHotKey("SELECT_VISIBLE_NODES", abstractZyGraph));
        actionMap.put("COPY_CONTENT_FROM_SELECTED_NODES", new CRegisterHotKeys$CActionHotKey("COPY_CONTENT_FROM_SELECTED_NODES", abstractZyGraph));
        abstractZyGraph.getView().setActionMap(actionMap);
        abstractZyGraph.getView().getCanvasComponent().setActionMap(actionMap);
    }
    
    public static void unregisterActions(final AbstractZyGraph abstractZyGraph) {
        final ActionMap actionMap = abstractZyGraph.getView().getCanvasComponent().getActionMap();
        final ActionMap actionMap2 = abstractZyGraph.getView().getActionMap();
        actionMap.remove("F2");
        actionMap.remove("DOWN");
        actionMap.remove("UP");
        actionMap.remove("LEFT");
        actionMap.remove("RIGHT");
        actionMap.remove("+");
        actionMap.remove("-");
        actionMap.remove("m");
        actionMap.remove("s");
        actionMap.remove("<");
        actionMap.remove("SELECT_VISIBLE_NODES");
        actionMap.remove("COPY_CONTENT_FROM_SELECTED_NODES");
        actionMap2.remove("DOWN");
        actionMap2.remove("UP");
        actionMap2.remove("LEFT");
        actionMap2.remove("RIGHT");
        actionMap2.remove("+");
        actionMap2.remove("-");
        actionMap2.remove("m");
        actionMap2.remove("s");
        actionMap2.remove("<");
        actionMap2.remove("SELECT_VISIBLE_NODES");
        actionMap2.remove("COPY_CONTENT_FROM_SELECTED_NODES");
    }
}
