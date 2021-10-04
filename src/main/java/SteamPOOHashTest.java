import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;


class SteamPOOHashTest {

    @Test
    void testaCadastroDeJogos() {
        SteamPOOHash sistema = new SteamPOOHash();
        Jogo jogo = new Jogo("Zelda");
        jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
        try {
            sistema.cadastraJogo(jogo);
        } catch (JogoJaExisteException e) {
            fail("Não deveria ter lançado exceção");
        }
        assertTrue(sistema.existeJogoComNome("Zelda"));
        int cont = sistema.contaJogosDaCategoria(CategoriaDeJogo.ARCADE);
        assertEquals(1,cont);
        assertTrue(sistema.existeJogoComNome("Zelda"));
        assertEquals(0.0,sistema.pesquisaPrecoDoJogo("Zelda"));


    }

    @Test
    void testJogosDaCategoria(){
        SteamPOOHash sistema = new SteamPOOHash();
        Jogo jogo = new Jogo("Lol");
        jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);

        Jogo jogo1 = new Jogo("CS");
        jogo.adicionaCategoria(CategoriaDeJogo.GUERRA);

        Jogo jogo2 = new Jogo("Resident");
        jogo.adicionaCategoria(CategoriaDeJogo.TERROR);

        Jogo jogo3 = new Jogo("COD WARZONE");
        jogo.adicionaCategoria(CategoriaDeJogo.GUERRA);

        assertTrue(sistema.contaJogosDaCategoria(CategoriaDeJogo.GUERRA) == 2);


    }

}
