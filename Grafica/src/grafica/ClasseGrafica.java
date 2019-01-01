package grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClasseGrafica extends Application {  // l'interfaccia è un'applicazione 

	private Stage stage;  //è la finestra vuota
	private Scene scene; //è l'insieme dei nodi (buttoni, etichette, textfield, LAYOUT)
	private GridPane gridpane = new GridPane();  //è il layout, ossia il modo in cui vengono disposti i nodi (è una griglia)

	private Button button = new Button("Send"); //bottone con su scritto "send"
	private TextField textfield = new TextField(); //textfield lungo e stretto
	private TextArea textarea = new TextArea(); //area della chat
	
	public void start( Stage stage1) {
		
		stage = stage1; //otteniamo una referenza esterna a stage1
		stage.setTitle("ma che bella gui"); //titolo della finestra
		
		button.setOnAction(e->{
			textarea.appendText(textfield.getText());  //aggiunge il testo del textfield all textarea
			textfield.clear(); //pulisce il textfield
		});
		
		textfield.setPromptText("Non dire parolacce"); //testo d'invito
		
		textarea.setEditable(false); //textarea non editabile
		textarea.setWrapText(true);  //va a capo da solo quando la lunghezza del testo eccede la larghezza della textarea
		
		gridpane.add(textarea, 0, 0); //aggiungiamo la textarea nella colonna 0 e riga 0
		gridpane.add(textfield, 0, 1); // ""
		gridpane.add(button, 1, 1);  //""
		
		scene = new Scene(gridpane);  //metto il gridpane (insieme a tutti i nodi che ho aggiunto con add) nella scene
		stage.setScene(scene); //metto la scene nello stage
		stage.show(); //mostra lo stage
		
	}

	
	public static void main(String[] args) {
		
		launch();  //lancia l'applicazione (l'interfaccia) eseguendo il metodo start

	}

}
