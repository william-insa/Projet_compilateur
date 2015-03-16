;entete 
extrn lirent:proc, ecrent:proc, ecrbool:poc, ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
debut : 
STARTUPCODE
;ouvrePrinc 8
mov bp,sp
sub sp,8
;iconst 10
push 10
