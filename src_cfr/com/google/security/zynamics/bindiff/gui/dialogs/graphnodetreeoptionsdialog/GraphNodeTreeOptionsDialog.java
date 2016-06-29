/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.FilteringTabPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.SearchingTabPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.SortingTabPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GraphNodeTreeOptionsDialog
extends BaseDialog {
    private final GraphNodeTreeOptionsDialog$InternalButtonListener buttonListener;
    final JTabbedPane tab;
    private final SearchingTabPanel searchingPanel;
    private final FilteringTabPanel filteringPanel;
    private final SortingTabPanel sortingPanel;
    private final JButton okButton;
    private final JButton cancelButton;
    private final JButton setDefaultsButton;
    private boolean ok;

    public GraphNodeTreeOptionsDialog(Window window, String string, boolean bl2, boolean bl3) {
        super(window, string);
        this.buttonListener = new GraphNodeTreeOptionsDialog$InternalButtonListener(this, null);
        this.tab = new JTabbedPane();
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.setDefaultsButton = new JButton("Set Defaults");
        this.ok = false;
        Preconditions.checkNotNull(window);
        Preconditions.checkNotNull(string);
        this.setTitle(string);
        this.setModal(true);
        this.setLayout(new BorderLayout());
        ArrayList<Image> arrayList = new ArrayList<Image>();
        arrayList.add(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
        arrayList.add(ImageUtils.getImageIcon("data/appicons/bindiff-32x32-rgba.png").getImage());
        arrayList.add(ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage());
        this.setIconImages(arrayList);
        this.searchingPanel = new SearchingTabPanel(bl3);
        this.filteringPanel = new FilteringTabPanel(bl3, bl2);
        this.sortingPanel = new SortingTabPanel(bl3, bl2);
        this.init();
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.setDefaultsButton.addActionListener(this.buttonListener);
    }

    private JPanel createButtonPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        jPanel.setBorder(new EmptyBorder(10, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.add((Component)this.setDefaultsButton, "West");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel4.add(this.okButton);
        jPanel4.add(this.cancelButton);
        jPanel3.add((Component)jPanel4, "East");
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        return jPanel;
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

    public ESortByCriterium getSortByCriterium(int n2) {
        return this.sortingPanel.getSortByCriterium(n2);
    }

    public ESortOrder getSortOrder(int n2) {
        return this.sortingPanel.getSortOrder(n2);
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
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.tab.add(this.searchingPanel);
        this.tab.add(this.filteringPanel);
        this.tab.add(this.sortingPanel);
        this.tab.setTitleAt(0, "Search");
        this.tab.setTitleAt(1, "Filter");
        this.tab.setTitleAt(2, "Sort");
        JPanel jPanel2 = this.createButtonPanel();
        jPanel.add((Component)this.tab, "Center");
        jPanel.add((Component)jPanel2, "South");
        this.add((Component)jPanel, "Center");
        this.pack();
        this.setPreferredSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height + 8));
        this.setMinimumSize(this.getPreferredSize());
    }

    public void setDefaults(int n2) {
        switch (n2) {
            case 0: {
                this.searchingPanel.setDefaults();
                return;
            }
            case 1: {
                this.filteringPanel.setDefaults();
                return;
            }
            case 2: {
                this.sortingPanel.setDefaults();
            }
        }
    }

    @Override
    public void setVisible(boolean bl2) {
        if (bl2) {
            this.searchingPanel.storeInitialSettings();
            this.filteringPanel.storeInitialSettings();
            this.sortingPanel.storeInitialSettings();
        }
        super.setVisible(bl2);
    }

    static /* synthetic */ JButton access$100(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        return graphNodeTreeOptionsDialog.okButton;
    }

    static /* synthetic */ boolean access$202(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog, boolean bl2) {
        graphNodeTreeOptionsDialog.ok = bl2;
        return graphNodeTreeOptionsDialog.ok;
    }

    static /* synthetic */ JButton access$300(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        return graphNodeTreeOptionsDialog.cancelButton;
    }

    static /* synthetic */ SearchingTabPanel access$400(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        return graphNodeTreeOptionsDialog.searchingPanel;
    }

    static /* synthetic */ FilteringTabPanel access$500(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        return graphNodeTreeOptionsDialog.filteringPanel;
    }

    static /* synthetic */ SortingTabPanel access$600(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        return graphNodeTreeOptionsDialog.sortingPanel;
    }

    static /* synthetic */ JButton access$700(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        return graphNodeTreeOptionsDialog.setDefaultsButton;
    }
}

