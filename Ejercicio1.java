import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import java.util.Scanner;

class Ejercicio1<T extends Comparable<T>> {
    private T value;
    private Ejercicio1<T> next;
    public Ejercicio1(T value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Ejercicio1<T> next) {
        this.next = next;
    }

    public Ejercicio1<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
    public static <T extends Comparable<T>> void insertionSort(Ejercicio1<T> head) {
        Ejercicio1<T> sorted = null;
        Ejercicio1<T> current = head;

        while (current != null) {
            Ejercicio1<T> next = current.getNext();

            if (sorted == null || current.getValue().compareTo(sorted.getValue()) < 0) {
                current.setNext(sorted);
                sorted = current;
            } else {
                Ejercicio1<T> temp = sorted;
                while (temp.getNext() != null && current.getValue().compareTo(temp.getNext().getValue()) >= 0) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = next;
        }
        head = sorted;
    }
    public static void main(String[] args) {
    	System.out.println("Introduzca el tamaño máximo del último arreglo:");
    	Scanner sc = new Scanner(System.in);	
    	int size = sc.nextInt();		//	
        
    	// Peores caseos       
        long[][] sortingTimes = new long[size][2];
        
        while (size>0) {         
        Ejercicio1<Integer> head = new Ejercicio1<>(size);
        Ejercicio1<Integer> current = head;

        for (int i = size - 1; i >= 0; i--) {
            Ejercicio1<Integer> newNode = new Ejercicio1<>(i);
            current.setNext(newNode);
            current = newNode;
        }

        // ordenar y tiempos

        long startTime = System.nanoTime();
        insertionSort(head);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        //guardar en long [][]
        for (int i = 0; i < size; i++) {
        sortingTimes[i][0] = size;
        sortingTimes[i][1] = timeTaken;
        
        }
       
        size--;
    }
        
       

        //imprimir el long [][]
       // for (int i = 0; i < sortingTimes.length; i++) {
       // for (int j = 0; j < sortingTimes[i].length; j++) {
       // System.out.print(sortingTimes[i][j] + " ");
      //  }
      //  System.out.println();
       // }

      //javaplot
        JavaPlot g = new JavaPlot();
        g.setTitle("Tiempos de Ordenamiento");
        g.getAxis("x").setLabel("Datos");
        g.getAxis("y").setLabel("Tiempo en Nanosegundos");
        g.getAxis("x").setBoundaries(0, sortingTimes.length);
        
        PlotStyle myPlotStyle = new PlotStyle();
        myPlotStyle.setStyle(Style.LINES);
        myPlotStyle.setLineWidth(1);
        DataSetPlot datos = new DataSetPlot(sortingTimes);
        datos.setPlotStyle(myPlotStyle);
        g.addPlot(datos);  
        
        g.plot();
    }
}