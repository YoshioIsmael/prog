package Vistas;



import estructurasInformacion.Puntos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *En esta clase se visualiza lo que se importo
 * @author YIMA
 */
public class LienzoImportarMatriz  extends JPanel
{
    private JTextArea areaRepintado;
    private JLabel matrizVisual [][];
    private Vector<Puntos> anteriores;
    
    //Constructor de la clase
    public LienzoImportarMatriz()
    {        
        setSize(300,300);
        anteriores = new Vector<Puntos>();
        configuracionBorde();
    }
    
    public void inicializarComponentes(int tamanio)
    {
        setLayout(new GridLayout(tamanio,tamanio));        
        matrizVisual = new JLabel[tamanio][tamanio];
        anteriores.clear();
        this.setBackground(Color.BLACK);
        agregarComponentesPanel();         
    }
    
    
    public void actualizar(int tamanio)
    {
        for(int i=0; i < matrizVisual.length; i++)
        {
            for(int j=0; j < matrizVisual.length; j++)
            {                  
                this.remove(matrizVisual[i][j]);
            }
        }        
        inicializarComponentes(tamanio);
        
        this.updateUI();
    }
    
    
    public void agregarComponentesPanel()
    {
        for(int i=0; i < matrizVisual.length; i++)
        {
            for(int j=0; j < matrizVisual.length; j++)
            {
                matrizVisual[i][j] = new JLabel(" ");
                matrizVisual[i][j].setBackground(null);
                matrizVisual[i][j].setOpaque(true); //Inica que debe de reflejar el color               
                add(matrizVisual[i][j]); //se agrega al panel
            }
        }
    }
    
    public void limpiarMatriz()
    {
        for(int i=0; i < matrizVisual.length; i++)
        {
            for(int j=0; j < matrizVisual.length; j++)
            {
                matrizVisual[i][j].setBackground(null);
            }
        }
    }
    
    public void repintarArea(Vector<Puntos> actualizar)
    {
        for(int i=0; i< anteriores.size(); i++)
        {
            Puntos punto = anteriores.get(i);
            matrizVisual[punto.i][punto.j].setBackground(null);
        }
        
        anteriores.clear();
        
        for(int i=0; i< actualizar.size(); i++)
        {
            Puntos punto = actualizar.get(i);
            anteriores.add(punto);
            matrizVisual[punto.i][punto.j].setBackground(Color.GREEN);
        }
        
        
    }
    
    public void configuracionBorde()
    {
        TitledBorder border = new TitledBorder("--Puntos donde se estuvo dos veces--");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        this.setBorder(border);
    }
}
