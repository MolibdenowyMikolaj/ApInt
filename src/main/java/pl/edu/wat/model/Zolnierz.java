package pl.edu.wat.model;

public class Zolnierz {

	private int id_zolnierza;
	private String stopien;
	private String imie;
	private String nazwisko;
        private String funkcja;
        private int kompania;
        private int pluton;
        private int druzyna;
        private String grupa_szkoleniowa;
        private String wydzial;
        private boolean l4;
        private boolean szpital;
        private boolean przepustka;
        private boolean sluzba;

    
	public Zolnierz(){
		id_zolnierza=0;
	}

    public Zolnierz(int id_zolnierza, String stopien, String imie, String nazwisko, String funkcja, int kompania, int pluton, int druzyna, String grupa_szkoleniowa, String wydzial, boolean l4, boolean szpital, boolean przepustka, boolean sluzba) {
        this.id_zolnierza = id_zolnierza;
        this.stopien = stopien;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.funkcja = funkcja;
        this.kompania = kompania;
        this.pluton = pluton;
        this.druzyna = druzyna;
        this.grupa_szkoleniowa = grupa_szkoleniowa;
        this.wydzial = wydzial;
        this.l4 = l4;
        this.szpital = szpital;
        this.przepustka = przepustka;
        this.sluzba = sluzba;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_zolnierza ^ (id_zolnierza >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Zolnierz))
			return false;
		Zolnierz other = (Zolnierz) obj;
		if (id_zolnierza != other.id_zolnierza)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zolnierz [id=" + id_zolnierza + ", stopien=" + stopien + ", imie=" + imie +
                        ", nazwisko=" + nazwisko + ", funkcja=" + funkcja + ", kompania=" + kompania + ", pluton=" + pluton 
                        + ", druzyna=" + druzyna + ", wydzial=" + wydzial + ", l4=" + l4+", szpital=" + szpital+", sluzba=" + sluzba+", przepustka=" + przepustka+ "]";
	}
        public int getId_zolnierza() {
        return id_zolnierza;
    }

    public void setId_zolnierza(int id_zolnierza) {
        this.id_zolnierza = id_zolnierza;
    }

    public String getStopien() {
        return stopien;
    }

    public void setStopien(String stopien) {
        this.stopien = stopien;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(String funkcja) {
        this.funkcja = funkcja;
    }

    public int getKompania() {
        return kompania;
    }

    public void setKompania(int kompania) {
        this.kompania = kompania;
    }

    public int getPluton() {
        return pluton;
    }

    public void setPluton(int pluton) {
        this.pluton = pluton;
    }

    public int getDruzyna() {
        return druzyna;
    }

    public void setDruzyna(int druzyna) {
        this.druzyna = druzyna;
    }

    public String getGrupa_szkoleniowa() {
        return grupa_szkoleniowa;
    }

    public void setGrupa_szkoleniowa(String grupa_szkoleniowa) {
        this.grupa_szkoleniowa = grupa_szkoleniowa;
    }

    public String getWydzial() {
        return wydzial;
    }

    public void setWydzial(String wydzial) {
        this.wydzial = wydzial;
    }

    public boolean isL4() {
        return l4;
    }

    public void setL4(boolean l4) {
        this.l4 = l4;
    }

    public boolean isSzpital() {
        return szpital;
    }

    public void setSzpital(boolean szpital) {
        this.szpital = szpital;
    }

    public boolean isPrzepustka() {
        return przepustka;
    }

    public void setPrzepustka(boolean przepustka) {
        this.przepustka = przepustka;
    }

    public boolean isSluzba() {
        return sluzba;
    }

    public void setSluzba(boolean sluzba) {
        this.sluzba = sluzba;
    }
        
	

	
}
