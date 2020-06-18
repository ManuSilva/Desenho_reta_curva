package Package;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.awt.GLCanvas ;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLAutoDrawable;

import java.nio.FloatBuffer;

import javax.swing.JFrame;

public class Curva implements GLEventListener{
	
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	private float x3;
	private float y3;
	private float x4;
	private float y4;
	int size = 15;
	
	 // *-----> Construtor
    public Curva(float x1, float y1,float x2,float y2, float x3, float y3, float x4,float y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }
    
    private void draw_pixel(GL2 gl, float x, float y, String cor) {
    	 if(cor.compareTo("BLACK") == 0) {
      	   //Inicia A cor Preto
             gl.glColor3f(0, 0, 0);
      	   
         }
         
         if(cor.compareTo("BLUE") == 0) {
      	   //Inicia A cor Vermelha
             gl.glColor3f(0, 0, 1);
      	   
         }
         
         if(cor.compareTo("GREEN") == 0) {
      	   //Inicia A cor Verde
             gl.glColor3f(0, 1, 0);
      	   
         }
  	   
  	   
         int lados = 60;
         double raio = 0.5;
         double PI = 3.14159265;
         
         gl.glBegin(gl.GL_POLYGON);
             for (int i = 0; i < lados; ++i) {
             	gl.glVertex2d(x + raio*Math.cos(i*2*PI/lados), y + raio*Math.sin(i*2*PI/lados));
             }
             gl.glEnd();
    	
    }

	@Override
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		
	      //Inicia A cor Preta
        gl.glColor3f(0, 0, 0);
  	
    	gl.glBegin(gl.GL_LINES);
        for (int i = 0; i < size; i++) {
        	gl.glVertex2f(i, 0);
        	gl.glVertex2f(i, size);

        	gl.glVertex2f(0, i);
        	gl.glVertex2f(size, i);
        }
        gl.glEnd();

	    gl.glColor3f(1.0f, 1.0f, 1.0f);
	    gl.glBegin(GL2.GL_LINE_STRIP);
	    for (int i = 0; i <= 30; i++)
	    {
	      gl.glEvalCoord1f((float) i / (float) 30.0);
	    }
	    gl.glEnd();
	     
	      // Exibir pontos de controle
	      
	      draw_pixel(gl, x1, y1,"GREEN");
	      draw_pixel(gl, x2, y2,"GREEN");
	      draw_pixel(gl, x3, y3,"GREEN");
	      draw_pixel(gl, x4, y4,"GREEN");

		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		final GL2 gl = arg0.getGL().getGL2();
		
        // Limpar a Tela e Setar a cor Branca
        gl.glClearColor(1, 1, 1, 0);
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT);
          
        
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glOrtho(0, size, 0, size, 1, -1);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        
		
		/* FloatBuffer ctrlpointBuf = FloatBuffer.allocate(12);

		   
		   ctrlpointBuf.put(x1);
		   ctrlpointBuf.put(y1);
		   ctrlpointBuf.put(x2);
		   ctrlpointBuf.put(y2);
		   ctrlpointBuf.put(x3);
		   ctrlpointBuf.put(y3);
		   ctrlpointBuf.put(x4);
		   ctrlpointBuf.put(y4);
 
           ctrlpointBuf.rewind();

		    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		    gl.glShadeModel(GL2.GL_FLAT);
		    gl.glMap1f(GL2.GL_MAP1_VERTEX_3, 0.0f, 1.0f, 3, 4, ctrlpointBuf);
		    gl.glEnable(GL2.GL_MAP1_VERTEX_3);*/
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		   final GL2 gl = arg0.getGL().getGL2();
		   
		    gl.glViewport(0, 0, arg3, arg4);
		    gl.glMatrixMode(GL2.GL_PROJECTION);
		    gl.glLoadIdentity();
		    if (arg3 <= arg4) {
		    	gl.glOrtho(-5.0, 5.0, -5.0 * (float) arg3 / (float) arg4, 5.0 * (float) arg3 / (float) arg4, -5.0, 5.0);
		    }else {
		    	gl.glOrtho(-5.0 * (float) arg3 / (float) arg4, 5.0 * (float) arg3 / (float) arg4,-5.0, 5.0, -5.0, 5.0);
		    } 
		
		    gl.glMatrixMode(GL2.GL_MODELVIEW);
		    gl.glLoadIdentity();
		
	}

}
