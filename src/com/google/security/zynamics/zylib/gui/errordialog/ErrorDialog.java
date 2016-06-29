/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.zylib.gui.errordialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.google.security.zynamics.zylib.general.StackTrace;
import com.google.security.zynamics.zylib.gui.CDialogEscaper;

public abstract class ErrorDialog extends JDialog {
  private final String description;

  private final Throwable exception;

  private final String message;

  public ErrorDialog(final Window owner, final String message, final String description) {
    this(owner, message, description, null);
  }

  public ErrorDialog(final Window owner, final String message, final String description,
      final Throwable exception) {
    super(owner, ModalityType.APPLICATION_MODAL);

    this.message = message;
    this.description = description;
    this.exception = exception;

    new CDialogEscaper(this);

    setLayout(new BorderLayout());

    createGui();

    setMinimumSize(new Dimension(600, 400));
    setSize(600, 400);
  }

  private void createGui() {
    final JPanel topPanel = new JPanel(new BorderLayout());

    final JPanel messagePanel = new JPanel(new BorderLayout());

    final JTextField messageField = new JTextField();
    messageField.setEditable(false);
    messageField.setText(message);
    messageField.setBackground(Color.WHITE);

    messagePanel.add(messageField);

    messagePanel.setBorder(new TitledBorder("Error Message"));

    topPanel.add(messagePanel, BorderLayout.NORTH);

    final JTabbedPane tabbedPane = new JTabbedPane();

    final JTextArea descriptionArea = new JTextArea();

    descriptionArea.setEditable(false);
    descriptionArea.setText(description);
    descriptionArea.setLineWrap(true);
    descriptionArea.setWrapStyleWord(true);

    tabbedPane.addTab("Description", descriptionArea);

    if (exception != null) {
      final JTextArea traceArea = new JTextArea();

      traceArea.setEditable(false);
      traceArea.setText(StackTrace.toString(exception.getStackTrace()));

      tabbedPane.addTab("Stack Trace", new JScrollPane(traceArea));
    }

    add(topPanel, BorderLayout.NORTH);
    add(tabbedPane);

    final JPanel bottomButtonPanel = new JPanel(new BorderLayout());
    final JPanel leftButtonPanelBottom = new JPanel();

    final JButton reportButton = new JButton(new ReportAction());
    reportButton.setMinimumSize(new Dimension(180, reportButton.getHeight()));

    leftButtonPanelBottom.add(reportButton);

    bottomButtonPanel.add(leftButtonPanelBottom, BorderLayout.WEST);

    final JPanel rightButtonPanelBottom = new JPanel();
    final JButton okButton = new JButton(new CloseButtonListener());
    getRootPane().setDefaultButton(okButton);
    rightButtonPanelBottom.add(okButton);
    bottomButtonPanel.add(rightButtonPanelBottom, BorderLayout.EAST);
    add(bottomButtonPanel, BorderLayout.SOUTH);
  }

  protected ImageIcon createImageIcon(final String path, final String description) {
    final java.net.URL imgURL = getClass().getResource(path);

    if (imgURL != null) {
      return new ImageIcon(imgURL, description);
    }
    System.err.println("Couldn't find file: " + path);
    return null;
  }

  protected abstract void report();

  private class CloseButtonListener extends AbstractAction {
    private CloseButtonListener() {
      super("Close");
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
      dispose();
    }
  }

  private class ReportAction extends AbstractAction {
    private ReportAction() {
      super("Report");
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
      report();
    }
  }
}
