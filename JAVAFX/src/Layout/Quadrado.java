package Layout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Quadrado extends Rectangle {

	private static int i = 0;

	private String[] cores = { "#000000", "#191970", "#3CB371", "#8B4513", "#EE82EE", "#B22222"

	};

	public Quadrado() {
		this(100, 100);
	}

	public Quadrado(int largura, int altura) {
		
		setWidth(largura);
		setHeight(altura);

		setFill(Color.web(cores[i++]));

		if (i == 6)
			i = 0;
	}

}
