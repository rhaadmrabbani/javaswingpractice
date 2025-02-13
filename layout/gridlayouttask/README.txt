I have re-written GridLayoutDemo from the official Java tutorials as GridLayoutTask.
I re-structured the code in a manner that I believe works well with Java Swing programming.

The class hierarchy of GridLayoutTask closely resembles the UI hierarchy.
The important classes are AppFrame, ControlPanel, and ExperimentPanel.
AppFrame has a ControlPanel and an ExperimentPanel as its children.
In turn, each of ControlPanel and ExperimentPanel has built-in Java Swing classes like JButton and JComboBox as its children.

You should use the GridLayoutTask code as the starter code for the tasks described below.



Task #1:

Read the starter code and develop an understanding of its structure.
It should be easy to distinguish between the parts of the code responsible for laying out the UI and for handling UI events.

Event data passes upwards from child to parent using the listener / event-notification pattern.
Information passes down from parent to child as simple function calls.
In particular, he "Apply Gaps" button notifies ControlPanel if a click event occurs.
Next, ControlPanel transforms the click event into a gap change request and notifies AppFrame.
Then AppFrame simply tells ExperimentPanel to process the gap change request.

AppFrame, ControlPanel, and ExperimentPanel do not have access to each other's UI components, so only event data is exchanged between these classes.
To avoid messy code logic, event data only travels up or down the class tree, and NOT sideways between siblings like ControlPanel and ExperimentPanel.
Because of this, we do not need multiple listeners per event, hence ControlPanel has a setGapChangeRequestListener instead of a addGapChangeRequestListener.



Task #2:

When we click the "X" button of AppFrame, we want a close confirmation dialog to pop up
Create a sub-class for JFrame that has such a behavior, and let AppFrame be a sub-class of this sub-class.


It might be easiest to find a solution online, and to then dissect and understand the code given in the solution.

For information on how to listen for a "X" button click, you may read:
https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html#setDefaultCloseOperation-int-

From the link below, you can find information on how to pop up a dialog asking for a "Yes" or "No" from the user:
https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html



Task #3:

In the ControlPanel code, we have the following:

private final JComboBox horGapComboBox, verGapComboBox;
...
public ControlPanel() {
    this.horGapComboBox = new JComboBox(GAP_LIST);
    this.verGapComboBox = new JComboBox(GAP_LIST);
    ...
}
...
private synchronized void processApplyButtonClick() {
    int horGap = GAP_LIST[this.horGapComboBox.getSelectedIndex()];
    int verGap = GAP_LIST[this.verGapComboBox.getSelectedIndex()];
    ...
}
...
private static final Integer[] GAP_LIST = {0, 10, 15, 20};

A JComboBox displays the string representations of the element list it is provided.
Hence, when we run the starter code, each JComboBox shows exactly these four option strings "0", "10", "15", "20".


Create a sub-class for JComboBox that behaves as described below:
- shows a blank option as the first option, followed by the string representations of the list of objects it is provided
  [we can easily achieve this by calling the super class constructor with a list of string representations with an empty string in the first position]
- override getSelectedIndex() so that it returns -1 if blank option is selected, and 0, 1, etc for the other options
  If it takes take {10, 15, 20} as its input 

Now, modify the app code to use, instead of JComboBox, this sub-class of JComboBox.
Instead of {0, 10, 15, 20}, we will now use a GAP_LIST of {10, 15, 20}
When processing a "Apply Gaps" button click, if getSelectedIndex() == -1 for any combo box, we will pick zero to be the corresponding gap.