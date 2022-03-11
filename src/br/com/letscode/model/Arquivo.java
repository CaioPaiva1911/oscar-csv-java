package br.com.letscode.model;

import br.com.letscode.entity.Actor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arquivo {

    private final List<Actor> atoresList;

    public Arquivo(String nomeArquivo) {
        this.atoresList = lerArquivo(nomeArquivo);
    }

    public List<Actor> getAtoresList(){
        return atoresList;
    }

    private List<Actor> lerArquivo(String nomeArquivo) {
        try(Stream<String> fileLines = Files.lines(Paths.get(nomeArquivo))) {
            return fileLines
                    .skip(1)
                    .map(Actor::fromLine)
                    .collect(Collectors.toList());
        } catch (IOException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void atorMaisNovoAGanharOscar(){
        System.out.println("Ator/Atriz mais jovem a ganhar um Oscar!");
        //this.getAtoresList().stream().sorted().limit(1).forEach(System.out::println);
        this.getAtoresList()
                .stream()
                .min(Comparator.comparing(Actor::getAge))
                .ifPresent(c -> System.out.println("O ator mais jovem é o: "
                        + c.getName() + " com "
                        + c.getAge()
                        + " anos atuando no filme " + c.getMovie()));
    }

    public void atrizQueMaisVezesGanhouOscar(){
        System.out.println("\n\nQuem foi a(o) atriz/ator que mais vezes foi premiada?");
        Map<String, Long> atrizes = this.getAtoresList()
                .stream()
                .map(Actor::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        atrizes.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(c -> System.out.println(c.getKey() + " ganhou " + c.getValue() + " vezes o prêmio"));
    }

    public void atrizQueMaisGanhouEntre20e30Anos(){
        System.out.println("\n\nQual atriz entre 20 e 30 anos que mais vezes foi vencedora?");
        Map<String, Long> atrizes = this.getAtoresList()
                .stream()
                .filter(a -> a.getAge() >= 20 && a.getAge() <= 30)
                .map(Actor::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //Captura o maior valor
        Long valor;
        valor = atrizes.entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue)).get().getValue();

        atrizes.entrySet()
                .stream()
                .filter(a -> a.getValue().equals(valor))
                .forEach( a -> System.out.println(a.getKey() + " ganhou " + a.getValue() + " vezes"));
    }

    public void atoresEAtrizesQueGanharamMaisDeUmOscar(Arquivo file){

        System.out.println("\n\nQuais atores ou atrizes receberam mais de um Oscar?");
        Map<String, Long> allActors = Stream.concat(this.getAtoresList().stream(), file.getAtoresList().stream())
                 .map(Actor::getName)
                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

         allActors.entrySet()
                 .stream()
                 .filter(a -> a.getValue() >= 2)
                 .sorted(Map.Entry.comparingByKey())
                 .forEach( a -> System.out.println(a.getKey() + " ganhou " + a.getValue() + " vezes"));
    }

    public void informacoesDoAtor(Arquivo file, String nome){

        Map<Actor, Long> allActors = Stream.concat(this.getAtoresList().stream(), file.getAtoresList().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        allActors.
                forEach((key, value) -> System.out.println(key + " ganhou " + value + " vezes"));
        /*
        //Salvar uma lista de objetos como chave e utilizar atributo como valor no Stream
        allActors.entrySet()
                .stream()
                .filter(a -> a.getKey().getName().equals(nome))
                .forEach( a -> System.out.println(a.getKey().getName() + " ganhou " + a.getValue() + " vezes"));
         */
    }
}
