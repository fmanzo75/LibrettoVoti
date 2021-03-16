/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtEsame"
    private TextField txtEsame; // Value injected by FXMLLoader

    @FXML // fx:id="txtVoto"
    private TextField txtVoto; // Value injected by FXMLLoader

    @FXML // fx:id="txtData"
    private TextField txtData; // Value injected by FXMLLoader

    @FXML // fx:id="txtResoult"
    private TextArea txtResoult; // Value injected by FXMLLoader

    @FXML
    void handleInserisci(ActionEvent event) {
    	// leggi e controlla i dati
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length() == 0) {
    		txtResoult.appendText("Il Nome Esame non può essere vuoto!");
    		return;
    	}
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
		} catch (NumberFormatException e) {
			txtResoult.appendText("ERRORE: il voto deve essere numerico!");
			return;
		}
    	if(votoInt > 30 || votoInt < 18) {
			txtResoult.appendText("ERRORE: il voto deve essere compreso tra 18 e 30");
			return;    		
    	}
    	String dataEsame = txtData.getText();
    	LocalDate data = null;
    	try {
    		data = LocalDate.parse(dataEsame);
		} catch (DateTimeParseException e) {
			txtResoult.appendText("ERRORE: data non corretta!");
			return;  
		}
    	
    	// TODO: aggiungere tutti i controlli
    	
    	// esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	// aggiorna i risultati nella (View)
    	txtResoult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	txtData.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResoult != null : "fx:id=\"txtResoult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
	public void setModel(Libretto model) {
    	this.model = model;
    }
}
