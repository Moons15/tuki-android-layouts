package com.tuki.di;

public enum ThreadTask {
    GUI, //Ejecuciones en el hilo principal
    DATA, //Ejecuciones de red o tareas largas y pesadas.
    SINGLE, //Tareas simples que no requieren muchos hilos.
}
