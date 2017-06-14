/*
 * OrderStatusMidlet.java
 *
 * Created on January 9, 2006, 4:14 AM
 */

package org.azri.estore.mobile;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author Mohamad Azri
 */
public class OrderStatusMidlet extends MIDlet implements CommandListener {
    
    /**
     * Creates a new instance of OrderStatusMidlet
     */
    public OrderStatusMidlet() {
        initialize();
    }
    
    private List MainMenu;//GEN-BEGIN:MVDFields
    private Command exitCommand1;
    private org.netbeans.microedition.lcdui.WaitScreen Connecting;
    private org.netbeans.microedition.util.SimpleCancellableTask getOrderStatus_Task;
    private Alert FailureAlert;
    private Form OrderStatusInput;
    private TextField getOrderStatus_string_1_InputItem;
    private Command backCommand1;
    private Command okCommand1;
    private Form OrderStatusOutput;
    private StringItem getOrderStatus_OutputItem;//GEN-END:MVDFields
// End2End client generated code
    private OrderStatusSEI_Stub client = new OrderStatusSEI_Stub();
    
    
    private java.lang.String getOrderStatus_returnValue; // field for holding value returned from method
    
// method calling the generated method
    private void call_getOrderStatus() throws java.io.IOException {
        java.lang.String string_1 = getOrderStatus_string_1_InputItem.getString();
        getOrderStatus_returnValue = client.getOrderStatus(string_1);
    }
    
// method for setting output values
    private void set_getOrderStatus_OutputValues() {
        get_getOrderStatus_OutputItem().setText(getOrderStatus_returnValue);
    }
    
