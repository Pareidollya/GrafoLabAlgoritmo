
package exercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jjao
 */
public class Exercicio7 {

    static int n = 5000; //numero de vertices 
    
    public static void main(String[] args) throws FileNotFoundException {
        
        
        LinkedList [] grafo = new LinkedList[n];
        ligarLista(grafo);
        int vertices = 0;
        int j = 0;
              
        try(Scanner scanner = new Scanner (new File("src/exercicio7/grafo-25000.txt"))){               
            while (scanner.hasNext()){       
               String linha = scanner.nextLine();
               String[] vertice = linha.split("\t"); //separar as linhas e adicionar ao vetor
                 
               for (int i = 0; i < vertice.length - 1; i++){ //adicionar as linhas a lista de adjacencia
               grafo[vertices].add(vertice[i]); //adicionar os valores do vertice dentro da lista em posição [j]
               }
               vertices++; //ao passar para uma nova linha, icrementa um novo vertice
            }
            
            System.out.println("O grafo possui: " + vertices +" vértices." );   
            print(grafo);
            complexidade(grafo);
       }       
    }
    
    static void ligarLista(LinkedList[] grafo) {
        for (int i = 0; i < n; i++) {
            grafo[i] = new LinkedList();
        }  
    }
    static void print(LinkedList[] grafo){
        for (int i = 0; i < n; i++) {
            System.out.print(grafo[i].getFirst() + ": " + grafo[i].size() + " vértices adjacentes.");
            System.out.println();
         }
    }
    static void complexidade(LinkedList[] grafo){ 
        int vertices = grafo.length;
        int arestas = 0;
        for (int k = 0; k<vertices;k++){
            arestas = arestas + grafo[k].size();
        }
        System.out.println("\nComplexidade: "+ (arestas + vertices) +".\n"+vertices+" vertices, "+arestas+" arestas.");
        
    } 
}
