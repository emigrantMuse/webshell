package UI;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class mainFrame {
	public static void createAndShowGUI() {
	//Frame������ҳ����Ҳ�����������������壬Ҫ��ѿؼ����ڸý����У�����ѿؼ�����JPanel��
			//Ϊ��ײ㣬ͬһ������ֻ��һ��JFrame
			
	        JFrame frame = new JFrame("Webshell������鹤��");//������
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ָ���رհ�ť�˳�Ӧ�ó���
	 
	        //Create and set up the content pane.
	        JComponent newContentPane = new SpecificDesign();//ʵ����������������
	        newContentPane.setOpaque(true); //���ÿؼ���͸��
	        frame.setContentPane(newContentPane);//JFrame�ǿ�ܣ�����ֱ����ӿؼ�������Jpanel���м�ؼ�
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);//��Ϊ�ɼ�
	}
}
