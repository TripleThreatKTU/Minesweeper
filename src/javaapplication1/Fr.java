            /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.sun.naming.internal.ResourceManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static javaapplication1.TCP.*;

/**
 *
 * @author Marius
 */
public class Fr extends JFrame {
    public static Thread one;
    public static JFrame serverf = new JFrame();
    public static JFrame clientf = new JFrame();
    public static JPanel n = new JPanel();
    public static JPanel pn = new JPanel();
    public static JPanel serverp = new JPanel();
    public static JPanel clientp = new JPanel();
    static JLayeredPane pane = new JLayeredPane();
    static JFrame frame = new JFrame("Minesweeper");
    final static Point p = new Point();
    static boolean PirmasPaspaudimas = true;
    final static JFrame F = new JFrame();
    static Matrica m;
    static JTable tab;
    static ArrayList<Point> points = new ArrayList<Point>();
    static ArrayList<Point> pnt = new ArrayList<Point>();
    static public JButton[][] buttons;
    static boolean[][] isEmpty;
    static boolean[][] isB;
    static boolean[][] isS;
    static boolean[][] flags;
    static boolean[][] isNotHidden;
    // static JFrame lenta = new JFrame();
    static boolean s = true;
    static boolean overload;
    static JFrame fr = new JFrame("Main menu");
    static int plotis = 30;
    static JLabel win = new JLabel();
    static JLabel loose = new JLabel("Too bad... You have triggered the bomb...");
    static JFrame dia = new JFrame(" Game over ");
    static int d = 0;
    static int o = 0;
    static Timer t;
    static JPanel lentaPanel = new JPanel();
    static int minuskaicius;
    static JButton onrestart = new JButton(" Play again? ");
    static JLayeredPane mainLayer = new JLayeredPane();
    static boolean changed = false;
    static JLabel mskaic = new JLabel();
    public static final JPanel mainp = new JPanel();
    public static ImageIcon img0 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-0.png"))));
    public static ImageIcon img1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-1.png"))));
    public static ImageIcon img2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-2.png"))));
    public static ImageIcon img3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-3.png"))));
    public static ImageIcon img4 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-4.png"))));
    public static ImageIcon img5 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-5.png"))));
    public static ImageIcon img6 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-6.png"))));
    public static ImageIcon img7 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-7.png"))));
    public static ImageIcon img8 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/Untitled-8.png"))));
    public static ImageIcon img9 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/2.png"))));
    public static ImageIcon flimg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/flag.png"))));
    public static ImageIcon qmark = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            (ResourceManager.class.getResource("/resources/q2.png"))));

    static public void isSuccess(int x, int y) {
        boolean c = false;
        int l;
        int k;
        int atidengti = 0;


        for (int e = 0; e < m.getilgis(); e++) {
            for (int f = 0; f < m.getilgis(); f++) {
                if (!isNotHidden[e][f]) {
                    atidengti++;




                }
            }
        }

        l = m.getilgis() * m.getilgis();
        k = l - m.getminos();

        if (k == atidengti) {


            c = true;

        }



        if (c || d == m.getminos()) {


            for (int i = 0; i < m.getilgis(); i++) {
                for (int j = 0; j < m.getilgis(); j++) {
                    buttons[i][j].hide();
                    flags[i][j] = false;
                    skaminas();
                }

            }
            if (!dia.isShowing()) {
                t.stop();
                TCP.sendString("w:w");
                win.setText("Success, all bombs have been found!");
                dia.add(win);
                dia.add(new JLabel("Your time is " + Integer.toString(o) + " seconds"));
                dia.add(onrestart);
                dia.setSize(240, 120);
                dia.show();
            }

        }

    }
    
    public static void faster(){
    
         JFrame opfaster = new JFrame("Game over");
         if (!opfaster.isShowing()) {

                opfaster.add(new JLabel("Too slow..."));
                opfaster.add(new JLabel("Your opponent was faster..."));


                //opfaster.add(onrestart);
                t.stop();
                opfaster.show();
            }
    
    
    
    }
    
    

    static public void gameOver(Point g) {
        if (isB[g.x][g.y]) {
            if (!dia.isShowing()) {

                dia.add(new JLabel("Too bad..."));
                dia.add(new JLabel("You have triggered the bomb..."));


                dia.add(onrestart);
                t.stop();
                dia.show();
            }

//            System.out.println("=====================================================================================================================================================================");
//            System.out.println("=====GGGGGGGGG=============AA===========MM===========MM==EEEEEEEEEEEEE================OOOOOOOOOOO======VV================VV==EEEEEEEEEEEEE===RRRRRRRRRRR=======!!!========");
//            System.out.println("===GG=========GG==========AAAA==========MMM=========MMM==EEEEEEEEEEEEE=============OOOOO=======OOOOO====VV==============VV===EEEEEEEEEEEEE===RR=========RR=====!!!========");
//            System.out.println("==GG============GG=======AA==AA=========MM=MM=====MM=MM==EE=======================OOO=============OOO====VV============VV====EE==============RR==========RR====!!!========");
//            System.out.println("=GG=====================AA====AA========MM===MM==MM==MM==EE======================OOO===============OOO====VV==========VV=====EE==============RR=========RR=====!!!========");
//            System.out.println("=GG====================AA======AA=======MM====MMMM===MM==EEEEEEEEEEEEE==========OOO=================OOO====VV========VV======EEEEEEEEEEEEE===RR=========RR=====!!!========");
//            System.out.println("=GG==========GGGGGG===AAAAAAAAAAAA======MM=====MM====MM==EEEEEEEEEEEEE==========OOO=================OOO=====VV======VV=======EEEEEEEEEEEEE===RRRRRRRRRRR=======!!!========");
//            System.out.println("=GG=============GG===AA==========AA=====MM===========MM==EE======================OOO===============OOO=======VV====VV========EE==============RR========RR======!!!========");
//            System.out.println("==GG===========GG===AA============AA====MM===========MM==EE=======================OOO=============OOO=========VV==VV=========EE==============RR=========RR================");
//            System.out.println("===GG=========GG===AA==============AA===MM===========MM==EEEEEEEEEEEEE==============OOOOO======OOOOO===========VVVV==========EEEEEEEEEEEEE===RR==========RR====!!!========");
//            System.out.println("=====GGGGGGGGG====AA================AA==MM===========MM==EEEEEEEEEEEEE=================OOOOOOOOOO===============VV===========EEEEEEEEEEEEE===RR===========RR===!!!========");
//            System.out.println("===========================================================================================================================================================================");
//

            for (int i = 0; i < isB.length; i++) {
                for (int j = 0; j < isB.length; j++) {

                    buttons[i][j].hide();
                    flags[i][j] = false;
                    skaminas();



                    if (isB[i][j]) {

                        buttons[i][j].hide();

                        flags[i][j] = false;
                        skaminas();
                    }
                }
            }
        }



    }

    static public void paieska(Point z) {



        int x;
        int y;
        int[] xk = {0, -1, -1, -1, 1, 1, 1, 0, 0};
        int[] yk = {0, 0, 1, -1, 0, -1, 1, -1, 1};


        x = z.x;
        y = z.y;

        if (x < isEmpty.length && x >= 0 && y < isEmpty.length && y >= 0) {

            if (!pnt.contains(z) && isEmpty[x][y]) {
                buttons[x][y].hide();
                flags[x][y] = false;
                skaminas();
                pnt.add(z);
                isNotHidden[x][y] = false;


                for (int i = 0; i < xk.length; i++) {
                    x = z.x + xk[i];
                    y = z.y + yk[i];
                    Point kazkas = new Point(x, y);



                    paieska(kazkas);
                    if (x < isEmpty.length && x >= 0 && y < isEmpty.length && y >= 0) {
                        buttons[x][y].hide();
                        flags[x][y] = false;
                        skaminas();
                        isNotHidden[x][y] = false;


                    }

                }
            }
        }
    }

    static public void rastiB() {
        String[][] mat = m.getmatrica2();

        if (s == true) {
            isB = new boolean[m.getilgis()][m.getilgis()];
            for (int i = 0; i < m.getilgis(); i++) {
                for (int j = 0; j < m.getilgis(); j++) {
                    isB[i][j] = false;
                    if ("B".equals(mat[i][j])) {
                        isB[i][j] = true;
                    }

                }

            }


        }
        s = false;
    }

    static public void rastiS() {
        String[][] mat = m.getmatrica2();

        if (s == true) {

            for (int i = 0; i < m.getilgis(); i++) {
                for (int j = 0; j < m.getilgis(); j++) {
                    isS[i][j] = false;
                    isNotHidden[i][j] = true;
                    if (!"B".equals(mat[i][j]) && !"".equals(mat[i][j])) {
                        isS[i][j] = true;

                    }
                }

            }


        }
    }

    static public void rastiT() {
        String[][] mat = m.getmatrica2();
        if (s == true) {
            isEmpty = new boolean[m.getilgis()][m.getilgis()];


            for (int i = 0; i < m.getilgis(); i++) {
                for (int j = 0; j < m.getilgis(); j++) {
                    isEmpty[i][j] = false;
                    if ("".equals(mat[i][j])) {
                        isEmpty[i][j] = true;
                    }

                }

            }

        }
    }

    static public void Generuoti() {
        int[] xk = {0, -1, -1, -1, 1, 1, 1, 0, 0};
        int[] yk = {0, 0, 1, -1, 0, -1, 1, -1, 1};

        if (PirmasPaspaudimas == true && p != null) {
            t.start();
            PirmasPaspaudimas = false;
            points.add(new Point(p));
            for (int i = 0; i < xk.length; i++) {

                points.add(new Point(p.x + xk[i], p.y + yk[i]));

            }
            m.GeneruotiMinas(points);
            m.IeskotiKoord();            // eina paeiliui per matricos koordinates ir skaiciuoja kiek minu yra aplink tam tikra koordinate
            m.rastiminas();             // vienoje matricoje esancias minas issaugo kitoje. to reikia, nes funkcija "IeskotiKoord" kartais vietoj minu iraso skaicius
            // m.PrintMatrix(m.getmatrica2());             // spausdina dvimate string matrica            
            m.ValytiNulius(m.getmatrica2());
            deliotiLenta();
            frame.repaint();
        }




    }

    static void skaminas() {
        minuskaicius = 0;
        for (int i = 0; i < m.getilgis(); i++) {
            for (int j = 0; j < m.getilgis(); j++) {

                if (flags[i][j]) {
                    minuskaicius++;
                }


            }


        }

        mskaic.setText(Integer.toString(m.getminos() - minuskaicius));



    }

    static public void UzdengtiLangelius(int ilg) {

        final JPanel panel = new JPanel();
        GridLayout l = new GridLayout(ilg, ilg);



        panel.setLayout(l);
        panel.setOpaque(false);

        panel.setSize(ilg * plotis, ilg * plotis);



        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {



                buttons[i][j].setCursor(new Cursor(12));

                panel.add(buttons[i][j]);
                panel.setVisible(true);
                panel.setOpaque(false);
                // fr.add(panel);
                panel.repaint();

                fr.repaint();
                mainLayer.add(panel, 0);
                //   rastiT();

            }

        }


    }

    public static void onstart() {

        initbuttons();
        dia.setBounds(400, 200, 300, 120);
        dia.setLayout(new GridLayout(3, 1));

        dia.setResizable(false);
        dia.setAlwaysOnTop(true);
        flags = new boolean[m.getilgis()][m.getilgis()];
        isS = new boolean[m.getilgis()][m.getilgis()];
        isNotHidden = new boolean[m.getilgis()][m.getilgis()];
        //=====================================================================================   


        UzdengtiLangelius(m.getilgis());
        m.ValytiNulius(m.getmatrica2());


        lentaPanel.setBounds(0, 0, plotis * m.getilgis() - 1, plotis * m.getilgis() + 1);
        lentaPanel.setBackground(Color.darkGray);



        GridLayout gr = new GridLayout(m.getilgis(), m.getilgis());
        gr.setHgap(1);
        gr.setVgap(1);
        lentaPanel.setLayout(gr);
        JPanel infp = new JPanel();
        infp.setLayout(new GridLayout(1, 4));
        infp.setBackground(Color.lightGray);
        infp.setBounds(0, plotis * m.getilgis(), plotis * m.getilgis(), 32);
        infp.setLocation(0, plotis * m.getilgis() + 1);


        final JLabel ct = new JLabel("0");
        ct.setSize(10, 30);



        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                o++;

                ct.setText(Integer.toString(o));

            }
        });
        JLabel minos = new JLabel("Mines: ");
        JLabel laikas = new JLabel("Time: ");


        mskaic.setText(Integer.toString(m.getminos() - minuskaicius));

        infp.add(laikas);
        infp.add(ct);
        infp.add(minos);
        infp.add(mskaic);
