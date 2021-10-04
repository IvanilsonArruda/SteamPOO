import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SteamPOOHash implements SteamPOO {
    private Map<String, Jogo> jogos;

    public SteamPOOHash() {
        this.jogos = new HashMap<>();
    }

    @Override
    public void cadastraJogo(Jogo jogo) throws JogoJaExisteException {
        if (this.jogos.containsKey(jogo.getNome())) {
            throw new JogoJaExisteException("Já existe jogo com o nome "
                    +jogo.getNome());
        } else {
            this.jogos.put(jogo.getNome(), jogo);
        }

    }

    @Override
    public void adicionaCategoriaEmJogo(String nomeJogo, CategoriaDeJogo categoria) throws JogoInexistenteException {

    if (this.jogos.containsKey(nomeJogo)){
        this.jogos.get(nomeJogo).adicionaCategoria(categoria);
    }
    }


    @Override
    public boolean existeJogoComNome(String nomeJogo) {
        return this.jogos.containsKey(nomeJogo);
    }


    @Override
    public List<Jogo> pesquisaJogosDaCategoria(CategoriaDeJogo categoria) {
        List<Jogo> jogosDaCategoria = new ArrayList<Jogo>();
        for (Jogo i: this.jogos.values()) {
            if (i.ehDaCategoria(categoria)) {
                jogosDaCategoria.add(i);
            }
        }
        return jogosDaCategoria;
    }

    public int contaJogosDaCategoria(CategoriaDeJogo categoria){
        int i = 0;
        for (Jogo l: this.jogos.values()) {
            if (l.ehDaCategoria(categoria)) {
                i++;
            }
        }
        return i;
    }
    public double pesquisaPrecoDoJogo(String nome){

        for (Jogo l: this.jogos.values()) {
            if (l.getNome().equals(nome)) {
                return l.getPreco();
            }
        }
        return 0.0;
    }
    public boolean RemoveJogo(String nome){
        if(this.jogos.containsKey(nome)){
            this.jogos.remove(nome);
            return true;
        }else{
            return false;
        }

    }

    public Jogo pesquisaPorNome(String nome){
        if(this.jogos.containsKey(nome)){
            return this.jogos.get(nome);
        }
        return null;

    }
    public void NomeNovo(String NomeNovo, String NomeAntigo, Jogo novojogo){
        this.jogos.remove(NomeAntigo);
        this.jogos.put(NomeNovo,novojogo);
        this.jogos.get(NomeNovo).setNome(NomeNovo);

    }
    public void NovoPreco(double NovoPreco, double AntigoPreco){
        this.jogos.get(AntigoPreco).setPreco(NovoPreco);

    }
    public void a (){
        for (Jogo l: this.jogos.values()) {
            System.out.println(l.getNome());
            }
    }

}