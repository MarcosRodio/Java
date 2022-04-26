package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {
	
	@FXML
	private TextField emailField;
	@FXML
	private PasswordField senhaField;
	
	public void entrar() {
		System.out.println("Entrar...");
		System.out.println(emailField.getText());
		System.out.println(senhaField.getText());
	}

}
