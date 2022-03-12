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

        System.out.println("Informações do Ator!");
        String nome;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n\nDigite o nome do Ator ou x para sair: ");
            nome = scan.nextLine();
            if(nome.equals("x")){ System.exit(0);}
            fileActors.informacoesDoAtor(fileActress, nome);
        }while(true);
    }
}
