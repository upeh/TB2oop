public class Bird extends Animal implements LandAnimal, FlyingAnimal, Karnivora {
	private final String TIPEANIMAL = "bird";
	private final char SIMBOL = 'b';
	private int bobot;
	private String tipeHabitat[] = {"land", "air"};
	private String musuh[] = {"butterfly", "eagle"};

	public Bird(int x, int y) {
		super(x, y);
		bobot = 7;
	}
	
	public void addBobot() {
		bobot++;
	}

	public int getBobot() {
		return bobot;
	}

	public char getSimbol() {
		return SIMBOL;
	}

	public String getMusuh(int i) {
		return musuh[i];
	}

	public String getTipeAnimal() {
		return TIPEANIMAL;
	}

	public String interact() {
		return "cuitcuit"; 
	}

	public char render() {
		return SIMBOL;
	}

	public String[] getTipeHabitat() {
		return tipeHabitat; 
	}
}
