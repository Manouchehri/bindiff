package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import javax.swing.JApplet;
import javax.swing.JPanel;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedApplet$MenuBarChangeListener;

public class TabbedApplet extends JApplet {
   private AbstractTabbedUI tabbedUI;

   protected final AbstractTabbedUI getTabbedUI() {
      return this.tabbedUI;
   }

   public void init(AbstractTabbedUI var1) {
      this.tabbedUI = var1;
      this.tabbedUI.addPropertyChangeListener("jMenuBar", new TabbedApplet$MenuBarChangeListener(this));
      JPanel var2 = new JPanel();
      var2.setLayout(new BorderLayout());
      var2.add(var1, "Center");
      this.setContentPane(var2);
      this.setJMenuBar(var1.getJMenuBar());
   }
}
