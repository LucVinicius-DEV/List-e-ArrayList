// aula sobre listas (List e ArrayList)

import java.util.ArrayList; // importando a classe ArrayList
import java.util.List; // importando a interface List
import java.util.stream.Collectors; // importando a classe Collectors

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(); // criando uma lista de strings

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");

        list.add(2, "Marco"); // adicionando um elemento na posição 2

        System.out.println(list.size()); // imprimindo o tamanho da lista

        list.remove("Anna"); // removendo um elemento da lista
        list.remove(1); // removendo um elemento da lista pela posição

        list.removeIf(x -> x.charAt(0) == 'M'); // removendo um elemento da lista com uma função lambda

        System.out.println("Index of Bob: " + list.indexOf("Bob")); // imprimindo a posição do elemento Bob

        System.out.println("Index of Marco: " + list.indexOf("Marco")); // imprimindo a posição do elemento Marco, que não existe por isso retorna -1
            for (String x : list) {
               System.out.println(x); // imprimindo a lista
            }

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); // criando uma nova lista com os elementos que começam com a letra A
        for (String x : result){
            System.out.println(x); // imprimindo a nova lista
        }

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null); // criando uma variável com o primeiro elemento que começa com a letra A
        System.out.println(name); // imprimindo a variável
     }
}
