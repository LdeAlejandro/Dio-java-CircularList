package dio;

public class CircularList<T> {

    private No<T>  cabeca;
    private No<T>  cauda;
    private int    tamanhoLista;

    public CircularList() {
       this.cauda = null;
       this.cabeca = null;
       this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No <T> novoNo = new No<>(conteudo);
        if(tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca; // o cauda aponta para o cabeca
            this.cabeca.setNoProximo(this.cauda); // o proximo do cabeca aponta para o cauda
        }else{
            novoNo.setNoProximo(this.cauda); // o proximo do novo no aponta para o cauda
            this.cabeca.setNoProximo(novoNo); // o proximo do cabeca aponta para o novo no
            this.cauda = novoNo; // o cauda aponta para o novo no
        }
        this.tamanhoLista++;
    }
    public void remove (int index){
        if(index >= this.tamanhoLista){
            throw new IndexOutOfBoundsException("O indice nao pode ser maior que o tamanho da lista");
        }

        No<T>  noAuxiliar = this.cauda;
        if(index == 0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);

        }else if(index == 1){//caso o indice seja 1
            // quando java perde a referencia do index 1 o mesmo é eliminado da lista por isso apontamos a referencia para o indice 2
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo()); // o proximo do cauda vai ser o proximo do proximo do cauda

        }else{ // caso o indice seja maior que 1
            for(int i = 0; i < index - 1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            // quando java perde a referencia do index o mesmo é eliminado da lista por isso apontamos a referencia para o indice 2
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo()); // o proximo do no auxiliar vai ser o proximo do proximo do no auxiliar
        }
        this.tamanhoLista--;
    }

    public T get(int index){

        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if(this.isEmpty()){ // se a lista estiver vazia
            throw new IndexOutOfBoundsException("A lista esta vazia");
        }

        if(index == 0){
            return this.cauda;
        }

        No <T> noAuxiliar = this.cauda;
        for(int i = 0; i < index; i++){ // percorrendo a lista
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }
    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;

        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}] ---> ";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += this.size() != 0 ? "(Retorna ao início)": "[]";

        return strRetorno;
    }
}