//===============================================================================================


        frame.pack();
        frame.setSize(m.getilgis() * plotis + 8, m.getilgis() * plotis + 62);
        mainLayer.add(infp);
        frame.repaint();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    static void deliotiLenta() {


        for (int i = 0; i < m.getilgis(); i++) {
            for (int j = 0; j < m.getilgis(); j++) {
                if ("".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img0));
                }

                if ("1".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img1));
                }
                if ("2".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img2));
                }
                if ("3".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img3));
                }
                if ("4".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img4));
                }
                if ("5".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img5));
                }
                if ("6".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img6));
                }
                if ("7".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img7));
                }
                if ("8".equals(m.getmatrica2()[i][j])) {
                    lentaPanel.add(new JLabel(img8));
                }
                if ("B".equals(m.getmatrica2()[i][j])) {

                    Image imgt = img9.getImage();
                    Image newimg = imgt.getScaledInstance(plotis, plotis, java.awt.Image.SCALE_SMOOTH);
                    img9 = new ImageIcon(newimg);
                    lentaPanel.add(new JLabel(img9));
                }



            }

        }


        mainLayer.add(lentaPanel, 1);

    }

    //=======================================================
    public static void main(String args[]) {
                    int ilgis = 9;
                    int bombos = 10;


                    String[][] mat = new String[ilgis][ilgis];
                    String[][] koord = new String[ilgis][ilgis];



                    m = new Matrica(mat, koord, ilgis, bombos);

        Image imgt1 = qmark.getImage();
        Image newimg = imgt1.getScaledInstance(plotis - 5, plotis - 5, java.awt.Image.SCALE_SMOOTH);
        qmark = new ImageIcon(newimg);

        Image imgt2 = flimg.getImage();
        Image newimg1 = imgt2.getScaledInstance(plotis - 8, plotis - 8, java.awt.Image.SCALE_SMOOTH);
        flimg = new ImageIcon(newimg1);

        onrestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                dia.setVisible(false);

                onrestart = new JButton(" Play again? ");
                frame.setVisible(false);
                fr.setVisible(s);
                pane = new JLayeredPane();
                frame = new JFrame("Minesweeper");

                PirmasPaspaudimas = true;


                points = new ArrayList<Point>();
                pnt = new ArrayList<Point>();


                // static JFrame lenta = new JFrame();
                s = true;

                fr = new JFrame("Main menu");

                win = new JLabel();

                dia = new JFrame("Game over");
                d = 0;
                o = 0;

                lentaPanel = new JPanel();


                mainLayer = new JLayeredPane();
                changed = false;
                mskaic = new JLabel();
                String[] a = {};
                main(a);
                n.repaint();

            }
        });



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(mainLayer, BorderLayout.CENTER);

        //==================== Nustatymu langas                  
        final JFrame of = new JFrame("Options");
        of.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        final JButton save = new JButton("Save changes");
        JButton close = new JButton("Close");
        save.setBounds(20, 200, 150, 40);
        close.setBounds(210, 200, 150, 40);
        save.setEnabled(false);
        final JSlider ls = new JSlider();
        final JSlider ms = new JSlider();
        final JLabel psk = new JLabel("");
        final JLabel minsk = new JLabel("");
        n.repaint();
        if (m == null) {
            psk.setText("");
            minsk.setText("");
            psk.setText("9");
            minsk.setText("10");
            ls.setMinimum(9);
            ls.setMaximum(30);
            ls.setValue(9);
            ms.setMinimum(10);
            ms.setMaximum(ls.getValue() * ls.getValue() - 15);
            ms.setValue(10);
        } else {
            psk.setText("");
            minsk.setText("");
            psk.setText(Integer.toString(ls.getValue()));
            minsk.setText(Integer.toString(ms.getValue()));
            ls.setMinimum(9);
            ls.setMaximum(30);
            ls.setValue(m.getilgis());
            ms.setMinimum(10);
            ms.setMaximum(ls.getValue() * ls.getValue() - 15);
            ms.setValue(m.getminos());

            psk.setText(Integer.toString(ls.getValue()));
            minsk.setText(Integer.toString(ms.getValue()));
        }


        JLabel pmin = new JLabel("9");
        JLabel pmax = new JLabel("30");

        JLabel mmin = new JLabel("10");
        final JLabel mmax = new JLabel(Integer.toString(ls.getValue() * ls.getValue() - 15));

        pmin.setBounds(20, 43, 40, 40);
        pmax.setBounds(350, 43, 40, 40);
        mmax.setBounds(350, 113, 40, 40);
        mmin.setBounds(20, 113, 40, 40);
        ls.setBounds(40, 40, 300, 30);
        ms.setBounds(40, 110, 300, 30);
        psk.setBounds(220, 20, 100, 20);
        minsk.setBounds(220, 90, 100, 20);
        JLabel pl = new JLabel("Gameboard width:");
        pl.setBounds(110, 20, 110, 20);
        JLabel msk = new JLabel("Number of mines:");
        msk.setBounds(110, 90, 110, 20);
        n.repaint();


        n = new JPanel();
        n.setLayout(null);


        n.add(ls);
        n.add(ms);
        n.add(pmin);
        n.add(pmax);
        n.add(mmin);
        n.add(mmax);
        n.add(psk);
        n.add(minsk);
        n.add(pl);
        n.add(msk);
        n.add(save);
        n.add(close);
        n.repaint();
        of.add(n);
        of.setBounds(300, 200, 400, 300);
        n.repaint();


        ls.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                psk.setText("");

                psk.setText(Integer.toString(ls.getValue()));

                ms.setMaximum(ls.getValue() * ls.getValue() - 15);
                mmax.setText(Integer.toString(ls.getValue() * ls.getValue() - 15));
                save.setEnabled(true);

            }
        });

        ms.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {

                minsk.setText("");
                minsk.setText(Integer.toString(ms.getValue()));
                save.setEnabled(true);

            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                changed = true;
                save.setEnabled(false);
                int ilgis = ls.getValue();
                int bombos = ms.getValue();

                String[][] mat = new String[ilgis][ilgis];
                String[][] koord = new String[ilgis][ilgis];

                m = new Matrica(mat, koord, ilgis, bombos);
                psk.setText("");
                minsk.setText("");
                psk.setText(Integer.toString(ls.getValue()));
                minsk.setText(Integer.toString(ms.getValue()));

            }
        });

