package servlets;


import java.util.ArrayList;
/**
 * Klasse AbstractUser, die vererbt wird
 * @author Metaxa
 * 
 */
public abstract class AbstractUser {

    
	private String name, vorname, email, password;
        private String sprache="--";
        private String studium="--";
        private String gebDatum="--";
        //private bollean sex;
        public ArrayList<PinnwandDaten> eintragListe=new ArrayList<PinnwandDaten>();//Jeder User hat eigene ArrayListe Pinnwand
	public ArrayList<String> friends = new ArrayList<String>();
	//private Pinnwand pinnwand = new Pinnwand();
	/**
         * Konstruktor fuer die Klasse AbstractUser
         * @param name
         * @param vorname
         * @param email
         * @param password 
         */
	public AbstractUser(String name, String vorname, String email, String password) {
		setName(name);
		setVorname(vorname);
		setEmail(email);
		setPassword(password);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean verifyPassword(String givenPassword){
		if (givenPassword.equals(this.password)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addFriend(String friend) {
		friends.add(friend);
	}
	
	public void removeFriend(String friend) {
		friends.remove(friend);
	}
        
        public ArrayList<String> getFriendsList(){
            return friends;
        }
	
        public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public String getStudium() {
        return studium;
    }

    public void setStudium(String studium) {
        this.studium = studium;
    }

    public String getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(String gebDatum) {
        this.gebDatum = gebDatum;
    }
}

