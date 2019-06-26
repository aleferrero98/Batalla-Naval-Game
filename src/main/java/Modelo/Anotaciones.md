#Anotaciones importantes hacerca del modelo

### Secuencia de las llamadas disparo:

un jugador quiere disparar a una celda con determinada fila y columna,
el jugador utiliza su Strategy de disparo **maneraDeDisparar**
y le pasa su tablero de disparos. Su manera de disparar le dice al
tablero que dispare a esa celda llamando al metodo dispararUna
(aclaracion: la manera de disprar gestiona si puede o realizar los disparos
preguntandole al tablero) el tablero llama a las celdas que son disparadas 
y estas celdas se van desactivando y ademas si tenian un barco encima
llaman al metodo bombardear de ese barco

### Tipos y cantidades de barcos:
- 1 Portaaviones: ocupa 5 casillas
- 1 Submarinos: ocupa 4 casillas(formando una T).
- 1 Cañonero: ocupa 4 casillas.
- 2 Destructores: ocupan 3 casillas.
- 1 Fragatas: ocupan 2 casilla.

### Tipos y cantidiades de disparos: 