//==============================================================================                    

        JButton sp = new JButton("Single player");
        JButton mp = new JButton("Multiplayer");
        JButton op = new JButton("Options");
        JButton ex = new JButton("Exit");



        JPanel emptyP = new JPanel();
        sp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(TCP.isHost){
               TCP.sendString("Zinute is serverio");
                }
                 if(!TCP.isHost){
               TCP.sendString("Zinute is kliento");
                }
               
st();

            }
        });



        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                of.setVisible(false);
                psk.setText("");
                minsk.setText("");
                psk.setText(Integer.toString(ls.getValue()));
                minsk.setText(Integer.toString(ms.getValue()));

            }
        });

        op.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                of.setVisible(true);
                of.add(n);
            }
        });

        mp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // fr.hide();
              

                          
                one = new Thread() {
 @Override
 public void run() {
  String[] a ={};
  TCP.main(a);
   fr.setVisible(false);
     
     
 }
 
};

one.start();
              



            }
        });


        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                System.exit(0);
            }
        });
        emptyP.setOpaque(false);
        fr.setBounds(100, 100, 250, 300);


        sp.setBounds(15, 50, 215, 40);
        mp.setBounds(15, 100, 215, 40);
        op.setBounds(15, 150, 215, 40);
        ex.setBounds(15, 200, 215, 40);
        of.setResizable(false);
        mainp.setLayout(new BorderLayout());
        mainp.add(sp);
        mainp.add(mp);
        mainp.add(op);
        mainp.add(ex);
        mainp.add(new JPanel());

        fr.add(mainp);
        fr.setResizable(false);



        fr.setVisible(true);


        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static JPanel initmppan() {

        final JPanel mainpan = new JPanel();
        JButton mps = new JButton("Server");
        JButton mpc = new JButton("Client");
        JButton bck = new JButton("Back");

        mps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {


                serverf.setSize(200, 200);
                serverf.add(serverp);
                serverf.setVisible(true);

            }
        });


        mpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clientf.setSize(200, 200);
                clientf.add(clientp);
                clientf.setVisible(true);


            }
        });

        bck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pn.setVisible(false);
                mainp.setVisible(true);
            }
        });
        mpc.setBounds(15, 50, 215, 40);
        mps.setBounds(15, 100, 215, 40);

        bck.setBounds(15, 200, 215, 40);

        mainpan.setLayout(new BorderLayout());
        mainpan.add(mpc);
        mainpan.add(mps);
        mainpan.add(bck);
        mainpan.add(new JPanel());

        return mainpan;
    }