    /** This method initializes UI of the application.//GEN-BEGIN:MVDMethods
     */
    private void initialize() {
        getDisplay().setCurrent(get_MainMenu());
    }//GEN-END:MVDMethods

    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
    // Insert global pre-action code here
        if (displayable == OrderStatusInput) {//GEN-BEGIN:MVDCABody
            if (command == okCommand1) {//GEN-END:MVDCABody
                // Insert pre-action code here
                getDisplay().setCurrent(get_Connecting());//GEN-LINE:MVDCAAction18
                // Insert post-action code here
            } else if (command == backCommand1) {//GEN-LINE:MVDCACase18
                // Insert pre-action code here
                getDisplay().setCurrent(get_MainMenu());//GEN-LINE:MVDCAAction16
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase16
        } else if (displayable == MainMenu) {
            if (command == exitCommand1) {//GEN-END:MVDCACase16
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction7
                // Insert post-action code here
            } else if (command == MainMenu.SELECT_COMMAND) {//GEN-BEGIN:MVDCACase7
                switch (get_MainMenu().getSelectedIndex()) {
                    case 0://GEN-END:MVDCACase7
                        // Insert pre-action code here
                        getDisplay().setCurrent(get_OrderStatusInput());//GEN-LINE:MVDCAAction4
                        // Insert post-action code here
                        break;//GEN-BEGIN:MVDCACase4
                }
            }
        } else if (displayable == OrderStatusOutput) {
            if (command == okCommand1) {//GEN-END:MVDCACase4
                // Insert pre-action code here
                getDisplay().setCurrent(get_MainMenu());//GEN-LINE:MVDCAAction21
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase21
        }//GEN-END:MVDCACase21
    // Insert global post-action code here
}//GEN-LINE:MVDCAEnd
    
    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay() {//GEN-FIRST:MVDGetDisplay
        return Display.getDisplay(this);
    }//GEN-LAST:MVDGetDisplay
    
    /**
     * This method should exit the midlet.
     */
    public void exitMIDlet() {//GEN-FIRST:MVDExitMidlet
        getDisplay().setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    }//GEN-LAST:MVDExitMidlet

    /** This method returns instance for MainMenu component and should be called instead of accessing MainMenu field directly.//GEN-BEGIN:MVDGetBegin2
     * @return Instance for MainMenu component
     */
    public List get_MainMenu() {
        if (MainMenu == null) {//GEN-END:MVDGetBegin2
            // Insert pre-init code here
            MainMenu = new List(null, Choice.IMPLICIT, new String[] {"eStore Order Status Checker"}, new Image[] {null});//GEN-BEGIN:MVDGetInit2
            MainMenu.addCommand(get_exitCommand1());
            MainMenu.setCommandListener(this);
            MainMenu.setSelectedFlags(new boolean[] {false});//GEN-END:MVDGetInit2
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd2
        return MainMenu;
    }//GEN-END:MVDGetEnd2

    /** This method returns instance for exitCommand1 component and should be called instead of accessing exitCommand1 field directly.//GEN-BEGIN:MVDGetBegin6
     * @return Instance for exitCommand1 component
     */
    public Command get_exitCommand1() {
        if (exitCommand1 == null) {//GEN-END:MVDGetBegin6
            // Insert pre-init code here
            exitCommand1 = new Command("Exit", Command.EXIT, 1);//GEN-LINE:MVDGetInit6
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd6
        return exitCommand1;
    }//GEN-END:MVDGetEnd6

    /** This method returns instance for Connecting component and should be called instead of accessing Connecting field directly.//GEN-BEGIN:MVDGetBegin8
     * @return Instance for Connecting component
     */
    public org.netbeans.microedition.lcdui.WaitScreen get_Connecting() {
        if (Connecting == null) {//GEN-END:MVDGetBegin8
            // Insert pre-init code here
            Connecting = new org.netbeans.microedition.lcdui.WaitScreen(getDisplay());//GEN-BEGIN:MVDGetInit8
            Connecting.setFailureDisplayable(get_FailureAlert(), get_MainMenu());
            Connecting.setText("Getting data from server ...");
            Connecting.setNextDisplayable(get_OrderStatusOutput());
            Connecting.setTask(get_getOrderStatus_Task());//GEN-END:MVDGetInit8
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd8
        return Connecting;
    }//GEN-END:MVDGetEnd8

    /** This method returns instance for getOrderStatus_Task component and should be called instead of accessing getOrderStatus_Task field directly.//GEN-BEGIN:MVDGetBegin11
     * @return Instance for getOrderStatus_Task component
     */
    public org.netbeans.microedition.util.SimpleCancellableTask get_getOrderStatus_Task() {
        if (getOrderStatus_Task == null) {//GEN-END:MVDGetBegin11
            // Insert pre-init code here
            getOrderStatus_Task = new org.netbeans.microedition.util.SimpleCancellableTask();//GEN-BEGIN:MVDGetInit11
            getOrderStatus_Task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {
// calls end-to-end method and setting result to output screens
                    try {
                        call_getOrderStatus();
                    } catch (java.io.IOException ioe) {
                        throw new RuntimeException(ioe.getMessage());
                    }
                    set_getOrderStatus_OutputValues();
                    
                    
                }
            });//GEN-END:MVDGetInit11
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd11
        return getOrderStatus_Task;
    }//GEN-END:MVDGetEnd11

    /** This method returns instance for FailureAlert component and should be called instead of accessing FailureAlert field directly.//GEN-BEGIN:MVDGetBegin12
     * @return Instance for FailureAlert component
     */
    public Alert get_FailureAlert() {
        if (FailureAlert == null) {//GEN-END:MVDGetBegin12
            // Insert pre-init code here
            FailureAlert = new Alert("Failure.", "Communication failed.", null, AlertType.ERROR);//GEN-BEGIN:MVDGetInit12
            FailureAlert.setTimeout(-2);//GEN-END:MVDGetInit12
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd12
        return FailureAlert;
    }//GEN-END:MVDGetEnd12

    /** This method returns instance for OrderStatusInput component and should be called instead of accessing OrderStatusInput field directly.//GEN-BEGIN:MVDGetBegin13
     * @return Instance for OrderStatusInput component
     */
    public Form get_OrderStatusInput() {
        if (OrderStatusInput == null) {//GEN-END:MVDGetBegin13
            // Insert pre-init code here
            OrderStatusInput = new Form("getOrderStatus", new Item[] {get_getOrderStatus_string_1_InputItem()});//GEN-BEGIN:MVDGetInit13
            OrderStatusInput.addCommand(get_backCommand1());
            OrderStatusInput.addCommand(get_okCommand1());
            OrderStatusInput.setCommandListener(this);//GEN-END:MVDGetInit13
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd13
        return OrderStatusInput;
    }//GEN-END:MVDGetEnd13

    /** This method returns instance for getOrderStatus_string_1_InputItem component and should be called instead of accessing getOrderStatus_string_1_InputItem field directly.//GEN-BEGIN:MVDGetBegin14
     * @return Instance for getOrderStatus_string_1_InputItem component
     */
    public TextField get_getOrderStatus_string_1_InputItem() {
        if (getOrderStatus_string_1_InputItem == null) {//GEN-END:MVDGetBegin14
            // Insert pre-init code here
            getOrderStatus_string_1_InputItem = new TextField("Please enter your order id:", "", 120, TextField.ANY);//GEN-LINE:MVDGetInit14
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd14
        return getOrderStatus_string_1_InputItem;
    }//GEN-END:MVDGetEnd14

    /** This method returns instance for backCommand1 component and should be called instead of accessing backCommand1 field directly.//GEN-BEGIN:MVDGetBegin15
     * @return Instance for backCommand1 component
     */
    public Command get_backCommand1() {
        if (backCommand1 == null) {//GEN-END:MVDGetBegin15
            // Insert pre-init code here
            backCommand1 = new Command("Back", Command.BACK, 1);//GEN-LINE:MVDGetInit15
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd15
        return backCommand1;
    }//GEN-END:MVDGetEnd15

    /** This method returns instance for okCommand1 component and should be called instead of accessing okCommand1 field directly.//GEN-BEGIN:MVDGetBegin17
     * @return Instance for okCommand1 component
     */
    public Command get_okCommand1() {
        if (okCommand1 == null) {//GEN-END:MVDGetBegin17
            // Insert pre-init code here
            okCommand1 = new Command("Ok", Command.OK, 1);//GEN-LINE:MVDGetInit17
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd17
        return okCommand1;
    }//GEN-END:MVDGetEnd17

    /** This method returns instance for OrderStatusOutput component and should be called instead of accessing OrderStatusOutput field directly.//GEN-BEGIN:MVDGetBegin19
     * @return Instance for OrderStatusOutput component
     */
    public Form get_OrderStatusOutput() {
        if (OrderStatusOutput == null) {//GEN-END:MVDGetBegin19
            // Insert pre-init code here
            OrderStatusOutput = new Form("getOrderStatus Output", new Item[] {get_getOrderStatus_OutputItem()});//GEN-BEGIN:MVDGetInit19
            OrderStatusOutput.addCommand(get_okCommand1());
            OrderStatusOutput.setCommandListener(this);//GEN-END:MVDGetInit19
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd19
        return OrderStatusOutput;
    }//GEN-END:MVDGetEnd19

    /** This method returns instance for getOrderStatus_OutputItem component and should be called instead of accessing getOrderStatus_OutputItem field directly.//GEN-BEGIN:MVDGetBegin20
     * @return Instance for getOrderStatus_OutputItem component
     */
    public StringItem get_getOrderStatus_OutputItem() {
        if (getOrderStatus_OutputItem == null) {//GEN-END:MVDGetBegin20
            // Insert pre-init code here
            getOrderStatus_OutputItem = new StringItem("Your order status: ", "<Enter Text>");//GEN-LINE:MVDGetInit20
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd20
        return getOrderStatus_OutputItem;
    }//GEN-END:MVDGetEnd20
    
    public void startApp() {
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
}
