public class ArvoreBi {
    private Node raiz;

    public ArvoreBi() {
        raiz = null;
    }


    public void insert(int valor) {
        raiz = insertRec(raiz, valor);
    }

    public Node insertRec(Node raiz, int valor) {
        if(raiz == null){
            raiz = new Node(valor);
            return raiz;
        }

        if(valor < raiz.valor){
            raiz.esquerda = insertRec(raiz.esquerda, valor);
        } else if(valor > raiz.valor){
            raiz.direita = insertRec(raiz.direita, valor);
        }
        return raiz;  
    }


    public boolean busca(int valor) {
        return buscaRec(raiz, valor);
    }

    public boolean buscaRec(Node raiz, int valor) {
        if(raiz == null){
            return false;
        }

        if(valor == raiz.valor){
            return true;
        }

        if(valor < raiz.valor){
            return buscaRec(raiz.esquerda, valor);
        }

        if(valor > raiz.valor){
            return buscaRec(raiz.direita, valor);
        }
        return false;
        
    }


    public void remove(int valor){
        raiz = removeRec(raiz, valor);
    }

    public Node removeRec(Node raiz, int valor) {
        if(raiz == null){
            return null;
        }

        if(valor < raiz.valor) {
            raiz.esquerda = removeRec(raiz.esquerda, valor);
        } else if(valor > raiz.valor){
            raiz.direita = removeRec(raiz.direita, valor);
        } else {

            if(raiz.esquerda == null && raiz.direita == null){
                return null;
            }

            if(raiz.esquerda == null){
                return raiz.direita;
            } else if(raiz.direita == null){
                return raiz.esquerda;
            }
            
            raiz.valor = valorMin(raiz.direita);
            raiz.direita = removeRec(raiz.direita, raiz.valor);
        }
        return raiz;
    }


    public int valorMin(Node raiz) {
        int min = raiz.valor;

        while(raiz.esquerda != null){
            min = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return min;
    }


    public void print() {
        printRec(raiz, 0);
    }

    public void printRec(Node raiz, int nivel) {
        if (raiz != null) {
            printRec(raiz.direita, nivel + 1);


            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }


            System.out.println(raiz.valor);

            printRec(raiz.esquerda, nivel + 1); 
        }
    }

    
}
