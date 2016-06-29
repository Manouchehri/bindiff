package com.google.security.zynamics.bindiff.gui.components.treesearchfield;

import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo$1;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo$InternalKeyListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBox;
import javax.swing.JTextField;

public class TreeSearchFieldCombo extends JMemoryBox {
   private static int SEARCH_STRING_HISTORY_MAX = 25;
   private final ListenerProvider listeners = new ListenerProvider();
   private final TreeSearchFieldCombo$InternalKeyListener listener = new TreeSearchFieldCombo$InternalKeyListener(this, (TreeSearchFieldCombo$1)null);
   private String lastSearchString = "";

   public TreeSearchFieldCombo() {
      super(SEARCH_STRING_HISTORY_MAX);
      this.getEditor().getEditorComponent().addKeyListener(this.listener);
   }

   private String getText() {
      return ((JTextField)this.getEditor().getEditorComponent()).getText();
   }

   public void addListener(ITreeSearchFieldListener var1) {
      this.listeners.addListener(var1);
   }

   public void clear() {
      this.setSelectedItem("");
      this.lastSearchString = "";
   }

   public void dispose() {
      this.getEditor().getEditorComponent().removeKeyListener(this.listener);
   }

   public void removeListener(ITreeSearchFieldListener var1) {
      this.listeners.removeListener(var1);
   }

   // $FF: synthetic method
   static String access$100(TreeSearchFieldCombo var0) {
      return var0.lastSearchString;
   }

   // $FF: synthetic method
   static String access$200(TreeSearchFieldCombo var0) {
      return var0.getText();
   }

   // $FF: synthetic method
   static ListenerProvider access$300(TreeSearchFieldCombo var0) {
      return var0.listeners;
   }

   // $FF: synthetic method
   static String access$102(TreeSearchFieldCombo var0, String var1) {
      return var0.lastSearchString = var1;
   }
}
