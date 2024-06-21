// para dia de la semana

function pedirDia(){
    let diaUsuario = prompt (' que dia es hoy?')
    if(diaUsuario == 'domingo'|| diaUsuario== 'sabado'){
        return alert('muy feliz dia cabronaso celebremos hoy es '+ diaUsuario,'!')
    }else{
        alert('vete alv no hay nada que celebrar')
        pedirDia();
    }
}


pedirDia();


