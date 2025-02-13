package layout.gridlayouttask;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ExperimentPanel extends JPanel {

    private final GridLayout experimentLayout;

    public ExperimentPanel() {
        this.experimentLayout = new GridLayout(0, 2);

        this.layoutComponents();
    }

    private void layoutComponents() {
        this.setLayout(this.experimentLayout);
        this.setPreferredSize(calculatePreferredSize());

        this.add(new JButton("Button 1"));
        this.add(new JButton("Button 2"));
        this.add(new JButton("Button 3"));
        this.add(new JButton("Long-Named Button 4"));
        this.add(new JButton("5"));
    }

    private static Dimension calculatePreferredSize() {
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        int preferredWidth = (int) (buttonSize.getWidth() * 2.5) + MAX_GAP;
        int preferredHeight = (int) (buttonSize.getHeight() * 3.5) + MAX_GAP * 2;

        return new Dimension(preferredWidth, preferredHeight);
    }

    public void processGapChangeRequest(int horGap, int verGap) {
        if (horGap < 0 || horGap > MAX_GAP || verGap < 0 || verGap > MAX_GAP) {
            throw new IllegalArgumentException(String.format("Gaps requested %d and %d. Gaps must be within 0 and %d.", horGap, verGap, MAX_GAP));
        }
        this.experimentLayout.setHgap(horGap);
        this.experimentLayout.setVgap(verGap);
        this.experimentLayout.layoutContainer(this);
    }

    private final static int MAX_GAP = 20;

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
