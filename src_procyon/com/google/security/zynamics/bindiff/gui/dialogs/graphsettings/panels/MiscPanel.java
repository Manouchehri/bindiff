package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.security.zynamics.zylib.gui.sliders.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;

public class MiscPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 4;
    private final JComboBox viewSynchronization;
    private final JComboBox gradientBackground;
    private final JComboBox layoutAnimation;
    private final DoubleLabeledSlider animationSpeed;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public MiscPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.viewSynchronization = new JComboBox();
        this.gradientBackground = new JComboBox();
        this.layoutAnimation = new JComboBox();
        this.animationSpeed = new DoubleLabeledSlider("  Slow  ", "  Fast  ", 1, 10, false, new LineBorder(Color.GRAY));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.animationSpeed.setInverted(true);
        this.init(s);
    }
    
    public MiscPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.viewSynchronization = new JComboBox();
        this.gradientBackground = new JComboBox();
        this.layoutAnimation = new JComboBox();
        this.animationSpeed = new DoubleLabeledSlider("  Slow  ", "  Fast  ", 1, 10, false, new LineBorder(Color.GRAY));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.animationSpeed.setInverted(true);
        this.init(s);
    }
    
    private int getAnimationSpeed(final BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getAnimationSpeed();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getAnimationSpeed();
            }
            default: {
                return this.settings.getDisplaySettings().getAnimationSpeed();
            }
        }
    }
    
    private boolean getGradientBackground(final BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getGradientBackground();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getGradientBackground();
            }
            default: {
                return this.settings.getDisplaySettings().getGradientBackground();
            }
        }
    }
    
    private boolean getLayoutAnimation(final BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getLayoutAnimation();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getLayoutAnimation();
            }
            default: {
                return this.settings.getLayoutSettings().getAnimateLayout();
            }
        }
    }
    
    private boolean getViewSynchronization(final BinDiffConfigFile binDiffConfigFile) {
        switch (MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getViewSynchronization();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getViewSynchronization();
            }
            default: {
                return this.settings.getGraphSyncMode() == EGraphSynchronization.SYNC;
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.viewSynchronization.addItem("On");
        this.viewSynchronization.addItem("Off");
        this.gradientBackground.addItem("On");
        this.gradientBackground.addItem("Off");
        this.layoutAnimation.addItem("On");
        this.layoutAnimation.addItem("Off");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout((this.dialogType != ESettingsDialogType.NON_INITIAL) ? 4 : 3, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        if (this.dialogType != ESettingsDialogType.NON_INITIAL) {
            panel.add(GuiUtils.createHorizontalNamedComponentPanel("Views synchronization", 275, this.viewSynchronization, 25));
        }
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Gradient background", 275, this.gradientBackground, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Layout animation", 275, this.layoutAnimation, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Animation speed", 275, this.animationSpeed, 25));
        this.add(panel, "North");
    }
    
    public int getAnimationSpeed() {
        return this.animationSpeed.getValue();
    }
    
    public boolean getGradientBackground() {
        return this.gradientBackground.getSelectedIndex() == 0;
    }
    
    public boolean getLayoutAnimation() {
        return this.layoutAnimation.getSelectedIndex() == 0;
    }
    
    public boolean getViewSynchronization() {
        return this.viewSynchronization.getSelectedIndex() == 0;
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.viewSynchronization.setSelectedIndex(this.getViewSynchronization(instance) ? 0 : 1);
        this.gradientBackground.setSelectedIndex(this.getGradientBackground(instance) ? 0 : 1);
        this.layoutAnimation.setSelectedIndex(this.getLayoutAnimation(instance) ? 0 : 1);
        this.animationSpeed.setValue(this.getAnimationSpeed(instance));
    }
}
