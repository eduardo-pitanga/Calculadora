package br.ifes.projetosistemas.calculadora.model;

import br.ifes.projetosistemas.calculadora.model.operation.IOperation;

public class Calc implements ICalc{

    public int calculation (IOperation operation, int value1, int value2){

        return operation.calc(value1,value2);
    }

}
