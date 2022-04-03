package Arbol;


public class arbolAVL {

	public nodoAVL raiz;

	public arbolAVL() {
		this.raiz = null;
	}

	// obtener el Factor de Equilibrio
	private int obtenerFE(nodoAVL nodo) {
		if (nodo == null) {
			return -1;
		}
		return nodo.fe;
	}

	// buscar
	public nodoAVL buscarAVL(int d, nodoAVL r) {

		if (raiz == null) {
			return null;
		} else if (r.valor == d) {
			return r;
		} else if (r.valor < d) {
			return buscarAVL(d, r.der);
		} else {
			return buscarAVL(d, r.izqq);
		}
	}

	// Rotacion simple Izquierda
	public nodoAVL rotacionIzquierda(nodoAVL raiz) {

		nodoAVL aux = raiz.der;

		raiz.der = aux.izqq;// sirve de pronto tenga descendientes
		aux.izqq = raiz;

		/// actualiza los factores de equilibrio

		aux.fe = Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1;
		return aux;
	}

	public nodoAVL rotacionSimpleIzquierda(nodoAVL raiz) {

		nodoAVL aux = raiz.izqq;
		raiz.izqq = aux.der;// sirve de pronto tenga descendientes
		aux.der = raiz;
		raiz.fe = Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1;
		/// actualiza los factores de equilibrio
		aux.fe = Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1;
		return aux;
	}

	// Rotacion simple Derecho
	public nodoAVL rotacionDerecha(nodoAVL raiz) {

		nodoAVL aux = raiz.izqq;
		raiz.izqq = aux.der;// sirve de pronto tenga descendientes
		aux.izqq = raiz;

		/// actualiza los factores de equilibrio

		aux.fe = Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1;
		return aux;
	}

	public nodoAVL rotacionSimpleDerecha(nodoAVL raiz) {

		nodoAVL aux = raiz.der;
		raiz.der = aux.izqq;// sirve de pronto tenga descendientes
		aux.izqq = raiz;
		raiz.fe = Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1;
		/// actualiza los factores de equilibrio
		aux.fe = Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1;
		return aux;
	}

	// este metodo realiza la rotacion doble primero izq y luego derecha
	public nodoAVL rotacionIzquierdaDerecha(nodoAVL raiz) {

		raiz.izqq = rotacionIzquierda(raiz.izqq);
		nodoAVL temp = rotacionDerecha(raiz);
		return temp;
	}
	// rotacion doble doble primero izq y luego derecha

	public nodoAVL rotacionDobleIzquierdaDerecha(nodoAVL raiz) {

		nodoAVL temp;
		raiz.izqq = rotacionSimpleDerecha(raiz.izqq);
		temp = rotacionSimpleIzquierda(raiz);
		return temp;
	}

	// este metodo realiza la rotacion doble primero derecha y luego izquir
	public nodoAVL rotacionDerechaIzquierda(nodoAVL raiz) {

		raiz.der = rotacionIzquierda(raiz.der);
		nodoAVL temp = rotacionIzquierda(raiz);
		return temp;
	}
	// rotacion doble doble doble primero derecha y luego izquir