//    static void initserverPanel() {
//        serverp = new JPanel();
//
//        serverp.setLayout(new GridLayout(6, 1));
//
//        InetAddress IP = null;
//        try {
//            IP = InetAddress.getLocalHost();
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Fr.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        JTextField ip = new JTextField(IP.getHostAddress());
//        ip.setEditable(false);
//        JTextField soc = new JTextField("1234");
//        ip.setSize(100, 20);
//        serverp.add(new JLabel("IP adress:"));
//        serverp.add(ip);
//        serverp.add(new JLabel("Port:"));
//        serverp.add(soc);
//        serverp.add(new JLabel());
//
//        JPanel gr = new JPanel();
//        gr.setLayout(new GridLayout(1, 2));
//        JButton b1 = new JButton("Start");
//        JButton b2 = new JButton("Close");
//        
//        
//        b1.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//  
//               
//            
//            }
//        });
//        
//        
//        
//        b2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//
//
//                serverf.setVisible(false);
//
//            }
//        });
//        gr.add(b1);
//        gr.add(b2);
//        serverp.add(gr);
//
//
//    }
//
//    static void initclientPanel() {
//        clientp = new JPanel();
//
//        clientp.setLayout(new GridLayout(6, 1));
//
//
//
//        JTextField ip = new JTextField();
//
//        JTextField soc = new JTextField("1234");
//
//        clientp.add(new JLabel("                    IP adress:"));
//        clientp.add(ip);
//        clientp.add(new JLabel("                         Port:"));
//        clientp.add(soc);
//        clientp.add(new JLabel());
//
//        JPanel gr = new JPanel();
//        gr.setLayout(new GridLayout(1, 2));
//        JButton b1 = new JButton("Start");
//        JButton b2 = new JButton("Close");
//        gr.add(b1);
//        gr.add(b2);
//
//        b2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                clientf.setVisible(false);
//            }
//        });
//
//
//
//
//
//
//        clientp.add(gr);
//
//
//    }

    static void initbuttons() {


        buttons = new JButton[m.getilgis()][m.getilgis()];
        final int[][] fl = new int[m.getilgis()][m.getilgis()];

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {

                buttons[i][j] = new JButton();


                buttons[i][j].setCursor(new Cursor(12));





                buttons[i][j].addMouseListener(new java.awt.event.MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        if (me.isMetaDown()) {

                            int kx = ((JButton) me.getSource()).getX() / plotis;
                            int ky = ((JButton) me.getSource()).getY() / plotis;
                            if (fl[kx][ky] == 0) {


                                ((JButton) me.getSource()).setIcon(null);
                                ((JButton) me.getSource()).setIcon(flimg);
                                fl[kx][ky] = 1;

                                flags[ky][kx] = true;


                                isSuccess(kx, ky);


                            } else {
                                if (fl[kx][ky] == 2) {
                                    fl[kx][ky] = 0;

                                    ((JButton) me.getSource()).setIcon(null);
                                    flags[ky][kx] = false;

                                } else {
                                    flags[ky][kx] = false;
                                    fl[kx][ky] = 2;

                                    ((JButton) me.getSource()).setIcon(null);
                                    ((JButton) me.getSource()).setIcon(qmark);


                                }
                            }

                            skaminas();

                        }

                    }
                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                    @Override
                    public void mousePressed(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });


                buttons[i][j].addActionListener(new java.awt.event.ActionListener() {
                    int y;
                    int x;

                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        x = ((JButton) ae.getSource()).getX();
                        y = ((JButton) ae.getSource()).getY();
                        p.x = y / plotis;
                        p.y = x / plotis;
                        Generuoti();

                        rastiS();
                        rastiT();
                        rastiB();

                        gameOver(p);
                        paieska(p);

                        pnt.clear();

                        ((JButton) ae.getSource()).hide();
                        flags[p.x][p.y] = false;
                        skaminas();
                        isNotHidden[p.x][p.y] = false;
                        isSuccess(p.x, p.y);



                    }
                });


            }
        }


    }
    
    public static void st(){
        
         fr.hide();

                if (!changed) {


                    int ilgis = 9;
                    int bombos = 10;


                    String[][] mat = new String[ilgis][ilgis];
                    String[][] koord = new String[ilgis][ilgis];



                    m = new Matrica(mat, koord, ilgis, bombos);
                    onstart();


                } else {
                    onstart();
                }
        
        
    }
    
    
    
}
