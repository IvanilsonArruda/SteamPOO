import java.util.List;
import java.util.Objects;


public class Jogo {

    private String nome;
    private double preco;
    private List<CategoriaDeJogo> categorias;

    public Jogo() {

    }

    public Jogo(String nome) {
        this.nome = nome;
    }

    public Jogo(String nome, double preco, List<CategoriaDeJogo> categorias) {
        this.nome = nome;
        this.preco = preco;
        this.categorias = categorias;
    }

    public void setCategorias(List<CategoriaDeJogo> categorias) {
        this.categorias = categorias;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jogo other = (Jogo) obj;
        return Objects.equals(nome, other.nome);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Jogo [nome=" + nome + ", preco=" + preco + ", categorias=" + categorias + "]";
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean ehDaCategoria(CategoriaDeJogo categoria) {
        for (CategoriaDeJogo cat : this.categorias) {
            if (cat.equals(categoria)) {
                return true;
            }
        }
        return false;
    }

    public List<CategoriaDeJogo> getCategorias(){
        return this.categorias;
    }

    public void adicionaCategoria(CategoriaDeJogo categoria) {
        if (!this.categorias.contains(categoria)) {
            this.categorias.add(categoria);
        }
    }
}