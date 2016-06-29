package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.ui.ArrowPanel;

public class Spinner extends JPanel implements MouseListener {
   private int value;
   private JTextField textField;
   private JPanel buttonPanel;
   private ArrowPanel upButton;
   private ArrowPanel downButton;

   public Spinner(int var1) {
      super(new BorderLayout());
      this.value = var1;
      this.textField = new JTextField(Integer.toString(this.value));
      this.textField.setHorizontalAlignment(4);
      this.add(this.textField);
      this.buttonPanel = new JPanel(new GridLayout(2, 1, 0, 1));
      this.upButton = new ArrowPanel(0);
      this.upButton.addMouseListener(this);
      this.downButton = new ArrowPanel(1);
      this.downButton.addMouseListener(this);
      this.buttonPanel.add(this.upButton);
      this.buttonPanel.add(this.downButton);
      this.add(this.buttonPanel, "East");
   }

   public int getValue() {
      return this.value;
   }

   public void mouseClicked(MouseEvent var1) {
      if(var1.getSource() == this.upButton) {
         ++this.value;
         this.textField.setText(Integer.toString(this.value));
         this.firePropertyChange("value", this.value - 1, this.value);
      } else if(var1.getSource() == this.downButton) {
         --this.value;
         this.textField.setText(Integer.toString(this.value));
         this.firePropertyChange("value", this.value + 1, this.value);
      }

   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseReleased(MouseEvent var1) {
   }
}
