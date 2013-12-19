/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marius
 */
public class Matrica {
    private String[][] matrica1;
    private String[][] matrica2;
    private int ilgis;
    private int minos;
    private boolean[][] arMina;
    private boolean[][] arTuscia;
    
    public Matrica(String[][] matrica1,String[][] matrica2, int ilgis, int minos){
    this.matrica1=matrica1;
    this.matrica2=matrica2;
    this.ilgis= ilgis;
    this.minos= minos;
}    
  
    public boolean[][] getArMina(){
        return arMina;
        
    }
    
    public boolean[][] getArTuscia(){
        return arTuscia;
        
    }
    
    public String[][] getmatrica1(){
  return matrica1;
       
} 
    
    public String[][] getmatrica2(){
  return matrica2;
       
}
    
    public int getilgis(){
        return ilgis;        
    }
    
    public int getminos(){
        return minos;
    }
    
    public void setmatrica1(String[][] matrica){

this.matrica1= matrica;
}
    
    public void setmatrica2(String[][] matrica){

this.matrica2= matrica;
}    
    
    public void setilgis(int ilg){
        this.ilgis= ilg;
    }
    
    public void setminos(int min){
        this.minos= min;
    }
    
    public void tikrintaplinka(int o, int p){
  int dydis=matrica1.length;
    int x=0;
    int y=0;
    int kiek;
    String sk="O";                 
    int[] xk={-1,-1,-1,1,1,1,0,0};
    int[] yk={0,1,-1,0,-1,1,-1,1}; //xk ir xy saugo skaicius kuriu reikia norint patikrint tam tikros koordinates aplinka
    
   for(int i =0; i<dydis; i++){
       for(int j=0; j<dydis; j++){           
           kiek=0;       
                for(int k=0;k<xk.length;k++){
                 x=xk[k]+i;
                 y=yk[k]+j;                 
               sk=Integer.toString(kiek);
  if(x>=0&&x<dydis &&y>=0&&y<dydis&&"B".equals(matrica1[x][y])){
      kiek++;         
      sk=Integer.toString(kiek);                    // skaiciuojama kiek minu yra aplink tam tikra koordinate.
  }
                }
                
   if(x<dydis &&y<dydis+1){        
        matrica2[x][y-1]=sk;                         // minu skaicius issaugomas tam tikros matricos koordinatese. 
    }       }
     
   }

    for(int i=0;i<xk.length;i++){
      x=xk[i]+o;
      y=yk[i]+p;
         
      if(x>=0&&x<dydis &&y>=0&&y<dydis&&!"B".equals(matrica1[x][y]))
      {  
     matrica1[x][y]=sk;                                // minu skaicius surasomas aplink minas
    }       
    }                

}

    public void rastiminas(){
  arMina= new boolean[ilgis][ilgis];
   int dydis = matrica1.length;
           for(int i =0; i<dydis; i++){
               for(int j=0;j<dydis; j++){
                 arMina[i][j]=false;  
  if("B".equals(matrica1[i][j])){
                          matrica2[i][j]="B";  // vienos matricos minu koordinates saugomos kitoje matricoje
                          arMina[i][j]=true; 
  }  
  }}}
    
    public void PrintMatrix(String[][] matrix){       // matricos spausdinimas
      int dydis = matrix.length;
        for(int i =0; i<dydis; i++){
            for(int j=0;j<dydis; j++){
            System.out.print(matrix[i][j].toString()+"  ");
            }
        System.out.println();
        
        }
    } 
    
    public void IeskotiKoord(){
    int dydis = matrica1.length;
     
        for(int i =0; i<dydis; i++){
               for(int j=0;j<dydis; j++){
                    if("B".equals(matrica1[i][j])){
                 
                         tikrintaplinka(i,j) ;       
                        
                                  }
           }
               }}  
    
    public void GeneruotiMinas(ArrayList<Point> pnt){
        Random rand = new Random();
        int rx;
        int ry;
        int sk=0;
        
            for(int i = 0; i< minos;){
                Point p = new Point();
                rx= rand.nextInt(ilgis);
                ry= rand.nextInt(ilgis);   // generuojamos minu kordinates 0<x<matricos ilgis
                
                   p.x=rx;
                   p.y=ry;                 
             sk++;
       
                    if(!pnt.contains(p)){    // tikrinama ar anksciau padetu minu koordinates nesikartoja su naujai sugeneruotom
                        i++;
                    pnt.add(new Point(rx,ry));   // saugomos jau isdeliotu minu koordinates
                    matrica1[rx][ry]="B";             // i sugeneruotas kordinates idedama mina
                    
        }
     }  System.out.println("minos sugeneruotos per "+sk+" kartu");
    }
    
    public void GeneruotiXMatrica(){
        for(int i=0; i<ilgis; i++){
           for(int j=0; j<ilgis; j++){
               matrica1[i][j]="x";        // uzpildo dvi matricas x. nebutina bet padeda klaidu paieskoje/taisyme
               matrica2[i][j]="x";        
           }             
        }    
    }
    
    public void KurtiMatricas(){
        
   if(ilgis>0){     
   matrica1= new String[ilgis][ilgis];
   matrica2= new String[ilgis][ilgis];
   arMina = new boolean[ilgis][ilgis];
   arTuscia = new boolean[ilgis][ilgis];
   }
    
    
    }
    
    public void ValytiNulius(String[][] matrix){
       // arTuscia = new boolean[ilgis][ilgis];
        for(int i = 0; i<ilgis; i++){
            for(int j= 0; j< ilgis; j++){
                //arTuscia[i][j]=false;
                if("0".equals(matrix[i][j])){
                    matrix[i][j]="";
                   // arTuscia[i][j]=true;
                    
                }
                //System.out.println(arTuscia[i][j]);
            }
        }
            
    }
    
}
