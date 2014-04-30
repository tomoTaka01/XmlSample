
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Currency List for creating XML by JAXB
 * 
 * @author tomo
 */
@XmlRootElement(name="CcyTbl")
    @XmlAccessorType(XmlAccessType.FIELD)
public class Currencies {
    @XmlElement(name="CcyNtry")
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
    
}
