package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.security.zynamics.zylib.gui.sliders.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;

public class ControlsPanel extends JPanel
{
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 4;
    private final JComboBox showScrollbars;
    private final JComboBox mouseWheelBehaviour;
    private final DoubleLabeledSlider zoomSensitivity;
    private final DoubleLabeledSlider scrollSensitivity;
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;
    
    public ControlsPanel(final String s, final ESettingsDialogType dialogType) {
        super(new BorderLayout());
        this.showScrollbars = new JComboBox();
        this.mouseWheelBehaviour = new JComboBox();
        this.zoomSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
        this.scrollSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = null;
        this.zoomSensitivity.setInverted(true);
        this.scrollSensitivity.setInverted(true);
        this.init(s);
    }
    
    public ControlsPanel(final String s, final ESettingsDialogType dialogType, final GraphSettings settings) {
        super(new BorderLayout());
        this.showScrollbars = new JComboBox();
        this.mouseWheelBehaviour = new JComboBox();
        this.zoomSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
        this.scrollSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
        Preconditions.checkNotNull(s);
        if (dialogType == null || dialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = dialogType;
        this.settings = settings;
        this.zoomSensitivity.setInverted(true);
        this.scrollSensitivity.setInverted(true);
        this.init(s);
    }
    
    private EMouseAction getMouseWheelBehaviour(final BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return EMouseAction.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getMouseWheelAction());
            }
            case 2: {
                return EMouseAction.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getMouseWheelAction());
            }
            default: {
                return (this.settings.getMouseSettings().getMouseWheelAction() == MouseWheelAction.ZOOM) ? EMouseAction.ZOOM : EMouseAction.SCROLL;
            }
        }
    }
    
    private int getScrollSensitivity(final BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getScrollSensitivity();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getScrollSensitivity();
            }
            default: {
                return this.settings.getMouseSettings().getScrollSensitivity();
            }
        }
    }
    
    private boolean getShowScrollbars(final BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getShowScrollbars();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getShowScrollbars();
            }
            default: {
                return this.settings.getShowScrollbars();
            }
        }
    }
    
    private int getZoomSensitivity(final BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getZoomSensitivity();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getZoomSensitivity();
            }
            default: {
                return this.settings.getMouseSettings().getZoomSensitivity();
            }
        }
    }
    
    private void init(final String s) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.showScrollbars.addItem("Always");
        this.showScrollbars.addItem("Never");
        this.mouseWheelBehaviour.addItem("Zoom");
        this.mouseWheelBehaviour.addItem("Scroll");
        this.setCurrentValues();
        final JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(new TitledBorder(s));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Show scrollbars", 275, this.showScrollbars, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Mousewheel action", 275, this.mouseWheelBehaviour, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Zoom sensitivity", 275, this.zoomSensitivity, 25));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Scroll sensitivity", 275, this.scrollSensitivity, 25));
        this.add(panel, "North");
    }
    
    public EMouseAction getMouseWheelBehaviour() {
        return EMouseAction.getEnum(this.mouseWheelBehaviour.getSelectedIndex());
    }
    
    public int getScrollSensitivity() {
        return this.scrollSensitivity.getValue();
    }
    
    public boolean getShowScrollbars() {
        return this.showScrollbars.getSelectedIndex() == 0;
    }
    
    public int getZoomSensitivity() {
        return this.zoomSensitivity.getValue();
    }
    
    public void setCurrentValues() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        this.showScrollbars.setSelectedIndex(this.getShowScrollbars(instance) ? 0 : 1);
        this.mouseWheelBehaviour.setSelectedIndex(EMouseAction.getOrdinal(this.getMouseWheelBehaviour(instance)));
        this.zoomSensitivity.setValue(this.getZoomSensitivity(instance));
        this.scrollSensitivity.setValue(this.getScrollSensitivity(instance));
    }
}
