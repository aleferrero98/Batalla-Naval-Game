import vistas.VistaInicio;
import vistas.VistaLogin;
import vistas.VistaConfig;
import vistas.VistaJuego;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//VistaInicio vista=new VistaInicio();
			VistaConfig vista=new VistaConfig();
			//VistaLogin vista=new VistaLogin();
			//VistaJuego vista=new VistaJuego();
			vista.hacerVisible(true);
	        vista.ubicarAlMedio();
		}
}


