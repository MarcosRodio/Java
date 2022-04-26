package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Wizard extends Application {

	private Stage janela;
	private Scene passo1;
	private Scene passo2;
	private Scene passo3;

	@Override
	public void start(Stage primaryStage) throws Exception {
		janela = primaryStage;
		criarpasso1();
		criarpasso2();
		criarpasso3();

		
		janela.setScene(passo1);
		janela.setTitle("Wizard :: passo1");
		janela.show();

	}

	private void criarpasso1() {
		Button proximoPasso = new Button ("Passo 2>>");
		proximoPasso.setOnAction(e ->{
			janela.setScene(passo2);
			janela.setTitle("Wizard :: passo2");});
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(proximoPasso);
		
		passo1 = new Scene(box,400,400);		
	}
	
	private void criarpasso2() {
		
		Button proximoPasso = new Button ("Passo 3>>");
		Button PassoAnterior = new Button ("<<Passo 1");
		PassoAnterior.setOnAction(e->{
			janela.setScene(passo1);
			janela.setTitle("Wizard :: passo1");});
		proximoPasso.setOnAction(e->{
			janela.setScene(passo3);
			janela.setTitle("Wizard :: passo3");});
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(PassoAnterior);
		box.getChildren().add(proximoPasso);
		passo2 = new Scene(box,400,400);
}
	
	private void criarpasso3() {
		Button proximoPasso = new Button ("Finalizar");
		Button PassoAnterior = new Button ("<<Passo 2");
		PassoAnterior.setOnAction(e->{
			janela.setScene(passo2);
			janela.setTitle("Wizard :: passo2");});
		proximoPasso.setOnAction(e->{System.exit(0);});
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(PassoAnterior);
		box.getChildren().add(proximoPasso);
		passo3 = new Scene(box,400,400);
}	


	public static void main(String[] args) {
		launch(args);
	}

}
