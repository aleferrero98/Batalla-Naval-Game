import vistas.VistaInicio;
import vistas.VistaLogin;
import vistas.VistaConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			VistaInicio vista=new VistaInicio();
			//VistaConfig vista=new VistaConfig();
			//VistaLogin vista=new VistaLogin();
			vista.hacerVisible(true);
	        vista.ubicarAlMedio();
		}
}


