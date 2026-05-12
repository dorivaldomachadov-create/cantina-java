package cantina.util;
public class Formatador{
    public static String formatarMoeda(double valor){
	return String.format("%.2f kz", valor);
    }
}