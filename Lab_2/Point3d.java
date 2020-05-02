// Класс точки в трехмерном пространстве
public class Point3d{
	// Координата X
	private double xCoord;
	// Координата Y
	private double yCoord;
	// Координата Z
	private double zCoord;
	// Конструктор инициализации
	public Point3d (double x, double y, double z){
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}

	// Конструктор по умолчанию
	public Point3d (){
		this(0, 0, 0);
	}

	// Возвращение координаты X
	public double getX() {
		return xCoord;
	}

	// Возвращение координаты Y
	public double getY(){
		return yCoord;
	}

	// Возвращение координаты Z
	public double getZ(){
		return zCoord;
	}

	// Установка значения координаты X
	public void setX(double val){
		xCoord = val;
	}

	// Установка значения координаты Y
	public void setY(double val){
		yCoord = val;
	}

	// Установка значения координаты Z
	public void setZ(double val){
		zCoord = val;
	}

	// Сравнивание точек
	public boolean Equal (Point3d q){
		if (xCoord == q.getX() && (yCoord == q.getY()) && (zCoord == q.getZ())) {
			return true;
		}
		return false;
	}

	// Расстояние между точками
	public double distanceTo (Point3d q){
		double xa = xCoord;
		double ya = yCoord;
		double za = zCoord;
		double xq = q.getX();
		double yq = q.getY();
		double zq = q.getZ();
		double distance = Math.sqrt((Math.pow((xq - xa), 2)) + (Math.pow((yq - ya), 2)) + (Math.pow((zq - za), 2)));
		return Math.round(distance * 100d)/100d;

	}
}