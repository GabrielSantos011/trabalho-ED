package entity;

public class No {
	
	public No prox;
	public No anterior;
	public Inscrito inscrito;

	public No(Inscrito inscrito) {
		this.inscrito=inscrito;
		prox=null;
		anterior=null;
	}
	
	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	
}
