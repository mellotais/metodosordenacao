package atividade;

public class ListaEncadeada {
	    private Nodo inicio;

	    public ListaEncadeada() {
	        inicio = null;
	    }

	    public Nodo getInicio() {
	        return inicio;
	    }

	    public void inserirOrdenado(int valor) {
	        Nodo novoNodo = new Nodo(valor);
	        if (inicio == null || valor < inicio.getDado()) {
	            novoNodo.setProx(inicio);
	            inicio = novoNodo;
	            return;
	        }

	        Nodo atual = inicio;
	        Nodo anterior = null;

	        while (atual != null && valor >= atual.getDado()) {
	            anterior = atual;
	            atual = atual.getProx();
	        }

	        if (anterior != null) {
	            novoNodo.setProx(atual);
	            anterior.setProx(novoNodo);
	        }
	    }


}
