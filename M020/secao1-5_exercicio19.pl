% https://swish.swi-prolog.or
% Secao 1.5, Exercício 19 (7ª edição)

item(bolo).

ingrediente(massa).
ingrediente(ovo).
ingrediente(fermento).
ingrediente(farinha).
ingrediente(agua).
ingrediente(manteiga).
ingrediente(cobertura).
ingrediente(leite).
ingrediente(chocolate).

seco(fermento).
seco(farinha).
seco(chocolate).

liquido(agua).
liquido(leite).

perecivel(bolo).
perecivel(massa).
perecivel(ovo).
perecivel(manteiga).
perecivel(cobertura).
perecivel(leite).

ingredienteDe(massa,bolo).
ingredienteDe(ovo,massa).
ingredienteDe(fermento,massa).
ingredienteDe(farinha,massa).
ingredienteDe(agua,massa).
ingredienteDe(manteiga,massa).
ingredienteDe(cobertura,bolo).
ingredienteDe(leite,cobertura).
ingredienteDe(chocolate,cobertura).

% a)
% ingredienteDe(Y,_),seco(Y).

% b)
% ingredienteDe(_Y,X),perecivel(X),liquido(_Y).

% c)
% encontradoEm(Y,X) :- ingredienteDe(Y,X).
% encontradoEm(Y,X) :- ingredienteDe(Y,Z), encontradoEm(Z,X).
