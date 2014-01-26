package InputOutput;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TextHandler {

	private File practice;
	private DocumentBuilderFactory dbFactory;
	
	public TextHandler()
	{
		practice = new File ("metadata\\practice.xml");
		dbFactory = DocumentBuilderFactory.newInstance();
	}
	
	
	public void beginState(String _currentState)
	{

		try {
			DocumentBuilder dBuilder     = dbFactory.newDocumentBuilder();
			Document        doc          = dBuilder.parse(practice);  
			
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getElementsByTagName(_currentState); //find current Location

		
			for(int i = 0; i < nodes.getLength(); i++)
			{
				Node node = nodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element element = (Element)node;
					if (element != null)
					System.out.println("NameOFlocation: " + getValue("introduction", element));
				}
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	
	public static String getValue(String tagName, Element element)
	{
		NodeList nodes = element.getElementsByTagName(tagName).item(0).getChildNodes();
		Node node = (Node)nodes.item(0);
		return node.getNodeValue();
	}
	
	public void fetchCurrentState()
	{
	}
	
	
}