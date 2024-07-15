public class MatrizEsparsa {
	// Constantes da classe
	private static final int MODULO = 16;
	
	// Propriedades da classe
	private Diretor cabeca = null;
	
	// Métodos da classe
	public void inserir(int numero) {
		// Declaração de variáveis
		Diretor ponteiroDiretor = cabeca;
		int resto = Math.abs(numero % MODULO);
		
		// Procura pelo diretor correto
		while ((ponteiroDiretor != null) &&
			   (ponteiroDiretor.getResto() != resto)) {
			ponteiroDiretor = ponteiroDiretor.getProximoDiretor();
		}
		
		// Cenário em que não há diretor, tem que criar
		if (ponteiroDiretor == null) {
			cabeca = new Diretor(resto, cabeca, null);
			ponteiroDiretor = cabeca;
		}
		
		// Criação do novo nó
		ponteiroDiretor.setProximoNo(
				new No(numero, ponteiroDiretor.getProximoNo()));
	}
	
	public void imprimir() {
		Diretor ponteiroDiretor = cabeca;
		
		while (ponteiroDiretor != null) {
			System.out.print(ponteiroDiretor.getResto() + " =>\t");
			
			No ponteiroNo = ponteiroDiretor.getProximoNo();
			while (ponteiroNo != null) {
				System.out.print(ponteiroNo.getNumero() + ", ");
				ponteiroNo = ponteiroNo.getProximoNo();
			}
			
			System.out.println();
			ponteiroDiretor = ponteiroDiretor.getProximoDiretor();
		}
	}
	
	public void remover(int numero) {
		// Declaração de variáveis
		Diretor ponteiroDiretor = cabeca;
		int resto = Math.abs(numero % MODULO);
		
		// Procura pelo diretor correto
		while ((ponteiroDiretor != null) &&
			   (ponteiroDiretor.getResto() != resto)) {
			ponteiroDiretor = ponteiroDiretor.getProximoDiretor();
		}
		
		// Cenário 1: diretor não encontrado
		if (ponteiroDiretor == null) {
			return;
		}
		
		// Cenário 2: diretor encontrado, porém lista vazia
		if (ponteiroDiretor.getProximoNo() == null) {
			return;
		}
		
		// Cenário 3: diretor encontrado, excluir o primeiro nó
		if (ponteiroDiretor.getProximoNo().getNumero() == numero) {
			ponteiroDiretor.setProximoNo(
					ponteiroDiretor.getProximoNo().getProximoNo());
			return;
		}
		
		// Cenário 4: diretor encontrado, excluir um nó no meio ou final
		No ponteiroNo = ponteiroDiretor.getProximoNo();
		
		while ((ponteiroNo.getProximoNo() != null) &&
			   (ponteiroNo.getProximoNo().getNumero() != numero)) {
			ponteiroNo = ponteiroNo.getProximoNo();
		}
		
		if (ponteiroNo.getProximoNo() != null) {
			ponteiroNo.setProximoNo(
					ponteiroNo.getProximoNo().getProximoNo());
		}
	}
}