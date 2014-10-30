
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AEstrela a = new AEstrela("data/distancias.txt");
		ParisMetro paris = new ParisMetro();
		
		a.calcularTrajeto(paris.e1, paris.e5);
		
	}

}
