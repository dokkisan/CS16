//package CS07.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class XMLTokenizer {
//    private TokenData tokenData;
//
////    <!DOCTYPE html><HTML lang="ko"><BODY><P>BOOST<IMG SRC=\"codesquad.kr\"></IMG><BR/></P></BODY></HTML>
//
//    public List<String> generateTokenContainer(String XMLString) {
//        List<String> tokenContainer = new ArrayList<>();
//
//        // StringTokenizer로 시도했지만 실패..?
////        StringTokenizer stringTokenizer = new StringTokenizer(XMLString, "");
//
////        int countTokens = stringTokenizer.countTokens();
////        for (int i = 0; i < countTokens; i++) {
////            tokenContainer.add(stringTokenizer.nextToken());
////        }
////
////        System.out.println(tokenContainer);
//
//
//        // split -> 토큰화
//        String[] temp = XMLString.split("");
//
//        for (String tokenChar : temp) {
//            tokenContainer.add(tokenChar);
////            System.out.println(character);
//        }
//
//            System.out.println(tokenContainer);
//        return tokenContainer;
//    }
//
//}
