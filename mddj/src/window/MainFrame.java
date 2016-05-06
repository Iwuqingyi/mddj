package window;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.add(new EditPanel());
		f.setSize(800, 300);
		f.setVisible(true);

	}

}
