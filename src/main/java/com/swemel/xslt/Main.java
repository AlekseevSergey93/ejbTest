package com.swemel.xslt;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class Main {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("article1a.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("article1.xml"));
        transformer.transform(xml, new StreamResult(new File("output.xml")));
    }
}
