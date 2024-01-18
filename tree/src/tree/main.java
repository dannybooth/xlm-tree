package tree;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;

public class main{
	public static void main(String[] args) {
		String title = "XML in a Nutshell";
		
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse("library.xml");
			System.out.println("Books in Library: ");
			
			Element root = doc.getDocumentElement();
			
			NodeList children = root.getChildNodes();
			
			for(int i=0;i<children.getLength();i++)
			{
				Node c = children.item(i);
				if(c.getNodeName().equals("book")) {
					NodeList grandchildren = c.getChildNodes();
					for(int j=0;j<grandchildren.getLength();j++)
					{
						Node d = grandchildren.item(j);
						if(d.getNodeName().equals("title")) {;
							String title2 = d.getChildNodes().item(0).getNodeValue();
							
							if(title2.compareTo(title)==0)
							{
								System.out.println("title "+title2);
								Node found = d.getParentNode();
								//authors
								for(int jj=0;jj<grandchildren.getLength();jj++)
								{
									Node dd = grandchildren.item(jj);
									if(dd.getNodeName().equals("authors")) {
										//author
										NodeList grandgrandchildren = dd.getChildNodes();
										for(int kk=0;kk<grandgrandchildren.getLength();kk++)
										{
											Node ee = grandgrandchildren.item(kk);
											if(ee.getNodeName().equals("author"))
											{
												NodeList grandgrandgrandchildren = ee.getChildNodes();
												for(int ll=0;ll<grandgrandgrandchildren.getLength();ll++)
												{
													Node f = grandgrandgrandchildren.item(ll);
													if(f.getNodeName().equals("forename"))
													{
														String forename = f.getChildNodes().item(0).getNodeValue();
														System.out.println("forename: "+forename);
													}
													if(f.getNodeName().equals("surname"))
													{
														String surname = f.getChildNodes().item(0).getNodeValue();
														System.out.println("surname: "+surname);
													}
												}
											}
									}
								}
							}
						}
					}
				}
			}
			}
		}
		catch(ParserConfigurationException | SAXException | IOException e) {
			System.err.println("Error opoening XML file: "+e);
		}
}
}