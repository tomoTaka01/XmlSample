
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * XML to Object, object to XML by JAXB
 * 
 * @author tomo
 */
public class JaxbSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        JaxbSample sample = new JaxbSample();
        Path xmlPath = Paths.get("/Users/tomo/currency.xml");
        sample.ObjToXml(xmlPath);
        sample.XmlToObj(xmlPath);
    }

    private void ObjToXml(Path xmlPath) throws Exception {
        List<Currency> currencyList = Arrays.asList(
              Currency.createJPY()
            , Currency.createUSD()
        );
        Currencies currencies = new Currencies();
        currencies.setCurrencies(currencyList);
        JAXBContext context = JAXBContext.newInstance(Currencies.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(xmlPath)){
            marshaller.marshal(currencies, writer);
        }
    }

    private void XmlToObj(Path xmlPath) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Currencies.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (BufferedReader reader = Files.newBufferedReader(xmlPath);) {
            Currencies unmarshal = (Currencies) unmarshaller.unmarshal(reader);
            unmarshal.getCurrencies().forEach(c -> {
                System.out.println(c.getCurrecyData());
            });
        }
    }
    
}
