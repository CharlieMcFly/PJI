import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaFenetre {

	public static void main(String[] args) {

		// JFrame
		JFrame jf = new JFrame("JFrame");
		jf.setSize(500, 500);
		jf.setLocationRelativeTo(null);
		// jf.getContentPane().add(new JLabel("Hello World"));
		jf.setDefaultCloseOperation(1);
		jf.setResizable(true);

		// JDialog
		// JDialog jd = new JDialog(jf);
		// jd.setTitle("JDialog");
		// jd.setLocationRelativeTo(jf);
		// jd.setSize(150,150);
		// jd.setDefaultCloseOperation(1);
		// jd.setResizable(false);

		// jf.getContentPane().add(new JButton("North"), BorderLayout.NORTH);
		// jf.getContentPane().add(new JButton("South"), BorderLayout.SOUTH);
		// jf.getContentPane().add(new JButton("East"), BorderLayout.EAST);
		// jf.getContentPane().add(new JButton("West"), BorderLayout.WEST);
		// jf.getContentPane().add(new JButton("Center"), BorderLayout.CENTER);

		// jf.setLayout(new FlowLayout(FlowLayout.CENTER));
		// for (int i = 1; i < 17; i++) {
		// jf.getContentPane().add(new JButton("Button "+i));
		// }

		// jf.setLayout(new GridLayout(4, 4));
		// for (int i = 1; i < 17; i++) {
		// jf.getContentPane().add(new JButton("Button "+i));
		// }

		// BoxLayout bl = new BoxLayout(jf.getContentPane(), BoxLayout.Y_AXIS);
		// jf.getContentPane().setLayout(bl);
		// for (int i = 1; i < 17; i++) {
		// JButton jb = new JButton("Button " + i);
		// if (i == 3) {
		// jf.getContentPane().add(new Filler(null, null, null));
		// } else {
		// jf.getContentPane().add(jb);
		// }
		// }

		// jf.setLayout(null);
		// jf.setBounds(new Rectangle(100,50));
		// JButton [] buttons = new JButton[10];
		// Insets in = jf.getContentPane().getInsets();
		// for (int i = 0; i < buttons.length; i++) {
		// buttons[i] = new JButton("Button "+i);
		// jf.getContentPane().add(buttons[i]);
		// buttons[i].setBounds(in.left+i*50, in.right+i*50, (int)
		// buttons[i].getPreferredSize().getWidth(),
		// (int) buttons[i].getPreferredSize().getHeight());
		// buttons[i].repaint();
		// }
		
		JPanel jp = new JPanel();
		for (int i = 0; i < 3; i++) {
			jp.add(new JButton("Button "+i));
		}
		jf.getContentPane().add(jp, BorderLayout.NORTH);
		jf.getContentPane().add(new JButton("South"), BorderLayout.SOUTH);
		jf.getContentPane().add(new JButton("East"), BorderLayout.EAST);
		jf.getContentPane().add(new JButton("West"), BorderLayout.WEST);
		jf.getContentPane().add(new JButton("Center"), BorderLayout.CENTER);
		
		// Rendre Visible
		jf.setVisible(true);
		// jd.setVisible(true);

	}
}
