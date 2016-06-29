package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.awt.event.*;
import java.util.*;

public class CDefaultLabelEventHandler extends KeyAdapter
{
    private final AbstractZyGraph m_graph;
    private final Map m_ctrlKeyBehaviourMap;
    private final Map m_keyBehaviourMap;
    private final CUndoManager m_undoManager;
    private ZyLabelContent m_activeLabelContent;
    private IZyRegenerateableRealizer m_activeRealizer;
    private final CDefaultLabelEventHandler$InternalFocusListener m_focusListener;
    private final ListenerProvider m_editModeListener;
    
    public CDefaultLabelEventHandler(final AbstractZyGraph graph) {
        this.m_ctrlKeyBehaviourMap = new HashMap();
        this.m_keyBehaviourMap = new HashMap();
        this.m_undoManager = new CUndoManager();
        this.m_focusListener = new CDefaultLabelEventHandler$InternalFocusListener(this, null);
        this.m_editModeListener = new ListenerProvider();
        (this.m_graph = graph).addViewFocusListener(this.m_focusListener);
        this.init();
    }
    
    private String getContentSnippet(final int n) {
        String s = "";
        final int firstLineIndexOfModel = this.getActiveLabelContent().getFirstLineIndexOfModelAt(n);
        for (int lastLineIndexOfModel = this.getActiveLabelContent().getLastLineIndexOfModelAt(n), i = firstLineIndexOfModel; i <= lastLineIndexOfModel; ++i) {
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(this.getActiveLabelContent().getLineContent(i).getText());
            s = ((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        if (firstLineIndexOfModel > 0) {
            final int n2 = firstLineIndexOfModel - 1;
            final int firstLineIndexOfModel2 = this.getActiveLabelContent().getFirstLineIndexOfModelAt(n2);
            String s2 = "";
            for (int j = firstLineIndexOfModel2; j <= n2; ++j) {
                final String value3 = String.valueOf(s2);
                final String value4 = String.valueOf(this.getActiveLabelContent().getLineContent(j).getText());
                s2 = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
            }
            final String value5 = String.valueOf(s2);
            final String value6 = String.valueOf(s);
            s = ((value6.length() != 0) ? value5.concat(value6) : new String(value5));
        }
        final int lastLineIndexOfModel2 = this.getActiveLabelContent().getLastLineIndexOfModelAt(n);
        if (lastLineIndexOfModel2 + 1 < this.getActiveLabelContent().getLineCount() - 1) {
            final int n3 = lastLineIndexOfModel2 + 1;
            for (int lastLineIndexOfModel3 = this.getActiveLabelContent().getLastLineIndexOfModelAt(n3), k = n3; k <= lastLineIndexOfModel3; ++k) {
                final String value7 = String.valueOf(s);
                final String value8 = String.valueOf(this.getActiveLabelContent().getLineContent(k).getText());
                s = ((value8.length() != 0) ? value7.concat(value8) : new String(value7));
            }
        }
        return s;
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
    
    public void activateLabelContent(final ZyLabelContent activeLabelContent, final IZyRegenerateableRealizer activeRealizer) {
        if (activeLabelContent == null || activeRealizer == null) {
            return;
        }
        this.unregisterListener();
        if (this.getActiveLabelContent() != null && activeLabelContent != this.getActiveLabelContent() && this.getActiveLabelContent().isSelectable()) {
            this.getActiveLabelContent().showCaret(false);
            this.m_graph.updateViews();
        }
        this.setActiveLabelContent(activeLabelContent);
        this.m_activeRealizer = activeRealizer;
        this.getActiveLabelContent().showCaret(this.getActiveLabelContent().isSelectable());
        this.m_undoManager.setLabelContent(this.getActiveLabelContent());
        this.registerListener();
    }
    
    public void addEditModeListener(final ILabelEditableContentListener labelEditableContentListener) {
        this.m_editModeListener.addListener(labelEditableContentListener);
    }
    
    public void addKeyBehaviour(final Integer n, final CAbstractKeyBehavior cAbstractKeyBehavior, final boolean b) {
        if (b) {
            this.m_ctrlKeyBehaviourMap.put(n, cAbstractKeyBehavior);
        }
        else {
            this.m_keyBehaviourMap.put(n, cAbstractKeyBehavior);
        }
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
    
    public void handleMouseDraggedEvent(final double n, final double n2, final double n3, final double n4, final double n5) {
        final ZyCaret caret = this.getActiveLabelContent().getCaret();
        final int ymouseReleased = caret.getYmouseReleased();
        final int xmouseReleased = caret.getXmouseReleased();
        caret.setCaretEnd(n, n2, n3, n4, n5);
        if (caret.getYmouseReleased() != ymouseReleased || caret.getXmouseReleased() != xmouseReleased) {
            this.m_activeRealizer.repaint();
        }
    }
    
    public void handleMousePressedEvent(final double n, final double n2, final double n3, final double n4, final double n5) {
        final ZyCaret caret = this.getActiveLabelContent().getCaret();
        caret.setCaretStart(n, n2, n3, n4, n5);
        caret.setCaretEnd(n, n2, n3, n4, n5);
        this.m_activeRealizer.repaint();
    }
    
    public void handleMouseReleasedEvent(final double n, final double n2, final double n3, final double n4, final double n5, final int n6) {
        final ZyCaret caret = this.getActiveLabelContent().getCaret();
        switch (n6) {
            case 1: {
                caret.setCaretEnd(n, n2, n3, n4, n5);
                break;
            }
            case 2: {
                caret.selectWord(n, n2, n3, n4, n5);
                break;
            }
            case 3: {
                caret.selectLine(n2, n4);
                break;
            }
            case 4: {
                caret.selectAll();
                break;
            }
        }
        this.m_activeRealizer.repaint();
    }
    
    public boolean hasEmptySelection() {
        return this.getActiveLabelContent().getSelectedText().equals("");
    }
    
    public boolean isActive() {
        return this.getActiveLabelContent() != null;
    }
    
    public boolean isActiveLabel(final ZyLabelContent zyLabelContent) {
        return zyLabelContent != null && zyLabelContent == this.getActiveLabelContent();
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
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
        final char char1 = KeyEvent.getKeyText(keyEvent.getKeyCode()).charAt(0);
        if (keyEvent.isControlDown() && char1 >= 'A' && char1 <= 'Z') {
            cAbstractKeyBehavior = this.m_ctrlKeyBehaviourMap.get(keyEvent.getKeyCode());
        }
        if (cAbstractKeyBehavior == null) {
            cAbstractKeyBehavior = this.m_keyBehaviourMap.get(keyEvent.getKeyCode());
            if (cAbstractKeyBehavior == null && keyEvent.getKeyChar() != '\uffff' && !keyEvent.isControlDown() && this.getActiveLabelContent().isEditable()) {
                cAbstractKeyBehavior = this.m_keyBehaviourMap.get(null);
            }
        }
        if (cAbstractKeyBehavior != null) {
            int ymouseReleased = -1;
            String contentSnippet = "";
            if (this.getActiveLabelContent().isEditable()) {
                ymouseReleased = this.getActiveLabelContent().getCaret().getYmouseReleased();
                contentSnippet = this.getContentSnippet(ymouseReleased);
            }
            cAbstractKeyBehavior.keyPressed(this.getActiveLabelContent(), keyEvent);
            if (ymouseReleased > -1 && !contentSnippet.equals(this.getContentSnippet(ymouseReleased)) && !contentSnippet.isEmpty()) {
                final Iterator iterator = this.m_editModeListener.iterator();
                while (iterator.hasNext()) {
                    iterator.next().editableContentChanged(this.getActiveLabelContent());
                }
            }
            this.m_activeRealizer.regenerate();
            this.m_activeRealizer.repaint();
            this.m_graph.updateViews();
        }
        keyEvent.consume();
    }
    
    public void registerListener() {
        if (this.isActive()) {
            this.m_graph.addViewCanvasKeyListener(this);
        }
    }
    
    public void removeEditModeListener(final ILabelEditableContentListener labelEditableContentListener) {
        this.m_editModeListener.removeListener(labelEditableContentListener);
    }
    
    public void unregisterListener() {
        if (this.isActive()) {
            this.m_graph.removeViewCanvasKeyListener(this);
        }
    }
    
    private ZyLabelContent getActiveLabelContent() {
        return this.m_activeLabelContent;
    }
    
    private void setActiveLabelContent(final ZyLabelContent activeLabelContent) {
        this.m_activeLabelContent = activeLabelContent;
    }
}
