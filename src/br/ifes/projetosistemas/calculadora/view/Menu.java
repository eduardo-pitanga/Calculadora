package br.ifes.projetosistemas.calculadora.view;

import br.ifes.projetosistemas.calculadora.dto.RequestDTO;
import br.ifes.projetosistemas.calculadora.dto.ResponseDTO;
import br.ifes.projetosistemas.calculadora.model.operation.IOperation;
import org.reflections.Reflections;

import java.util.Scanner;
import java.util.Set;

public class Menu {

    public RequestDTO show(){
        this.showMenu();
        return this.captureValues();
    }

    private RequestDTO captureValues (){

        Scanner input = new Scanner(System.in);
        String opcao = input.nextLine();
        System.out.println("Informe o primeiro valor:");
        int valor1 = input.nextInt();
        System.out.println("Informe o segundo valor:");
        int valor2 = input.nextInt();

        return new RequestDTO(opcao,valor1,valor2);
    }

    private void showMenu(){

        Reflections reflections = new Reflections("br.ifes.projetosistemas.calculadora.model.operation");

        Set<Class<? extends IOperation>> classes = reflections.getSubTypesOf(IOperation.class);

        System.out.println("---->Olá Meu fi!<----");
        System.out.println("Escolha uma das opções:");

        for (Class<? extends IOperation> clazz : classes) {
            System.out.println("1 - " + clazz.getSimpleName());
        }
    }
    public void showResult (ResponseDTO responseDTO){
        System.out.println("O Resultado é: "+responseDTO.getResult());
    }
}