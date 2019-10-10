% https://swish.swi-prolog.or
% Secao 1.5, Exercício 20 (7ª edição)

cidade(beloHorizonte).
cidade(saoPaulo).
cidade(rioDeJaneiro).
cidade(itabira).
cidade(voltaRedonda).
cidade(guarulhos).

voo(beloHorizonte,saoPaulo).
voo(beloHorizonte,rioDeJaneiro).
voo(beloHorizonte,itabira).
voo(rioDeJaneiro,saoPaulo).
voo(rioDeJaneiro,beloHorizonte).
voo(rioDeJaneiro,voltaRedonda).
voo(saoPaulo,beloHorizonte).
voo(saoPaulo,rioDeJaneiro).
voo(saoPaulo,guarulhos).

% a)
% voo(beloHorizonte,Y).

% b)
% voo(X,rioDeJaneiro).

% c)
% rota(X,Y) :- voo(X,Y).
% rota(X,Y) :- voo(Z,Y), rota(X,Z).
