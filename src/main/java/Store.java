public class Store {

    private static int firstAvailableID = 0;
    private int id;
    private String name;
    private String address;
    private int phoneNr;

    public Store(String name){
        this.id = firstAvailableID;
        firstAvailableID++;
        this.name = name;
        this.address = "";
        this.phoneNr = -1;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNr(int phoneNr){
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString(){
        return  "Store name: " + this.name + "\n" +
                "Store address: " + this.address + "\n" +
                "Store phone number: " + this.phoneNr + "\n";
    }
}
