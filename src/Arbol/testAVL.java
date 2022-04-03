package Arbol;

public class testAVL {

	public static void main(String[] args) {

		// nodoAVL raiz = new nodoAVL(10);
		// nodoAVL n1 = new nodoAVL(20);
		// nodoAVL n2 = new nodoAVL(15);
		// nodoAVL n3 = new nodoAVL(22);
		// nodoAVL n4 = new nodoAVL(40);
		// nodoAVL n5 = new nodoAVL(50);

		// raiz.der = n1;
		// raiz.der.izqq = n2;
		// raiz.der.der=n3;

		// rotacion doble izq - der
		// raiz.izqq = n1;
		// raiz.izqq.der= n2;
		/// rotacion doble dere - izq
		// raiz.der=n1;
		// raiz.der.izqq=n2;

		arbolAVL arbol = new arbolAVL();
		// nodoAVL rotado = arbol.rotacionIzquierda(raiz);
		// nodoAVL rotar = arbol.rotacionDerecha(raiz);
		// nodoAVL rotar=arbol.rotacionIzquierdaDerecha(raiz);
		// nodoAVL rotar=arbol.rotacionDoleDerechaIzquierda(raiz);
		arbol.insertar(10);
		arbol.insertar(5); // 20
		arbol.insertar(13); // 30
		arbol.insertar(1); // 40
		arbol.insertar(6); // 50
		arbol.insertar(17);
		arbol.insertar(16);

		// arbol.preOrden(rotado);
		String s=arbol.preorden();
		System.out.println(s);
		// System.out.println(rotar.fe);

	}

}
