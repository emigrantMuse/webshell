package Program;

import java.io.File;

import Global.status;
import UI.SpecificDesign;

public class RuntheMain{

public RuntheMain() throws Exception 
{
	 /*****
	 * ��ȡĿ¼�µ������ļ��б�
	 */
	GetAllFile step1= new GetAllFile();
	
	/******
	 * 
	 * ��ȡ�ؼ���
	 * 
	 */
	ReadTXT step2=new ReadTXT();
	step2.Readwebshell();
	
	/******
	 * 
	 * ���������ļ����ҷ������Ƿ�Ϊwebshell
	 */
	Analysis step3 = new Analysis();
	status.done = true;
}


}
