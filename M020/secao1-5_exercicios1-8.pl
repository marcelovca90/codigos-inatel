% https://swish.swi-prolog.org/
% Secao 1.5, Exemplo 39, Exercicios 1-8

come(urso,peixe).
come(peixe,peixinho).
come(peixinho,alga).
come(guaxinim,peixe).
come(urso,guaxinim).
come(urso,raposa).
come(raposa,coelho).
come(coelho,grama).
come(urso,veado).
come(veado,grama).
come(lince,veado).

animal(urso).
animal(peixe).
animal(peixinho).
animal(guaxinim).
animal(raposa).
animal(coelho).
animal(veado).
animal(lince).

planta(grama).
planta(alga).

presa(X) :- come(_,X), animal(X).

% 1)
% come(urso,peixinho).
% 
% 2)
% come(raposa,coelho).
% 
% 3)
% come(guaxinim,X).
% 
% 4)
% come(X,grama).
% 
% 5)
% come(urso,X), come(X,coelho).
% 
% 6)
% presa(X), not(come(raposa,X)).
% 
% 7)
% herbivoro(X) :- come(X,Y), not(animal(Y)).
% 
% 8)
% herbivoro(X).
