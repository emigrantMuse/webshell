package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Global.FileInformation;
import Global.status;
import Program.RuntheMain;
public class SpecificDesign extends JPanel {
	
	JTextField path=new JTextField(30);
	JTextArea info=new JTextArea(20,25);//�߶ȣ����
	JTextArea result=new JTextArea(20,25);
	JButton Analysis=new JButton("��ʼɨ��");//�����ļ�
	JLabel InfoPath = new JLabel("��ɨ����ļ�Ŀ¼");
	JLabel InfoFile = new JLabel("ɨ����ļ���Ϣ");
	JLabel InfoResult = new JLabel("ɨ����");
	
	static javax.swing.JFileChooser MyFile=new javax.swing.JFileChooser();
	//javax.swing.

	public SpecificDesign()
	{
		super(new BorderLayout());
		
		JMenuBar Menubar = new JMenuBar();

	   	 JMenu StartMenu = new JMenu("��ʼ");
	   	 JMenu AboutMenu = new JMenu("����");
	   	 
	   	JMenuItem StartScanMenu= new JMenuItem("ѡ��·��");
	   	StartScanMenu.addActionListener(new GetfilepathActionListener());
	   	JMenuItem StopScanMenu= new JMenuItem("ֹͣɨ��");
	    JMenuItem ExitMenu= new JMenuItem("�˳�");
	  	JMenuItem InformationMenu= new JMenuItem("������Ϣ");
	   	 
	  	StartMenu.add(StartScanMenu);
	  	StartMenu.add(StopScanMenu);
	  	StartMenu.add(ExitMenu);
	  	AboutMenu.add(InformationMenu);
	  	
	    Menubar.add(StartMenu);
	    Menubar.add(AboutMenu);
	    
	    Analysis.addActionListener(new AnalysisActionListener());
	      
			JPanel PathChoose = new JPanel();

			
			PathChoose.add(InfoPath);
			PathChoose.add(path);
			PathChoose.add(Analysis);
			//PathChoose.setBorder(BorderFactory.createEmptyBorder(0,20,30,20));
			
			JPanel ResultOut = new JPanel();
			info.setLineWrap(true);
			result.setLineWrap(true);
			JScrollPane jS_info;
			JScrollPane jS_result;
			
			GridBagLayout layout = new GridBagLayout();
			 ResultOut.setLayout(layout);
			ResultOut.add(InfoFile);
			ResultOut.add(InfoResult);
			ResultOut.add(jS_info = new JScrollPane(info));
			ResultOut.add(jS_result = new JScrollPane(result));
			
			
			GridBagConstraints s_layout= new GridBagConstraints();
			 //s_layout.insets = new Insets(10,5,0,0);
		        s_layout.gridwidth=1;//�÷������������ˮƽ��ռ�õĸ����������Ϊ0����˵��������Ǹ��е����һ��
		        s_layout.weightx = 0;//�÷����������ˮƽ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
		        s_layout.weighty=0;//�÷������������ֱ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
		        layout.setConstraints(InfoFile, s_layout);//�������
		        
		        s_layout.gridwidth=0;
		        layout.setConstraints(InfoResult, s_layout);
		        
		        s_layout.insets = new Insets(10,10,10,10);//top, left,  bottom, right
		        s_layout.gridwidth=1;
		        layout.setConstraints(jS_info, s_layout);
		       //s_layout.gridwidth=0;
		        layout.setConstraints(jS_result, s_layout);

			this.add(Menubar,BorderLayout.NORTH);
			this.add(PathChoose,BorderLayout.WEST);
			this.add(ResultOut,BorderLayout.SOUTH);
			
	}
	public void show(String temp)
	{
		result.setText(info.getText()+temp+"\n"+"------------------------------------------------------");
	}
	
	private class GetfilepathActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
        	MyFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//ֻ��ѡ��Ŀ¼
        	 
        	 File f=null;
        	 
        	 try{     
        		 MyFile.showOpenDialog(null);  //�����ļ�ѡ��
             }    
             catch(HeadlessException head){     
                  System.out.println("Open File Dialog ERROR!");    
             }        
                 f=MyFile.getSelectedFile();    
                 status.setFilePath(f.getPath());
                
                 System.out.println(status.getFilePath());    
                 path.setText(status.getFilePath());
              //RuntheMain pro = new RuntheMain();
        } 
    }
	
	private class AnalysisActionListener implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
        	if(status.getFilePath() != null)
        	{
            	try {
    				RuntheMain pro = new RuntheMain();
    			} catch (Exception e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	/***
            	 * ��ʾ�ļ���Ϣ
            	 */
            	FileInformation vector = FileInformation.getInstance();
            	for(int j=0; j<vector.size(); j++){
            		info.setText(info.getText()+(String) vector.m_element.get(j)+"\n"+"------------------------------------------------------");
            	//info.setText((String) vector.m_element.get(j));
            		/****
            		 * 
            		 * ��ʾ���
            		 * 
            		 */
            	}
            }
        	else{
           	 JOptionPane.showMessageDialog(null, "����ѡ���ɨ��·��!", "������Ϣ",
                     JOptionPane.ERROR_MESSAGE);
        	}
        	}

    }
}
