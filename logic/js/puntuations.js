
// para puntuaciones




let puntuacionTotal = 0;

function pedirPuntuacion() {
    let puntuacionUsuario = prompt("Ingresa tu puntuación:");
    if (puntuacionUsuario != null) {
        return parseInt(puntuacionUsuario); 
    } else {
        alert('No ingresaste una puntuación válida.');
        return 0;
    }
}

function evaluarPuntuacion(puntuacion) {
    puntuacionTotal += puntuacion;
    if (puntuacionTotal >= 100) {
        alert('¡Felicidades, has ganado!');
    } else {
        alert('Inténtalo nuevamente para ganar. Tu puntuación actual es: ' + puntuacionTotal);
        iniciarJuego(); 
    }
}

function iniciarJuego() {
    let puntuacionUsuario = pedirPuntuacion();
    evaluarPuntuacion(puntuacionUsuario);
}

iniciarJuego();
