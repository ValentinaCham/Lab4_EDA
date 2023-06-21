import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import java.util.Scanner;

import java.util.Scanner;

class Ejercicio2<T extends Comparable<T>> {
    private T value;
    private Ejercicio2<T> prev;
    private Ejercicio2<T> next;

    public Ejercicio2(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public void setPrev(Ejercicio2<T> prev) {
        this.prev = prev;
    }

    public Ejercicio2<T> getPrev() {
        return prev;
    }

    public void setNext(Ejercicio2<T> next) {
        this.next = next;
    }

    public Ejercicio2<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public static <T extends Comparable<T>> void insertionSort(Ejercicio2<T> head) {
        Ejercicio2<T> sorted = null;
        Ejercicio2<T> current = head;

        while (current != null) {
            Ejercicio2<T> next = current.getNext();

            if (sorted == null || current.getValue().compareTo(sorted.getValue()) < 0) {
                current.setPrev(null);
                current.setNext(sorted);
                if (sorted != null)
                    sorted.setPrev(current);
                sorted = current;
            } else {
                Ejercicio2<T> temp = sorted;
                while (temp.getNext() != null && current.getValue().compareTo(temp.getNext().getValue()) >= 0) {
                    temp = temp.getNext();
                }
                current.setPrev(temp);
                current.setNext(temp.getNext());
                if (temp.getNext() != null)
                    temp.getNext().setPrev(current);
                temp.setNext(current);
            }
            current = next;
        }
        head = sorted;
    }

    public static void main(String[] args) {
        System.out.println("Introduzca el tamaño máximo del último arreglo:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        // Peores casos
        long[][] sortingTimes = new long[size][2];

        while (size > 0) {
            Ejercicio2<Integer> head = new Ejercicio2<>(size);
            Ejercicio2<Integer> current = head;

            for (int i = size - 1; i >= 0; i--) {
                Ejercicio2<Integer> newNode = new Ejercicio2<>(i);
                newNode.setPrev(current);
                current.setNext(newNode);
                current = newNode;
            }

            // Ordenar y calcular tiempos
            long startTime = System.nanoTime();
            insertionSort(head);
            long endTime = System.nanoTime();
            long timeTaken = endTime - startTime;

            // Guardar en arreglo de long[][]
            for (int i = 0; i < size; i++) {
                sortingTimes[i][0] = size;
                sortingTimes[i][1] = timeTaken;
            }

            size--;
        }

        // Imprimir el arreglo de long[][]
        /*
        for (int i = 0; i < sortingTimes.length; i++) {
            for (int j = 0; j < sortingTimes[i].length; j++) {
                System.out.print(sortingTimes[i][j] + " ");
            }
            System.out.println();
        }
        */

        // JavaPlot
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
