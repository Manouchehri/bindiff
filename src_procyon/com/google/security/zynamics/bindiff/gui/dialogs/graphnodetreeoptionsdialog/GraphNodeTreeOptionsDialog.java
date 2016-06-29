package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;
import java.awt.*;

public class GraphNodeTreeOptionsDialog extends BaseDialog
{
    private final GraphNodeTreeOptionsDialog$InternalButtonListener buttonListener;
    final JTabbedPane tab;
    private final SearchingTabPanel searchingPanel;
    private final FilteringTabPanel filteringPanel;
    private final SortingTabPanel sortingPanel;
    private final JButton okButton;
    private final JButton cancelButton;
    private final JButton setDefaultsButton;
    private boolean ok;
    
    public GraphNodeTreeOptionsDialog(final Window window, final String title, final boolean b, final boolean b2) {
        super(window, title);
        this.buttonListener = new GraphNodeTreeOptionsDialog$InternalButtonListener(this, null);
        this.tab = new JTabbedPane();
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.setDefaultsButton = new JButton("Set Defaults");
        this.ok = false;
        Preconditions.checkNotNull(window);
        Preconditions.checkNotNull(title);
        this.setTitle(title);
        this.setModal(true);
        this.setLayout(new BorderLayout());
        final ArrayList<Image> iconImages = new ArrayList<Image>();
        iconImages.add(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
        iconImages.add(ImageUtils.getImageIcon("data/appicons/bindiff-32x32-rgba.png").getImage());
        iconImages.add(ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage());
        this.setIconImages(iconImages);
        this.searchingPanel = new SearchingTabPanel(b2);
        this.filteringPanel = new FilteringTabPanel(b2, b);
        this.sortingPanel = new SortingTabPanel(b2, b);
        this.init();
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.setDefaultsButton.addActionListener(this.buttonListener);
    }
    
    private JPanel createButtonPanel() {
        final JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.setBorder(new EmptyBorder(10, 5, 5, 5));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(this.setDefaultsButton, "West");
        final JPanel panel3 = new JPanel(new BorderLayout());
        final JPanel panel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel4.add(this.okButton);
        panel4.add(this.cancelButton);
        panel3.add(panel4, "East");
        panel.add(panel2);
        panel.add(panel3);
        return panel;
    }
    
    @Override
    public void dispose() {
        this.okButton.removeActionListener(this.buttonListener);
        this.cancelButton.removeActionListener(this.buttonListener);
        this.setDefaultsButton.removeActionListener(this.buttonListener);
        super.dispose();
    }
    
    public boolean getCaseSensitive() {
        return this.searchingPanel.getCaseSensitive();
    }
    
    public IAddress getEndAddress() {
        return this.filteringPanel.getEndAddress();
    }
    
    public boolean getHighlightGraphNodes() {
        return this.searchingPanel.getHighlightGraphNodes();
    }
    
    public EMatchStateFilter getMatchStateFilter() {
        return this.filteringPanel.getMatchStateFilter();
    }
    
    public boolean getOkPressed() {
        return this.ok;
    }
    
    public boolean getPrimarySide() {
        return this.searchingPanel.getPrimarySide();
    }
    
    public boolean getRegEx() {
        return this.searchingPanel.getRegEx();
    }
    
    public boolean getSecondarySide() {
        return this.searchingPanel.getSecondarySide();
    }
    
    public ESelectionFilter getSelectionFilter() {
        return this.filteringPanel.getSelectionFilter();
    }
    
    public ESideFilter getSideFilter() {
        return this.filteringPanel.getSideFilter();
    }
    
    public ESortByCriterium getSortByCriterium(final int n) {
        return this.sortingPanel.getSortByCriterium(n);
    }
    
    public ESortOrder getSortOrder(final int n) {
        return this.sortingPanel.getSortOrder(n);
    }
    
    public IAddress getStartAddress() {
        return this.filteringPanel.getStartAddress();
    }
    
    public boolean getUseTemporaryResult() {
        return this.searchingPanel.getUseTemporaryResult();
    }
    
    public EVisibilityFilter getVisibilityFilter() {
        return this.filteringPanel.getVisibilityFilter();
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.tab.add(this.searchingPanel);
        this.tab.add(this.filteringPanel);
        this.tab.add(this.sortingPanel);
        this.tab.setTitleAt(0, "Search");
        this.tab.setTitleAt(1, "Filter");
        this.tab.setTitleAt(2, "Sort");
        final JPanel buttonPanel = this.createButtonPanel();
        panel.add(this.tab, "Center");
        panel.add(buttonPanel, "South");
        this.add(panel, "Center");
        this.pack();
        this.setPreferredSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height + 8));
        this.setMinimumSize(this.getPreferredSize());
    }
    
    public void setDefaults(final int n) {
        switch (n) {
            case 0: {
                this.searchingPanel.setDefaults();
                break;
            }
            case 1: {
                this.filteringPanel.setDefaults();
                break;
            }
            case 2: {
                this.sortingPanel.setDefaults();
                break;
            }
        }
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (visible) {
            this.searchingPanel.storeInitialSettings();
            this.filteringPanel.storeInitialSettings();
            this.sortingPanel.storeInitialSettings();
        }
        super.setVisible(visible);
    }
}
