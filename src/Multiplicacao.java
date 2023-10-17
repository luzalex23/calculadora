public class Multiplicacao extends AbstactCalc {

    public Multiplicacao(){
        super();
    }

    @Override
    public double calcular(double num1, double num2){
        resultado = num1 * num2;
        return resultado;
    }
    public double calcular(double num1, double num2, double num3) {
        resultado = num1 * num2 * num3;
        return resultado;
    }
   
}
