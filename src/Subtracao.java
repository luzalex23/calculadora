public class Subtracao extends AbstactCalc{
    public Subtracao(){
        super();
    }
    @Override
    public double calcular(double num1, double num2) {
        resultado = num1 - num2;
        return resultado;
    }
}
