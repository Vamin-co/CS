    segment .data
x       dw  -6, 14, 156     ; array of three values
y       db  -4, -22, 15     ; array of three values
result  dq  0               ; final result

    segment .text
    global main 
main: 
    ; Initialize the registers
    xor rax, rax

    ; Load addresses of x and y
    lea r10, [x]
    lea r11, [y]
    
    ; Load the first elements of x and y into R10 and R11
    movsx r10, word [r10]
    movsx r11, byte [r11]
    
    add r10, -12
    add r11, -6
    
    sub r11, r10
    mov r12, r11
    
    lea r10, [x+2]
    lea r11, [y+1]
    
    movsx r10, word [r10]
    movsx r11, byte [r11]

    add r10, -12
    add r11, -6
    
    add r11, r10
    add r12, r11
    
    lea r10, [x+4]
    lea r11, [y+2]
    
    movsx r10, word [r10]
    movsx r11, byte [r11]

    add r10, -12
    add r11, -6
    
    sub r11, r10
    add r12, r11
    
    xor r10, r10    ; zero out rax
    xor r11, r11
    xor r12, r12

    
