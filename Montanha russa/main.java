import static java.lang.Math.floor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        Passageiros passag = new Passageiros();
        Carros carros = new Carros();

        System.out.println("Entre com uma quantidade de pessoas (Capacidade maxima 100): ");
        passag.n = ler.nextInt();

        System.out.println("Entre com a quantidade de carros(minimo 1 // maximo 8): ");
        carros.C = ler.nextInt();

        System.out.println("Entre com a quantidade de lugares no carrinho: ");
        carros.L = ler.nextInt();

        System.out.println("Entre com o tempo de Embarque/Desembarque: ");
        passag.Te = ler.nextInt();

        System.out.println("Entre com o tempo do Passeio da Montanha Russa: ");
        passag.Tp = ler.nextInt();

     

        int ca = carros.C;

       
     
        Semaphore sem = new Semaphore(1);
        //Switch Case- O Switch Case está aqui para controlar quantas threads(carrinhos) serão criados;
        switch (ca) {
            case 1:
                ThreadCarrinho t1 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                break;
            case 2:
                ThreadCarrinho t2 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t3 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                break;
            case 3:
                ThreadCarrinho t37 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t38 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                ThreadCarrinho t39 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                break;
            case 4:
                ThreadCarrinho t7 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t8 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                ThreadCarrinho t9 = new ThreadCarrinho("Carrinho3", "embarque", sem);
                ThreadCarrinho t10 = new ThreadCarrinho("Carrinho4", "embarque", sem);
                break;
            case 5:
                ThreadCarrinho t11 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t12 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                ThreadCarrinho t13 = new ThreadCarrinho("Carrinho3", "embarque", sem);
                ThreadCarrinho t14 = new ThreadCarrinho("Carrinho4", "embarque", sem);
                ThreadCarrinho t15 = new ThreadCarrinho("Carrinho5", "embarque", sem);
                break;
            case 6:
                ThreadCarrinho t16 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t17 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                ThreadCarrinho t18 = new ThreadCarrinho("Carrinho3", "embarque", sem);
                ThreadCarrinho t19 = new ThreadCarrinho("Carrinho4", "embarque", sem);
                ThreadCarrinho t20 = new ThreadCarrinho("Carrinho5", "embarque", sem);
                ThreadCarrinho t21 = new ThreadCarrinho("Carrinho6", "embarque", sem);
                break;
            case 7:
                ThreadCarrinho t22 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t23 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                ThreadCarrinho t24 = new ThreadCarrinho("Carrinho3", "embarque", sem);
                ThreadCarrinho t25 = new ThreadCarrinho("Carrinho4", "embarque", sem);
                ThreadCarrinho t26 = new ThreadCarrinho("Carrinho5", "embarque", sem);
                ThreadCarrinho t27 = new ThreadCarrinho("Carrinho6", "embarque", sem);
                ThreadCarrinho t28 = new ThreadCarrinho("Carrinho7", "embarque", sem);
                break;
            case 8:
                ThreadCarrinho t29 = new ThreadCarrinho("Carrinho1", "embarque", sem);
                ThreadCarrinho t30 = new ThreadCarrinho("Carrinho2", "embarque", sem);
                ThreadCarrinho t31 = new ThreadCarrinho("Carrinho3", "embarque", sem);
                ThreadCarrinho t32 = new ThreadCarrinho("Carrinho4", "embarque", sem);
                ThreadCarrinho t33 = new ThreadCarrinho("Carrinho5", "embarque", sem);
                ThreadCarrinho t34 = new ThreadCarrinho("Carrinho6", "embarque", sem);
                ThreadCarrinho t35 = new ThreadCarrinho("Carrinho7", "embarque", sem);
                ThreadCarrinho t36 = new ThreadCarrinho("Carrinho8", "embarque", sem);
                break;

        }
        
        while (true) {
            if (passag.n <= 100) {//Controle da Fila, aqui definimos quantas pessoas poderam chegar na Fila, nunca passará acima de 110

                Random aleatorio = new Random();
                int valor = aleatorio.nextInt(30);//Tempo aleatório para chegada de novas pessoas na fila(vai de 0 ate 30 segundos)
                int PR = aleatorio.nextInt(5);//Quantidade de pessoas que chegaram na fila, após o tempo aleatório(vai de 0 ate 5 pessoas
               
                passag.Tr = valor;

                try {
                    // Ao fim do tempo aleatório é apresentado na tela, a quantidade de pessoas na fila
                	//quantidade de carrinhos cheios e a quantidade de carros selecionada

                    TimeUnit.SECONDS.sleep(passag.Tr);
                    passag.n = passag.n + PR;
                    if(passag.n<0) {
                    	System.out.println(" -----------------");
                    	System.out.println("Agurdando " + (passag.n*-1)+(" para encher o carrinho"));
                    }else {
                    	System.out.println("-------------- ");
                    System.out.println("Fila atualmente " + passag.n);}
                    // quando o número ficar negativo, o ultimo carrinho que não foi preenchido totalmene, irá esperar, preencher todos os lugares para sair.
                    

                    
                    System.out.println("Carrinhos cheios = " + passag.carrinhoCheio);
                    System.out.println("Quantidade de carros = " + carros.C);
                    System.out.println("-------------------- ");
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }

    }

}
