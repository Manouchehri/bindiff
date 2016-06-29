/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EMouseAction;
import com.google.security.zynamics.bindiff.graph.settings.GraphMouseSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ControlsPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.sliders.DoubleLabeledSlider;
import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ControlsPanel
extends JPanel {
    private static final int LABEL_WIDTH = 275;
    private static final int ROW_HEIGHT = 25;
    private static final int NUMBER_OF_ROWS = 4;
    private final JComboBox showScrollbars = new JComboBox();
    private final JComboBox mouseWheelBehaviour = new JComboBox();
    private final DoubleLabeledSlider zoomSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
    private final DoubleLabeledSlider scrollSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
    private final ESettingsDialogType dialogType;
    private final GraphSettings settings;

    public ControlsPanel(String string, ESettingsDialogType eSettingsDialogType) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        if (eSettingsDialogType == null) throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        if (eSettingsDialogType == ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
        }
        this.dialogType = eSettingsDialogType;
        this.settings = null;
        this.zoomSensitivity.setInverted(true);
        this.scrollSensitivity.setInverted(true);
        this.init(string);
    }

    public ControlsPanel(String string, ESettingsDialogType eSettingsDialogType, GraphSettings graphSettings) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        if (eSettingsDialogType == null) throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        if (eSettingsDialogType != ESettingsDialogType.NON_INITIAL) {
            throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
        }
        this.dialogType = eSettingsDialogType;
        this.settings = graphSettings;
        this.zoomSensitivity.setInverted(true);
        this.scrollSensitivity.setInverted(true);
        this.init(string);
    }

    private EMouseAction getMouseWheelBehaviour(BinDiffConfigFile binDiffConfigFile) {
        EMouseAction eMouseAction;
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return EMouseAction.getEnum(binDiffConfigFile.getInitialCallgraphSettings().getMouseWheelAction());
            }
            case 2: {
                return EMouseAction.getEnum(binDiffConfigFile.getInitialFlowgraphSettings().getMouseWheelAction());
            }
        }
        if (this.settings.getMouseSettings().getMouseWheelAction() == MouseWheelAction.ZOOM) {
            eMouseAction = EMouseAction.ZOOM;
            return eMouseAction;
        }
        eMouseAction = EMouseAction.SCROLL;
        return eMouseAction;
    }

    private int getScrollSensitivity(BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getScrollSensitivity();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getScrollSensitivity();
            }
        }
        return this.settings.getMouseSettings().getScrollSensitivity();
    }

    private boolean getShowScrollbars(BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getShowScrollbars();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getShowScrollbars();
            }
        }
        return this.settings.getShowScrollbars();
    }

    private int getZoomSensitivity(BinDiffConfigFile binDiffConfigFile) {
        switch (ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
            case 1: {
                return binDiffConfigFile.getInitialCallgraphSettings().getZoomSensitivity();
            }
            case 2: {
                return binDiffConfigFile.getInitialFlowgraphSettings().getZoomSensitivity();
            }
        }
        return this.settings.getMouseSettings().getZoomSensitivity();
    }

    private void init(String string) {
        this.setBorder(new LineBorder(Color.GRAY));
        this.showScrollbars.addItem("Always");
        this.showScrollbars.addItem("Never");
        this.mouseWheelBehaviour.addItem("Zoom");
        this.mouseWheelBehaviour.addItem("Scroll");
        this.setCurrentValues();
        JPanel jPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        jPanel.setBorder(new TitledBorder(string));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Show scrollbars", 275, this.showScrollbars, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Mousewheel action", 275, this.mouseWheelBehaviour, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Zoom sensitivity", 275, this.zoomSensitivity, 25));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Scroll sensitivity", 275, this.scrollSensitivity, 25));
        this.add((Component)jPanel, "North");
    }

    public EMouseAction getMouseWheelBehaviour() {
        return EMouseAction.getEnum(this.mouseWheelBehaviour.getSelectedIndex());
    }

    public int getScrollSensitivity() {
        return this.scrollSensitivity.getValue();
    }

    public boolean getShowScrollbars() {
        if (this.showScrollbars.getSelectedIndex() != 0) return false;
        return true;
    }

    public int getZoomSensitivity() {
        return this.zoomSensitivity.getValue();
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        this.showScrollbars.setSelectedIndex(this.getShowScrollbars(binDiffConfigFile) ? 0 : 1);
        this.mouseWheelBehaviour.setSelectedIndex(EMouseAction.getOrdinal(this.getMouseWheelBehaviour(binDiffConfigFile)));
        this.zoomSensitivity.setValue(this.getZoomSensitivity(binDiffConfigFile));
        this.scrollSensitivity.setValue(this.getScrollSensitivity(binDiffConfigFile));
    }
}

