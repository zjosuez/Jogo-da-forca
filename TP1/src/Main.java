
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       menu();
       
    }
    static String [][] temas = new String[51][51];
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void menu() {
        
        System.out.println("---Bem vindo ao jogo da forca!---\n");
        System.out.println("[1] Gerenciar Temas");
        System.out.println("[2] Gerenciar Palavras");
        System.out.println("[3] Jogar");
        System.out.println("[4] Sair\n");
        System.out.print("Digite um valor de 1-5: ");
        int valor1 = input.nextInt();

        switch(valor1) {
            case 1:
                temasMenu();
                break;
            case 2:
                palavrasMenu();
                break;
            case 3:
                game();
                break;
            case 4:
                System.out.println("\nJogo finalizado!");
                break;
            default:
                System.out.println("Valor inv?lido, digite novamente.");
                menu();
                break;
        }
    }

    // Menu dos temas.
    public static void temasMenu() {
        System.out.println("\n---Digite o numero da a??o que dejesa realizar---\n ");
        System.out.println("[1] Cadastrar Tema");
        System.out.println("[2] Excluir Tema");
        System.out.println("[3] Buscar Tema");
        System.out.println("[4] Gerar 5 temas automaticamente");
        System.out.println("[5] Voltar\n");
        System.out.print("Digite um valor de 1-5: ");
        int valor2 = input.nextInt();
         switch (valor2) {
            case 1:
                gerenciarTemas(1);
                break;
            case 2:
                gerenciarTemas(2);
                break;
            case 3:
                gerenciarTemas(3);
                break;
            case 4:
                gerarTemas();
                break;
               
            case 5:
                menu();
                break;
            default:
                System.out.println("Valor invalido, digite novamente.");
                temasMenu();
                break;
         }
    }

    // Menu das palavras.

    public static void palavrasMenu () {
        System.out.println("\n---Digite o numero da a??o que dejesa realizar---\n ");
        System.out.println("[1] Cadastrar Palavra");
        System.out.println("[2] Excluir Palavra");
        System.out.println("[3] Buscar Palavra");
        System.out.println("[4] Listar palavras");
        System.out.println("[5] Gerar 10 palavras para os 5 primeiros temas.");
        System.out.println("[6] Voltar");
        System.out.print("\nDigite um numero de 1-6: ");
        int valorPalavra = input.nextInt();

         switch (valorPalavra) {
            case 1:
                gerenciarPalavras(1);
                break;
            case 2:
                gerenciarPalavras(2);
                break;
            case 3:
                gerenciarPalavras(3);
                break;
            case 4:
                gerenciarPalavras(4);
                break;
            case 5:
                gerarPalavras();
                break;
            case 6:
                menu();
                break;
            default:
                System.out.println("Valor invalido, digite novamente.");
                palavrasMenu();
                break;
         }
    }

    public static void gerenciarTemas(int valor2) {
        // ---------------------------------------Cadastrar Temas.--------------------------------------
        if (valor2 == 1) {
        System.out.println("\nQuantidade de temas que deseja cadastrar:\n");
        System.out.print("Digite um numero de 1-50: ");
        int qtdTemas = input.nextInt();
        int k = 1;

        for (int l = 0; l < temas.length; l++) {
            if (temas[l][0] == null) {
                temas[l][0] = "";
            }
        }
        
        // Estrutura de repeti??o para armazenar os temas no array.
        for(int i = 0; i < qtdTemas; i++) {
            System.out.println("\nQual ? o nome do tema " + k + "? tema?\n");
            System.out.print("Digite o nome: ");
            String valor = input.next().toLowerCase();
            if (temas[i][0] == null) {
                temas[i][0] = "";
            }

            // Removendo temas repetidos.
            for (int j = 0; j < qtdTemas; j++) {
                
                if (valor.equals(temas[j][0])) {
                    temas[j][0] = temas[j + 1][0];
                    System.out.println("Tema j? foi inserido");
                }
            }
            for(int aux = 0; aux < temas.length; aux++) {
                if (temas[aux][0] == "" || temas[aux][0] == null) {
                    temas[aux][0] = valor;
                    break;
                }
            }   
            k++;
            
            }
            
        System.out.println("\nOs temas foram cadastrados com sucesso!\n");
        temasMenu();
        }
        
        // ---------------------------------------Excluir Temas.--------------------------------------
        if (valor2 == 2) {
            System.out.print("Digite o nome do tema que deseja remover: ");
            String remover = input.next().toLowerCase();

            // Excluindo o tema que o usu?rio deseja.
            for (int i = 0; i < temas.length; i++) {
                if (remover.equals(temas[i][0])) {
                    temas[i][0] = null;
                    System.out.println("\nTema removido com sucesso!");
                } 
                if (i == temas.length) {
                    System.out.println("Tema n?o encontrado.");
                    temasMenu();
                }
            }
            
            temasMenu();
        }
           
        // ---------------------------------------Buscar Temas.--------------------------------------
        if (valor2 == 3) {
            System.out.println("\nQual tema deseja buscar?\n ");
            System.out.print("Digite o nome do tema: ");
            String buscaPalavra1 = input.next().toLowerCase();
            boolean vCadastro = false;  

            for (int l = 0; l < temas.length; l++) {
                if (temas[l][0] == null) {
                    temas[l][0] = "";
                }
            }

            for (int i = 0; i < temas.length; i++) {
                if (temas[i][0].equals(buscaPalavra1)) {
                    System.out.println("\nO tema " + buscaPalavra1 + " est? cadastrado.");
                    vCadastro = true;
                    
                }
            }
            if (vCadastro == false) {
                System.out.println("\nO tema " + buscaPalavra1 + " n?o est? cadastrado.");
                
            }
            temasMenu();
        }   
    }

    public static void gerenciarPalavras(int valorPalavra) {
        if (valorPalavra == 1) {
            System.out.println("\nTemas cadastrados: ");
            
            // Mostrando os temas que j? foram cadastrados.
            for (int i = 0; i < temas.length; i++) {
                if (temas[0][0] == null) {
                    System.out.println("Nunhum tema foi inserido, insira um tema para cadastrar as palavras");
                    palavrasMenu();
                }
                if (!temas[i][0].equals("")) {
                    System.out.println("\n" + temas[i][0]);
                }

                for (int j = 0; j < temas.length; j++) {
                    if (temas[i][j] == null) {
                        temas[i][j] = "";
                    }
                } 
            }
            
            // Cadastrando as palavras
            System.out.print("\nDigite o nome do tema que deseja cadastrar a palavra: ");
            String temaEscolha = input.next().toLowerCase();

            System.out.print("\nQuantidade de palavras que deseja cadastrar(1-50): ");
            int qtdPalavras = input.nextInt();
            if (qtdPalavras > 50) {
                System.out.println("So pode inserir 50 palavras no m?ximo.");
                
            }
            int k = 1;
            // Estrutura de repeti??o para armazenar as palavras no array.
            String [] palavraEscolha = new String [qtdPalavras];
            for(int i = 0; i < qtdPalavras; i++) {
                
                System.out.println("\nQual ? a " + k + "? palavra que deseja cadastrar?");
                System.out.print("Digite a palavra: ");
                String palavraArm = input.next().toLowerCase();
                palavraEscolha[i] = palavraArm;
                k++;
            }

            // Armazenando as palavras no tema escolhido.
            for (int l = 0; l < temas.length; l++) {
                if (temas[l][0].equals(temaEscolha)) {
                    for (int m = 0; m < qtdPalavras; m++) {
                        temas[l][m + 1] = palavraEscolha[m];
                    }  
                }           
            }

            System.out.println("\nAs palavras foram cadastrados com sucesso!\n");
            palavrasMenu();
        }
        // -------------------------------------Excluir Palavra-------------------------------------------------
        if (valorPalavra == 2) {
            System.out.println("\nQual o tema da palavra que deseja excluir?");

            // Mostrando os Temas cadastrados.
            for (int i = 0; i < temas.length; i++) {
                if (temas[0][0] == null) {
                    System.out.println("Nunhum tema foi inserido, volte e insira um tema para cadastrar as palavras");
                    palavrasMenu();
                }
                if (!temas[i][0].equals("")) {
                    System.out.println("\n" + temas[i][0]);
                }
            }
            System.out.print("\nDigite o tema: ");
            String removerTema = input.next().toLowerCase();
            System.out.println("\nDigite a palavra que deseja remover.");

            // Mostrando as palavras cadastradas no tema inserido.
            for (int i = 0; i < temas.length; i++) {
                if (removerTema.equals(temas[i][0])) {
                    for (int j = 1; j < temas.length; j++) {
                        if (!temas[i][j].equals("")) {
                            System.out.println("\n" + temas[i][j]);
                        }
                    }
                }
            }
            System.out.print("\nNome da palavra: ");
            String removerPalavra = input.next().toLowerCase();

            // Removendo palavra do tema escolhido.
            for(int i = 0; i < temas.length; i++) {
                if (removerTema.equals(temas[i][0])) {
                    for (int j = 1; j < temas.length; j++) {
                        if (removerPalavra.equals(temas[i][j])) {
                            for(int k = j; k < temas.length - 1; k++) {
                                temas[i][k] = temas[i][k + 1];
                                temas[i][k + 1] = "";
                            }
                            System.out.println("\nPalavra removida com sucesso!");
                            palavrasMenu();
                        }
                    }
                } 
            }

            
        }
        // -------------------------------------Buscar Palavra---------------------------------------------------
        if (valorPalavra == 3) {
            System.out.print("\nDigite o nome da palavra  que procura: ");
            String procurarPalavra = input.next().toLowerCase();
            int teste = 0;
            // Percorrendo linhas e colunas do array para encontrar a palavra.
            for (int i = 0; i < temas.length; i++) {
                for (int j = 1; j < temas.length; j++) {
                    if (procurarPalavra.equals(temas[i][j])) {
                        System.out.println("\nPalavra encontrada no tema: " + temas[i][0]);
                        teste += 1;
                    }
                }
            }
            // Caso n?o tenha a palavra no array, sera printado que a palavra n?o foi encontrada.
            if (teste == 0) {
                System.out.println("\nPalavra n?o encontrada.");
            }
            palavrasMenu();
        }
        // -------------------------------------Lista de palavras------------------------------------------------
        if (valorPalavra == 4) {
            System.out.println("\nDeseja ver as palavras de qual tema?");
            // Mostrando os temas que foram inseridos
            for (int i = 0; i < temas.length; i++) {
                if (temas[0][0] == null) {
                    System.out.println("Nunhum tema foi inserido, volte e insira um tema para cadastrar as palavras");
                    palavrasMenu();
                }
                if (!temas[i][0].equals("")) {
                    System.out.println("\n" + temas[i][0] + "\n");
                }
            }
            System.out.print("Digite o tema: ");
            String temaVer = input.next().toLowerCase();

            for (int i = 0; i < temas.length; i++) {
                if (temaVer.equals(temas[i][0])) {
                    for(int j = 1; j < temas.length; j++) {
                        
                        if (temas[i][j] == null) {
                            System.out.println("Nenhuma palavra foi inserida, volte e insira uma palavra.");
                            palavrasMenu();
                        }
                        if (!temas[i][j].equals("")) {
                            System.out.println("\n" + temas[i][j]);

                        }
                    }
                }
            }
            palavrasMenu();
        }
    }

    public static void game() {
        System.out.println("\n---Bem vindo ao jogo da Forca!---\n");
        System.out.println("Escolha um tema: ");

        // Mostrando os Temas Cadastrados.
        for (int i = 0; i < temas.length; i++) {
            if (temas[0][0] == null) {
                System.out.println("Nunhum tema foi inserido, volte e insira um tema para cadastrar as palavras");
                palavrasMenu();
            }
            if (!temas[i][0].equals("")) {
                System.out.println("\n" + temas[i][0] + "\n");
            }
        }
        System.out.print("Digite o tema: ");
        String temaSelecionado = input.next().toLowerCase();
        String [] bancoPalavras = new String [51];
        
        int aux = 0;

        // Loop para armazenar as palavras que foram cadastradas em um novo array.
        for (int j = 0; j < temas.length; j++) {
            if (temaSelecionado.equals(temas[j][0])) {
                for (int k = 1, l = 0; k < temas.length; k++) {
                    if (!temas[j][k].equals("")) {
                        bancoPalavras[l] = temas[j][k];
                        l++;
                    }
                }
            }
        }
        
        // Loop para selecionar apenas as posi??es que cont?m palavras.
        for (int n = 0; n < temas.length; n++) {
            if(bancoPalavras[n] != null) {
                aux += 1;
            }
        }

        // Pegando palavras aleat?rias dentro do array "bancoPalavras".
        int posicaoPalavra = random.nextInt(aux);
        String palavraEscolhida = bancoPalavras[posicaoPalavra];
        char [] encontrada = new char[palavraEscolhida.length()];
        boolean condicao = false;
        int qtdErros = 5;
        

        // Loop para mostrar quantas letras tem a palavra.
        while (!condicao) {
            System.out.println("\nQual ? a letra?\n");
            System.out.print("Digite a letra: ");
            char letraTentada = input.next().toLowerCase().charAt(0);
            boolean vidaPerdida = true;

            // Verificando se a letra foi encontrada.
            for( int j = 0; j < palavraEscolhida.length(); j++) {
                if (letraTentada == palavraEscolhida.charAt(j)) {
                    
                    encontrada[j] = 1;
                    vidaPerdida = false;
                }
            }
            
            if (vidaPerdida) {
                qtdErros--;
                System.out.println("Voc? tem " + qtdErros + " de vida");
            }
            
            condicao = true;

            // Verificando se a entrada do usuario foi encontrada.
            for (int i = 0; i < palavraEscolhida.length(); i++) {
                if (encontrada[i] == 0) {
                    System.out.print(" _ ");
                    condicao = false;
                    
                }
                else {
                    System.out.print(" " + palavraEscolhida.charAt(i) + " ");
                }
            }
            if (condicao != false) {
                System.out.println("\n\nParabens voce acertou, a palavra ?: " + palavraEscolhida);
                System.out.println("\nDeseja jogar novamente?\n[1] Para jogar novamente\n[2] para sair");
                
                    int fimJogo = input.nextInt();
                    if (fimJogo == 1) {
                        game();
                    }
            }

            if (qtdErros == 0) {
                System.out.println("\n\nVoce perdeu todas as vidas!\n");
                System.out.println("Deseja jogar novamente?\n[1] Para jogar novamente\n[2] para sair");
                int fimJogo = input.nextInt();
                if (fimJogo == 1) {
                    game();
                    break;
                } 
                else if (fimJogo == 2) {
                    break;
                }
            } 
        }
        menu();
    }

    public static void gerarTemas() {
        for (int i = 0, j = 1; i < 5; i++, j++) {
            temas[i][0] = "tema" + j;
        }
        System.out.println("\nTemas gerado com sucesso!");
        temasMenu();
    }

    public static void gerarPalavras() {

        for (int i = 0; i < temas.length; i++) {
            for(int j = 0; j < temas.length; j++) {
                if (temas[i][j] == null) {
                    temas[i][j] = "";
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= 10; j++) {
                temas[i][j] = "palavra" + j;
            }
        }
        System.out.println("\nPalavras gerada com sucesso!");
        palavrasMenu();
    }
}