package br.ifes.projetosistemas.calculadora.controller;

import br.ifes.projetosistemas.calculadora.dto.RequestDTO;
import br.ifes.projetosistemas.calculadora.dto.ResponseDTO;
import br.ifes.projetosistemas.calculadora.model.Calc;
import br.ifes.projetosistemas.calculadora.model.CalcX;
import br.ifes.projetosistemas.calculadora.model.ICalc;
import br.ifes.projetosistemas.calculadora.model.operation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ControllerCalc {

    public ResponseDTO calc(RequestDTO requestDTO) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int result = 0;
        ICalc calc = null;
        if (Objects.equals(requestDTO.getOpcao(), "Somar")){
            calc = new Calc();

        }else {
            calc = new CalcX();
        }

        Class<?> operacao = Class.forName("br.ifes.projetosistemas.calculadora.model.operation." + requestDTO.getOpcao());
        IOperation Ioperation = (IOperation) operacao.getDeclaredConstructor().newInstance();
        result = calc.calculation(Ioperation,requestDTO.getValor1(),requestDTO.getValor2());
        return new ResponseDTO(result);
    }
}