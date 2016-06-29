package com.google.security.zynamics.bindiff.gui.components.treesearchfield;

import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

class TreeSearchFieldCombo$InternalKeyListener implements KeyListener {
   // $FF: synthetic field
   final TreeSearchFieldCombo this$0;

   private TreeSearchFieldCombo$InternalKeyListener(TreeSearchFieldCombo var1) {
      this.this$0 = var1;
   }

   public void keyPressed(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
   }

   public void keyTyped(KeyEvent var1) {
      if(var1.getKeyChar() == 10 && !TreeSearchFieldCombo.access$200(this.this$0).equals(TreeSearchFieldCombo.access$100(this.this$0))) {
         if(!TreeSearchFieldCombo.access$200(this.this$0).equals("")) {
            this.this$0.add(TreeSearchFieldCombo.access$200(this.this$0));
         }

         Iterator var2 = TreeSearchFieldCombo.access$300(this.this$0).iterator();

         while(var2.hasNext()) {
            ITreeSearchFieldListener var3 = (ITreeSearchFieldListener)var2.next();
            var3.searchChanged(TreeSearchFieldCombo.access$200(this.this$0));
         }

         TreeSearchFieldCombo.access$102(this.this$0, TreeSearchFieldCombo.access$200(this.this$0));
      }

   }

   // $FF: synthetic method
   TreeSearchFieldCombo$InternalKeyListener(TreeSearchFieldCombo var1, TreeSearchFieldCombo$1 var2) {
      this(var1);
   }
}
