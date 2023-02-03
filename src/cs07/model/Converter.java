package cs07.model;

public class Converter {
    // sample code
    private String sample1 = "<span>hello</span>";
    private String sample2 = "<!DOCTYPE html><HTML lang=\"ko\"><BODY><P>BOOST<IMG SRC=\\\"codesquad.kr\\\"></IMG><BR/></P></BODY></HTML>";
    public String generateXMLToString() {
        String XMLString = sample1;
//        StringTokenizer stringTokenizer = new StringTokenizer(XMLString);
        return XMLString;
    }
}
