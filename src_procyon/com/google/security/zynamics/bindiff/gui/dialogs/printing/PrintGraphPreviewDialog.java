package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import java.awt.event.*;
import java.awt.print.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class PrintGraphPreviewDialog extends BaseDialog
{
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
    
    public PrintGraphPreviewDialog(final JFrame frame, final ch view) {
        super((Window)frame, "Print View");
        this.buttonListener = new PrintGraphPreviewDialog$InternalButtonListener(this, null);
        this.view = view;
        this.printJob = PrinterJob.getPrinterJob();
        this.printer = new bW(view);
        (this.cancelButton = new JButton()).addActionListener(this.buttonListener);
        (this.optionsButton = new JButton()).addActionListener(this.buttonListener);
        this.extractComponents();
        this.printButton.addActionListener(this.buttonListener);
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(frame, this, true);
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
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new GridLayout(1, 4, 5, 5));
        panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel3.add(this.zoomComboBox);
        panel3.add(this.zoomOutButton);
        panel3.add(this.zoomInButton);
        panel3.add(this.optionsButton);
        panel2.add(panel3, "North");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new EmptyBorder(0, 5, 0, 4));
        panel4.add(this.previewPane, "Center");
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBorder(new EmptyBorder(10, 10, 10, 10));
        final JPanel panel6 = new JPanel(new BorderLayout());
        panel6.add(this.pageSetupButton, "West");
        final JPanel panel7 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel7.add(this.printButton);
        panel7.add(this.cancelButton);
        panel5.add(panel6, "West");
        panel5.add(panel7, "East");
        panel.add(panel2, "North");
        panel.add(panel4, "Center");
        panel.add(panel5, "South");
        this.add(panel, "Center");
    }
    
    @Override
    public void dispose() {
        this.cancelButton.removeActionListener(this.buttonListener);
        this.optionsButton.removeActionListener(this.buttonListener);
        this.printButton.removeActionListener(this.buttonListener);
        super.dispose();
    }
}
