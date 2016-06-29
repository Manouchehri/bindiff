package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler$1;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler$InternalFocusListener;
import com.google.security.zynamics.zylib.gui.zygraph.ILabelEditableContentListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CDefaultLabelEventHandler extends KeyAdapter {
   private final AbstractZyGraph m_graph;
   private final Map m_ctrlKeyBehaviourMap = new HashMap();
   private final Map m_keyBehaviourMap = new HashMap();
   private final CUndoManager m_undoManager = new CUndoManager();
   private ZyLabelContent m_activeLabelContent;
   private IZyRegenerateableRealizer m_activeRealizer;
   private final CDefaultLabelEventHandler$InternalFocusListener m_focusListener = new CDefaultLabelEventHandler$InternalFocusListener(this, (CDefaultLabelEventHandler$1)null);
   private final ListenerProvider m_editModeListener = new ListenerProvider();

   public CDefaultLabelEventHandler(AbstractZyGraph var1) {
      this.m_graph = var1;
      this.m_graph.addViewFocusListener(this.m_focusListener);
      this.init();
   }

   private String getContentSnippet(int var1) {
      // $FF: Couldn't be decompiled
   }

   private void init() {
      this.m_keyBehaviourMap.put(Integer.valueOf(38), new CCursorKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(40), new CCursorKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(37), new CCursorKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(39), new CCursorKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(9), new CTabKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(36), new CHomeKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(35), new CEndKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(155), new CInsertKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(127), new CDelKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(8), new CBackspaceKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put(Integer.valueOf(10), new CReturnKeyBehavior(this.m_undoManager));
      this.m_keyBehaviourMap.put((Object)null, new CCharKeyBehavior(this.m_undoManager));
      this.m_ctrlKeyBehaviourMap.put(Integer.valueOf(65), new CSelectAllKeyBehavior(this.m_undoManager));
      this.m_ctrlKeyBehaviourMap.put(Integer.valueOf(88), new CCutKeyBehavior(this.m_undoManager));
      this.m_ctrlKeyBehaviourMap.put(Integer.valueOf(67), new CCopyKeyBehavior(this.m_undoManager));
      this.m_ctrlKeyBehaviourMap.put(Integer.valueOf(86), new CPasteKeyBehavior(this.m_undoManager));
      this.m_ctrlKeyBehaviourMap.put(Integer.valueOf(89), new CRedoKeyBehavior(this.m_undoManager));
      this.m_ctrlKeyBehaviourMap.put(Integer.valueOf(90), new CUndoKeyBehavior(this.m_undoManager));
   }

   protected AbstractZyGraph getGraph() {
      return this.m_graph;
   }

   public void activateLabelContent(ZyLabelContent var1, IZyRegenerateableRealizer var2) {
      if(var1 != null && var2 != null) {
         this.unregisterListener();
         if(this.getActiveLabelContent() != null && var1 != this.getActiveLabelContent() && this.getActiveLabelContent().isSelectable()) {
            this.getActiveLabelContent().showCaret(false);
            this.m_graph.updateViews();
         }

         this.setActiveLabelContent(var1);
         this.m_activeRealizer = var2;
         this.getActiveLabelContent().showCaret(this.getActiveLabelContent().isSelectable());
         this.m_undoManager.setLabelContent(this.getActiveLabelContent());
         this.registerListener();
      }
   }

   public void addEditModeListener(ILabelEditableContentListener var1) {
      this.m_editModeListener.addListener(var1);
   }

   public void addKeyBehaviour(Integer var1, CAbstractKeyBehavior var2, boolean var3) {
      if(var3) {
         this.m_ctrlKeyBehaviourMap.put(var1, var2);
      } else {
         this.m_keyBehaviourMap.put(var1, var2);
      }

   }

   public void deactivateLabelContent() {
      this.unregisterListener();
      if(this.getActiveLabelContent() != null && this.getActiveLabelContent().isSelectable()) {
         this.getActiveLabelContent().showCaret(false);
         this.setActiveLabelContent((ZyLabelContent)null);
         this.m_activeRealizer = null;
      }

      this.m_graph.updateViews();
      this.m_undoManager.setLabelContent(this.getActiveLabelContent());
      this.registerListener();
   }

   public void dispose() {
      this.m_graph.removeViewFocusListener(this.m_focusListener);
   }

   public void handleMouseDraggedEvent(double var1, double var3, double var5, double var7, double var9) {
      ZyCaret var11 = this.getActiveLabelContent().getCaret();
      int var12 = var11.getYmouseReleased();
      int var13 = var11.getXmouseReleased();
      var11.setCaretEnd(var1, var3, var5, var7, var9);
      if(var11.getYmouseReleased() != var12 || var11.getXmouseReleased() != var13) {
         this.m_activeRealizer.repaint();
      }

   }

   public void handleMousePressedEvent(double var1, double var3, double var5, double var7, double var9) {
      ZyCaret var11 = this.getActiveLabelContent().getCaret();
      var11.setCaretStart(var1, var3, var5, var7, var9);
      var11.setCaretEnd(var1, var3, var5, var7, var9);
      this.m_activeRealizer.repaint();
   }

   public void handleMouseReleasedEvent(double var1, double var3, double var5, double var7, double var9, int var11) {
      ZyCaret var12 = this.getActiveLabelContent().getCaret();
      switch(var11) {
      case 1:
         var12.setCaretEnd(var1, var3, var5, var7, var9);
         break;
      case 2:
         var12.selectWord(var1, var3, var5, var7, var9);
         break;
      case 3:
         var12.selectLine(var3, var7);
         break;
      case 4:
         var12.selectAll();
      }

      this.m_activeRealizer.repaint();
   }

   public boolean hasEmptySelection() {
      return this.getActiveLabelContent().getSelectedText().equals("");
   }

   public boolean isActive() {
      return this.getActiveLabelContent() != null;
   }

   public boolean isActiveLabel(ZyLabelContent var1) {
      return var1 != null && var1 == this.getActiveLabelContent();
   }

   public void keyPressed(KeyEvent var1) {
      if(this.isActive()) {
         if(var1.getKeyCode() == 27) {
            this.deactivateLabelContent();
         } else if(var1.getKeyCode() != 9 || var1.getModifiers() == 0 || var1.getModifiers() == 64) {
            if(this.getActiveLabelContent().isSelectable()) {
               CAbstractKeyBehavior var2 = null;
               char var3 = KeyEvent.getKeyText(var1.getKeyCode()).charAt(0);
               if(var1.isControlDown() && var3 >= 65 && var3 <= 90) {
                  var2 = (CAbstractKeyBehavior)this.m_ctrlKeyBehaviourMap.get(Integer.valueOf(var1.getKeyCode()));
               }

               if(var2 == null) {
                  var2 = (CAbstractKeyBehavior)this.m_keyBehaviourMap.get(Integer.valueOf(var1.getKeyCode()));
                  if(var2 == null && var1.getKeyChar() != '\uffff' && !var1.isControlDown() && this.getActiveLabelContent().isEditable()) {
                     var2 = (CAbstractKeyBehavior)this.m_keyBehaviourMap.get((Object)null);
                  }
               }

               if(var2 != null) {
                  int var4 = -1;
                  String var5 = "";
                  if(this.getActiveLabelContent().isEditable()) {
                     var4 = this.getActiveLabelContent().getCaret().getYmouseReleased();
                     var5 = this.getContentSnippet(var4);
                  }

                  var2.keyPressed(this.getActiveLabelContent(), var1);
                  if(var4 > -1) {
                     String var6 = this.getContentSnippet(var4);
                     if(!var5.equals(var6) && !var5.isEmpty()) {
                        Iterator var7 = this.m_editModeListener.iterator();

                        while(var7.hasNext()) {
                           ILabelEditableContentListener var8 = (ILabelEditableContentListener)var7.next();
                           var8.editableContentChanged(this.getActiveLabelContent());
                        }
                     }
                  }

                  this.m_activeRealizer.regenerate();
                  this.m_activeRealizer.repaint();
                  this.m_graph.updateViews();
               }

               var1.consume();
            }
         }
      }
   }

   public void registerListener() {
      if(this.isActive()) {
         this.m_graph.addViewCanvasKeyListener(this);
      }

   }

   public void removeEditModeListener(ILabelEditableContentListener var1) {
      this.m_editModeListener.removeListener(var1);
   }

   public void unregisterListener() {
      if(this.isActive()) {
         this.m_graph.removeViewCanvasKeyListener(this);
      }

   }

   private ZyLabelContent getActiveLabelContent() {
      return this.m_activeLabelContent;
   }

   private void setActiveLabelContent(ZyLabelContent var1) {
      this.m_activeLabelContent = var1;
   }
}
