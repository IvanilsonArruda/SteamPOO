import java.util.List;
public interface SteamPOO{

    public void cadastraJogo(Jogo jogo) throws JogoJaExisteException;

    public void adicionaCategoriaEmJogo(String nomeJogo, CategoriaDeJogo categoria) throws JogoInexistenteException;

    public List<Jogo> pesquisaJogosDaCategoria(CategoriaDeJogo categoria);

    public double pesquisaPrecoDoJogo(String nome) throws JogoInexistenteException;

    public boolean existeJogoComNome(String nomeJogo);

    public int contaJogosDaCategoria(CategoriaDeJogo categoria);

}