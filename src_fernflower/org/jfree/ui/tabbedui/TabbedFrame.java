package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedFrame$1;
import org.jfree.ui.tabbedui.TabbedFrame$MenuBarChangeListener;

public class TabbedFrame extends JFrame {
   private AbstractTabbedUI tabbedUI;

   public TabbedFrame() {
   }

   public TabbedFrame(String var1) {
      super(var1);
   }

   protected final AbstractTabbedUI getTabbedUI() {
      return this.tabbedUI;
   }

   public void init(AbstractTabbedUI var1) {
      this.tabbedUI = var1;
      this.tabbedUI.addPropertyChangeListener("jMenuBar", new TabbedFrame$MenuBarChangeListener(this));
      this.addWindowListener(new TabbedFrame$1(this));
      JPanel var2 = new JPanel();
      var2.setLayout(new BorderLayout());
      var2.add(var1, "Center");
      this.setContentPane(var2);
      this.setJMenuBar(var1.getJMenuBar());
   }
}
