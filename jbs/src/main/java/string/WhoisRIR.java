package string;

/**
 * Created by Sun on 2015/12/10.
 */
public enum WhoisRIR {

    ARIN("whois.arin.net"),
    RIPE("whois.ripe.net");

    private String url;

    private WhoisRIR(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
