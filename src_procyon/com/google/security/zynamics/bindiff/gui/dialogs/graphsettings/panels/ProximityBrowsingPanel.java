package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.security.zynamics.bindiff.gui.components.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.text.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;

public class ProximityBrowsingPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 5;
    private static final int SLIDER_MIN = 0;
    private static final int SLIDER_MAX = 10;
    private static final int SLIDER_LABEL_WIDTH = 25;
    private final JComboBox proximityBrowsing;
    private final SliderPanel proximityBrowsingParentDepth;
    private final SliderPanel proximityBrowsingChildDepth;
    private final JFormattedTextField autoProximityBrowsingActivionThreshold;
    private final JFormattedTextField visibilityWarningThreshold;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public ProximityBrowsingPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.proximityBrowsing = new JComboBox();
        this.proximityBrowsingParentDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
        this.proximityBrowsingChildDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
        this.autoProximityBrowsingActivionThreshold = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(5)));
        this.visibilityWarningThreshold = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(5)));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.init(s);
    }
    
    public ProximityBrowsingPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.proximityBrowsing = new JComboBox();
        this.proximityBrowsingParentDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
        this.proximityBrowsingChildDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
        this.autoProximityBrowsingActivionThreshold = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(5)));
        this.visibilityWarningThreshold = new JFormattedTextField(new DefaultFormatterFactory((JFormattedTextField.AbstractFormatter)new CDecFormatter(5)));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.init(s);
    }
    
    private int getAutoProximityBrowsingActivationThreshold(final BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getAutoProximityBrowsingActivationThreshold();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getAutoProximityBrowsingActivationThreshold();
            }
            default: {
                return this.settings.getProximitySettings().getAutoProximityBrowsingActivationThreshold();
            }
        }
    }
    
    private boolean getProximityBrowsing(final BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getProximityBrowsing();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getProximityBrowsing();
            }
            default: {
                return this.settings.getProximitySettings().getProximityBrowsing();
            }
        }
    }
    
    private int getProximityBrowsingChildDepth(final BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getProximityBrowsingChildDepth();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getProximityBrowsingChildDepth();
            }
            default: {
                return this.settings.getProximitySettings().getProximityBrowsingChildren();
            }
        }
    }
    
    private int getProximityBrowsingParentDepth(final BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getProximityBrowsingParentDepth();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getProximityBrowsingParentDepth();
            }
            default: {
                return this.settings.getProximitySettings().getProximityBrowsingParents();
            }
        }
    }
    
    private int getVisibilityWarningThreshold(final BinDiffConfigFile binDiffConfigFile) {
        switch (ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getVisibilityWarningThreshold();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getVisibilityWarningThreshold();
            }
            default: {
                return this.settings.getLayoutSettings().getVisibilityWarningThreshold();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.proximityBrowsing.addItem("On");
        this.proximityBrowsing.addItem("Off");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout((this.dialogType != ESettingsDialogType.NON_INITIAL) ? 5 : 3, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        if (this.dialogType != ESettingsDialogType.NON_INITIAL) {
            panel.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic proximity browsing", 275, this.proximityBrowsing, 25));
        }
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Proximity browsing parent depth", 275, this.proximityBrowsingParentDepth, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Proximity browsing child depth", 275, this.proximityBrowsingChildDepth, 25));
        if (this.dialogType != ESettingsDialogType.NON_INITIAL) {
            panel.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic proximity browsing activation threshold", 275, this.autoProximityBrowsingActivionThreshold, 25));
        }
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Visibility Warning threshold", 275, this.visibilityWarningThreshold, 25));
        this.add(panel, "North");
    }
    
    public void dispose() {
        this.proximityBrowsingParentDepth.dispose();
        this.proximityBrowsingChildDepth.dispose();
    }
    
    public int getAutoProximityBrowsingActivationThreshold() {
        return Integer.parseInt(this.autoProximityBrowsingActivionThreshold.getText());
    }
    
    public boolean getProximityBrowsing() {
        return this.proximityBrowsing.getSelectedIndex() == 0;
    }
    
    public int getProximityBrowsingChildDepth() {
        return this.proximityBrowsingChildDepth.getValue();
    }
    
    public int getProximityBrowsingParentDepth() {
        return this.proximityBrowsingParentDepth.getValue();
    }
    
    public int getVisibilityWarningThreshold() {
        return Integer.parseInt(this.visibilityWarningThreshold.getText());
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.proximityBrowsing.setSelectedIndex(this.getProximityBrowsing(instance) ? 0 : 1);
        this.proximityBrowsingParentDepth.setValue(this.getProximityBrowsingParentDepth(instance));
        this.proximityBrowsingChildDepth.setValue(this.getProximityBrowsingChildDepth(instance));
        this.autoProximityBrowsingActivionThreshold.setText(Integer.toString(this.getAutoProximityBrowsingActivationThreshold(instance)));
        this.visibilityWarningThreshold.setText(Integer.toString(this.getVisibilityWarningThreshold(instance)));
    }
}
