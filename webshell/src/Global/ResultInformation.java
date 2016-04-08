package Global;


import java.util.ArrayList;

import java.util.Vector;

public class ResultInformation {
	public Vector<Double> m_element;

	private static ResultInformation m_instance;//这是Vector类型的实例
	public static ResultInformation getInstance()
	{
		if (m_instance==null)
			m_instance=new ResultInformation();
		return m_instance; 
	}
	
	public void  Clear() {
		m_element.clear();
	}
	
	private ResultInformation()
	{
		m_element=new Vector<Double>();
	}
	
	public void addElement(double x)
	{
		m_element.add(x);
	}

	public int size() {
		// TODO Auto-generated method stub
		return m_element.size();
	}

}
