package translation.usage;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 爬取图虫所用正则表达式：src="//.*?jpg
 */
public class down_pic {
    public static void main(String[] args) throws Exception {
        String regex="src=.*?jpg";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(getStr());
        while (matcher.find()){
            String url=matcher.group().substring(6);
            url="https:/"+url;
            System.out.println(url);
            getImg.download(url,"F:/maomao/web02/"+(System.currentTimeMillis()+".jpg"));
        }

    }
    private static String getStr(){
        String s="src=\"//weiliicimg6.pstatp.com/weili/sm/256874623886688405.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/256874623886688405.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/445131003383251113.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/445131003383251113.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/428910879003771313.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/428910879003771313.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/260878212011393087.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/260878212011393087.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/259008870445482183.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/259008870445482183.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/255109856184500435.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/255109856184500435.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/255222478816936060.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/255418750232428580.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/238549673471901808.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/238362129429954661.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/263447083490738339.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/256366228607860940.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/260610395030683911.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/259451810422718502.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/725369759598247970.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/55305752713233774.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/258419970299658279.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/262560078254833888.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/261169402204127375.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/263397665597030595.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/254998178444869744.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/258400909234798645.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/264182948827496667.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/261137877144174817.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/725369759595495475.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/79053786542473029.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/79053588973923710.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/260699472652402829.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/260755994422018131.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/257445081442943256.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/256606798316044291.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/263756132157489333.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/428373956552163530.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/649187820138135565.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/262764931014983772.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/258986450716197051.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/725369759603752992.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/243071973369839635.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/658856856673320974.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/79053588973888101.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/262134000319201387.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/258512879032205438.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/79052841649645001.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/79053588973923469.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/257594872722358349.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/79053588973888065.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/262866403912319034.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/259217846374236304.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/247497146911424837.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/430978433311310369.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/266980553085157388.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/460976907264721008.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/79053588973923593.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/79053786542486749.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/79053099347655129.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/429862343109771589.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/457301909907964090.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/237708796184756286.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/454909888001999234.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/784959149478641710.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/800596730263371781.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/448247818183508287.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/260093186478964801.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/255867471235645639.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/456904067087335921.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/247590605399785856.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/454391811866886359.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/455955377531126069.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/259460623695609937.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/458042954975281563.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/452071430015418442.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/448582739750027311.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/256156874721984562.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/79053855261913498.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/79052171634692072.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/79053786542486842.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/133389761417052466.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/255714364241477640.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/79053588973923476.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/449093050584269042.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/261877238584311908.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/254304034420424740.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/79052171634692015.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/79053588973923494.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/79053786542485675.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/258777852744564750.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/79053786542472963.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/457480992864338309.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/248292772423139705.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/453388060829941765.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/79053786542472894.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/79053588973923577.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/238712753380130912.jpg\n" +
                "src=\"//icweiliimg6.pstatp.com/weili/sm/259902163513507884.jpg\n" +
                "src=\"//icweiliimg1.pstatp.com/weili/sm/454053102155989068.jpg\n" +
                "src=\"//weiliicimg1.pstatp.com/weili/sm/55306998253753745.jpg\n" +
                "src=\"//icweiliimg9.pstatp.com/weili/sm/457476457378873714.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/460382518150692969.jpg\n" +
                "src=\"//weiliicimg6.pstatp.com/weili/sm/238615206082904415.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/789361027099131945.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/750551479277322273.jpg\n" +
                "src=\"//weiliicimg9.pstatp.com/weili/sm/750551479277322273.jpg\n";
    return s;
    }

    private static String geturl(String url){
        String context = null;
        StringBuilder result=new StringBuilder();
        try {
             context=url_context.getContent("https://stock.tuchong.com/search?term=%E5%AD%A6%E7%94%9FIT&use=0");
            System.out.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String regex="src=\".*?jpg";
        Pattern p=Pattern.compile(regex);
        Matcher matcher=p.matcher(context);
        while (matcher.find())
            result.append(matcher.group());
        return result.toString();
    }
}