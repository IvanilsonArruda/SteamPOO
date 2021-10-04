import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class InterfaceSistemaGUI {
    public static void main(String[] args) throws JogoJaExisteException {
        SteamPOOHash sistema = new SteamPOOHash();

        String menu = "Escolha uma opção abaixo:\n" + "1 - Cadastrar um novo jogo\n"
                + "2 - Pesquisar jogo por nome\n" + "3 - Pesquisar por categoria\n"
                + "4 - Excluir jogo\n" + "5 - Editar jogo\n" + "6 - Listar por categoria\n"
                + "7 - Sair";
        int opcao = 0;
        do {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE));

            switch (opcao) {
                case 1:
                    String nomeJogo = JOptionPane.showInputDialog(null, "Qual o nome do jogo");
                    Jogo jogo = new Jogo(nomeJogo);
                    CategoriaDeJogo x = null;
                    int categoriadejogo = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a categoria do jogo\n"
                            + "1 - ACAO\n" + "2 - ARCADE\n" + "3 - AVENTURA\n" + "4 - CORRIDA\n" + "5 - GUERRA\n" + "6 - LUTA\n" + " 7 - TERROR\n"));
                    List<CategoriaDeJogo> games = new ArrayList<>();
                    switch (categoriadejogo) {

                        case 1:
                            x = CategoriaDeJogo.ACAO;
                            games.add(x);
                            break;

                        case 2:
                             x = CategoriaDeJogo.ARCADE;
                             games.add(x);
                            break;

                        case 3:

                             x = CategoriaDeJogo.AVENTURA;
                            games.add(x);
                            break;

                        case 4:
                             x = CategoriaDeJogo.CORRIDA;
                            games.add(x);
                            break;

                        case 5:
                             x = CategoriaDeJogo.GUERRA;
                            games.add(x);
                            break;

                        case 6:
                             x = CategoriaDeJogo.LUTA;
                            games.add(x);
                            break;

                        case 7:
                             x = CategoriaDeJogo.TERROR;
                            games.add(x);
                            break;

                    }

                    double precoJogo = Double.parseDouble(JOptionPane.showInputDialog(null, "qual o preço do jogo? use a estrutura 0.0"));

                    jogo.setPreco(precoJogo);
                    jogo.setCategorias(games);
                    sistema.cadastraJogo(jogo);
                    JOptionPane.showMessageDialog(null,"JOGO CADASTRADO COM SUCESSO.");

                    break;

                case 2:
                    sistema.a();
                    String nome = JOptionPane.showInputDialog(null, "Qual o nome do jogo");
                    if (sistema.existeJogoComNome(nome)) {
                        JOptionPane.showMessageDialog(null, "Existe o jogo :" + nome);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existe o jogo :" + nome);
                    }
                    sistema.a();
                    break;
                case 3:
                    CategoriaDeJogo categoriaJogo2 = null;
                    int categoriadejogo1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a categoria do jogo\n"
                            + "1 - ACAO\n" + "2 - ARCADE\n" + "3 - AVENTURA\n" + "4 - CORRIDA\n" + "5 - GUERRA\n" + "6 - LUTA\n" + " 7 - TERROR\n"));
                    switch (categoriadejogo1) {
                        case 1:
                            categoriaJogo2 = CategoriaDeJogo.ACAO;
                            break;

                        case 2:
                            categoriaJogo2 = CategoriaDeJogo.ARCADE;
                            break;

                        case 3:
                            categoriaJogo2 = CategoriaDeJogo.AVENTURA;
                            break;

                        case 4:
                            categoriaJogo2 = CategoriaDeJogo.CORRIDA;
                            break;

                        case 5:
                            categoriaJogo2 = CategoriaDeJogo.GUERRA;
                            break;

                        case 6:
                            categoriaJogo2 = CategoriaDeJogo.LUTA;
                            break;

                        case 7:
                            categoriaJogo2 = CategoriaDeJogo.TERROR;
                            break;

                    }
                    List<Jogo> categoriaDeJogoList = sistema.pesquisaJogosDaCategoria(categoriaJogo2);
                    JOptionPane.showMessageDialog(null, categoriaDeJogoList.toString());
                    break;
                case 4: {
                    String jogoRemover = JOptionPane.showInputDialog(null, "Qual o jogo para remover");
                    if (sistema.RemoveJogo(jogoRemover)) {
                        JOptionPane.showMessageDialog(null, "Jogo removido com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Problema ao remover o jogo, reveja o nome do jogo");
                    }
                }
                break;

                case 5: {
                    String jogoEditar = JOptionPane.showInputDialog(null, "Qual o jogo você deseja editar? ");

                    Jogo gameEditar = sistema.pesquisaPorNome(jogoEditar);

                    sistema.a();
                    int jogoEditarMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a categoria do jogo\n"
                            + "1 - Editar Nome\n" + "2 - Editar Categoria\n" + "3 - Editar preço\n"));

                    switch (jogoEditarMenu) {

                        case 1:
                            String NovoNome = JOptionPane.showInputDialog(null, "Qual o novo nome? ");
                            sistema.NomeNovo(NovoNome,gameEditar.getNome(),gameEditar);
                            System.out.println(NovoNome + gameEditar.getNome());
                            break;

                        case 2:
                            int categoria = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a categoria do jogo\n"
                                    + "1 - ACAO\n" + "2 - ARCADE\n" + "3 - AVENTURA\n" + "4 - CORRIDA\n" + "5 - GUERRA\n" + "6 - LUTA\n" + " 7 - TERROR\n"));
                            switch (categoria){
                                case 1:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.ACAO);
                                    break;

                                case 2:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.ARCADE);
                                    break;
                                case 3:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.AVENTURA);
                                    break;

                                case 4:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.CORRIDA);
                                    break;

                                case 5:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.GUERRA);
                                    break;

                                case 6:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.LUTA);
                                    break;

                                case 7:
                                    gameEditar.adicionaCategoria(CategoriaDeJogo.TERROR);
                                    break;

                            }
                            break;

                        case 3:
                            double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o novo preço? "));
                            sistema.NovoPreco(preco,gameEditar.getPreco());
                            break;


                    }
                    sistema.a();
                }

                break;

                case 6:
                    CategoriaDeJogo y = null;
                    int categoriadegame = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a categoria do jogo\n"
                            + "1 - ACAO\n" + "2 - ARCADE\n" + "3 - AVENTURA\n" + "4 - CORRIDA\n" + "5 - GUERRA\n" + "6 - LUTA\n" + " 7 - TERROR\n"));
                    List<CategoriaDeJogo> gamedeJogos = new ArrayList<>();
                    switch (categoriadegame) {

                        case 1:
                            y = CategoriaDeJogo.ACAO;
                            gamedeJogos.add(y);
                            break;

                        case 2:
                            y = CategoriaDeJogo.ARCADE;
                            gamedeJogos.add(y);
                            break;

                        case 3:

                            y = CategoriaDeJogo.AVENTURA;
                            gamedeJogos.add(y);
                            break;

                        case 4:
                            y = CategoriaDeJogo.CORRIDA;
                            gamedeJogos.add(y);
                            break;

                        case 5:
                            y = CategoriaDeJogo.GUERRA;
                            gamedeJogos.add(y);
                            break;

                        case 6:
                            y = CategoriaDeJogo.LUTA;
                            gamedeJogos.add(y);
                            break;

                        case 7:
                            y = CategoriaDeJogo.TERROR;
                            gamedeJogos.add(y);
                            break;

                    }

                    List<Jogo> gameCategoria = sistema.pesquisaJogosDaCategoria(y);
                    for (Jogo d : gameCategoria) {
                        JOptionPane.showMessageDialog(null, d.getNome() + " de preço: " + d.getPreco() + "\n");
                        System.out.println(d.getNome());
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema", "Saindo", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Op��o inv�lida", "Erro", JOptionPane.ERROR_MESSAGE);
            }


        } while (opcao != 7);
    }
}

