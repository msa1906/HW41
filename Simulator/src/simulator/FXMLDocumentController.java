/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
/**
 *
 * @author Mingtong Wu
 * 110033615
 * Mingtong.wu@stonybrook.edu
 */

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField numOfRouter;
  @FXML
    private TextField arrivalProb;
    @FXML
    private TextField maxBuffer;
      @FXML
    private TextField minPacketSize;
      
  @FXML
    private TextField maxPacketSize;
    @FXML
    private TextField bandwidth;
      @FXML
    private TextField duration;
        @FXML
    private TextArea showArea;
            @FXML
    private Button simulate;
            @FXML
            private void handleButtonAction(ActionEvent event) {
			Simulator a = new Simulator();
			System.out.println("Starting simulator...");
			System.out.println("Enter the number of Intermediate routers:");
			a.setNumIntRouters(getNumOfRouter());
			/*
			 a.setNumIntRouters(4); a.setArrivalProb(0.5);
			 a.setMaxBufferSize(5); a.setMinPacketSize(500);
			 a.setMaxPacketSize(1500); a.setBandwidth(2); a.setDuration(25);
			 */
			 //test data
			System.out.println("Enter the arrival probability of a packet:");
			a.setArrivalProb(getArrivalProb());
			System.out.println("Enter the maximum buffer size of a router:");
			a.setMaxBufferSize(getMaxBuffer());
			System.out.println("Enter the minimum size of a packet:");
			a.setMinPacketSize(getMinPacketSize());
			System.out.println("Enter the maximum size of a packet:");
			a.setMaxPacketSize(getMaxPacketSize());
			System.out.println("Enter the bandwidth size:");
			a.setBandwidth(getBandwidth());
			System.out.println("Enter the simulation duration:");
			a.setDuration(getDuration());
			a.simulate();
			System.out.println("Quit?(y/any key for no)");
    }
    @FXML
    /*private void handleButtonAction(ActionEvent event) {
        my_println("T1");
        my_println(field1.getText());
        //textField.setText("sdfsdf\nsdfsd");
    }
    @FXML */
    public int getNumOfRouter(){
        return Integer.parseInt(numOfRouter.getText());
    } 
    public double getArrivalProb( ){
        return Double.parseDouble(arrivalProb.getText());
    } 
    public int getMaxBuffer( ){
        return Integer.parseInt(maxBuffer.getText());
    } 
    public int getMinPacketSize( ){
        return Integer.parseInt(minPacketSize.getText());
    } 
    public int getMaxPacketSize( ){
        return Integer.parseInt(maxPacketSize.getText());
    } 
    public int getBandwidth( ){
        return Integer.parseInt(bandwidth.getText());
    } 
    public int getDuration( ){
        return Integer.parseInt(duration.getText());
    } 
    @FXML
    private void enterPressed(ActionEvent event) {
        handleButtonAction(null);
    }
    
    
    private void my_println(String var) {
        System.out.println(var);
        showArea.appendText(var + "\r\n");
    }
    
    public void my_printf(String format, Object ... args) {
        String outp = String.format(format, args);
        System.out.print(outp);
        showArea.appendText(outp);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
