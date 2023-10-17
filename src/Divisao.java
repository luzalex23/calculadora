public class Divisao extends AbstactCalc {

    public Divisao(){
        super();
    }
    @Override
    public double calcular(double num1, double num2){
        if (num2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        resultado = num1 / num2;
        return resultado;
    }
    
}
