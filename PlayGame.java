package playgame;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.misc.Launcher;

public class PlayGame {
    private static InputStreamReader ir = null;
    private static MyGame mg = null;
    public PlayGame(ByteArrayInputStream irb,MyGame mg){
        this.ir=new InputStreamReader(irb);
        this.mg=mg;
    }
    
    public static void main(String[] args){
        BufferedReader reader = null;
        if(ir==null){
            reader = new BufferedReader(new InputStreamReader(System.in));
        } else {
            reader = new BufferedReader(ir);
        }
 
//        Get valid MIN value
        String userInputMIN=null;
        int userMIN=-1;
        do {
         System.out.println("Enter range: minimum value");
            try {
                userInputMIN = reader.readLine();
            } catch (IOException e) {
            }
            if(checkEnd(userInputMIN)) System.exit(0);
            userMIN=getValidInteger(userInputMIN);
        } while(userMIN==-1);
        
        String userInputMAX=null;
        int userMAX=-1;
      
        do{
         System.out.println("Enter range: maximum value");
            try {
                userInputMAX = reader.readLine();
            } catch (IOException e) {
            }
            if(checkEnd(userInputMAX)) System.exit(0);
            userMAX = getValidInteger(userInputMAX);
        } while(userMAX==-1);

        //Create Game instance and Present approximations
        MyGame gameInst = null;
        if(mg==null){
             gameInst = new MyGame(userMAX, userMIN);
        } else {
            gameInst=mg;
        }
        //Present first approximation
        int approx = (gameInst.getMAX()+gameInst.getMIN()) / 2;
        String userDirection=null;
        gameInst.setCurrentValue(approx);
        System.out.println("Is this the number:" + approx);
        do{
         System.out.println("Please enter direction: lower or higher");
            try {
                userDirection = reader.readLine();
            } catch (IOException e) {
            }
            if(checkEnd(userDirection)) System.exit(0);
            gameInst.setPreviousDirection(userDirection);
            System.out.println(userDirection.equalsIgnoreCase("lower"));
        } while(!userDirection.equalsIgnoreCase("higher") && !userDirection.equalsIgnoreCase("lower"));      

        //Keep presenting new approximation until user agrees to guess

        do{
         System.out.println("Is this the number:" + gameInst.nextMove(userDirection));
         System.out.println("Enter direction: lower or higher");
            try {
                userDirection = reader.readLine();
            } catch (IOException e) {
            }
            if(checkEnd(userDirection)) System.exit(0);
        } while(!userDirection.equalsIgnoreCase("yes"));       
        
        gameInst.setCompleted("yes");
        
        System.out.println("Completed");                
            
    }

    public static int getValidInteger (String value){
                    int inputParsed=0;
                    if(value!=null && !value.isEmpty()){             
                            try{
                                    inputParsed = Integer.parseInt(value);
                            } catch (NumberFormatException e) {
                                    return -1;
                            }                    
                    }
        return inputParsed;
    }

    public static boolean checkEnd(String userDirection){
            if(userDirection!=null && !userDirection.isEmpty() && userDirection.equalsIgnoreCase("end")) return true;
            else return false;
            
    }


    public static void setMg(MyGame mg) {
        PlayGame.mg = mg;
    }

    public static MyGame getMg() {
        return mg;
    }

    public static void setIr(InputStreamReader ir) {
        PlayGame.ir = ir;
    }

    public static InputStreamReader getIr() {
        return ir;
    }
}
