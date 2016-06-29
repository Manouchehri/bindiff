package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import y.h.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.ColorPanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;

public class PrintGraphOptionsDialog extends BaseDialog
{
    private static final int LABEL_WIDTH = 125;
    private static final int ROW_HEIGHT = 25;
    private final bW printer;
    private boolean okPressed;
    private final ActionListener buttonListener;
    private final JButton okButton;
    private final JButton cancelButton;
    private final JFormattedTextField posterRows;
    private final JFormattedTextField posterCols;
    private final JComboBox posterCoords;
    private final JComboBox ClipArea;
    private final JTextField titel;
    private final ColorPanel titleBarColor;
    private final ColorPanel titleTextColor;
    private final JFormattedTextField fontSize;
    
    public PrintGraphOptionsDialog(final Window window, final bW printer) {
        super(window, "Print Options");
        this.okPressed = false;
        this.buttonListener = new PrintGraphOptionsDialog$InteneralButtonListener(this, null);
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.posterRows = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CDecFormatter(2));
        this.posterCols = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CDecFormatter(2));
        this.posterCoords = new JComboBox();
        this.ClipArea = new JComboBox();
        this.titel = new JTextField();
        this.titleBarColor = new ColorPanel(Colors.GRAY192, true, true);
        this.titleTextColor = new ColorPanel(Color.BLACK, true, true);
        this.fontSize = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CDecFormatter(2));
        this.printer = printer;
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }
    
    private JPanel createButtonsPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        final JPanel panel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel2.add(this.okButton);
        panel2.add(this.cancelButton);
        panel.add(panel2, "East");
        return panel;
    }
    
    private JPanel createGeneralTabPanel() {
        this.posterRows.setText(String.valueOf(this.printer.b()));
        this.posterCols.setText(String.valueOf(this.printer.c()));
        this.posterCoords.addItem("Show");
        this.posterCoords.addItem("Hide");
        this.posterCoords.setSelectedIndex(1);
        this.ClipArea.addItem("Graph");
        this.ClipArea.addItem("View");
        final JPanel panel = new JPanel(new GridLayout(4, 1, 3, 3));
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5)));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Poster Rows", 125, this.posterRows, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Poster Columns", 125, this.posterCols, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Add Poster Coords", 125, this.posterCoords, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Clip Area", 125, this.ClipArea, 25));
        return panel;
    }
    
    private JPanel createTitleTabPanel() {
        final JPanel panel = new JPanel(new GridLayout(4, 1, 3, 3));
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5)));
        this.fontSize.setText("13");
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Text", 125, this.titel, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Text Color", 125, this.titleTextColor, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Titlebar Color", 125, this.titleBarColor, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Font Size", 125, this.fontSize, 25));
        return panel;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("General", this.createGeneralTabPanel());
        tabbedPane.addTab("Title", this.createTitleTabPanel());
        panel.add(tabbedPane, "North");
        panel.add(this.createButtonsPanel(), "South");
        this.add(panel, "Center");
    }
    
    @Override
    public void dispose() {
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        super.dispose();
    }
    
    public boolean isOkPressed() {
        return this.okPressed;
    }
}
