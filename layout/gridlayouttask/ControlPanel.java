package layout.gridlayouttask;

import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

    private final JComboBox horGapComboBox, verGapComboBox;
    private final JButton applyButton;
    private GapChangeRequestListener gapChangeRequestListener;

    public ControlPanel() {
        this.horGapComboBox = new JComboBox(GAP_LIST);
        this.verGapComboBox = new JComboBox(GAP_LIST);
        this.applyButton = new JButton("Apply gaps");

        this.layoutComponents();
        this.addEventHandling();
    }

    public void setGapChangeRequestListener(GapChangeRequestListener gapChangeRequestListener) {
        this.gapChangeRequestListener = gapChangeRequestListener;
    }

    private void layoutComponents() {
        this.setLayout(new GridLayout(2, 3));

        // First row
        this.add(new Label("Horizontal gap:"));
        this.add(new Label("Vertical gap:"));
        this.add(new Label(" "));

        // Second row
        this.add(this.horGapComboBox);
        this.add(this.verGapComboBox);
        this.add(this.applyButton);
    }

    private void addEventHandling() {
        this.applyButton.addActionListener((actionEvent) -> this.processApplyButtonClick());
    }

    private synchronized void processApplyButtonClick() {
        int horGap = GAP_LIST[this.horGapComboBox.getSelectedIndex()];
        int verGap = GAP_LIST[this.verGapComboBox.getSelectedIndex()];

        this.gapChangeRequestListener.gapChangeRequested(horGap, verGap);
    }

    private static final Integer[] GAP_LIST = {0, 10, 15, 20};

}

/*
 * Based on GridLayoutDemo.java from Java tutorals
 * Link to original code: https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridLayoutDemoProject/src/layout/GridLayoutDemo.java
 * License to original code is reproduced beloe.
 *
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
