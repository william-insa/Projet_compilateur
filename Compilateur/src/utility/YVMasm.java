package utility;

import java.io.OutputStream;

public class YVMasm implements YVM {
	static OutputStream  file;
	
    public void entete(){
		
	file = Ecriture.ouvrir("result.asm");
		
    Ecriture.ecrireStringln (";entete ");
    Ecriture.ecrireStringln (".model SMALL");
    Ecriture.ecrireStringln (".586");
    Ecriture.ecrireStringln (".CODE");
    Ecriture.ecrireStringln ("debut : ");
    Ecriture.ecrireStringln ("STARTUPCODE");
    }
	
	public void ouvrePrinc(int x){
	Ecriture.ecrireStringln (";ouvrePrinc " + x);
    Ecriture.ecrireStringln ("mov bp,sp");
    Ecriture.ecrireStringln ("sub sp," + x);
	}
	
	public void iconst(int valeur){
	Ecriture.ecrireStringln (";iconst " + valeur);	
    Ecriture.ecrireStringln ("push " + 10);
	}
	
	public void idiv(){
	Ecriture.ecrireStringln (";idiv");
    Ecriture.ecrireStringln ("pop bx");
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("cwd");
    Ecriture.ecrireStringln ("idiv bx");
    Ecriture.ecrireStringln ("push ax");
	}
	
	public void iadd(){
	Ecriture.ecrireStringln (";iadd");
	Ecriture.ecrireStringln ("pop bx");	
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("add ax,bx");
    Ecriture.ecrireStringln ("push ax");
	}
	
	public void istore(int offset){
	Ecriture.ecrireStringln (";istore " + offset);
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("mov word ptr[bp" + offset +"],ax");
	}
	
	public void iload (int x){
	Ecriture.ecrireStringln (";iload");	
    Ecriture.ecrireStringln ("push word ptr[bp" + x + "]");
	}
	
	public void imul(){
	Ecriture.ecrireStringln (";imul");	
    Ecriture.ecrireStringln ("pop bx");
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("imul bx");
    Ecriture.ecrireStringln ("push ax");
	}
	
	public void isub(){
	Ecriture.ecrireStringln (";isub");
	Ecriture.ecrireStringln ("pop bx");	
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("sub ax,bx");
    Ecriture.ecrireStringln ("push ax");
	}
	
	public void ior(){
	Ecriture.ecrireStringln (";ior");
    Ecriture.ecrireStringln ("pop bx");
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("or ax,bx");
    Ecriture.ecrireStringln ("push ax");
		
	}
	
	public void iinfegal(){
	Ecriture.ecrireStringln (";iinfegal");	
    Ecriture.ecrireStringln ("pop bx");
    Ecriture.ecrireStringln ("pop ax");
    Ecriture.ecrireStringln ("cmp ax,bx");
    Ecriture.ecrireStringln ("jg $+6");
    Ecriture.ecrireStringln ("push -1");
    Ecriture.ecrireStringln ("jmp $+4");
    Ecriture.ecrireStringln ("push 0");
	}
	
	public void queue(){
	Ecriture.ecrireStringln (";queue");	
    Ecriture.ecrireStringln ("nop");
    Ecriture.ecrireStringln ("exitcode");
    Ecriture.ecrireStringln ("end debut");
	}
}
