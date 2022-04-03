package Arbol;

public class nodoAVL {
	public int valor;
	public nodoAVL izqq, der;
	public int fe;

	public nodoAVL(int valor) {
		this.valor = valor;
		this.izqq = this.der = null;
		this.fe = 0;
	}
}
