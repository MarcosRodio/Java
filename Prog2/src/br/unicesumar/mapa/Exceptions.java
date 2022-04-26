package br.unicesumar.mapa;

public class Exceptions {

	public Exceptions(String string) {
		// TODO Auto-generated constructor stub
	}

	public class DadoConsultadoException extends Exception{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public DadoConsultadoException(Throwable message) {
	        super(message);
	    }

		
	}
}
