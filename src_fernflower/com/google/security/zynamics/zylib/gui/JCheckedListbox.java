package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.JCheckedListbox$1;
import com.google.security.zynamics.zylib.gui.JCheckedListbox$CheckedListboxRenderer;
import com.google.security.zynamics.zylib.gui.JCheckedListbox$InternalListener;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.ListModel;

public class JCheckedListbox extends JList {
   private final boolean[] m_selected;
   private boolean m_selectCompleteLine = true;

   public JCheckedListbox(ListModel var1) {
      super(var1);
      this.m_selected = new boolean[var1.getSize()];
      this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
      this.addMouseListener(new JCheckedListbox$InternalListener(this, (JCheckedListbox$1)null));
   }

   public JCheckedListbox(Object[] var1) {
      super(var1);
      this.m_selected = new boolean[var1.length];
      this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
      this.addMouseListener(new JCheckedListbox$InternalListener(this, (JCheckedListbox$1)null));
   }

   public JCheckedListbox(Vector var1) {
      super(var1);
      this.m_selected = new boolean[var1.size()];
      this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
      this.addMouseListener(new JCheckedListbox$InternalListener(this, (JCheckedListbox$1)null));
   }

   public JCheckedListbox(Vector var1, boolean var2) {
      super(var1);
      this.m_selectCompleteLine = var2;
      this.m_selected = new boolean[var1.size()];
      this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
      this.addMouseListener(new JCheckedListbox$InternalListener(this, (JCheckedListbox$1)null));
   }

   public boolean isChecked(int var1) {
      return this.m_selected[var1];
   }

   public void setChecked(int var1, boolean var2) {
      this.m_selected[var1] = var2;
      this.updateUI();
      this.fireSelectionValueChanged(var1, var1, false);
   }

   public void updateUI() {
      super.updateUI();
   }

   // $FF: synthetic method
   static boolean access$100(JCheckedListbox var0) {
      return var0.m_selectCompleteLine;
   }

   // $FF: synthetic method
   static boolean[] access$200(JCheckedListbox var0) {
      return var0.m_selected;
   }

   // $FF: synthetic method
   static void access$300(JCheckedListbox var0, int var1, int var2, boolean var3) {
      var0.fireSelectionValueChanged(var1, var2, var3);
   }
}
