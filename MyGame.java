package playgame;

public class MyGame {
    private int MAX;
    private int MIN;
    private int currentValue;
    private int previousValue;
    private String previousDirection;
    private String completed=null;

    public MyGame(int max, int min){
            this.MAX=max;
            this.MIN=min;
    };
    

    public int nextMove(String userDirection){
            int nextApprox = 0;
            //No direction change
            if(previousDirection.equalsIgnoreCase(userDirection)){
                    if(userDirection.equalsIgnoreCase("higher")){
                            previousValue=currentValue;
                            nextApprox = (MAX+currentValue)/2;
                             
                    }
                    else if(userDirection.equalsIgnoreCase("lower")){
                            previousValue=currentValue;
                            nextApprox = (MIN+currentValue)/2;      
                    }
            }

            else if(!previousDirection.equalsIgnoreCase(userDirection)){
                    if(userDirection.equalsIgnoreCase("higher")){
                            nextApprox = (currentValue + previousValue)/2;
                            this.MAX = previousValue;
                            previousValue=currentValue;
                            this.MIN=currentValue;  
                    }
                    else if(userDirection.equalsIgnoreCase("lower")){
                            nextApprox = (currentValue + previousValue)/2;
                            this.MIN = previousValue;
                            previousValue=currentValue;
                            this.MAX=currentValue; 
                            
                    }
            }
            previousDirection = userDirection;
            currentValue = nextApprox;
            return nextApprox;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMIN(int MIN) {
        this.MIN = MIN;
    }

    public int getMIN() {
        return MIN;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setPreviousValue(int previousValue) {
        this.previousValue = previousValue;
    }

    public int getPreviousValue() {
        return previousValue;
    }

    public void setPreviousDirection(String previousDirection) {
        this.previousDirection = previousDirection;
    }

    public String getPreviousDirection() {
        return previousDirection;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getCompleted() {
        return completed;
    }
}
