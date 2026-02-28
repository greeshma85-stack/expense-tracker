class Expense{
    String date;
    String category;
    double amount;
    Expense(String date,String category,double amount){
        this.date=date;
        this.category=category;
        this.amount=amount;
    }
    void display(){
        System.out.println(date +" | "+category+ " | "+amount+" | ");
    }
}
