import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String mensagemCesar = "";
        StringBuilder builder = new StringBuilder();
        boolean menu = true;

        Scanner input = new Scanner(System.in);

        while(menu){
            System.out.println("\nVocê deseja:\n1) Criptografar\n2) Descriptografar\n3) Sair");
            int opcao = input.nextInt();
            input.nextLine();

            System.out.print("Deslocamento a direita: ");
            int numero = input.nextInt();
            input.nextLine();

            char letra;

            switch(opcao){
                case 1:{
                    System.out.print("Digite a mensagem a ser criptografada: ");
                    String mensagem = input.nextLine();
                    mensagem = mensagem.toUpperCase();

                    for (int i = 0; i < mensagem.length(); i++) {
                        letra = mensagem.charAt(i);
                        if(letra == ' '){
                            builder.append(' ');
                        }else{
                            for (int j = 0; j < alfabeto.length; j++) {
                                if (letra == alfabeto[j]){
                                    builder.append(alfabeto[(j + numero) % alfabeto.length]);
                                }
                            }
                        }
                    }
                    break;
                }

                case 2:{
                    System.out.print("Digite a mensagem a ser descriptografada: ");
                    String mensagem = input.nextLine();
                    mensagem = mensagem.toUpperCase();

                    for (int i = 0; i < mensagem.length(); i++) {
                        letra = mensagem.charAt(i);
                        if(letra == ' '){
                            builder.append(' ');
                        }else{
                            for (int j = 0; j < alfabeto.length; j++) {
                                if (letra == alfabeto[j]){
                                    builder.append(alfabeto[(j - numero + alfabeto.length) % alfabeto.length]);
                                }
                            }
                        }
                    }
                    break;
                }

                case 3:{
                    menu = false;
                    return;
                }

                default:{
                    System.out.println("Escolha uma opção válida!");
                }
            }

            mensagemCesar = builder.toString();
            builder.setLength(0);

            if(opcao == 1){
                System.out.println("Mensagem criptografada: " + mensagemCesar);
            }else{
                System.out.println("Mensagem descriptografada: " + mensagemCesar);
            }



        }
    }
}