	public nodoAVL rrotacionDobleDerechaIzquierda(nodoAVL raiz) {

		nodoAVL temp;
		raiz.der = rotacionSimpleIzquierda(raiz.der);
		temp = rotacionSimpleDerecha(raiz);
		return temp;
	}
	/*
	 * public void insertar(int valor) {
	 * 
	 * nodoAVL nuevo = new nodoAVL(valor); if (nuevo == null) { raiz = nuevo; }
	 * else { raiz = insertar(this.raiz, nuevo); } }
	 * 
	 * private nodoAVL insertar(nodoAVL raiz, nodoAVL nuevo) { int peso; nodoAVL
	 * nuevaRaiz = raiz; if (nuevo.valor < raiz.valor) { if (raiz.izqq == null)
	 * { // valida si solo hay un nivel raiz.izqq = nuevo; } else { raiz.izqq =
	 * insertar(raiz.izqq, nuevo); peso = obtenerFE(raiz.der) -
	 * obtenerFE(raiz.izqq); if (peso == -2) { if (nuevo.valor <
	 * raiz.izqq.valor) { /// rotacion simple derecha nuevaRaiz =
	 * rotacionDerecha(raiz); } else { /// rotacion doble derecha nuevaRaiz =
	 * rotacionIzquierdaDerecha(raiz); }
	 * 
	 * } } } else if (nuevo.valor > raiz.valor) { if (raiz.der == null) { //
	 * valida si solo hay un nivel raiz.der = nuevo; } else { raiz.der =
	 * insertar(raiz.der, nuevo); peso = obtenerFE(raiz.der) -
	 * obtenerFE(raiz.izqq); if (peso == 2) { if (nuevo.valor > raiz.der.valor)
	 * { /// rotacion simple izq nuevaRaiz = rotacionIzquierda(raiz); } else {
	 * /// rotacion doble izq nuevaRaiz = rotacionDoleDerechaIzquierda(raiz); }
	 * 
	 * } } } /// aqui voy actualizar los FE if ((raiz.izqq == null) && (raiz.der
	 * == null)) { raiz.fe = raiz.der.fe + 1; } else if ((raiz.der == null) &&
	 * (raiz.izqq == null)) { raiz.fe = raiz.izqq.fe + 1; } else { raiz.fe =
	 * Math.max(obtenerFE(raiz.izqq), obtenerFE(raiz.der)) + 1; } return
	 * nuevaRaiz; }
	 */
	// Método para inserar AVL

	private nodoAVL insertarAVL(nodoAVL nuevo, nodoAVL subArb) {

		nodoAVL nuevoPadre = subArb;

		if (nuevo.valor < subArb.valor) {
			if (subArb.izqq == null) {
				subArb.izqq = nuevo;
			} else {
				subArb.izqq = insertarAVL(nuevo, subArb.izqq);
				if ((obtenerFE(subArb.izqq) - obtenerFE(subArb.der) == 2)) {
					if (nuevo.valor < subArb.izqq.valor) {
						nuevoPadre = rotacionSimpleIzquierda(subArb);
					} else {
						nuevoPadre = rotacionDobleIzquierdaDerecha(subArb);
					}
				}
			}
		} else if (nuevo.valor > subArb.valor) {
			if (subArb.der == null) {
				subArb.der = nuevo;
			} else {
				subArb.der = insertarAVL(nuevo, subArb.der);
				if ((obtenerFE(subArb.der) - obtenerFE(subArb.izqq) == 2)) {
					if (nuevo.valor > subArb.der.valor) {
						nuevoPadre = rotacionSimpleDerecha(subArb);
					} else {
						nuevoPadre = rrotacionDobleDerechaIzquierda(subArb);
					}
				}
			}
		} else {
			System.out.println("Nodo dublicado");
		}

		// Actualizar la actura
		if ((subArb.izqq == null) && (subArb.der != null)) {
			subArb.fe = subArb.der.fe + 1;
		} else if ((subArb.der == null) && (subArb.izqq != null)) {
			subArb.fe = subArb.izqq.fe + 1;
		} else {
			subArb.fe = Math.max(obtenerFE(subArb.izqq), obtenerFE(subArb.der)) + 1;
		}
		return nuevoPadre;
	}

	// Método para insertar public

	public void insertar(int d) {
		nodoAVL nuevo = new nodoAVL(d);
		if (raiz == null) {
			raiz = nuevo;
		} else {
			raiz = insertarAVL(nuevo, raiz);
		}
	}

	String salida;

	public String preorden() {
		salida = "";
		return preOrden(this.raiz);
	}

	private String preOrden(nodoAVL inicio) {

		// actual
		// izq
		// der

		if (inicio != null) {

			// System.out.print(inicio.getDato().toString()+"||");
			salida += inicio.valor + " || ";
			preOrden(inicio.izqq);// izq
			preOrden(inicio.der);// der

		}
		return salida;
	}
}
