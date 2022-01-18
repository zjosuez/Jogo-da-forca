
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo da forca!");
        System.out.println("[1] Gerenciar Temas");
        System.out.println("[2] Gerenciar Palavras");
        System.out.println("[3] Jogar");
        System.out.println("[4] Sair");
        int valor = input.nextInt();

        switch(valor) {
            case 1:
                gerenciarTemas();
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            default:
                System.out.println("Valor invalor, digite novamente.");
                break;
        }

        
    }
    public static void gerenciarTemas() {
        Scanner input = new Scanner(System.in);

        System.out.println("Quantidade de temas que deseja cadastrar: ");
        int qtdTemas = input.nextInt();
        String [][] temas = new String[50][50];
        
        int k = 1;
        
        // Estrutura de repetição para armazenar os temas no array.
        for(int i = 0; i < qtdTemas; i++) {
            System.out.println("Qual é o nome do tema " + k + "º tema?");
            String valor = input.next();
            temas[i][0] = valor;
            k++;
        
        }
        
           
            


        
        System.out.println(Arrays.deepToString(temas));
    }
    public static void removeElement(String [][] userInput, String toRemove) {
        
        for (int i = 0; i < userInput.length; i++) {
            
            if (userInput[i][0].equals(toRemove)) {
                userInput[i][0] = userInput[i + 1][0];
            }
        }
    }
}
