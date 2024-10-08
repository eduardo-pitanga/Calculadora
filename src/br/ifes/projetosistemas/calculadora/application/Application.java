package br.ifes.projetosistemas.calculadora.application;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class<?> Menu = Class.forName("br.ifes.projetosistemas.calculadora.view.Menu");
            Object menu = Menu.getDeclaredConstructor().newInstance();
            Method show = Menu.getMethod("show");

            Object requestDTO = show.invoke(menu);

            Class<?> ControllerCalc = Class.forName("br.ifes.projetosistemas.calculadora.controller.ControllerCalc");
            Object controllerCalc = ControllerCalc.getDeclaredConstructor().newInstance();

            Method calc = ControllerCalc.getMethod("calc", Class.forName("br.ifes.projetosistemas.calculadora.dto.RequestDTO"));
            Object responseDTO = calc.invoke(controllerCalc, requestDTO);

            Method showResult = Menu.getMethod("showResult", Class.forName("br.ifes.projetosistemas.calculadora.dto.ResponseDTO"));
            showResult.invoke(menu, responseDTO);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
