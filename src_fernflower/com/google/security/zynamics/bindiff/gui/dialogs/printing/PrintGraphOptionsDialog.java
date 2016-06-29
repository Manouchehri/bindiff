package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog$InteneralButtonListener;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import y.h.bW;

public class PrintGraphOptionsDialog extends BaseDialog {
   private static final int LABEL_WIDTH = 125;
   private static final int ROW_HEIGHT = 25;
   private final bW printer;
   private boolean okPressed = false;
   private final ActionListener buttonListener = new PrintGraphOptionsDialog$InteneralButtonListener(this, (PrintGraphOptionsDialog$1)null);
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private final JFormattedTextField posterRows = new JFormattedTextField(new CDecFormatter(2));
   private final JFormattedTextField posterCols = new JFormattedTextField(new CDecFormatter(2));
   private final JComboBox posterCoords = new JComboBox();
   private final JComboBox ClipArea = new JComboBox();
   private final JTextField titel = new JTextField();
   private final ColorPanel titleBarColor;
   private final ColorPanel titleTextColor;
   private final JFormattedTextField fontSize;

   public PrintGraphOptionsDialog(Window var1, bW var2) {
      super(var1, "Print Options");
      this.titleBarColor = new ColorPanel(Colors.GRAY192, true, true);
      this.titleTextColor = new ColorPanel(Color.BLACK, true, true);
      this.fontSize = new JFormattedTextField(new CDecFormatter(2));
      this.printer = var2;
      this.okButton.addActionListener(this.buttonListener);
      this.cancelButton.addActionListener(this.buttonListener);
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var1, this, true);
      this.setVisible(true);
   }

   private JPanel createButtonsPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(10, 10, 10, 10));
      JPanel var2 = new JPanel(new GridLayout(1, 2, 5, 5));
      var2.add(this.okButton);
      var2.add(this.cancelButton);
      var1.add(var2, "East");
      return var1;
   }

   private JPanel createGeneralTabPanel() {
      this.posterRows.setText(String.valueOf(this.printer.b()));
      this.posterCols.setText(String.valueOf(this.printer.c()));
      this.posterCoords.addItem("Show");
      this.posterCoords.addItem("Hide");
      this.posterCoords.setSelectedIndex(1);
      this.ClipArea.addItem("Graph");
      this.ClipArea.addItem("View");
      JPanel var1 = new JPanel(new GridLayout(4, 1, 3, 3));
      var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5)));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Poster Rows", 125, this.posterRows, 25));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Poster Columns", 125, this.posterCols, 25));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Add Poster Coords", 125, this.posterCoords, 25));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Clip Area", 125, this.ClipArea, 25));
      return var1;
   }

   private JPanel createTitleTabPanel() {
      JPanel var1 = new JPanel(new GridLayout(4, 1, 3, 3));
      var1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5)));
      this.fontSize.setText("13");
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Text", 125, this.titel, 25));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Text Color", 125, this.titleTextColor, 25));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Titlebar Color", 125, this.titleBarColor, 25));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Font Size", 125, this.fontSize, 25));
      return var1;
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(1, 1, 1, 1));
      JTabbedPane var2 = new JTabbedPane();
      var2.addTab("General", this.createGeneralTabPanel());
      var2.addTab("Title", this.createTitleTabPanel());
      var1.add(var2, "North");
      var1.add(this.createButtonsPanel(), "South");
      this.add(var1, "Center");
   }

   public void dispose() {
      this.okButton.addActionListener(this.buttonListener);
      this.cancelButton.addActionListener(this.buttonListener);
      super.dispose();
   }

   public boolean isOkPressed() {
      return this.okPressed;
   }

   // $FF: synthetic method
   static JButton access$100(PrintGraphOptionsDialog var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static JFormattedTextField access$200(PrintGraphOptionsDialog var0) {
      return var0.posterRows;
   }

   // $FF: synthetic method
   static JFormattedTextField access$300(PrintGraphOptionsDialog var0) {
      return var0.posterCols;
   }

   // $FF: synthetic method
   static JFormattedTextField access$400(PrintGraphOptionsDialog var0) {
      return var0.fontSize;
   }

   // $FF: synthetic method
   static boolean access$502(PrintGraphOptionsDialog var0, boolean var1) {
      return var0.okPressed = var1;
   }

   // $FF: synthetic method
   static bW access$600(PrintGraphOptionsDialog var0) {
      return var0.printer;
   }

   // $FF: synthetic method
   static JComboBox access$700(PrintGraphOptionsDialog var0) {
      return var0.ClipArea;
   }

   // $FF: synthetic method
   static JComboBox access$800(PrintGraphOptionsDialog var0) {
      return var0.posterCoords;
   }

   // $FF: synthetic method
   static JTextField access$900(PrintGraphOptionsDialog var0) {
      return var0.titel;
   }

   // $FF: synthetic method
   static ColorPanel access$1000(PrintGraphOptionsDialog var0) {
      return var0.titleTextColor;
   }

   // $FF: synthetic method
   static ColorPanel access$1100(PrintGraphOptionsDialog var0) {
      return var0.titleBarColor;
   }
}
