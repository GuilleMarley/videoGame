package Windows;

//Demostracion de hilo que se muestra por consola cada 5 segundos

public class Threads extends Thread{
    @Override
    public void run(){
        while(true) { //Este while hace que el hilo aparezca todo el rato mientras el programa esta corriendo
            try {
                Thread.sleep(5000);
                System.out.println("Este hilo esta corriendo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
