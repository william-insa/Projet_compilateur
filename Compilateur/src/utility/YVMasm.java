package utility;

import java.io.OutputStream;

public class YVMasm implements YVM {

	private OutputStream file;
	private int comptString;

	public YVMasm(String nom) {
		super();
		file = Ecriture.ouvrir(nom + ".asm");
		this.comptString = 0;
	}

    public void entete(){
		
	    Ecriture.ecrireStringln (file,";entete ");
	    Ecriture.ecrireStringln (file,"extrn lirent:proc, ecrent:proc, ecrbool:poc, ecrch:proc, ligsuiv:proc");  
	    Ecriture.ecrireStringln (file,".model SMALL");
	    Ecriture.ecrireStringln (file,".586");
	    Ecriture.ecrireStringln (file,".CODE");
	    Ecriture.ecrireStringln (file,"debut : ");
	    Ecriture.ecrireStringln (file,"STARTUPCODE");
    }
    
	
	
	public void ouvrePrinc(int x){
		Ecriture.ecrireStringln (file,";ouvrePrinc " + 2*x);
	    Ecriture.ecrireStringln (file,"mov bp,sp");
	    Ecriture.ecrireStringln (file,"sub sp," + 2*x);
	}
	
	public void iconst(int valeur){
		Ecriture.ecrireStringln (file,";iconst " + valeur);	
	    Ecriture.ecrireStringln (file,"push " + valeur);
	}
	
