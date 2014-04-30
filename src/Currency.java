
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Currency Infomation for XML
 *
 * @author tomo
 */
@XmlType(propOrder={"countryName", "name", "code", "numericCode", "minorUnit"})
public class Currency {
    private String code;
    private int numericCode;
    private String name;
    private String countryName;
    private int minorUnit;

    public String getCode() {
        return code;
    }
    @XmlElement(name="Ccy")
    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name="CcyNbr")
    public int getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(int NumericCode) {
        this.numericCode = NumericCode;
    }

    @XmlElement(name="CcyNm")
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    @XmlElement(name="CtryNm")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlElement(name="CcyMnrUnts")
    public int getMinorUnit() {
        return minorUnit;
    }

    public void setMinorUnit(int minorUnit) {
        this.minorUnit = minorUnit;
    }

    public static Currency createJPY() {
        Currency currency = new Currency();
        currency.setCode("JPY");
        currency.setName("YEN");
        currency.setCountryName("JAPAN");
        currency.setNumericCode(392);
        currency.setMinorUnit(0);
        return currency;
    }

    public static Currency createUSD() {
        Currency currency = new Currency();
        currency.setCode("USD");
        currency.setName("US Dollar");
        currency.setCountryName("UNITED STATES");
        currency.setNumericCode(840);
        currency.setMinorUnit(2);
        return currency;
    }
 
    public String getCurrecyData(){
        return String.format("Code:%s, Name:%s, Country:%s, Numeric Code:%d, Minor Unit:%d"
                , code, name,countryName, numericCode, minorUnit);
    }
}
