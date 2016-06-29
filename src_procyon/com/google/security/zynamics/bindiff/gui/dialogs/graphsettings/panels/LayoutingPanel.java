package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;

public final class LayoutingPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 2;
    private final JComboBox initalLayout;
    private final JComboBox autoLayouting;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public LayoutingPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.initalLayout = new JComboBox();
        this.autoLayouting = new JComboBox();
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.init(s);
    }
    
    public LayoutingPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.initalLayout = new JComboBox();
        this.autoLayouting = new JComboBox();
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.init(s);
    }
    
    private boolean getAutoLayouting(final BinDiffConfigFile binDiffConfigFile) {
        switch (LayoutingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getAutoLayouting();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getAutoLayouting();
            }
            default: {
                return this.settings.getLayoutSettings().getAutomaticLayouting();
            }
        }
    }
    
    private EGraphLayout getDefaultGraphLayout(final BinDiffConfigFile binDiffConfigFile) {
        switch (LayoutingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return EGraphLayout.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getDefaultGraphLayout());
            }
            case 2: {
                return EGraphLayout.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getDefaultGraphLayout());
            }
            default: {
                return this.settings.getLayoutSettings().getDefaultGraphLayout();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.initalLayout.addItem("Hierarchical");
        this.initalLayout.addItem("Orthogonal");
        this.initalLayout.addItem("Circular");
        this.autoLayouting.addItem("On");
        this.autoLayouting.addItem("Off");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Default layout", 275, this.initalLayout, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic layouting", 275, this.autoLayouting, 25));
        this.add(panel, "North");
    }
    
    public boolean getAutoLayouting() {
        return this.autoLayouting.getSelectedIndex() == 0;
    }
    
    public EGraphLayout getDefaultLayout() {
        return EGraphLayout.getEnum(this.initalLayout.getSelectedIndex());
    }
    
    public void getDefaultLayout(final EGraphLayout eGraphLayout) {
        this.initalLayout.setSelectedIndex(EGraphLayout.getOrdinal(eGraphLayout));
    }
    
    public void setAutoLayouting(final boolean b) {
        this.autoLayouting.setSelectedIndex(b ? 0 : 1);
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.initalLayout.setSelectedIndex(EGraphLayout.getOrdinal(this.getDefaultGraphLayout(instance)));
        this.autoLayouting.setSelectedIndex(this.getAutoLayouting(instance) ? 0 : 1);
    }
}
