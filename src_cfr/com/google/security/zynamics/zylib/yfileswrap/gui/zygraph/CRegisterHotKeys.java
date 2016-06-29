/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.CRegisterHotKeys$CActionHotKey;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import y.h.ch;
import y.h.cm;

public class CRegisterHotKeys {
    public static void register(AbstractZyGraph abstractZyGraph) {
        ch ch2 = abstractZyGraph.getView();
        cm cm2 = new cm(ch2);
        ActionMap actionMap = cm2.v();
        InputMap inputMap = cm2.a(actionMap);
        ch2.setActionMap(actionMap);
        ch2.setInputMap(0, inputMap);
        ch2.getCanvasComponent().setActionMap(actionMap);
        ch2.getCanvasComponent().setInputMap(0, inputMap);
        inputMap.put(KeyStroke.getKeyStroke(40, 0), "DOWN");
        inputMap.put(KeyStroke.getKeyStroke(38, 0), "UP");
        inputMap.put(KeyStroke.getKeyStroke(37, 0), "LEFT");
        inputMap.put(KeyStroke.getKeyStroke(39, 0), "RIGHT");
        inputMap.put(KeyStroke.getKeyStroke(521, 0), "+");
        inputMap.put(KeyStroke.getKeyStroke(45, 0), "-");
        inputMap.put(KeyStroke.getKeyStroke(77, 0), "m");
        inputMap.put(KeyStroke.getKeyStroke(83, 0), "s");
        inputMap.put(KeyStroke.getKeyStroke(153, 0), "<");
        inputMap.put(KeyStroke.getKeyStroke(65, 128), "SELECT_VISIBLE_NODES");
        inputMap.put(KeyStroke.getKeyStroke(67, 128), "COPY_CONTENT_FROM_SELECTED_NODES");
        actionMap.remove(cm.u);
        actionMap.remove(cm.B);
        CRegisterHotKeys.registerActions(abstractZyGraph);
    }

    public static void registerActions(AbstractZyGraph abstractZyGraph) {
        ActionMap actionMap = abstractZyGraph.getView().getCanvasComponent().getActionMap();
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

    public static void unregisterActions(AbstractZyGraph abstractZyGraph) {
        ActionMap actionMap = abstractZyGraph.getView().getCanvasComponent().getActionMap();
        ActionMap actionMap2 = abstractZyGraph.getView().getActionMap();
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

