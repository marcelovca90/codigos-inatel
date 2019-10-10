% https://swish.swi-prolog.org/
% Secao 1.5, Exercicio 17 (7a edicao)

homem(alberto).
homem(silvio).
homem(tiago).
homem(murilo).
homem(felipe).

mulher(rebeca).
mulher(cintia).
mulher(silvia).
mulher(daniela).
mulher(patricia).
mulher(renata).
mulher(luana).
mulher(amanda).

progenitor(alberto,silvio).
progenitor(rebeca,silvio).
progenitor(silvio,cintia).
progenitor(silvio,silvia).
progenitor(silvio,daniela).
progenitor(silvio,patricia).
progenitor(silvio,renata).
progenitor(cintia,tiago).
progenitor(silvia,luana).
progenitor(murilo,luana).
progenitor(silvia,amanda).
progenitor(felipe,amanda).

% a)
% paiDe(X, Y) :- homem(X), progenitor(X, Y).

% b)
% filhaDe(X, Y) :- mulher(X), progenitor(Y, X).

% c)
% ancestralDe(X, Y) :- progenitor(X, Y).
% ancestralDe(X, Y) :- progenitor(Z, Y), ancestralDe(X, Z).
