% https://swish.swi-prolog.org/
% Secao 1.5, Exercicio 18 (7a edicao)

peca(transmissao).
peca(diferencial).
peca(rolamento).
peca(cubo).
peca(embreagem).
peca(disco).
peca(tampa).
peca(suspensao).
peca(amortecedor).
peca(mola).
peca(batente).
peca(pneu).
peca(bico).
peca(carcaca).

grande(transmissao).
grande(diferencial).
grande(embreagem).
grande(suspensao).
grande(amortecedor).
grande(pneu).

pequena(rolamento).
pequena(cubo).
pequena(tampa).
pequena(disco).
pequena(mola).
pequena(batente).
pequena(bico).
pequena(carcaca).

% X eh parte de Y
parteDe(diferencial,transmissao).
parteDe(rolamento,diferencial).
parteDe(cubo,diferencial).
parteDe(embreagem,transmissao).
parteDe(disco,embreagem).
parteDe(tampa,embreagem).
parteDe(amortecedor,suspensao).
parteDe(mola,amortecedor).
parteDe(batente,amortecedor).
parteDe(pneu,suspensao).
parteDe(bico,pneu).
parteDe(carcaca,pneu).

% a)
% pequena(Y),parteDe(Y,_).

% b)
% parteDe(_Y,X),grande(X),pequena(_Y).

% c)
% componenteDe(Y, X) :- parteDe(Y, X).
% componenteDe(Y,X) :- parteDe(Y, Z), componenteDe(Z, X).
