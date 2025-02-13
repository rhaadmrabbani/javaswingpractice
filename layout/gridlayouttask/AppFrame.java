package layout.gridlayouttask;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JSeparator;

public class AppFrame extends JFrame {

    private final ControlPanel controlPanel;
    private final ExperimentPanel experimentPanel;

    public AppFrame() {
        this.controlPanel = new ControlPanel();
        this.experimentPanel = new ExperimentPanel();

        this.setupFrame();
        this.layoutComponents();
        this.addEventHandling();
        this.displayFrame();
    }

    private void setupFrame() {
        super.setTitle("Grid Layout Task");
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void layoutComponents() {
        Container pane = this.getContentPane();
        pane.add(this.experimentPanel, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(this.controlPanel, BorderLayout.SOUTH);
    }

    private void displayFrame() {
        super.pack();
        super.setVisible(true);
    }

    private void addEventHandling() {
        this.controlPanel.setGapChangeRequestListener((horGap, verGap) -> this.experimentPanel.processGapChangeRequest(horGap, verGap));
    }

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
