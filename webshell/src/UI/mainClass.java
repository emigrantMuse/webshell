package UI;

public class mainClass {
	public static void main(String[] args) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {//�¼��ɷ��߳�
         public void run() {
	mainFrame.createAndShowGUI();//����UI����
         }
     });
}

}
