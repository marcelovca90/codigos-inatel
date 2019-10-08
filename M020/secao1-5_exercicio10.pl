% https://swish.swi-prolog.org/
% Secao 1.5, Exercicio 10

capital(acre,rioBranco).
capital(amapa,macapa).
capital(amazonas,manaus).
capital(para,belem).
capital(rondonia,portoVelho).
capital(roraima,boaVista).
capital(tocantins,palmas).
capital(alagoas,maceio).
capital(bahia,salvador).
capital(ceara,fortaleza).
capital(maranhao,saoLuis).
capital(paraiba,joaoPessoa).
capital(pernambuco,recife).
capital(piaui,teresina).
capital(rioGrandeDoNorte,natal).
capital(sergipe,aracaju).
capital(goias,goiania).
capital(matoGrosso,cuiaba).
capital(matoGrossoDoSul,campoGrande).
capital(distritoFederal,brasilia).
capital(espiritoSanto,vitoria).
capital(minasGerais,beloHorizonte).
capital(saoPaulo,saoPaulo).
capital(rioDeJaneiro,rioDeJaneiro).
capital(parana,curitiba).
capital(rioGrandeDoSul,portoAlegre).
capital(santaCatarina,florianopolis).

% estados da regiao sul
sul(parana).
sul(rioGrandeDoSul).
sul(santaCatarina).

% estados da regiao nordeste
nordeste(alagoas).
nordeste(bahia).
nordeste(ceara).
nordeste(maranhao).
nordeste(paraiba).
nordeste(pernambuco).
nordeste(piaui).
nordeste(rioGrandeDoNorte).
nordeste(sergipe).

% cinco menores capitais do pais
pequena(rioBranco).
pequena(boaVista).
pequena(vitoria).
pequena(palmas).
pequena(florianopolis).

% cinco maiores capitais do pais
grande(saoPaulo).
grande(rioDeJaneiro).
grande(brasilia).
grande(salvador).
grande(fortaleza).

% a)
% capital(_,C),pequena(C).

% b)
% capital(E,_C),pequena(_C).

% c)
% capital(E,_C),nordeste(E),grande(_C).

% d)
% cosmopolita(C) :- capital(_,C), grande(C), sul(C).

% e)
% cosmopolita(C).
