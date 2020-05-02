import java.util.Scanner;
// Класс Lab1
public class Lab1{
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		// Ввод координат трех точек
		System.out.print("Input first point coordinates ");
		Point3d firstP = new Point3d();
		firstP.setX(scanner.nextDouble());
		firstP.setY(scanner.nextDouble());
		firstP.setZ(scanner.nextDouble());

		System.out.print("Input second point coordinates ");
		Point3d secondP = new Point3d();
		secondP.setX(scanner.nextDouble());
		secondP.setY(scanner.nextDouble());
		secondP.setZ(scanner.nextDouble());

		System.out.print("Input third point coordinates ");
		Point3d thirdP = new Point3d();
		thirdP.setX(scanner.nextDouble());
		thirdP.setY(scanner.nextDouble());
		thirdP.setZ(scanner.nextDouble());

		// Проверяем, составляют ли точки треугольник
		if ((firstP.Equal(secondP)) || (firstP.Equal(thirdP)) || (secondP.Equal(thirdP))) {
			System.out.print("Not a triangle ");
		}

		// Если составляют, то считаем и выводим площадь треугольника
		else {
			System.out.print("Area of triangle is " + computeArea(firstP, secondP, thirdP));

		}
	}

	public static double computeArea(Point3d q, Point3d w, Point3d e){
		//Вычисляем длины сторон
		double s;
		double qw = q.distanceTo(w);
		double we = w.distanceTo(e);
		double qe = q.distanceTo(e);

		//Полупериметр
		double p = (qw + we + qe) / 2;

		//Площадь по формуле Герона
		s = Math.sqrt(p*(p-qw)*(p-we)*(p-qe));
		return Math.round(s*100d)/100d;


	}
}