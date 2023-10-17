public abstract class AbstactCalc implements ICalculator {
    
        // A classe AbstactCalc esta implementando a interface ICalculator.

        //---os métodos abaixo são da própria classe abstrata--//
        protected double resultado;

        public AbstactCalc() {
            resultado = 0.0;
        }
    
        @Override
        public double calcular(double num1, double num2) {
            return 0.0; // Implementação padrão
        }

}
