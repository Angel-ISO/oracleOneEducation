let numerosGenerados = [];
let numeroSecreto = GeneraRamdom();
let intentos = 0;

function asignarTexto(elemento, texto) {
    let parrafo = document.querySelector(elemento);
    parrafo.innerHTML = texto;
}

function GeneraRamdom() {
    let ramdom;
    do {
        ramdom = Math.floor(Math.random() * 10) + 1;
    } while (numerosGenerados.includes(ramdom));
    numerosGenerados.push(ramdom);
    return ramdom;
}

let titulo = asignarTexto('h1', 'Bienvenido al juego');
let instruccion = asignarTexto('.texto__parrafo', 'Selecciona un número entre 1 y 10');

function verificarIngreso() {
    if (intentos >= 3) {
        asignarTexto('.texto__parrafo', 'Has alcanzado el número máximo de intentos. No puedes intentar más.');
        document.querySelector('#botonIntento').disabled = true;
        return;
    }

    let inputIntento = parseInt(document.querySelector('#inputintento').value);
    intentos++;

    if (inputIntento === numeroSecreto) {
        asignarTexto('.texto__parrafo', '¡Felicidades, acertaste el número!');
        document.querySelector('#botonIntento').disabled = true;
    } else {
        if (numeroSecreto > inputIntento) {
            asignarTexto('.texto__parrafo', 'No acertaste, el número secreto es mayor.');
            limpiarInput();
        } else {
            asignarTexto('.texto__parrafo', 'No acertaste, el número secreto es menor.');
            limpiarInput();
        }
        if (intentos >= 3) {
            asignarTexto('.texto__parrafo', 'No acertaste. Has alcanzado el número máximo de intentos.');
            document.querySelector('#botonIntento').disabled = true;
        }
    }
}

function limpiarInput() {
    let valor = document.querySelector('#inputintento');
    valor.value = '';
}

document.querySelector('#botonIntento').addEventListener('click', verificarIngreso);
