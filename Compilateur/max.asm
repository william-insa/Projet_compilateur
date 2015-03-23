;entete 
extrn lirent:proc, ecrent:proc, ecrbool:poc, ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
debut : 
STARTUPCODE
;iload
push word ptr[bp0]
;iconst 10
push 10
;iadd
pop bx
pop ax
add ax,bx
push ax
;iconst 10
push 10
;idiv
pop bx
pop ax
cwd
idiv bx
push ax
;iconst 2
push 2
;idiv
pop bx
pop ax
cwd
idiv bx
push ax
;iconst 5
push 5
;iload
push word ptr[bp0]
;iload
push word ptr[bp0]
;iadd
pop bx
pop ax
add ax,bx
push ax
;iconst 3
push 3
;imul
pop bx
pop ax
imul bx
push ax
;iload
push word ptr[bp0]
;isub
pop bx
pop ax
sub ax,bx
push ax
;iconst 10
push 10
;iload
push word ptr[bp0]
;iconst 1
push 1
;ior
pop bx
pop ax
or ax,bx
push ax
;iload
push word ptr[bp0]
;iload
push word ptr[bp0]
;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0
;iload
push word ptr[bp0]
;iadd
pop bx
pop ax
add ax,bx
push ax
;iconst 4
push 4
;queue
nop
exitcode
end debut
