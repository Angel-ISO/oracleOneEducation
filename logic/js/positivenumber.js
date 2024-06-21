// para el numero positivo

function numeroPos(){
    let numerousuario = prompt('ingresa un numero porfavor')
    if(numerousuario > 0){
        return alert('es positivo')
    }else if(numerousuario == 0){
        return alert ('el numero es cero')
    }else{
        alert('el numero es negativo')
        numeroPos();
    }
}


numeroPos();