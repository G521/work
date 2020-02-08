package Main.usage;
public class data {
    public static int windowSizeX=1200;
    public static int windowSizeY=800;
    public static int candleSize=30;
    public static double candleSpeed=0.15;
    public static double Love_size=100;
    public static double reseSize=40;
    public static String bgImage= "Main/usage/images/others/birthday.png";
    public static int roseSizeX=200;
    public static int roseSizeY=80;

    public static String candleImage()
    {
        switch ((int)(Math.random()*8)){
            case 1:return "Main/usage/images/candles/candle1.png";
            case 2:return "Main/usage/images/candles/candle2.png";
            case 3:return "Main/usage/images/candles/candle3.png";
            case 4:return "Main/usage/images/candles/candle4.png";
            case 5:return "Main/usage/images/candles/candle5.png";
            case 6:return "Main/usage/images/candles/candle6.png";
            case 7:return "Main/usage/images/candles/candle7.png";
            default:return "Main/usage/images/candles/candle7.png";
        }
    }
    public static String roseImage() {

        switch ((int) (Math.random() * 6)) {
            case 1:
                return "Main/usage/images/roses/rose1.png";
            case 2:
                return "Main/usage/images/roses/rose2.png";
            case 3:
                return "Main/usage/images/roses/rose3.png";
            case 4:
                return "Main/usage/images/roses/rose4.png";
            case 5:
                return "Main/usage/images/roses/rose5.png";
            default:
                return "Main/usage/images/roses/rose5.png";
        }
    }
}