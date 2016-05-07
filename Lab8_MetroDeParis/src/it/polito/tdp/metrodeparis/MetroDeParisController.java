package it.polito.tdp.metrodeparis;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.grafoTrasporti.Fermata;
import it.polito.tdp.grafoTrasporti.ModelTrasporti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MetroDeParisController {
	private ModelTrasporti model;
	
	private boolean generato=false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Fermata> Partenza;

    @FXML
    private ComboBox<Fermata> Arrivo;
    
    @FXML
    private Button Calcola;

	

    @FXML
    private TextArea Risultato;
    
    @FXML
    void CalcolaPercorso(ActionEvent event) {
    	//Partenza.getItems().addAll(model.fermate());
		//Arrivo.getItems().addAll(model.fermate());
    	if(!generato){
    		model.generaMetro();
    		generato=true;
    	}
    	Fermata f1=new Fermata(8,"Alesia",2.3624,8.8285);
    	Fermata f2=new Fermata(31,"Balard",2.2785,48.83685);
    	List<Fermata>fermate=model.percorso(f1,f2);//(Partenza.getValue(),Arrivo.getValue());
    	Visualizza(fermate);
    }
    private void Visualizza(List<Fermata> elementi){
    	String s="Percorso:[";
    	for(Fermata elemento : elementi)
    		s+=elemento.getNome()+", ";
    	s+="]";
    	Risultato.setText(s);
    }
    @FXML
    void initialize() {
    	  assert Partenza != null : "fx:id=\"Partenza\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
          assert Arrivo != null : "fx:id=\"Arrivo\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
          assert Calcola != null : "fx:id=\"Calcola\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
          assert Risultato != null : "fx:id=\"Risultato\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
    }

	public void setModel(ModelTrasporti m) {
		this.model=m;
		//Partenza.getItems().addAll(m.fermate());
		//Arrivo.getItems().addAll(m.fermate());
	}
}
