package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

public class ViewSearchOptionsDialog extends BaseDialog
{
    private static final ImageIcon APP_ICON;
    private final ViewSearchOptionsDialog$InternalOkButtonListener okButtonListener;
    private final ViewSearchOptionsDialog$InternalCancelButtonListener cancelButtonListener;
    private final JButton okButton;
    private final JButton cancelButton;
    private final JCheckBox regExBox;
    private final JCheckBox caseSensitiveBox;
    private final JCheckBox primarySideBox;
    private final JCheckBox secondarySideBox;
    private final JCheckBox tempViewTables;
    private boolean okButtonPressed;
    
    public ViewSearchOptionsDialog(final Window window, final String s, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
        super(window, s);
        this.okButtonListener = new ViewSearchOptionsDialog$InternalOkButtonListener(this, null);
        this.cancelButtonListener = new ViewSearchOptionsDialog$InternalCancelButtonListener(this, null);
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.okButtonPressed = false;
        this.setIconImage(ViewSearchOptionsDialog.APP_ICON.getImage());
        this.okButton.addActionListener(this.okButtonListener);
        this.cancelButton.addActionListener(this.cancelButtonListener);
        this.regExBox = new JCheckBox("Regular Expression", b);
        this.caseSensitiveBox = new JCheckBox("Case sensitive", b2);
        this.primarySideBox = new JCheckBox("Primary Side", b3);
        this.secondarySideBox = new JCheckBox("Secondary Side", b4);
        this.tempViewTables = new JCheckBox("Only search in last temporary search result table", b5);
        this.init();
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(2, 1));
        panel2.setBorder(new TitledBorder(""));
        panel2.add(this.regExBox);
        panel2.add(this.caseSensitiveBox);
        final JPanel panel3 = new JPanel(new GridLayout(2, 1));
        panel3.setBorder(new TitledBorder(""));
        panel3.add(this.primarySideBox);
        panel3.add(this.secondarySideBox);
        final JPanel panel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel4.add(panel2);
        panel4.add(panel3);
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.add(panel4, "Center");
        final JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBorder(new EmptyBorder(5, 0, 0, 0));
        panel6.add(this.tempViewTables, "Center");
        panel5.add(panel6, "South");
        final JPanel panel7 = new JPanel(new BorderLayout());
        panel7.setBorder(new EmptyBorder(10, 0, 0, 0));
        final JPanel panel8 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel8.add(this.okButton);
        panel8.add(this.cancelButton);
        panel7.add(panel8, "East");
        panel.add(panel5, "Center");
        panel.add(panel7, "South");
        this.add(panel, "Center");
        this.pack();
        this.setMinimumSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height));
        this.setResizable(false);
    }
    
    public void disableSideCheckboxes() {
        this.primarySideBox.setEnabled(false);
        this.secondarySideBox.setEnabled(false);
    }
    
    @Override
    public void dispose() {
        this.okButton.removeActionListener(this.okButtonListener);
        this.cancelButton.removeActionListener(this.cancelButtonListener);
        super.dispose();
    }
    
    public boolean getCaseSensitiveSelected() {
        return this.caseSensitiveBox.isSelected();
    }
    
    public boolean getOkButtonPressed() {
        return this.okButtonPressed;
    }
    
    public boolean getPrimarySideSearch() {
        return this.primarySideBox.isSelected();
    }
    
    public boolean getRegExSelected() {
        return this.regExBox.isSelected();
    }
    
    public boolean getSecondarySideSearch() {
        return this.secondarySideBox.isSelected();
    }
    
    public boolean getTemporaryTableUse() {
        return this.tempViewTables.isSelected();
    }
    
    static {
        APP_ICON = ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png");
    }
}
