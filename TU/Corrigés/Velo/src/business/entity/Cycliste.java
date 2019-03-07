package business.entity;

public class Cycliste {
	private long id;
	private String name;
	private int nbVelos;
	private Equipe equipe;
	
	@Override
	public String toString() {
		return "Cycliste [id=" + id + ", name=" + name + ", nbVelos=" + nbVelos + ", equipe=" + equipe + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbVelos() {
		return nbVelos;
	}

	public void setNbVelos(int nbVelos) {
		this.nbVelos = nbVelos;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Cycliste(String name, int nbVelos, Equipe equipe) {
		super();
		this.name = name;
		this.nbVelos = nbVelos;
		this.equipe = equipe;
	}

	public Cycliste(long id, String name, int nbVelos,Equipe equipe) {
		super();
		this.id = id;
		this.name = name;
		this.nbVelos = nbVelos;
		this.equipe = equipe;
	}
	
	
}