	public void idiv(){
		Ecriture.ecrireStringln (file,";idiv");
	    Ecriture.ecrireStringln (file,"pop bx");
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"cwd");
	    Ecriture.ecrireStringln (file,"idiv bx");
	    Ecriture.ecrireStringln (file,"push ax");
	}
	
	public void iadd(){
		Ecriture.ecrireStringln (file,";iadd");
		Ecriture.ecrireStringln (file,"pop bx");	
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"add ax,bx");
	    Ecriture.ecrireStringln (file,"push ax");
	}
	
	public void istore(int offset){
		Ecriture.ecrireStringln (file,";istore " + offset);
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"mov word ptr[bp" + offset +"],ax");
	}
	
	public void iload (int x){
		Ecriture.ecrireStringln (file,";iload "+x);	
	    Ecriture.ecrireStringln (file,"push word ptr[bp" + x + "]");
	}
	
	public void imul(){
		Ecriture.ecrireStringln (file,";imul");	
	    Ecriture.ecrireStringln (file,"pop bx");
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"imul bx");
	    Ecriture.ecrireStringln (file,"push ax");
	}
	
	public void isub(){
		Ecriture.ecrireStringln (file,";isub");
		Ecriture.ecrireStringln (file,"pop bx");	
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"sub ax,bx");
	    Ecriture.ecrireStringln (file,"push ax");
	}
	
	public void ior(){
		Ecriture.ecrireStringln (file,";ior");
	    Ecriture.ecrireStringln (file,"pop bx");
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"or ax,bx");
	    Ecriture.ecrireStringln (file,"push ax");
		
	}
	
	public void iinfegal(){
		Ecriture.ecrireStringln (file,";iinfegal");	
	    Ecriture.ecrireStringln (file,"pop bx");
	    Ecriture.ecrireStringln (file,"pop ax");
	    Ecriture.ecrireStringln (file,"cmp ax,bx");
	    Ecriture.ecrireStringln (file,"jg $+6");
	    Ecriture.ecrireStringln (file,"push -1");
	    Ecriture.ecrireStringln (file,"jmp $+4");
	    Ecriture.ecrireStringln (file,"push 0");
	}
	
	public void queue(){
		Ecriture.ecrireStringln (file,";queue");	
	    Ecriture.ecrireStringln (file,"nop");
	    Ecriture.ecrireStringln (file,"exitcode");
	    Ecriture.ecrireStringln (file,"end debut");
		Ecriture.fermer(file);
	}

	public void iinf() {
		Ecriture.ecrireStringln(file, ";iinf");
		Ecriture.ecrireStringln(file, "pop bx");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,bx");
		Ecriture.ecrireStringln(file, "jge $+6");
		Ecriture.ecrireStringln(file, "push -1");
		Ecriture.ecrireStringln(file, "jmp $+4");
		Ecriture.ecrireStringln(file, "push 0");
	}

	public void ineg() {
		Ecriture.ecrireStringln(file, ";ineg");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "push dx");
		Ecriture.ecrireStringln(file, "mov dx,-1");
		Ecriture.ecrireStringln(file, "mul dx");
		Ecriture.ecrireStringln(file, "pop dx");
		Ecriture.ecrireStringln(file, "push ax");
	}

	public void inot() {
		Ecriture.ecrireStringln(file, ";inot");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "not ax");
		Ecriture.ecrireStringln(file, "push ax");
	}

	public void isup() {
		Ecriture.ecrireStringln(file, ";isup");
		Ecriture.ecrireStringln(file, "pop bx");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,bx");
		Ecriture.ecrireStringln(file, "jle $+6");
		Ecriture.ecrireStringln(file, "push -1");
		Ecriture.ecrireStringln(file, "jmp $+4");
		Ecriture.ecrireStringln(file, "push 0");
	}

	public void isupegal() {
		Ecriture.ecrireStringln(file, ";isupegal");
		Ecriture.ecrireStringln(file, "pop bx");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,bx");
		Ecriture.ecrireStringln(file, "jl $+6");
		Ecriture.ecrireStringln(file, "push -1");
		Ecriture.ecrireStringln(file, "jmp $+4");
		Ecriture.ecrireStringln(file, "push 0");
	}

	public void iegal() {
		Ecriture.ecrireStringln(file, ";iegal");
		Ecriture.ecrireStringln(file, "pop bx");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,bx");
		Ecriture.ecrireStringln(file, "jne $+6");
		Ecriture.ecrireStringln(file, "push -1");
		Ecriture.ecrireStringln(file, "jmp $+4");
		Ecriture.ecrireStringln(file, "push 0");
	}

	public void ifeq(String etiq) {
		Ecriture.ecrireStringln(file, ";ifeq " + etiq);
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,0");
		Ecriture.ecrireStringln(file, "je " + etiq);
	}

	public void idiff() {
		Ecriture.ecrireStringln(file, ";idiff");
		Ecriture.ecrireStringln(file, "pop bx");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,bx");
		Ecriture.ecrireStringln(file, "je $+6");
		Ecriture.ecrireStringln(file, "push -1");
		Ecriture.ecrireStringln(file, "jmp $+4");
		Ecriture.ecrireStringln(file, "push 0");
	}

	public void iand() {
		Ecriture.ecrireStringln(file, ";and");
		Ecriture.ecrireStringln(file, "pop bx");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "and ax,bx");
		Ecriture.ecrireStringln(file, "push ax");
	}

	public void Goto(String etiq) {
		Ecriture.ecrireStringln(file, ";goto " + etiq);
		Ecriture.ecrireStringln(file, "jmp " + etiq);
	}

	public void aLaLigne() {
		Ecriture.ecrireStringln(file, ";aLaLigne");
		Ecriture.ecrireStringln(file, "call ligsuiv");
	}

	public void lireEnt(int x) {
		Ecriture.ecrireStringln(file, ";lireEnt " + x);
		Ecriture.ecrireStringln(file, "lea dx,[bp" + x + "]");
		Ecriture.ecrireStringln(file, "push dx");
		Ecriture.ecrireStringln(file, "call lirent");
	}

	public void ecrireChaine(String x) {
		Ecriture.ecrireStringln(file, ";ecrireChaine " + x);
		Ecriture.ecrireStringln(file, ".DATA\n\tmess" + this.comptString 
				+ " DB " + "\"" + x.substring(1,x.length() - 1) + "$ \"");
		Ecriture.ecrireStringln(file, ".CODE\n\tlea dx,mess" + this.comptString
				+ "\n\tpush dx\n\tcall ecrch");
		this.comptString++;
	}

	public void ecrireEnt() {
		Ecriture.ecrireStringln(file, ";ecrireEnt");
		Ecriture.ecrireStringln(file, "call ecrent");
	}

	public void ecrireBool() {
		Ecriture.ecrireStringln(file, ";ecrireBool");
		Ecriture.ecrireStringln(file, "call ecrbool");
	}
	
	public void etiquette(String etiq) {
		Ecriture.ecrireStringln(file, etiq+":");
	}
	
	public void iffaux(String etiq) {
		Ecriture.ecrireStringln(file, ";iffaux " + etiq + ":");
		Ecriture.ecrireStringln(file, "pop ax");
		Ecriture.ecrireStringln(file, "cmp ax,0");
		Ecriture.ecrireStringln(file, "je " + etiq);
	}
}
