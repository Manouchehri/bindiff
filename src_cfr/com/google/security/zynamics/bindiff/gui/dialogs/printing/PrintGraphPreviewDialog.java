/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import y.h.bW;
import y.h.ch;

public class PrintGraphPreviewDialog
extends BaseDialog {
    private final ActionListener buttonListener;
    private final PrinterJob printJob;
    private final bW printer;
    private final ch view;
    private final JButton cancelButton;
    private PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel hiddenPrinterPreviewPanel;
    private JButton pageSetupButton;
    private JButton printButton;
    private JButton zoomInButton;
    private JButton zoomOutButton;
    private final JButton optionsButton;
    private JComboBox zoomComboBox;
    private JScrollPane previewPane;

    public PrintGraphPreviewDialog(JFrame jFrame, ch ch2) {
        super(jFrame, "Print View");
        this.buttonListener = new PrintGraphPreviewDialog$InternalButtonListener(this, null);
        this.view = ch2;
        this.printJob = PrinterJob.getPrinterJob();
        this.printer = new bW(ch2);
        this.cancelButton = new JButton();
        this.cancelButton.addActionListener(this.buttonListener);
        this.optionsButton = new JButton();
        this.optionsButton.addActionListener(this.buttonListener);
        this.extractComponents();
        this.printButton.addActionListener(this.buttonListener);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(jFrame, this, true);
        this.setVisible(true);
    }

    private void extractComponents() {
        this.hiddenPrinterPreviewPanel = new PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel(this, this.printJob, this.printer, this.printJob.defaultPage());
    }

    private void init() {
        this.pageSetupButton.setText("Page Setup");
        this.printButton.setText("Print");
        this.zoomOutButton.setText("Zoom In");
        this.zoomInButton.setText("Zoom Out");
        this.optionsButton.setText("Options");
        this.cancelButton.setText("Cancel");
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel(new GridLayout(1, 4, 5, 5));
        jPanel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel3.add(this.zoomComboBox);
        jPanel3.add(this.zoomOutButton);
        jPanel3.add(this.zoomInButton);
        jPanel3.add(this.optionsButton);
        jPanel2.add((Component)jPanel3, "North");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(0, 5, 0, 4));
        jPanel4.add((Component)this.previewPane, "Center");
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.add((Component)this.pageSetupButton, "West");
        JPanel jPanel7 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel7.add(this.printButton);
        jPanel7.add(this.cancelButton);
        jPanel5.add((Component)jPanel6, "West");
        jPanel5.add((Component)jPanel7, "East");
        jPanel.add((Component)jPanel2, "North");
        jPanel.add((Component)jPanel4, "Center");
        jPanel.add((Component)jPanel5, "South");
        this.add((Component)jPanel, "Center");
    }

    @Override
    public void dispose() {
        this.cancelButton.removeActionListener(this.buttonListener);
        this.optionsButton.removeActionListener(this.buttonListener);
        this.printButton.removeActionListener(this.buttonListener);
        super.dispose();
    }

    static /* synthetic */ JComboBox access$102(PrintGraphPreviewDialog printGraphPreviewDialog, JComboBox jComboBox) {
        printGraphPreviewDialog.zoomComboBox = jComboBox;
        return printGraphPreviewDialog.zoomComboBox;
    }

    static /* synthetic */ JScrollPane access$202(PrintGraphPreviewDialog printGraphPreviewDialog, JScrollPane jScrollPane) {
        printGraphPreviewDialog.previewPane = jScrollPane;
        return printGraphPreviewDialog.previewPane;
    }

    static /* synthetic */ JButton access$302(PrintGraphPreviewDialog printGraphPreviewDialog, JButton jButton) {
        printGraphPreviewDialog.pageSetupButton = jButton;
        return printGraphPreviewDialog.pageSetupButton;
    }

    static /* synthetic */ JButton access$402(PrintGraphPreviewDialog printGraphPreviewDialog, JButton jButton) {
        printGraphPreviewDialog.printButton = jButton;
        return printGraphPreviewDialog.printButton;
    }

    static /* synthetic */ JButton access$502(PrintGraphPreviewDialog printGraphPreviewDialog, JButton jButton) {
        printGraphPreviewDialog.zoomOutButton = jButton;
        return printGraphPreviewDialog.zoomOutButton;
    }

    static /* synthetic */ JButton access$602(PrintGraphPreviewDialog printGraphPreviewDialog, JButton jButton) {
        printGraphPreviewDialog.zoomInButton = jButton;
        return printGraphPreviewDialog.zoomInButton;
    }

    static /* synthetic */ JButton access$700(PrintGraphPreviewDialog printGraphPreviewDialog) {
        return printGraphPreviewDialog.cancelButton;
    }

    static /* synthetic */ JButton access$400(PrintGraphPreviewDialog printGraphPreviewDialog) {
        return printGraphPreviewDialog.printButton;
    }

    static /* synthetic */ JButton access$800(PrintGraphPreviewDialog printGraphPreviewDialog) {
        return printGraphPreviewDialog.optionsButton;
    }

    static /* synthetic */ bW access$900(PrintGraphPreviewDialog printGraphPreviewDialog) {
        return printGraphPreviewDialog.printer;
    }

    static /* synthetic */ PrintGraphPreviewDialog$CGraph2DPrintPreviewPanel access$1000(PrintGraphPreviewDialog printGraphPreviewDialog) {
        return printGraphPreviewDialog.hiddenPrinterPreviewPanel;
    }
}

