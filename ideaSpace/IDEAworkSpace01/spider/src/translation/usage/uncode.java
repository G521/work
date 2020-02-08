package translation.usage;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class uncode {
    final static Base64.Decoder decoder = Base64.getDecoder();
    public static String decode(String encodedText) {
        String text = null;
        try {
            text = new String(decoder.decode(encodedText), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
       String result= uncode.decode("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAAEEfUpiAAAAAXNSR0IArs4c6QAAASdJREFUWAntVdEOwyAInEv//5c3z+UMgsQqLr7UhyoCxwFa0yuPTx6YMVIjpJQaLSze+MiRIDRujQAMDirGGPTAnBEsDSgIh7WBxKYcFwTpIZVYV5qekUnUIHieNCwcSjrcybN0GmYRM0DopsOCxqMcmNljWSGHHvAsgqXFHrGekXtNQZRlqhHb1ASylI8LMASNvts6Qp17pW9T7QyCsW9VtnBKttnI2sU5lixmCFAYW7CDpyBzUGmhkzchjGmbwANx4XXQ3pIzOhYsYvs5xBjKn3to7gT3blT3zQ1oBWfFhYvUuEoQKyrtnfecNAW2wi4CX2PTLPEtolFD4FM8S0vbbW+CVWgemfLwCD4GnAuYW8HT+e+b/4XgLpt/j2cowU8/veAW+5E+MPpVWVgcAAAAASUVORK5CYII=");

        System.out.println(result);}
}
