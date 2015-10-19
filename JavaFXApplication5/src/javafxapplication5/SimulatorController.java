/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class SimulatorController implements Initializable {
    @FXML
    private Button myButton;
        @FXML
    private Button clean;
    @FXML
    private TextField numOfRouter;
    @FXML
    private TextField arrivalProb;
    @FXML
    private TextField axBuffer;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML
    private void cleanData(ActionEvent event) {
    showArea.setText(null);
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
      Simulator a = new Simulator();
			System.out.println("Starting simulator...");
			a.setNumIntRouters(Integer.parseInt(numOfRouter.getText()));
			System.out.println("Enter the arrival probability of a packet:");
			a.setArrivalProb(Double.parseDouble(arrivalProb.getText()));
			System.out.println("Enter the maximum buffer size of a router:");
			a.setMaxBufferSize(Integer.parseInt(axBuffer.getText()));
			System.out.println("Enter the minimum size of a packet:");
			a.setMinPacketSize(Integer.parseInt(minPacketSize.getText()));
			System.out.println("Enter the maximum size of a packet:");
			a.setMaxPacketSize(Integer.parseInt(maxPacketSize.getText()));
			System.out.println("Enter the bandwidth size:");
			a.setBandwidth(Integer.parseInt(bandwidth.getText()));
			System.out.println("Enter the simulation duration:");
			a.setDuration(Integer.parseInt(duration.getText()));
			my_println(a.simulate());
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
    }
    

