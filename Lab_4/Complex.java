public class Complex {
    private double real;
    private double imaginary;
    public Complex(double real, double imaginary){
        this.imaginary = imaginary;
        this.real = real;
    }
    public double real(){
        return real;
    }
    public double imaginary(){
        return imaginary;
    }
    // Получение комплексного числа
    public double abs(){
        return real * real - imaginary * imaginary;
    }
    // Сложение комплексных чисел
    public Complex add(Complex term){
        double real = this.real + term.real();
        double imaginary = this.imaginary + term.imaginary();
        return new Complex(real, imaginary);
    }
    // Умножение комплексных чисел
    public Complex mul(Complex multiplier){
        double real = this.real * multiplier.real() - this.imaginary * multiplier.imaginary();
        double imaginary = this.real * multiplier.imaginary() + this.imaginary * multiplier.real();
        return new Complex(real, imaginary);
    }
}
