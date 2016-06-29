/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler$1;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler$InternalFocusListener;
import com.google.security.zynamics.zylib.gui.zygraph.ILabelEditableContentListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CBackspaceKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CCharKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CCopyKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CCursorKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CCutKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CDelKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CEndKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CHomeKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CInsertKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CPasteKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CRedoKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CReturnKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CSelectAllKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CTabKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CUndoKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class CDefaultLabelEventHandler
extends KeyAdapter {
    private final AbstractZyGraph m_graph;
    private final Map m_ctrlKeyBehaviourMap = new HashMap();
    private final Map m_keyBehaviourMap = new HashMap();
    private final CUndoManager m_undoManager = new CUndoManager();
    private ZyLabelContent m_activeLabelContent;
    private IZyRegenerateableRealizer m_activeRealizer;
    private final CDefaultLabelEventHandler$InternalFocusListener m_focusListener;
    private final ListenerProvider m_editModeListener;

    public CDefaultLabelEventHandler(AbstractZyGraph abstractZyGraph) {
        this.m_focusListener = new CDefaultLabelEventHandler$InternalFocusListener(this, null);
        this.m_editModeListener = new ListenerProvider();
        this.m_graph = abstractZyGraph;
        this.m_graph.addViewFocusListener(this.m_focusListener);
        this.init();
    }

    private String getContentSnippet(int n2) {
        int n3;
        String string = "";
        int n4 = this.getActiveLabelContent().getFirstLineIndexOfModelAt(n2);
        int n5 = this.getActiveLabelContent().getLastLineIndexOfModelAt(n2);
        for (n3 = n4; n3 <= n5; ++n3) {
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(this.getActiveLabelContent().getLineContent(n3).getText());
            string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        }
        if (n4 > 0) {
            n5 = n4 - 1;
            n4 = this.getActiveLabelContent().getFirstLineIndexOfModelAt(n5);
            String string4 = "";
            for (int i2 = n4; i2 <= n5; ++i2) {
                String string5 = String.valueOf(string4);
                String string6 = String.valueOf(this.getActiveLabelContent().getLineContent(i2).getText());
                string4 = string6.length() != 0 ? string5.concat(string6) : new String(string5);
            }
            String string7 = String.valueOf(string4);
            String string8 = String.valueOf(string);
            string = string8.length() != 0 ? string7.concat(string8) : new String(string7);
        }
        if ((n5 = this.getActiveLabelContent().getLastLineIndexOfModelAt(n2)) + 1 >= this.getActiveLabelContent().getLineCount() - 1) return string;
        n4 = n5 + 1;
        n5 = this.getActiveLabelContent().getLastLineIndexOfModelAt(n4);
        n3 = n4;
        while (n3 <= n5) {
            String string9 = String.valueOf(string);
            String string10 = String.valueOf(this.getActiveLabelContent().getLineContent(n3).getText());
            string = string10.length() != 0 ? string9.concat(string10) : new String(string9);
            ++n3;
        }
        return string;
    }

    private void init() {
        this.m_keyBehaviourMap.put(38, new CCursorKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(40, new CCursorKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(37, new CCursorKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(39, new CCursorKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(9, new CTabKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(36, new CHomeKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(35, new CEndKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(155, new CInsertKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(127, new CDelKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(8, new CBackspaceKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(10, new CReturnKeyBehavior(this.m_undoManager));
        this.m_keyBehaviourMap.put(null, new CCharKeyBehavior(this.m_undoManager));
        this.m_ctrlKeyBehaviourMap.put(65, new CSelectAllKeyBehavior(this.m_undoManager));
        this.m_ctrlKeyBehaviourMap.put(88, new CCutKeyBehavior(this.m_undoManager));
        this.m_ctrlKeyBehaviourMap.put(67, new CCopyKeyBehavior(this.m_undoManager));
        this.m_ctrlKeyBehaviourMap.put(86, new CPasteKeyBehavior(this.m_undoManager));
        this.m_ctrlKeyBehaviourMap.put(89, new CRedoKeyBehavior(this.m_undoManager));
        this.m_ctrlKeyBehaviourMap.put(90, new CUndoKeyBehavior(this.m_undoManager));
    }

    protected AbstractZyGraph getGraph() {
        return this.m_graph;
    }

    public void activateLabelContent(ZyLabelContent zyLabelContent, IZyRegenerateableRealizer iZyRegenerateableRealizer) {
        if (zyLabelContent == null) return;
        if (iZyRegenerateableRealizer == null) {
            return;
        }
        this.unregisterListener();
        if (this.getActiveLabelContent() != null && zyLabelContent != this.getActiveLabelContent() && this.getActiveLabelContent().isSelectable()) {
            this.getActiveLabelContent().showCaret(false);
            this.m_graph.updateViews();
        }
        this.setActiveLabelContent(zyLabelContent);
        this.m_activeRealizer = iZyRegenerateableRealizer;
        this.getActiveLabelContent().showCaret(this.getActiveLabelContent().isSelectable());
        this.m_undoManager.setLabelContent(this.getActiveLabelContent());
        this.registerListener();
    }

    public void addEditModeListener(ILabelEditableContentListener iLabelEditableContentListener) {
        this.m_editModeListener.addListener(iLabelEditableContentListener);
    }

    public void addKeyBehaviour(Integer n2, CAbstractKeyBehavior cAbstractKeyBehavior, boolean bl2) {
        if (bl2) {
            this.m_ctrlKeyBehaviourMap.put(n2, cAbstractKeyBehavior);
            return;
        }
        this.m_keyBehaviourMap.put(n2, cAbstractKeyBehavior);
    }

    public void deactivateLabelContent() {
        this.unregisterListener();
        if (this.getActiveLabelContent() != null && this.getActiveLabelContent().isSelectable()) {
            this.getActiveLabelContent().showCaret(false);
            this.setActiveLabelContent(null);
            this.m_activeRealizer = null;
        }
        this.m_graph.updateViews();
        this.m_undoManager.setLabelContent(this.getActiveLabelContent());
        this.registerListener();
    }

    public void dispose() {
        this.m_graph.removeViewFocusListener(this.m_focusListener);
    }

    public void handleMouseDraggedEvent(double d2, double d3, double d4, double d5, double d6) {
        ZyCaret zyCaret = this.getActiveLabelContent().getCaret();
        int n2 = zyCaret.getYmouseReleased();
        int n3 = zyCaret.getXmouseReleased();
        zyCaret.setCaretEnd(d2, d3, d4, d5, d6);
        if (zyCaret.getYmouseReleased() == n2) {
            if (zyCaret.getXmouseReleased() == n3) return;
        }
        this.m_activeRealizer.repaint();
    }

    public void handleMousePressedEvent(double d2, double d3, double d4, double d5, double d6) {
        ZyCaret zyCaret = this.getActiveLabelContent().getCaret();
        zyCaret.setCaretStart(d2, d3, d4, d5, d6);
        zyCaret.setCaretEnd(d2, d3, d4, d5, d6);
        this.m_activeRealizer.repaint();
    }

    public void handleMouseReleasedEvent(double d2, double d3, double d4, double d5, double d6, int n2) {
        ZyCaret zyCaret = this.getActiveLabelContent().getCaret();
        switch (n2) {
            case 1: {
                zyCaret.setCaretEnd(d2, d3, d4, d5, d6);
                break;
            }
            case 2: {
                zyCaret.selectWord(d2, d3, d4, d5, d6);
                break;
            }
            case 3: {
                zyCaret.selectLine(d3, d5);
                break;
            }
            case 4: {
                zyCaret.selectAll();
            }
        }
        this.m_activeRealizer.repaint();
    }

    public boolean hasEmptySelection() {
        return this.getActiveLabelContent().getSelectedText().equals("");
    }

    public boolean isActive() {
        if (this.getActiveLabelContent() == null) return false;
        return true;
    }

    public boolean isActiveLabel(ZyLabelContent zyLabelContent) {
        if (zyLabelContent == null) return false;
        if (zyLabelContent != this.getActiveLabelContent()) return false;
        return true;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.isActive()) {
            return;
        }
        if (keyEvent.getKeyCode() == 27) {
            this.deactivateLabelContent();
            return;
        }
        if (keyEvent.getKeyCode() == 9 && keyEvent.getModifiers() != 0 && keyEvent.getModifiers() != 64) {
            return;
        }
        if (!this.getActiveLabelContent().isSelectable()) {
            return;
        }
        CAbstractKeyBehavior cAbstractKeyBehavior = null;
        char c2 = KeyEvent.getKeyText(keyEvent.getKeyCode()).charAt(0);
        if (keyEvent.isControlDown() && c2 >= 'A' && c2 <= 'Z') {
            cAbstractKeyBehavior = (CAbstractKeyBehavior)this.m_ctrlKeyBehaviourMap.get(keyEvent.getKeyCode());
        }
        if (cAbstractKeyBehavior == null && (cAbstractKeyBehavior = (CAbstractKeyBehavior)this.m_keyBehaviourMap.get(keyEvent.getKeyCode())) == null && keyEvent.getKeyChar() != '\uffff' && !keyEvent.isControlDown() && this.getActiveLabelContent().isEditable()) {
            cAbstractKeyBehavior = (CAbstractKeyBehavior)this.m_keyBehaviourMap.get(null);
        }
        if (cAbstractKeyBehavior != null) {
            String string;
            int n2 = -1;
            String string2 = "";
            if (this.getActiveLabelContent().isEditable()) {
                n2 = this.getActiveLabelContent().getCaret().getYmouseReleased();
                string2 = this.getContentSnippet(n2);
            }
            cAbstractKeyBehavior.keyPressed(this.getActiveLabelContent(), keyEvent);
            if (n2 > -1 && !string2.equals(string = this.getContentSnippet(n2)) && !string2.isEmpty()) {
                for (ILabelEditableContentListener iLabelEditableContentListener : this.m_editModeListener) {
                    iLabelEditableContentListener.editableContentChanged(this.getActiveLabelContent());
                }
            }
            this.m_activeRealizer.regenerate();
            this.m_activeRealizer.repaint();
            this.m_graph.updateViews();
        }
        keyEvent.consume();
    }

    public void registerListener() {
        if (!this.isActive()) return;
        this.m_graph.addViewCanvasKeyListener(this);
    }

    public void removeEditModeListener(ILabelEditableContentListener iLabelEditableContentListener) {
        this.m_editModeListener.removeListener(iLabelEditableContentListener);
    }

    public void unregisterListener() {
        if (!this.isActive()) return;
        this.m_graph.removeViewCanvasKeyListener(this);
    }

    private ZyLabelContent getActiveLabelContent() {
        return this.m_activeLabelContent;
    }

    private void setActiveLabelContent(ZyLabelContent zyLabelContent) {
        this.m_activeLabelContent = zyLabelContent;
    }
}

