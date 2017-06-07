/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic;

/**
 *
 * @author Orom
 */
public class Maagic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*   
    //Instanciamos Menu
        Menu menuPrincipal=new Menu();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    /*    
    java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
        
      */
        // Main. Aki instanciamos juego 
        //Creamos los 2 jugadores con sus barajas (en este caso la de prueba)
        //Comentado por la base de datos que me da un error lo corrijo esta tarde
//        Jugador j1=new Jugador("barajas/Cartas.txt");
//        Jugador j2=new Jugador("barajas/Cartas.txt");
//        //Se barajan ambos mazos
//        j1.barajar();
//        j2.barajar();
//        while(j1.getVida()>0&&j2.getVida()>0){
//        //Inicia el turno del jugador 1
//        j1.cogerMano();
//        //Elige que carta de jugar de su mano
//        do{
//        j1.elegirCarta();
//        j1.printMesa(j2);
//        
//        }
//        while((j1.hayCarta(0)||j1.hayCarta(1)||j1.hayCarta(2))==true);
//        //Se realizan los ataques
//        j1.realizarAtaque(j2);
//        if(j2.getVida()<1){
//            break;
//        }
//        //Empieza el turno del jugador 2
//        j2.cogerMano();
//        //Elige que carta de jugar de su mano
//        do{
//        j2.elegirCarta();
//        j2.printMesa(j1);
//        }
//        while((j2.hayCarta(0)||j2.hayCarta(1)||j2.hayCarta(2))==true);
//        //Se realizan los ataques
//        j2.realizarAtaque(j1);
//        }
//        
//        //Test
//        if(j1.getVida()<1){
//            System.out.println("Jugador 1! Has Perdido!");
//        }
//        if(j2.getVida()<1){
//            System.out.println("Jugador 2! Has Perdido!");
//        }
//        //End Test
    }
    
}
