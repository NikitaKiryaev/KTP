import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FractalExplorer extends JFrame{
	/**
	 * Класс реализации GUI
	 */
	private JImageDisplay image;
	private JButton reset;
	private  JButton save;
	private final Rectangle2D.Double rectangle;
	private FractalGenerator fractal;
	private final int size;
	private JComboBox comboBox = null;
	private int remain;
	public FractalExplorer(int size) {
		this.size = size;
		this.rectangle = new Rectangle2D.Double(0, 0, size, size);
		// Отрисовка окна
		createAndShowGUI(new Dimension(size, size));
		fractal = new Mandelbrot();
		fractal.getInitialRange(rectangle);
		// Отрисовка фрактала
		drawFractal();
	}
	// Отрисовка GUI изображения
	private void createAndShowGUI(Dimension dim){
		reset = new JButton("Reset Fractal");
		reset.setBackground(Color.GRAY);
		// Обработка нажатия
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				fractal.getInitialRange(rectangle);
				drawFractal();
			}
		});
		// Параметры кнопки сохранения
		save = new JButton("Save Fractal");
		save.setBackground(Color.GRAY);
		// Обработка нажатия
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JFileChooser chooser = new JFileChooser();
				// Инициализация фильтра
				FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
				chooser.setFileFilter(filter);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showDialog(null, "Выбрать файл");
				// Путь к файлу и его сохранение
				File file = chooser.getSelectedFile();
				BufferedImage buffer = image.getImage();
				try {
					ImageIO.write(buffer, "PNG", file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		// Параметры окна
		setSize(dim.width, dim.height + reset.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Коллекция фракталов
		FractalGenerator[] fractals = {new Mandelbrot(), new Tricorn(), new BurningShip()};
		// Список
		comboBox = new JComboBox(fractals);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JComboBox box = (JComboBox) actionEvent.getSource();
				fractal = (FractalGenerator) box.getSelectedItem();
				fractal.getInitialRange(rectangle);
				drawFractal();
			}
		});		
		int height = dim.height - reset.getHeight();
		image = new JImageDisplay(height, dim.width);
		image.clearImage();

		// Обработка нажатия мыши
		image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				if (remain < 1);
				int x = a.getX();
				int y = a.getY();
				double xCoord = FractalGenerator.getCoord(rectangle.x, rectangle.x + rectangle.width, size,x);
				double yCoord = FractalGenerator.getCoord(rectangle.y, rectangle.y + rectangle.height, size,y);
				fractal.recenterAndZoomRange(rectangle,xCoord,yCoord,0.5);
				drawFractal();
			}
		});
		// Создание контекстной панели
		JPanel panel = new JPanel();
		panel.add(reset);
		panel.add(save);

		add(image, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		add(comboBox, BorderLayout.NORTH);
		// Отображение окна
		pack ();
		setVisible (true);
		setResizable (false);
	}
	// Метод рассчета отрисовки фрактала
	private void drawFractal() {
		enableUI(false);
		remain = size - 1;
		for(int y = 0; y < size; y++)
			new FractalWorker(y).execute();
	}
	private void enableUI(boolean enabled){
		comboBox.setEnabled(enabled);
		save.setEnabled(enabled);
		reset.setEnabled(enabled);
	}
	private class FractalWorker extends SwingWorker<Object, Object>{
		// Координата строки
		private int y;
		private int[] yLineColor = new int[size];
		public FractalWorker(int y){
			this.y = y;
		}

		@Override
		protected Object doInBackground() throws Exception {
			// Координата y фрактала
			double yCoord = FractalGenerator.getCoord(rectangle.y, rectangle.y + rectangle.height, size, y);
			for(int x = 0; x < size; x++){
				// Координата x фрактала
				double xCoord = FractalGenerator.getCoord(rectangle.x, rectangle.x + rectangle.width, size, x);
				int iteration = fractal.numIterations(xCoord, yCoord);

				// Проверка на превышение итераций
				if (iteration == -1)
					yLineColor[x] = 0;
				else {
					float hue = 0.5f + (float) iteration / 200f;
					int rgbColor = Color.HSBtoRGB(hue, 0.7f, 1.0f);
					yLineColor[x] = rgbColor;
				}
			}

			return null;
		}
		// Метод отрисовки строки
		@Override
		protected void done() {
			for(int x = 0; x < size; x++)
				image.drawPixel(x, y , yLineColor[x]);
			image.repaint(0, 0, y, size, 1);

			// Проверка на окончание перерисовки
			remain --;
		
			if(remain < 1)
				enableUI(true);
		}
	}
}