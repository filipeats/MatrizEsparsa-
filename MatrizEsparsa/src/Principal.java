public class Principal {
	public static void main(String[] args) {
		MatrizEsparsa objMatrizEsparsa = new MatrizEsparsa();
		
		for (int i = -100 ; i < 100 ; i++) {
			objMatrizEsparsa.inserir(i);
		}
		
		objMatrizEsparsa.imprimir();
		
		for (int i = -100 ; i < 1000 ; i++) {
			objMatrizEsparsa.remover(i);
		}
		
		objMatrizEsparsa.imprimir();
	}
}