public class Bird extends Animal implements FlyingAnimal, Karnivora {
	private final String TIPEANIMAL = "owl";
	private final char SIMBOL = 'o';
	private int bobot;
	private String tipeHabitat[] = {"air"};
	private String musuh[] = {"bee", "beetle"};

	public Owl(int x, int y) {
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
		return "uhukuhuk"; 
	}

	public char render() {
		return SIMBOL;
	}

	public String[] getTipeHabitat() {
		return tipeHabitat; 
	}
}
