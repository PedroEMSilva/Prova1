package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * Primeira avaliação parcial 2014/2.
 *
 * @author
 */
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
public class Complexo {

    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        this.real = real;
        this.img = img;
    }

    // implementar getReal()
    // implementar getImg()
    public Complexo soma(Complexo c) {
        return new Complexo(getReal() + c.getReal(), getImg() + c.getImg());
    }

    public Complexo sub(Complexo c){
        return new Complexo(getReal() - c.getReal(), getImg() - c.getImg());
    }
    public Complexo prod(double x){
        return new Complexo(getReal()*x,getImg()*x);
    }
    public Complexo prod(Complexo y){
        return new Complexo(((getReal()*y.getReal())-(getImg()*y.getImg())),((getImg()*y.getReal())+(y.getImg()*getReal())));
    }
    public  Complexo div(Complexo y){
        return new Complexo (((getReal()*y.getReal())+(getImg()*y.getImg()))/((y.getReal()*y.getReal())+(y.getImg()*y.getImg())),((getImg()*y.getReal())-(y.getImg()*getReal()))/((y.getReal()*y.getReal())+(y.getImg()*y.getImg())));
    }
       public static double sqrt(double a) {  
    return StrictMath.sqrt(a);  
    }  
    public Complexo[] sqrt() {
        // completar implementação
        
        Complexo v[]=new Complexo[2];
        double r=sqrt(getReal()*getReal()+getImg()*getImg());
        double p=sqrt(r);
        double fi=0;
        if(getReal()>0){
            fi=atan(getImg()/getReal());
        }
        if(getReal()<0){
            fi=atan(getImg()/getReal())+Math.PI;
        }
        if (getReal()==0){
            if (getImg()==0){
                fi=0;
            }
            if(getImg()>0){
                fi=Math.PI/2;
            }
            if(getImg()<0){
                fi=(Math.PI*3)/2;
            }
        }
        double fi1=fi/2;
        double fi2=fi1+Math.PI;
        v[0].real=p*cos(fi1);
        v[0].img=p*sin(fi1);
        v[1].real=p*cos(fi2);
        v[1].img=p*sin(fi2);
        // retornar o vetor contendo as raízes
        return v;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(getReal())
                ^ (Double.doubleToLongBits(getReal()) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(getImg())
                ^ (Double.doubleToLongBits(getImg()) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
                && getReal() == c.getReal() && getImg() == c.getImg();
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", getReal(), getImg());
    }

    /**
     * @return the real
     */
    public double getReal() {
        return real;
    }

    /**
     * @param real the real to set
     */
   

    /**
     * @return the img
     */
    public double getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    
}
