/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog$InteneralButtonListener;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import y.h.bW;

public class PrintGraphOptionsDialog
extends BaseDialog {
    private static final int LABEL_WIDTH = 125;
    private static final int ROW_HEIGHT = 25;
    private final bW printer;
    private boolean okPressed = false;
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

    public PrintGraphOptionsDialog(Window window, bW bW2) {
        super(window, "Print Options");
        this.buttonListener = new PrintGraphOptionsDialog$InteneralButtonListener(this, null);
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.posterRows = new JFormattedTextField(new CDecFormatter(2));
        this.posterCols = new JFormattedTextField(new CDecFormatter(2));
        this.posterCoords = new JComboBox();
        this.ClipArea = new JComboBox();
        this.titel = new JTextField();
        this.titleBarColor = new ColorPanel(Colors.GRAY192, true, true);
        this.titleTextColor = new ColorPanel(Color.BLACK, true, true);
        this.fontSize = new JFormattedTextField(new CDecFormatter(2));
        this.printer = bW2;
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.setVisible(true);
    }

    private JPanel createButtonsPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel2.add(this.okButton);
        jPanel2.add(this.cancelButton);
        jPanel.add((Component)jPanel2, "East");
        return jPanel;
    }

    private JPanel createGeneralTabPanel() {
        this.posterRows.setText(String.valueOf(this.printer.b()));
        this.posterCols.setText(String.valueOf(this.printer.c()));
        this.posterCoords.addItem("Show");
        this.posterCoords.addItem("Hide");
        this.posterCoords.setSelectedIndex(1);
        this.ClipArea.addItem("Graph");
        this.ClipArea.addItem("View");
        JPanel jPanel = new JPanel(new GridLayout(4, 1, 3, 3));
        jPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5)));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Poster Rows", 125, this.posterRows, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Poster Columns", 125, this.posterCols, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Add Poster Coords", 125, this.posterCoords, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Clip Area", 125, this.ClipArea, 25));
        return jPanel;
    }

    private JPanel createTitleTabPanel() {
        JPanel jPanel = new JPanel(new GridLayout(4, 1, 3, 3));
        jPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5)));
        this.fontSize.setText("13");
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Text", 125, this.titel, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Text Color", 125, this.titleTextColor, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Titlebar Color", 125, this.titleBarColor, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Font Size", 125, this.fontSize, 25));
        return jPanel;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("General", this.createGeneralTabPanel());
        jTabbedPane.addTab("Title", this.createTitleTabPanel());
        jPanel.add((Component)jTabbedPane, "North");
        jPanel.add((Component)this.createButtonsPanel(), "South");
        this.add((Component)jPanel, "Center");
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

    static /* synthetic */ JButton access$100(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.okButton;
    }

    static /* synthetic */ JFormattedTextField access$200(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.posterRows;
    }

    static /* synthetic */ JFormattedTextField access$300(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.posterCols;
    }

    static /* synthetic */ JFormattedTextField access$400(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.fontSize;
    }

    static /* synthetic */ boolean access$502(PrintGraphOptionsDialog printGraphOptionsDialog, boolean bl2) {
        printGraphOptionsDialog.okPressed = bl2;
        return printGraphOptionsDialog.okPressed;
    }

    static /* synthetic */ bW access$600(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.printer;
    }

    static /* synthetic */ JComboBox access$700(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.ClipArea;
    }

    static /* synthetic */ JComboBox access$800(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.posterCoords;
    }

    static /* synthetic */ JTextField access$900(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.titel;
    }

    static /* synthetic */ ColorPanel access$1000(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.titleTextColor;
    }

    static /* synthetic */ ColorPanel access$1100(PrintGraphOptionsDialog printGraphOptionsDialog) {
        return printGraphOptionsDialog.titleBarColor;
    }
}

