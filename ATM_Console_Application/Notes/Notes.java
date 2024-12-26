package ATM_Console_Application.Notes;

public class Notes {
    private  String notes;
    private  int count;
    public  void setNotes(String notes){
        this.notes=notes;
    }
    public  void setCount(int count){
        this.count=count;
    }
    public String getNotes(){
        return notes;
    }
    public int getCount(){
        return count;
    }
}
