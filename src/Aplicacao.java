import br.com.letscode.model.Arquivo;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args){
        Arquivo fileActors = new Arquivo("oscar_age_male.csv");
        Arquivo fileActress = new Arquivo("oscar_age_female.csv");

        fileActors.atorMaisNovoAGanharOscar();

        fileActress.atrizQueMaisVezesGanhouOscar();

        fileActress.atrizQueMaisGanhouEntre20e30Anos();

        fileActors.atoresEAtrizesQueGanharamMaisDeUmOscar(fileActress);

        try{
            System.out.println("\n\nInformações do Ator!");
            menu(fileActors, fileActress);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Ator/Atriz não encontrado!");
            menu(fileActors, fileActress);
        }

    }

    public static void menu(Arquivo file, Arquivo otherFile){
        String nome;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\nDigite o nome do Ator ou x para sair: ");
            nome = scan.nextLine();
            if(nome.equals("x")){ System.exit(0);}
            file.informacoesDoAtor(otherFile, nome);
        }while(true);
    }
}
