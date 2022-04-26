package Layout;


import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Caixa extends HBox {
	
	private static int i = 0;
	
	private String[] cores = {
			"#000000","#191970","#3CB371",
			"#8B4513", "#EE82EE", "#B22222"
			
	};
	public Caixa () {
		this(100,100);
	}

	public Caixa(int largura, int altura) {
		setAlignment(Pos.CENTER);
		setMinWidth(largura);
		setMinHeight(altura);
		
		BackgroundFill fill = new BackgroundFill(
				Color.web(cores[i++]), CornerRadii.EMPTY,Insets.EMPTY);
		setBackground(new Background(fill));
		
		if (i == 6) i= 0;
	}
	
	public Caixa comTexto(String texto) {
		Label label= new javafx.scene.control.Label(texto);
		getChildren().add(label);
		label.setFont(new Font(24));
		
		return this;
	}
}
