package result;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class resultController implements Initializable {
	@FXML
	private WebView webview;

	@FXML
	private WebEngine engine;
	
	@FXML
	Button btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		engine= webview.getEngine();
		
	}
	

	public void btn1(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("file:///F:/JavaWorkSpace/TableView/test-output/STMExtentReport.html#!"));
	}
	
	
	
	
	
	
	

}
