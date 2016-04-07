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
	JTextArea info=new JTextArea(20,25);//高度，宽度
	JTextArea result=new JTextArea(20,25);
	JButton Analysis=new JButton("开始扫描");//分析文件
	JLabel InfoPath = new JLabel("待扫描的文件目录");
	JLabel InfoFile = new JLabel("扫描的文件信息");
	JLabel InfoResult = new JLabel("扫描结果");
	
	static javax.swing.JFileChooser MyFile=new javax.swing.JFileChooser();
	//javax.swing.

	public SpecificDesign()
	{
		super(new BorderLayout());
		
		JMenuBar Menubar = new JMenuBar();

	   	 JMenu StartMenu = new JMenu("开始");
	   	 JMenu AboutMenu = new JMenu("关于");
	   	 
	   	JMenuItem StartScanMenu= new JMenuItem("选择路径");
	   	StartScanMenu.addActionListener(new GetfilepathActionListener());
	   	JMenuItem StopScanMenu= new JMenuItem("停止扫描");
	    JMenuItem ExitMenu= new JMenuItem("退出");
	  	JMenuItem InformationMenu= new JMenuItem("工具信息");
	   	 
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
		        s_layout.gridwidth=1;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
		        s_layout.weightx = 0;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
		        s_layout.weighty=0;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
		        layout.setConstraints(InfoFile, s_layout);//设置组件
		        
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
        	MyFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
        	 
        	 File f=null;
        	 
        	 try{     
        		 MyFile.showOpenDialog(null);  //弹出文件选择
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
            	 * 显示文件信息
            	 */
            	FileInformation vector = FileInformation.getInstance();
            	for(int j=0; j<vector.size(); j++){
            		info.setText(info.getText()+(String) vector.m_element.get(j)+"\n"+"------------------------------------------------------");
            	//info.setText((String) vector.m_element.get(j));
            		/****
            		 * 
            		 * 显示结果
            		 * 
            		 */
            	}
            }
        	else{
           	 JOptionPane.showMessageDialog(null, "请先选择待扫描路径!", "错误信息",
                     JOptionPane.ERROR_MESSAGE);
        	}
        	}

    }
}
