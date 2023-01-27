package CS07.controller;

import CS07.model.Converter;
import CS07.model.XMLTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String XMLString = converter.generateXMLToString();
        XMLTokenizer tokenizer = new XMLTokenizer();

        tokenizer.generateTokenList(XMLString);
        
    }
}
