import java.util.*;
public class Adress {
	private String ort;
	private int postnr;
	private String gata;

	public Adress (String ort, int postnr, String gata){
		this.ort = ort;
		this.postnr = postnr;
		this.gata = gata;
	}
	public String getOrt(){
		return ort;
	}
	public int getPostNr(){
		return postnr;
	}
	public String getGata(){
		return gata;
	}
	public String toString (){
		return gata + "  " + postnr + "  " + ort;
	}
	public boolean equals(Object other){
		if (other instanceof Adress){
			Adress a = (Adress)other;
			return ort.equals(a.ort) && postnr == a.postnr && gata.equals(a.gata);// sv�rt att f�rst� a.gata och a.ort. �r det just det adressobjektets gata som ska j�mst�llas?
		}
		else
			return false;
	}
	public int hashCode(){
		return ort.hashCode() * 10000 + postnr + gata.hashCode();
	}

	Map<String, Adress> adressLista = new TreeMap <String, Adress>();
	

	public static Map<Adress, List<String>> makeNamesPerAdressMap (Map<String, Adress> adresslista){

		Map <Adress, List<String>> nyMap = new HashMap <Adress, List<String>>();

		for (Map.Entry<String, Adress> me : adresslista.entrySet()){// g�r en m�ngd s� att kan anv�nda forloop
			String namn = me.getKey();
			Adress adress = me.getValue();

			List<String> namnLista =  nyMap.get(adress);//lite os�ker p� hur adressobjektet passar in i nya mappen. skulle lika g�rna kunna kalla det nyMap.get(adress);
			if (namnLista == null){
				namnLista = new ArrayList<String>();
				nyMap.put(adress, namnLista);
			}
			namnLista.add(namn);// l�gger till namnet som lista h�r till
		}

		return nyMap;
	}



public static List<String> namnGen(String namn){
	List<String> namnLista = new ArrayList<>();
	for( int e = 0; e <5; e++ ){
		namnLista.add(namn + e);
	}
	return namnLista;
}


	public static void main(String[] args) { 
		Map <String, Adress> minTestMap = new HashMap <>();
		
		
		Adress a = new Adress("Gumm�ngen1", 145, "h�stv�gen1");
		Adress b = new Adress("Gumm�ngen2", 145, "h�stv�gen2");
		Adress c = new Adress("Gumm�ngen3", 145, "h�stv�gen3");
		Adress d = new Adress("Gumm�ngen4", 145, "h�stv�gen4");
		Adress e = new Adress("Gumm�ngen5", 145, "h�stv�gen5");
		minTestMap.put("Anna", a );
		minTestMap.put("bosse", b);
		minTestMap.put("calle", c);
		minTestMap.put("muhammed", d);
		minTestMap.put("tarek", e);
		minTestMap.put("Hannah", a);
	
	
		Map <Adress, List<String>> SvarsMap = makeNamesPerAdressMap(minTestMap);
		
		for (Map.Entry<Adress, List<String>> me : SvarsMap.entrySet()){
			Adress adress = me.getKey();
			List<String> namnen = me.getValue();
			System.out.print(adress + " ");
			
				for( String f :namnen){
				System.out.print(f + ", " );
			}
			System.out.println();
		}
	}
		// TODO Auto-generated method stub

	

}
