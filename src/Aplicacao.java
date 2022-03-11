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

        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nDigite o nome do Ator: ");
        String nome = scan.next();
        scan.close();

        fileActors.informacoesDoAtor(fileActress, nome);

    }
}
